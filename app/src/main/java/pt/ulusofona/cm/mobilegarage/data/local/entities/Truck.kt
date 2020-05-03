package pt.ulusofona.cm.mobilegarage.data.local.entities

import java.util.*

class Truck(
    plate: String,
    insuranceDeadLineDate: Calendar
) : Vehicle(
    plate = plate,
    insuranceDeadLineDate = insuranceDeadLineDate,
    category = "C"
) {

    init {
        vehicleTypeIconSrc = "drawable/ic_local_shipping_black_24dp.xml"
    }

}