package pt.ulusofona.cm.mobilegarage.data.local.list

import pt.ulusofona.cm.mobilegarage.data.local.entities.Park
import java.util.*

class MockingDBParks private constructor(){

    var parkToShow: Park? = null
//    mutableListOf(<"distance" || "availability" || "all">, <"surface" || "structure" || "all">)
    private val filterStatus: MutableList<String> = mutableListOf("availability", "all")
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

    fun getFilterSortStatus(): String = filterStatus[0]

    fun getFilterParkTypeStatus(): String = filterStatus[1]

    fun setSortByDistanceStatus() {
        filterStatus[0] = "distance"
    }

    fun setSortByAvailabilityStatus() {
        filterStatus[0] = "availability"
    }

    fun setSurfaceParkDistanceStatus() {
        filterStatus[1] = "surface"
    }

    fun setStructureParkAvailabilityStatus() {
        filterStatus[1] = "structure"
    }

    fun setAllParkAllStatus() {
        filterStatus[1] = "all"
    }

    fun insert(park: Park) {
        storage.add(park)
    }

    fun getAll(): List<Park> {

        var parks: MutableList<Park> = mutableListOf()

        when (filterStatus[1]) {
            "all" -> {
                parks = storage
            }
            "structure" -> {
                for (park in storage) {
                    if (park.type.toLowerCase() == "structure") {
                        parks.add(park)
                    }
                }
            }
            "surface" -> {
                for (park in storage) {
                    if (park.type.toLowerCase() == "surface") {
                        parks.add(park)
                    }
                }
            }
        }

        when (filterStatus[0]) {
            "distance" -> parks.sortBy { it.distance }
            else -> parks.sortByDescending { it.availability }
        }

        return parks.toList()
    }

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