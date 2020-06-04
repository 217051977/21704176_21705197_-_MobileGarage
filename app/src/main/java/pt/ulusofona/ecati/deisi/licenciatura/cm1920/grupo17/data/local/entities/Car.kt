package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities

import java.util.*

class Car(
    plate: String,
    insuranceDeadLineDate: Calendar
) : Vehicle(
    plate = plate,
    insuranceDeadLineDate = insuranceDeadLineDate,
    category = "B"
)