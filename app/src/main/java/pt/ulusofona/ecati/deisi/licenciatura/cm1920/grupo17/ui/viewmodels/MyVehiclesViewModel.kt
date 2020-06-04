package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.viewmodels

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.R
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities.Vehicle
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.domain.mobilegarage.MyVehiclesLogic
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.adapters.MyVehiclesAdapter
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.utils.MyVehiclesNavigationManager

class MyVehiclesViewModel : ViewModel() {

    private val myVehiclesLogic: MyVehiclesLogic =
        MyVehiclesLogic()

    fun getVehicleToShow(): Vehicle? = myVehiclesLogic.getVehicleToShow()

    fun setVehicleToShow(vehicle: Vehicle) {
        myVehiclesLogic.setVehicleToShow(vehicle)
    }

    fun onClickAddVehicle(supp: FragmentManager) {
        MyVehiclesNavigationManager.goToVehicleAdd(supp)
    }

    fun onClickDeleteVehicle(supp: FragmentManager, vehicle: Vehicle) {
        myVehiclesLogic.remove(vehicle)
        MyVehiclesNavigationManager.goToVehicleList(supp)
    }

    // fun onClickEditVehicle(supp: FragmentManager) {}

    fun onClickCancelAddVehicle(supp: FragmentManager) {
        MyVehiclesNavigationManager.goToVehicleList(supp)
    }

    fun onClickSubmitAddVehicle(supp: FragmentManager, vehicle: Vehicle) {
        myVehiclesLogic.add(vehicle)
        MyVehiclesNavigationManager.goToVehicleList(supp)
    }

    fun setAdapter(context: Context, supportFragmentManager: FragmentManager, viewModel: MyVehiclesViewModel): MyVehiclesAdapter {
        val vehicles: List<Vehicle> = myVehiclesLogic.getAll()
        return when (vehicles.size) {
            0 -> MyVehiclesAdapter(
                context,
                R.layout.item_vehicle_list,
                mutableListOf(),
                supportFragmentManager,
                viewModel
            )
            else -> MyVehiclesAdapter(
                context,
                R.layout.item_vehicle_list,
                myVehiclesLogic.getAll() as MutableList<Vehicle>,
                supportFragmentManager,
                viewModel
            )
        }
    }
}