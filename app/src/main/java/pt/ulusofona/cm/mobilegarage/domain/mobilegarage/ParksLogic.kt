package pt.ulusofona.cm.mobilegarage.domain.mobilegarage

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pt.ulusofona.cm.mobilegarage.data.local.entities.Park
import pt.ulusofona.cm.mobilegarage.data.local.list.MockingDBParks
import pt.ulusofona.cm.mobilegarage.data.remote.responses.ParkingLotsResponse
import pt.ulusofona.cm.mobilegarage.data.remote.services.ParkingLotsService
import retrofit2.Retrofit

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