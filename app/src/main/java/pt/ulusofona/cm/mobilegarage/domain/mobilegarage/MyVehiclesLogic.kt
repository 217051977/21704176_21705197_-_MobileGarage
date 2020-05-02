package pt.ulusofona.cm.mobilegarage.domain.mobilegarage

import pt.ulusofona.cm.mobilegarage.data.local.entities.Vehicle
import pt.ulusofona.cm.mobilegarage.data.local.list.MockingDBCars

class MyVehiclesLogic {

    private val storage: MockingDBCars = MockingDBCars.getInstance()

    fun getAll(): List<Vehicle> = storage.getAll()

    fun add(vehicle: Vehicle) {
        storage.insert(vehicle)
    }

}