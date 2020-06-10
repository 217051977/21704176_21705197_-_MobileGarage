package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.repositories

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities.Park
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.room.dao.ParkDao
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.remote.responses.ParkingLotsResponse
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.remote.services.ParkingLotsService
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.listeners.OnReceiveParkingLots
import retrofit2.Retrofit
import java.util.*

class ParkRepository(private val local: ParkDao, private val remote: Retrofit) {

    private val apiKey = "93600bb4e7fee17750ae478c22182dda"

    fun getParks(listener: OnReceiveParkingLots?) {
        val service = remote.create(ParkingLotsService::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.getParkingLots(apiKey)

            var parks: List<Park>? = null
            if (response.isSuccessful) {
                val parksWeb = response.body()
                parks = parkCreation(parksWeb!!)
            } else {
                parks = local.getAll()
            }

            withContext(Dispatchers.Main) {
                Log.i(this::class.java.simpleName, parks.toString())
                listener?.onReceiveParkingLots(parks)
            }

        }

    }

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


}