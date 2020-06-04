package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities

import java.util.*

class Motorcycle(
    plate: String,
    insuranceDeadLineDate: Calendar
) : Vehicle(
    plate = plate,
    insuranceDeadLineDate = insuranceDeadLineDate,
    category = "A"
) {

    init {
        vehicleTypeIconSrc = "drawable/ic_motorcycle_black_24dp.xml"
    }

}