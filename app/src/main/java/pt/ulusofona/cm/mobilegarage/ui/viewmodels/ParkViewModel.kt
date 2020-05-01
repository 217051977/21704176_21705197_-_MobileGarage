package pt.ulusofona.cm.mobilegarage.ui.viewmodels

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import pt.ulusofona.cm.mobilegarage.domain.mobilegarage.NavBarLogic
import pt.ulusofona.cm.mobilegarage.ui.utils.NavBarNavigationManager
import pt.ulusofona.cm.mobilegarage.ui.utils.NavigationManager
import pt.ulusofona.cm.mobilegarage.ui.utils.ParkNavigationManager

class ParkViewModel : ViewModel() {

    fun onClickVehicleDetails(
        supportFragmentManager: FragmentManager
    ) {
        ParkNavigationManager.goToParkDetails(supportFragmentManager)
    }

}