package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.domain.mobilegarage

import android.content.Context
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.repositories.VehiclesRepository
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.listeners.OnReceiveVehicles

class MyVehiclesLogic(private val repository: VehiclesRepository) {

   fun getVehicles(listener: OnReceiveVehicles?, context: Context) = repository.getVehicles(listener, context)


}