package pt.ulusofona.cm.mobilegarage.data.local.list

import pt.ulusofona.cm.mobilegarage.data.local.entities.Park
import java.util.*

class MockingDBParks private constructor(){

    private val storage: MutableList<Park> = mutableListOf(
        Park(
            "park1",
            90.1,
            25.0,
            Calendar.getInstance(),
            "Structure",
            0.0
        ), Park(
            "park2",
            0.0,
            25.0,
            Calendar.getInstance(),
            "Surface",
            0.0
        ), Park(
            "park3",
            10.0,
            25.0,
            Calendar.getInstance(),
            "Structure",
            0.0
        )
    )

    companion object {

        private var instance: MockingDBParks? = null

        fun getInstance(): MockingDBParks {
            synchronized(this) {
                if (instance == null) {
                    instance = MockingDBParks()
                }
                return instance as MockingDBParks
            }
        }

    }

    fun insert(park: Park) {
        storage.add(park)
    }

    fun getAll(): List<Park> = storage.toList()

    fun getAllFavorites(): List<Park> {
        val favoriteParks: MutableList<Park> = mutableListOf()
        for (park in storage) {
            if (park.favorite) {
                favoriteParks.add(park)
            }
        }
        return favoriteParks
    }

}