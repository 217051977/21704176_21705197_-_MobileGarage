package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.R
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities.Vehicle
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.fragments.MyVehiclesAddFragment
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.fragments.MyVehiclesDetailsFragment
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.fragments.MyVehiclesFragment

class MyVehiclesNavigationManager {

    companion object {

        private fun placeFragment(fm: FragmentManager, fragment: Fragment) {
            val transition = fm.beginTransaction()
            transition.replace(R.id.frame, fragment)
            transition.addToBackStack(null)
            transition.commit()
        }

        fun goToVehicleList(fm: FragmentManager) {
            placeFragment(
                fm,
                MyVehiclesFragment()
            )
        }

        fun goToVehicleDetails(fm: FragmentManager, vehicle: Vehicle) {
            placeFragment(
                fm,
                MyVehiclesDetailsFragment(vehicle)
            )
        }

        fun goToVehicleAdd(fm: FragmentManager) {
            placeFragment(
                fm,
                MyVehiclesAddFragment()
            )
        }



    }

}