package pt.ulusofona.cm.mobilegarage.ui.viewmodels

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import pt.ulusofona.cm.mobilegarage.domain.mobilegarage.DrawerLogic
import pt.ulusofona.cm.mobilegarage.domain.mobilegarage.NavBarLogic
import pt.ulusofona.cm.mobilegarage.ui.utils.DrawerNavigationManager
import pt.ulusofona.cm.mobilegarage.ui.utils.NavBarNavigationManager
import pt.ulusofona.cm.mobilegarage.ui.utils.NavigationManager

class DrawerViewModel : ViewModel() {

    private val drawerLogic = DrawerLogic()

    fun onClickContacts(
        context: Context,
        TAG: String?,
        supportFragmentManager: FragmentManager
    ) {
        makeLog(TAG, "nav_contacts")
        makeToast(context, "nav_contacts")
        DrawerNavigationManager.goToContacts(supportFragmentManager)
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