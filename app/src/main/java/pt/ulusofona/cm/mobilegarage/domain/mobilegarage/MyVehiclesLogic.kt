package pt.ulusofona.cm.mobilegarage.domain.mobilegarage

import pt.ulusofona.cm.mobilegarage.data.local.entities.Vehicle
import pt.ulusofona.cm.mobilegarage.data.local.list.MockingDBCars

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

    /*
     var vehicle: Vehicle? = null

    fun setVehicleToShow(vehicle: Vehicle) {
        CoroutineScope(Dispatchers.IO).launch {
            storage.setVehicleToShow(vehicleID = "1")
        }
    }

    fun getVehicleToShow(): Vehicle? = vehicle

    fun getAll(): List<Vehicle> {
        var vehicles: List<Vehicle> = mutableListOf()
        CoroutineScope(Dispatchers.IO).launch {
            vehicles = storage.getAll()
        }
        return vehicles
    }

    fun add(vehicle: Vehicle) {
        CoroutineScope(Dispatchers.IO).launch {
            storage.insert(vehicle)
        }
    }
     */

}