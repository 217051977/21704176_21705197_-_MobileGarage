package pt.ulusofona.cm.mobilegarage.ui.viewmodels

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import pt.ulusofona.cm.mobilegarage.ui.utils.ParkNavigationManager

class ParkViewModel : ViewModel() {

    fun onClickVehicleDetails(supportFragmentManager: FragmentManager ) {
        ParkNavigationManager.goToParkDetails(supportFragmentManager)
    }

}