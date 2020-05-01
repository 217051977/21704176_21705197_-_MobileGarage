package pt.ulusofona.cm.mobilegarage.data.local.list

import pt.ulusofona.cm.mobilegarage.data.local.entities.Park

class MockingDBCars private constructor(){

    private val storage: MutableList<Park> = mutableListOf()

    companion object {

        private var instance: MockingDBCars? = null

        fun getInstance(): MockingDBCars {
            synchronized(this) {
                if (instance == null) {
                    instance = MockingDBCars()
                }
                return instance as MockingDBCars
            }
        }

    }

    fun insert(park: Park) {
        storage.add(park)
    }

    fun getAll(): List<Park> = storage.toList()

}