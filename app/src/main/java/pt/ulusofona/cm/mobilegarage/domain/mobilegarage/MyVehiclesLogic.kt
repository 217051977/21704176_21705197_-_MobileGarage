package pt.ulusofona.cm.mobilegarage.domain.mobilegarage

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pt.ulusofona.cm.mobilegarage.data.local.entities.Vehicle
import pt.ulusofona.cm.mobilegarage.data.local.list.MockingDBCars
import pt.ulusofona.cm.mobilegarage.data.local.room.dao.VehicleDao

class MyVehiclesLogic(private val storage: VehicleDao) {

    //private val storage: MockingDBCars = MockingDBCars.getInstance()

    var vehicle: Vehicle? = null

    fun getVehicleToShow(): Vehicle? = vehicle

    fun setVehicleToShow(v: Vehicle) {
        CoroutineScope(Dispatchers.IO).launch {
            vehicle = storage.setVehicleToShow(v.uuid)
        }
    }

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