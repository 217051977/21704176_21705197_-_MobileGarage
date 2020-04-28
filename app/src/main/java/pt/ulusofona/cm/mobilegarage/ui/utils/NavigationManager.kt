package pt.ulusofona.cm.mobilegarage.ui.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import pt.ulusofona.cm.mobilegarage.R
import pt.ulusofona.cm.mobilegarage.ui.fragments.*

class NavigationManager {

    companion object {

        private fun placeFragment(fm: FragmentManager, fragment: Fragment) {
            val transition = fm.beginTransaction()
            transition.replace(R.id.frame, fragment)
            transition.addToBackStack(null)
            transition.commit()
        }

        fun goToHomePage(fm: FragmentManager) {
            placeFragment(
                fm,
                HomeMenuFragment()
            )
        }

        fun goToLogInPage(fm: FragmentManager) {
            placeFragment(
                fm,
                LogInFragment()
            )
        }

        fun goToRegisterPage(fm: FragmentManager) {
            placeFragment(
                fm,
                RegisterFragment()
            )
        }

        fun goToSettingsPage(fm: FragmentManager) {
            placeFragment(
                fm,
                SettingsFragment()
            )
        }

        fun goToContactsPage(fm: FragmentManager) {
            placeFragment(
                fm,
                ContactsFragment()
            )
        }

    }

}