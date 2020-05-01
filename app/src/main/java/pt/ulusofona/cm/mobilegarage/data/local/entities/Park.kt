package pt.ulusofona.cm.mobilegarage.data.local.entities

import java.util.*

class Park(
    val name: String,
    var availability: Double,
    var distance: Double,
    var lastUpdate: Calendar,
    val type: String,
    var price: Double
) {

    var favorite: Boolean = false

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

}