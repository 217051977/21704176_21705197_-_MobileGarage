package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.repositories

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities.Vehicle
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.room.dao.VehicleDao
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.listeners.OnReceiveVehicles

class VehiclesRepository(private val local: VehicleDao) {

    fun getVehicles(listener: OnReceiveVehicles?) {

        CoroutineScope(Dispatchers.IO).launch {
            val vehicles = local.getAll() as MutableList<Vehicle>

            withContext(Dispatchers.Main) {
                listener?.onReceiveVehicles(vehicles)
            }
        }
    }

}