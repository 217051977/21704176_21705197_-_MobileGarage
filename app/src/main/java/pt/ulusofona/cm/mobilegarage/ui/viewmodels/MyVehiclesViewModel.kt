package pt.ulusofona.cm.mobilegarage.ui.viewmodels

import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import pt.ulusofona.cm.mobilegarage.R
import pt.ulusofona.cm.mobilegarage.data.local.entities.Vehicle
import pt.ulusofona.cm.mobilegarage.data.local.list.MockingDBCars
import pt.ulusofona.cm.mobilegarage.domain.mobilegarage.MyVehiclesLogic
import pt.ulusofona.cm.mobilegarage.ui.adapters.MyVehiclesAdapter
import pt.ulusofona.cm.mobilegarage.ui.utils.MyVehiclesNavigationManager

class MyVehiclesViewModel : ViewModel() {

    private val myVehiclesLogic: MyVehiclesLogic = MyVehiclesLogic()

    fun onClickAddVehicle(supp: FragmentManager) {
        MyVehiclesNavigationManager.goToVehicleAdd(supp)
    }

    fun onClickCancelAddVehicle(supp: FragmentManager) {
        MyVehiclesNavigationManager.goToVehicleList(supp)
    }

    fun onClickSubmitAddVehicle(supp: FragmentManager, vehicle: Vehicle) {
        myVehiclesLogic.add(vehicle)
        MyVehiclesNavigationManager.goToVehicleList(supp)
    }

    fun setAdapter(context: Context, supportFragmentManager: FragmentManager): MyVehiclesAdapter {
        return MyVehiclesAdapter(
            context,
            R.layout.item_vehicle_list,
            myVehiclesLogic.getAll() as MutableList<Vehicle>,
            supportFragmentManager
        )
    }
}