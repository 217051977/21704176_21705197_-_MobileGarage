package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.R
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.fragments.FavoritesFragment
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.fragments.HomeMenuFragment
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.fragments.MyVehiclesFragment
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.fragments.ParkMeNowFragment

class NavBarNavigationManager {

    companion object {

        private fun placeFragment(fm: FragmentManager, fragment: Fragment) {
            val transition = fm.beginTransaction()
            transition.replace(R.id.frame, fragment)
            transition.addToBackStack(null)
            transition.commit()
        }

        fun goToMyVehicles(fm: FragmentManager) {
            placeFragment(
                fm,
                MyVehiclesFragment()
            )
        }

        fun goToFavorites(fm: FragmentManager) {
            placeFragment(
                fm,
                FavoritesFragment()
            )
        }

        fun goToHomePage(fm: FragmentManager) {
            placeFragment(
                fm,
                HomeMenuFragment()
            )
        }

        fun goToParkMeNow(fm: FragmentManager) {
            placeFragment(
                fm,
                ParkMeNowFragment()
            )
        }

    }

}