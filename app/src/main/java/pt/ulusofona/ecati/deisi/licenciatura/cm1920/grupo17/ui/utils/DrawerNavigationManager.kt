package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.R
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.fragments.*

class DrawerNavigationManager {

    companion object {

        private fun placeFragment(fm: FragmentManager, fragment: Fragment) {
            val transition = fm.beginTransaction()
            transition.replace(R.id.frame, fragment)
            transition.addToBackStack(null)
            transition.commit()
        }

        fun goToProfile(fm: FragmentManager) {
            placeFragment(
                fm,
                ProfileFragment()
            )
        }

        fun goToMyVehicles(fm: FragmentManager) {
            placeFragment(
                fm,
                MyVehiclesFragment()
            )
        }

        fun goToContacts(fm: FragmentManager) {
            placeFragment(
                fm,
                ContactsFragment()
            )
        }

        fun goToGira(fm: FragmentManager) {
            placeFragment(
                fm,
                GiraFragment()
            )
        }

        fun goToTraffic(fm: FragmentManager) {
            placeFragment(
                fm,
                TrafficFragment()
            )
        }

        fun goToMap(fm: FragmentManager) {
            placeFragment(
                fm,
                MapFragment()
            )
        }

        fun goToFindVehicle(fm: FragmentManager) {
            placeFragment(
                fm,
                FindVehicleFragment()
            )
        }

        fun goToShareLocation(fm: FragmentManager) {
            placeFragment(
                fm,
                ShareLocationFragment()
            )
        }

    }

}