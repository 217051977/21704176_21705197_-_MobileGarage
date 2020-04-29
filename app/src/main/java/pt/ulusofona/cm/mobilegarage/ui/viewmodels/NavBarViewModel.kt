package pt.ulusofona.cm.mobilegarage.ui.viewmodels

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import pt.ulusofona.cm.mobilegarage.domain.mobilegarage.NavBarLogic
import pt.ulusofona.cm.mobilegarage.ui.utils.NavigationManager

class NavBarViewModel : ViewModel() {

    private val navBarLogic = NavBarLogic()

    fun onClickHome(supportFragmentManager: FragmentManager) {
        NavigationManager.goToHomePage(supportFragmentManager)
    }

    fun onClickVehicleList() {

    }

    fun onClickFavorites() {
        NavigationManager
    }

    fun onClickParkMeNow() {

    }

    fun onClickProfile() {
        NavigationManager
    }

}