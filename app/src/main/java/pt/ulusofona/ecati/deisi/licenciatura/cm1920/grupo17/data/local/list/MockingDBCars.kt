package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.list

import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities.Vehicle
import java.util.*

/*
class MockingDBCars private constructor(){

    private val storage: MutableList<Vehicle> = mutableListOf(
        Car(
            "25-SW-00",
            Calendar.getInstance()
        ),
        Car(
            "DF-08-23",
            Calendar.getInstance()
        ),
        Car(
            "25-26-AD",
            Calendar.getInstance()
        )
    )

    var vehicle: Vehicle? = null

    init {
        storage[1].setInsuranceDate(2020, 6, 2)
        storage[2].setInsuranceDate(1999, 5, 2)
    }

    companion object {

        private var instance: MockingDBCars? = null

        fun getInstance(): MockingDBCars {
            synchronized(this) {
                if (instance == null) {
                    instance =
                        MockingDBCars()
                }
                return instance as MockingDBCars
            }
        }

    }

    fun insert(vehicle: Vehicle) {
        storage.add(vehicle)
    }

    fun remove(vehicle: Vehicle) {
        storage.remove(vehicle)
    }

    fun getAll(): List<Vehicle> = storage.toList()

}
 */