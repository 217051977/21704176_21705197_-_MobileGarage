package pt.ulusofona.cm.mobilegarage.ui.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import pt.ulusofona.cm.mobilegarage.R
import pt.ulusofona.cm.mobilegarage.ui.fragments.MyVehiclesAddFragment
import pt.ulusofona.cm.mobilegarage.ui.fragments.MyVehiclesDetailsFragment
import pt.ulusofona.cm.mobilegarage.ui.fragments.MyVehiclesFragment
import pt.ulusofona.cm.mobilegarage.ui.fragments.ParkDetailsFragment

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

        fun goToVehicleDetails(fm: FragmentManager) {
            placeFragment(
                fm,
                MyVehiclesDetailsFragment()
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