package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Park(
    @PrimaryKey
    val parkID: String,
    val name: String,
    var lastDate: Calendar,
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
        "${lastDate.get(
            Calendar.DATE
        )}/${lastDate.get(
            Calendar.MONTH
        ) + 1}/${lastDate.get(
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
                "lastUpdate: $lastDate\n" +
                "type: $type\n" +
                "price: $price\n" +
                "price: $address\n"

}