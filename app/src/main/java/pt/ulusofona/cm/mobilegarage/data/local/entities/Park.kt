package pt.ulusofona.cm.mobilegarage.data.local.entities

import java.util.*

class Park(
    val name: String,
    var availability: Double,
    var distance: Double,
    var lastUpdate: Calendar,
    val type: String,
    var price: Double,
    val address: String,
    val nrParkingSpot: Int,
    val nrParkingSpotForDisablePeople: Int,
    var favorite: Boolean = false
) {

    fun getLastUpdate(): String =
        "${lastUpdate.get(
            Calendar.DATE
        )}/${lastUpdate.get(
            Calendar.MONTH
        ) + 1}/${lastUpdate.get(
            Calendar.YEAR
        )}"

    fun getAvailabilityStatus(): String = when {
        availability > 90 -> {
            "Free"
        }
        availability >= 10 -> {
            "Potentially crowded"
        }
        else -> {
            "Full"
        }
    }

    override fun toString(): String =
        "name: $name\n" +
                "availability: $availability\n" +
                "distance: $distance\n" +
                "lastUpdate: $lastUpdate\n" +
                "type: $type\n" +
                "price: $price\n" +
                "price: $address\n"

}