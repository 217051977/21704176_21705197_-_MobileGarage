package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.repositories

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities.Vehicle
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.room.dao.VehicleDao
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.listeners.OnReceiveVehicles
import java.util.*

private val TAG = VehiclesRepository::class.java.simpleName

class VehiclesRepository(private val local: VehicleDao) {

    fun getVehicles(listener: OnReceiveVehicles?, context: Context) {

        val snackBarPrefs: SharedPreferences =  context.getSharedPreferences("SnackBarPrefs", 0)
        val sharedPrefsEdit: SharedPreferences.Editor = snackBarPrefs.edit()

        var acessed = false

        if (!acessed) {

            val vehicles = mutableListOf(
                Vehicle(
                    plate = "25-SW-00",
                    insuranceDeadLineDate = Calendar.getInstance()
                ),
                Vehicle(
                    plate = "DF-08-23",
                    insuranceDeadLineDate = Calendar.getInstance()
                ),
                Vehicle(
                    plate = "25-26-AD",
                    insuranceDeadLineDate = Calendar.getInstance()
                )
            )

            CoroutineScope(Dispatchers.IO).launch {
                local.insertVehicles(vehicles)

                withContext(Dispatchers.Main) {
                    listener?.onReceiveVehicles(vehicles)
                    Log.i(TAG, "Nr Vehicles: ${vehicles.size}")
                    acessed = true
                }
            }
        } else {
            CoroutineScope(Dispatchers.IO).launch {
                val vehicles = local.getAll() as MutableList<Vehicle>

                withContext(Dispatchers.Main) {
                    listener?.onReceiveVehicles(vehicles)
                    Log.i(TAG, "Nr Vehicles: ${vehicles.size}")
                }
            }
        }
    }

}