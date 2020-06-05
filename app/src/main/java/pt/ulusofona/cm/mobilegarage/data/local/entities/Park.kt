package pt.ulusofona.cm.mobilegarage.data.local.entities

import java.util.*

data class Park(
    val name: String,
    var lastUpdate: Calendar,
    val type: String,
    val nrParkingSpot: Int,
    var availability: Double = 0.0,
    var distance: Double = 0.0,
    var price: Double = 0.0,
    val address: String = "",
    val nrParkingSpotForDisablePeople: Int = 0,
    var favorite: Boolean = false
) {

    fun getAddressNotification(): String = "Address: $address"

    fun getLastUpdateNotification(): String = "Last update: ${getLastUpdate()}"

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