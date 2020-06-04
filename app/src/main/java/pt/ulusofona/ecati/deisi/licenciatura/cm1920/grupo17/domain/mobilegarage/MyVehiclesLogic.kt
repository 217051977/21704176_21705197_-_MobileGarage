package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.domain.mobilegarage

import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities.Vehicle
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.list.MockingDBCars

class MyVehiclesLogic {

    private val storage: MockingDBCars = MockingDBCars.getInstance()

    fun getVehicleToShow(): Vehicle? = storage.vehicle

    fun setVehicleToShow(vehicle: Vehicle) {
        storage.vehicle = vehicle
    }

    fun getAll(): List<Vehicle> = storage.getAll()

    fun add(vehicle: Vehicle) {
        storage.insert(vehicle)
    }

    fun remove(vehicle: Vehicle) {
        storage.remove(vehicle)
    }


}