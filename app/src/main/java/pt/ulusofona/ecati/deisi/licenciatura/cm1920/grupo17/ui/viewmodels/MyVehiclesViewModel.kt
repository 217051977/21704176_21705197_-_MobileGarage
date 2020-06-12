package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.viewmodels

import android.app.Application
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.AndroidViewModel
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities.Vehicle
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.room.MobileGarageDatabase
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.repositories.VehiclesRepository
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.domain.mobilegarage.MyVehiclesLogic
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

    /**************** REGISTERS AND UNREGISTERS ************************/
    fun registerListenerVehicles(listener: OnReceiveVehicles, context: Context) {
        this.listenerVehicles = listener
        myVehicleLogic.getVehicles(listenerVehicles, context)
    }

    fun registerListenerVehicle(listener: OnReceiveVehicle, vehicle: Vehicle) {
        this.listenerVehicle = listener
        myVehicleLogic.getVehicle(listener, vehicle)
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
        myVehicleLogic.deleteVehicle(vehicle)
        MyVehiclesNavigationManager.goToVehicleList(supp)
    }

    fun onClickCancelAddVehicle(supp: FragmentManager) {
        MyVehiclesNavigationManager.goToVehicleList(supp)
    }

    fun onClickSubmitAddVehicle(supp: FragmentManager, vehicle: Vehicle) {
        myVehicleLogic.addVehicle(vehicle)
        MyVehiclesNavigationManager.goToVehicleList(supp)
    }

    fun onClickCancelEditVehicle(supp: FragmentManager, vehicle: Vehicle) {
        MyVehiclesNavigationManager.goToVehicleDetails(supp, vehicle)
    }

    fun onClickSubmitEditVehicle(supp: FragmentManager, vehicle: Vehicle) {
        myVehicleLogic.addVehicle(vehicle)
        MyVehiclesNavigationManager.goToVehicleList(supp)
    }

    fun onClickEditVehicle(supp: FragmentManager, vehicle: Vehicle) {
        MyVehiclesNavigationManager.goToVehicleEdit(supp, vehicle)
    }

    fun onClickBlockVehicle(context: Context, vehicle: Vehicle) {

        val uri = Uri.parse("smsto:$3838")
        val intent = Intent(Intent.ACTION_SENDTO, uri)
        intent.putExtra("sms_body", "Reboque ${vehicle.plate}")
        context.startActivity(intent)

    }
    /************************ END ********************************/
}