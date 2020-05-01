package pt.ulusofona.cm.mobilegarage.domain.mobilegarage

import pt.ulusofona.cm.mobilegarage.data.local.entities.Park
import pt.ulusofona.cm.mobilegarage.data.local.list.MockingDBParks

class ParksLogic {

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