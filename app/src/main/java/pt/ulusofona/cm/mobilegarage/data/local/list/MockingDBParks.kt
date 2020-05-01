package pt.ulusofona.cm.mobilegarage.data.local.list

import pt.ulusofona.cm.mobilegarage.data.local.entities.Park
import java.util.*

class MockingDBParks private constructor(){

    var parkToShow: Park? = null

    private val storage: MutableList<Park> = mutableListOf(
        Park(
            "park1",
            90.1,
            25.0,
            Calendar.getInstance(),
            "Structure",
            0.0,
            "rua 1",
            100,
            10,
            true
        ), Park(
            "park2",
            0.0,
            25.0,
            Calendar.getInstance(),
            "Surface",
            0.0,
            "rua 2",
            100,
            10
        ), Park(
            "park3",
            10.0,
            25.0,
            Calendar.getInstance(),
            "Structure",
            0.0,
            "Odivelas",
            100,
            10
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