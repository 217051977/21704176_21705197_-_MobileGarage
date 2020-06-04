package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.list

import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities.Park
import java.util.*

class MockingDBParks private constructor(){

    var parkToShow: Park? = null
    //    mutableListOf(
//0    <"distance" || "availability">(sort),
//1    <"surface" || "structure" || "all">(park type),
//2    <"true", "false">
//3    <"$distanceValue">
//    )
    private val filterStatus: MutableList<String> = mutableListOf(
        "availability",
        "all",
        "false",
        "0"
    )
    private val storage: MutableList<Park> = mutableListOf(
        Park(
            "park1",
            90.1,
            5.0,
            Calendar.getInstance(),
            "Structure",
            0.0,
            "rua 1",
            100,
            10,
            true
        ),
        Park(
            "park2",
            0.0,
            50.0,
            Calendar.getInstance(),
            "Surface",
            0.0,
            "rua 2",
            100,
            10
        ),
        Park(
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
                    instance =
                        MockingDBParks()
                }
                return instance as MockingDBParks
            }
        }

    }

    fun getFilterSortStatus(): String = filterStatus[0]

    fun getFilterParkTypeStatus(): String = filterStatus[1]

    fun getAccessibilityStatus(): Boolean = filterStatus[2].toBoolean()

    fun getDistanceValueStatus(): Int = filterStatus[3].toInt()

    fun setSortByDistanceStatus() { filterStatus[0] = "distance" }

    fun setSortByAvailabilityStatus() { filterStatus[0] = "availability" }

    fun setSurfaceParkStatus() { filterStatus[1] = "surface" }

    fun setStructureParkStatus() { filterStatus[1] = "structure" }

    fun setAllParksStatus() { filterStatus[1] = "all" }

    fun setAccessibilityStatus(status: Boolean) { filterStatus[2] = status.toString() }

    fun setDistanceValueStatus(value: Int) { filterStatus[3] = value.toString() }

    fun insert(park: Park) { storage.add(park) }

    fun getAll(): List<Park> {

        var parks: MutableList<Park> = mutableListOf()
        val parksAux: MutableList<Park> = mutableListOf()

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

        if (filterStatus[2].toBoolean()) {
            for (park in parks) {
                if (park.nrParkingSpotForDisablePeople > 0) {
                    parksAux.add(park)
                }
            }
            parks.clear()
            parks.addAll(parksAux)
            parksAux.clear()
        }

        val distance = filterStatus[3].toInt()

        if (distance > 0) {
            for (park in parks) {
                if (park.distance <= distance) {
                    parksAux.add(park)
                }
            }
            parks.clear()
            parks.addAll(parksAux)
            parksAux.clear()
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