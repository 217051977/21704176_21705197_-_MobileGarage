package pt.ulusofona.cm.mobilegarage.data.local.entities

import java.util.*

class Park(
    val name: String,
    val availability: Boolean,
    var distance: Double,
    var lastUpdate: Date,
    val type: ParkType,
    var price: Double
)