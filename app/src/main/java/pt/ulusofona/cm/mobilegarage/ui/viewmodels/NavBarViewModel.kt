package pt.ulusofona.cm.mobilegarage.ui.viewmodels

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import pt.ulusofona.cm.mobilegarage.domain.mobilegarage.NavBarLogic
import pt.ulusofona.cm.mobilegarage.ui.utils.NavBarNavigationManager
import pt.ulusofona.cm.mobilegarage.ui.utils.NavigationManager

class NavBarViewModel : ViewModel() {

    private val navBarLogic = NavBarLogic()

    fun onClickMyVehicles(
        context: Context,
        TAG: String?,
        supportFragmentManager: FragmentManager
    ) {
        makeLog(TAG, "nav_bar_my_vehicles")
        makeToast(context, "nav_bar_my_vehicles")
        NavBarNavigationManager.goToMyVehicles(supportFragmentManager)
    }

    fun onClickFavorites(
        context: Context,
        TAG: String?,
        supportFragmentManager: FragmentManager
    ) {
        makeLog(TAG, "nav_bar_favorites")
        makeToast(context, "nav_bar_favorites")
        NavBarNavigationManager.goToFavorites(supportFragmentManager)
    }

    fun onClickHome(
        context: Context,
        TAG: String?,
        supportFragmentManager: FragmentManager
    ) {
        makeLog(TAG, "nav_bar_home")
        makeToast(context, "nav_bar_home")
        NavBarNavigationManager.goToHomePage(supportFragmentManager)
    }

    fun onClickParkMeNow(
        context: Context,
        TAG: String?,
        supportFragmentManager: FragmentManager
    ) {
        makeLog(TAG, "nav_bar_park_me_now")
        makeToast(context, "nav_bar_park_me_now")
        NavBarNavigationManager.goToParkMeNow(supportFragmentManager)
    }

    fun onClickProfile(
        context: Context,
        TAG: String?,
        supportFragmentManager: FragmentManager
    ) {
        makeLog(TAG, "nav_bar_profile")
        makeToast(context, "nav_bar_profile")
        NavBarNavigationManager.goToProfile(supportFragmentManager)
    }

    private fun makeToast(context: Context, buttonName: String) {
        Toast.makeText(
            context,
            "Button $buttonName has been pressed!",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun makeLog(TAG: String?, buttonName: String) {
        Log.i(TAG,
            "Button $buttonName has been pressed!"
        )
    }

}