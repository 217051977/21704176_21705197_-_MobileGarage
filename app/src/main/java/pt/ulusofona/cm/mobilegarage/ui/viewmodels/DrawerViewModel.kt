package pt.ulusofona.cm.mobilegarage.ui.viewmodels

import android.content.Context
import android.util.Log
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import pt.ulusofona.cm.mobilegarage.data.local.entities.Feedback
import pt.ulusofona.cm.mobilegarage.domain.mobilegarage.DrawerLogic
import pt.ulusofona.cm.mobilegarage.ui.utils.DrawerNavigationManager

class DrawerViewModel : ViewModel() {

    private val feedback: Feedback = Feedback.getInstance()
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
        feedback.makeToast(
            context,
            "Button $buttonName has been pressed!"
        )
    }

    private fun makeLog(TAG: String?, buttonName: String) {
        Log.i(TAG,
            "Button $buttonName has been pressed!"
        )
    }

}