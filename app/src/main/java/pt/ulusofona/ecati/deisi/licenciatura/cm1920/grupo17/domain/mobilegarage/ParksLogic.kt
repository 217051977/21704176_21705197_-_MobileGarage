package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.domain.mobilegarage

import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities.Park
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.list.MockingDBParks
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.remote.responses.ParkingLotsResponse
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.remote.services.ParkingLotsService
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.repositories.ParkRepository
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.listeners.OnReceiveParkingLots
import retrofit2.Retrofit
import java.util.*

class ParksLogic(private val repository: ParkRepository) {

    private val storage: MockingDBParks = MockingDBParks.getInstance()

    fun getParkToShow(): Park? = storage.parkToShow

    fun setParkToShow(park: Park) {
        storage.parkToShow = park
    }

    fun getParks(listener: OnReceiveParkingLots?) = repository.getParks(listener)

    /*

    fun getAll(): List<Park> = storage.getAll()

    fun getAllFavorites(): List<Park> = storage.getAllFavorites()

    fun add(vehicle: Park) {
        storage.insert(vehicle)
    }

     */

}