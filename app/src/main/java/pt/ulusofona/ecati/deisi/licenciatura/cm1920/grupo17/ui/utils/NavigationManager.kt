package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.R
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.fragments.SettingsFragment

class NavigationManager {

    companion object {

        private fun placeFragment(fm: FragmentManager, fragment: Fragment) {
            val transition = fm.beginTransaction()
            transition.replace(R.id.frame, fragment)
            transition.addToBackStack(null)
            transition.commit()
        }

        /*
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
         */

    }

}