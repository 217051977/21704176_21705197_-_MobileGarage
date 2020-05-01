package pt.ulusofona.cm.mobilegarage.ui.viewmodels

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import pt.ulusofona.cm.mobilegarage.data.local.entities.Feedback
import pt.ulusofona.cm.mobilegarage.ui.adapters.ViewPagerAdapter
import pt.ulusofona.cm.mobilegarage.ui.fragments.ContactGeneralFragment
import pt.ulusofona.cm.mobilegarage.ui.fragments.ServiceStationFragment
import pt.ulusofona.cm.mobilegarage.ui.fragments.ServiceVehiclesFragment
import pt.ulusofona.cm.mobilegarage.ui.utils.DrawerNavigationManager

class DrawerViewModel : ViewModel() {

    private val feedback: Feedback = Feedback.getInstance()

    fun setAdapter(childFragmentManager: FragmentManager): ViewPagerAdapter {
        val adapter: ViewPagerAdapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFragment(ServiceStationFragment(), "Station")
        adapter.addFragment(ContactGeneralFragment(), "General")
        adapter.addFragment(ServiceVehiclesFragment(), "Vehicles")
        return adapter
    }

    fun onClickContacts(
        context: Context,
        TAG: String?,
        supportFragmentManager: FragmentManager
    ) {
        feedback.createFullButton(TAG, context,"nav_contacts")
        DrawerNavigationManager.goToContacts(supportFragmentManager)
    }

}