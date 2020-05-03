package pt.ulusofona.cm.mobilegarage.ui.viewmodels

import android.app.Application
import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import pt.ulusofona.cm.mobilegarage.R
import pt.ulusofona.cm.mobilegarage.data.local.entities.Vehicle
import pt.ulusofona.cm.mobilegarage.data.local.room.MobileGarageDatabase
import pt.ulusofona.cm.mobilegarage.domain.mobilegarage.MyVehiclesLogic
import pt.ulusofona.cm.mobilegarage.ui.adapters.MyVehiclesAdapter
import pt.ulusofona.cm.mobilegarage.ui.utils.MyVehiclesNavigationManager

class MyVehiclesViewModel(application: Application) : AndroidViewModel(application) {

    private val storage = MobileGarageDatabase.getInstance(application).vehicleDao()
    private val myVehiclesLogic: MyVehiclesLogic = MyVehiclesLogic(storage)

    fun getVehicleToShow(): Vehicle? = myVehiclesLogic.getVehicleToShow()

    fun setVehicleToShow(vehicle: Vehicle) {
        myVehiclesLogic.setVehicleToShow(vehicle)
    }

    fun onClickAddVehicle(supp: FragmentManager) {
        MyVehiclesNavigationManager.goToVehicleAdd(supp)
    }

    fun onClickDeleteVehicle(supp: FragmentManager) {
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
        return MyVehiclesAdapter(
            context,
            R.layout.item_vehicle_list,
            myVehiclesLogic.getAll() as MutableList<Vehicle>,
            supportFragmentManager,
            viewModel
        )
    }
}