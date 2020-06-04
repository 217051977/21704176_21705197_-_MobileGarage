package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.viewmodels

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities.Feedback
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.adapters.ViewPagerAdapter
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.fragments.ContactGeneralFragment
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.fragments.ServiceStationFragment
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.fragments.ServiceVehiclesFragment
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.utils.DrawerNavigationManager

class DrawerViewModel : ViewModel() {

    private val feedback: Feedback = Feedback.getInstance()

    fun setAdapter(childFragmentManager: FragmentManager): ViewPagerAdapter {
        val adapter: ViewPagerAdapter =
            ViewPagerAdapter(
                childFragmentManager
            )
        adapter.addFragment(ServiceStationFragment(), "Station")
        adapter.addFragment(ContactGeneralFragment(), "General")
        adapter.addFragment(ServiceVehiclesFragment(), "Vehicles")
        return adapter
    }

    fun onClickProfile(
        context: Context,
        TAG: String?,
        supportFragmentManager: FragmentManager
    ) {
        feedback.createFullButton(TAG, context, "nav_bar_profile")
        DrawerNavigationManager.goToProfile(supportFragmentManager)
    }

    fun onClickMyVehicles(
        context: Context,
        TAG: String?,
        supportFragmentManager: FragmentManager
    ) {
        feedback.createFullButton(TAG, context, "nav_bar_my_vehicles")
        DrawerNavigationManager.goToMyVehicles(supportFragmentManager)
    }

    fun onClickContacts(
        context: Context,
        TAG: String?,
        supportFragmentManager: FragmentManager
    ) {
        feedback.createFullButton(TAG, context,"nav_contacts")
        DrawerNavigationManager.goToContacts(supportFragmentManager)
    }

    fun onClickGira(
        context: Context,
        TAG: String?,
        supportFragmentManager: FragmentManager
    ) {
        feedback.createFullButton(TAG, context,"nav_contacts")
        DrawerNavigationManager.goToGira(supportFragmentManager)
    }

    fun onClickTraffic(
        context: Context,
        TAG: String?,
        supportFragmentManager: FragmentManager
    ) {
        feedback.createFullButton(TAG, context,"nav_contacts")
        DrawerNavigationManager.goToTraffic(supportFragmentManager)
    }

    fun onClickMap(
        context: Context,
        TAG: String?,
        supportFragmentManager: FragmentManager
    ) {
        feedback.createFullButton(TAG, context,"nav_contacts")
        DrawerNavigationManager.goToMap(supportFragmentManager)
    }

    fun onClickFindVehicle(
        context: Context,
        TAG: String?,
        supportFragmentManager: FragmentManager
    ) {
        feedback.createFullButton(TAG, context,"nav_contacts")
        DrawerNavigationManager.goToFindVehicle(supportFragmentManager)
    }

    fun onClickShareLocation(
        context: Context,
        TAG: String?,
        supportFragmentManager: FragmentManager
    ) {
        feedback.createFullButton(TAG, context,"nav_contacts")
        DrawerNavigationManager.goToShareLocation(supportFragmentManager)
    }

}