package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.viewmodels

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities.Feedback
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.utils.NavBarNavigationManager

class NavBarViewModel : ViewModel() {

    private val feedback: Feedback = Feedback.getInstance()

    fun onClickFavorites(
        context: Context,
        TAG: String?,
        supportFragmentManager: FragmentManager
    ) {
        feedback.createFullButton(TAG, context, "nav_bar_favorites")
        NavBarNavigationManager.goToFavorites(supportFragmentManager)
    }

    fun onClickHome(
        context: Context,
        TAG: String?,
        supportFragmentManager: FragmentManager
    ) {
        feedback.createFullButton(TAG, context, "nav_bar_home")
        NavBarNavigationManager.goToHomePage(supportFragmentManager)
    }

    fun onClickParkMeNow(
        context: Context,
        TAG: String?,
        supportFragmentManager: FragmentManager
    ) {
        feedback.createFullButton(TAG, context, "nav_bar_park_me_now")
        NavBarNavigationManager.goToParkMeNow(supportFragmentManager)
    }

}