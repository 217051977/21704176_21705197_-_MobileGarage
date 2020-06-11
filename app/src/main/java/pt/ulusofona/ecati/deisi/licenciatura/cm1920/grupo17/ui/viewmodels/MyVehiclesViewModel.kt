package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.viewmodels

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.R
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities.Vehicle
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.room.MobileGarageDatabase
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.repositories.ParkRepository
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.repositories.VehiclesRepository
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.domain.mobilegarage.MyVehiclesLogic
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.domain.mobilegarage.ParksLogic
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.adapters.MyVehiclesAdapter
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.listeners.OnReceivePark
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.listeners.OnReceiveParks
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.listeners.OnReceiveVehicle
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.listeners.OnReceiveVehicles
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.utils.MyVehiclesNavigationManager

private val TAG = MyVehiclesViewModel::class.java.simpleName

class MyVehiclesViewModel(application: Application): AndroidViewModel(application) {

    private val local = MobileGarageDatabase.getInstance(application).vehicleDao()
    private val myVehicleLogic: MyVehiclesLogic =  MyVehiclesLogic(VehiclesRepository(local = local))

    // LISTENERS
    private var listenerVehicles: OnReceiveVehicles? = null
    private var listenerVehicle: OnReceiveVehicle? = null

    var vehicles = listOf<Vehicle>()
    var vehicle: Vehicle? = null

    /**************** REGISTERS AND UNREGISTERS ************************/
    fun registerListenerVehicles(listener: OnReceiveVehicles, context: Context) {
        this.listenerVehicles = listener
        myVehicleLogic.getVehicles(listenerVehicles, context)
    }

    fun registerListenerVehicle(listener: OnReceiveVehicle) {
        this.listenerVehicle = listener
    }

    fun unregisterListenerVehicles() {
        listenerVehicles = null
    }

    fun unregisterListenerVehicle() {
        listenerVehicle = null
    }
    /************************ END ********************************/

    /**************** FUNCTIONS ************************/
    fun onClickAddVehicle(supp: FragmentManager) {
        MyVehiclesNavigationManager.goToVehicleAdd(supp)
    }

    fun onClickDeleteVehicle(supp: FragmentManager, vehicle: Vehicle) {
        //myVehiclesLogic.remove(vehicle)
        MyVehiclesNavigationManager.goToVehicleList(supp)
    }

    fun onClickCancelAddVehicle(supp: FragmentManager) {
        MyVehiclesNavigationManager.goToVehicleList(supp)
    }

    fun onClickSubmitAddVehicle(supp: FragmentManager, vehicle: Vehicle) {
        //myVehiclesLogic.add(vehicle)
        MyVehiclesNavigationManager.goToVehicleList(supp)
    }
    /************************ END ********************************/


}