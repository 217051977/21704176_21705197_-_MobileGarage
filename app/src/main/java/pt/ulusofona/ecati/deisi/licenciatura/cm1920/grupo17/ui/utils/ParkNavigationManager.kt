package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.R
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities.Park
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.fragments.FavoritesFilterOptionsFragment
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.fragments.HomeMenuFilterOptionsFragment
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.fragments.ParkDetailsFragment

class ParkNavigationManager {

    companion object {

        private fun placeFragment(fm: FragmentManager, fragment: Fragment) {
            val transition = fm.beginTransaction()
            transition.replace(R.id.frame, fragment)
            transition.addToBackStack(null)
            transition.commit()
        }

        fun goToFilterOptions(fm: FragmentManager, fav: Boolean = false) {
            if (fav) {
                placeFragment(
                    fm,
                    FavoritesFilterOptionsFragment()
                )
            } else {
                placeFragment(
                    fm,
                    HomeMenuFilterOptionsFragment()
                )
            }
        }

        fun goToParkDetails(fm: FragmentManager, park: Park) {
            placeFragment(
                fm,
                ParkDetailsFragment(park)
            )
        }

    }

}