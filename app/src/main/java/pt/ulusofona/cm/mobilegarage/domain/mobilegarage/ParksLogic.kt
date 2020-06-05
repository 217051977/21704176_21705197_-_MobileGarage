package pt.ulusofona.cm.mobilegarage.domain.mobilegarage

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pt.ulusofona.cm.mobilegarage.data.local.entities.Park
import pt.ulusofona.cm.mobilegarage.data.local.list.MockingDBParks
import pt.ulusofona.cm.mobilegarage.data.remote.responses.ParkingLotsResponse
import pt.ulusofona.cm.mobilegarage.data.remote.services.ParkingLotsService
import retrofit2.Retrofit
import java.util.*

class ParksLogic(private val retrofit: Retrofit) {

    fun getParks(): List<ParkingLotsResponse> {
        val service = retrofit.create(ParkingLotsService::class.java)
        var lists = listOf<ParkingLotsResponse>()
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.getParkingLots("93600bb4e7fee17750ae478c22182dda")

            if (response.isSuccessful) {
                lists = response.body()!!
            }
            /*
            val operacoes = response.body()
            listener?.onReceiveOperations(operacoes!!)
             */
        }
        Thread.sleep(60)
        return lists
    }

    fun parkCreation(pakrs: List<ParkingLotsResponse>): List<Park> {
        val newPark = mutableListOf<Park>()
        var updateDate = Calendar.getInstance()
        for (park in pakrs) {
            var updateDateParts = park.lastUpdateDate.split(" ")
            var datePart = updateDateParts[0].split("-")
            var hourPart = updateDateParts[1].split(":")

            updateDate.set(datePart[0].toInt(), datePart[1].toInt(), datePart[2].toInt(),
                hourPart[0].toInt(), hourPart[1].toInt(), hourPart[2].toInt())

            newPark.add(Park(
                name = park.name,
                lastUpdate = updateDate,
                type = park.parkType,
                nrParkingSpot = park.maxCapacity
            ))
        }

        return newPark
    }

    private val storage: MockingDBParks = MockingDBParks.getInstance()

    fun getParkToShow(): Park? = storage.parkToShow

    fun setParkToShow(park: Park) {
        storage.parkToShow = park
    }

    fun getAll(): List<Park> = storage.getAll()

    fun getAllFavorites(): List<Park> = storage.getAllFavorites()

    fun add(vehicle: Park) {
        storage.insert(vehicle)
    }

}