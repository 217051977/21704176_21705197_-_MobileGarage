package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.domain.mobilegarage

import android.content.Context
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities.Vehicle
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.repositories.VehiclesRepository
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.listeners.OnReceiveVehicle
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.listeners.OnReceiveVehicles

class MyVehiclesLogic(private val repository: VehiclesRepository) {

   fun getVehicles(listener: OnReceiveVehicles?, context: Context) = repository.getVehicles(listener, context)

   fun getVehicle(listener: OnReceiveVehicle?, vehicle: Vehicle) = repository.getVehicle(listener, vehicle)

   fun addVehicle(vehicle: Vehicle) = repository.addVehicle(vehicle)

   fun deleteVehicle(vehicle: Vehicle) = repository.deleteVehicle(vehicle)

}