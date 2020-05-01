package pt.ulusofona.cm.mobilegarage.ui.viewmodels

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import pt.ulusofona.cm.mobilegarage.data.local.entities.Feedback
import pt.ulusofona.cm.mobilegarage.domain.mobilegarage.NavBarLogic
import pt.ulusofona.cm.mobilegarage.ui.utils.NavBarNavigationManager

class NavBarViewModel : ViewModel() {

    private val feedback: Feedback = Feedback.getInstance()

    private val navBarLogic = NavBarLogic()

    fun onClickMyVehicles(
        context: Context,
        TAG: String?,
        supportFragmentManager: FragmentManager
    ) {
        feedback.makeLog(TAG, "nav_bar_my_vehicles")
        feedback.makeToast(context, "nav_bar_my_vehicles")
        NavBarNavigationManager.goToMyVehicles(supportFragmentManager)
    }

    fun onClickFavorites(
        context: Context,
        TAG: String?,
        supportFragmentManager: FragmentManager
    ) {
        feedback.makeLog(TAG, "nav_bar_favorites")
        feedback.makeToast(context, "nav_bar_favorites")
        NavBarNavigationManager.goToFavorites(supportFragmentManager)
    }

    fun onClickHome(
        context: Context,
        TAG: String?,
        supportFragmentManager: FragmentManager
    ) {
        feedback.makeLog(TAG, "nav_bar_home")
        feedback.makeToast(context, "nav_bar_home")
        NavBarNavigationManager.goToHomePage(supportFragmentManager)
    }

    fun onClickParkMeNow(
        context: Context,
        TAG: String?,
        supportFragmentManager: FragmentManager
    ) {
        feedback.makeLog(TAG, "nav_bar_park_me_now")
        feedback.makeToast(context, "nav_bar_park_me_now")
        NavBarNavigationManager.goToParkMeNow(supportFragmentManager)
    }

    fun onClickProfile(
        context: Context,
        TAG: String?,
        supportFragmentManager: FragmentManager
    ) {
        feedback.makeLog(TAG, "nav_bar_profile")
        feedback.makeToast(context, "nav_bar_profile")
        NavBarNavigationManager.goToProfile(supportFragmentManager)
    }

}