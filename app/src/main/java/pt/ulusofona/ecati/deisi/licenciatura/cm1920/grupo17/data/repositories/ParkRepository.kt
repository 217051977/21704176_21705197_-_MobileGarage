package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.repositories

import android.util.Log
import android.view.View
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities.Park
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.room.dao.ParkDao
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.remote.responses.ParkingLotsResponse
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.remote.services.ParkingLotsService
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.listeners.OnReceiveFavorites
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.listeners.OnReceiveParks
import retrofit2.Retrofit
import java.util.*

private val TAG = ParkRepository::class.java.simpleName

class ParkRepository(private val local: ParkDao, private val remote: Retrofit) {

    private val apiKey = "93600bb4e7fee17750ae478c22182dda"
    private var userWarned = false

    private fun parkCreation(parks: List<ParkingLotsResponse>): List<Park> {
        val newPark = mutableListOf<Park>()
        val updateDate = Calendar.getInstance()
        for (park in parks) {
            val updateDateParts = park.lastUpdateDate.split(" ")
            val datePart = updateDateParts[0].split("-")
            val hourPart = updateDateParts[1].split(":")

            updateDate.set(datePart[0].toInt(), datePart[1].toInt(), datePart[2].toInt(),
                hourPart[0].toInt(), hourPart[1].toInt(), hourPart[2].toInt())

            newPark.add(
                Park(
                    parkID = park.parkID,
                    name = park.name,
                    lastDate = updateDate,
                    type = park.parkType,
                    nrParkingSpot = park.maxCapacity
                )
            )
        }

        return newPark
    }

    fun getParks(listener: OnReceiveParks?, view: View?) {
        val service = remote.create(ParkingLotsService::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.getParkingLots(apiKey)

            var parks: List<Park>? = null
            if (response.isSuccessful) {

                Log.i(TAG, "Local Antes delete ${local.getAll().size}")
                local.deleteParks() // DELETE BEFORE UPDATE
                Log.i(TAG, "Local Depois delete ${local.getAll().size}")

                val parksWeb = response.body()
                parks = parkCreation(parksWeb!!)
                local.insertParks(parks) // UPDATES PARKS
                Log.i(TAG, "Local Depois do insert ${local.getAll().size}")

            } else {
                parks = local.getAll()
                Log.i(TAG, "Local ${parks.size}")

                if (!userWarned) {
                    val snackbar: Snackbar = Snackbar.make(view!!, "Getting Data from Cache", Snackbar.LENGTH_LONG);
                    snackbar.show();
                    userWarned = true
                }
            }

            withContext(Dispatchers.Main) {
                Log.i(TAG, "NrParks: ${parks.size}")
                listener?.onReceiveParks(parks)
            }
        }
    }

    fun getFavorites(listener: OnReceiveFavorites?) {

        val favoriteParks = mutableListOf<Park>()
        var parks = mutableListOf<Park>()

        CoroutineScope(Dispatchers.IO).launch {
            parks = local.getAll() as MutableList<Park>
        }

        for (park in parks) {
            if (park.favorite) {
                favoriteParks.add(park)
            }
        }

        listener?.onReceiveFavorites(favoriteParks)

    }
}