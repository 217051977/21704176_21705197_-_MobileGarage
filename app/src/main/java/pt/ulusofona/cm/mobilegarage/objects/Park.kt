package pt.ulusofona.cm.mobilegarage.objects

import java.util.*

class Park(
    val name: String,
    val availability: Boolean,
    var distance: Double,
    var lastUpdate: Date,
    val type: ParkType,
    var price: Double
)