package pt.ulusofona.cm.mobilegarage.ui.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import pt.ulusofona.cm.mobilegarage.R
import pt.ulusofona.cm.mobilegarage.ui.fragments.*

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

    }

}