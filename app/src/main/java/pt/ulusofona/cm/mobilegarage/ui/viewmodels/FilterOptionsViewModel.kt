package pt.ulusofona.cm.mobilegarage.ui.viewmodels

import android.content.Context
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import pt.ulusofona.cm.mobilegarage.R
import pt.ulusofona.cm.mobilegarage.data.local.entities.Feedback
import pt.ulusofona.cm.mobilegarage.data.local.entities.Park
import pt.ulusofona.cm.mobilegarage.domain.mobilegarage.FilterLogic
import pt.ulusofona.cm.mobilegarage.ui.utils.NavBarNavigationManager
import pt.ulusofona.cm.mobilegarage.ui.utils.ParkNavigationManager

class FilterOptionsViewModel : ViewModel() {

    private val feedback: Feedback = Feedback.getInstance()
    private val filterLogic: FilterLogic = FilterLogic()

    private var distanceBarValue: Int = 0

    fun getFilterSortStatus(): String = filterLogic.getFilterSortStatus()

    fun getFilterParkTypeStatus(): String = filterLogic.getFilterParkTypeStatus()

    fun getAccessibilityStatus(): Boolean = filterLogic.getAccessibilityStatus()

    fun getDistanceValueStatus(): Int = filterLogic.getDistanceValueStatus()

    fun onClickSortByDistanceFilter(TAG: String, context: Context, messageIntro: String) {
        feedback.createFullMessage(TAG, context, messageIntro)
        filterLogic.setSortByDistanceStatus()
    }

    fun onClickSortByAvailabilityFilter(TAG: String, context: Context, messageIntro: String) {
        feedback.createFullMessage(TAG, context, messageIntro)
        filterLogic.setSortByAvailabilityStatus()
    }

    fun onClickSurfaceParkFilter(TAG: String, context: Context, messageIntro: String) {
        feedback.createFullMessage(TAG, context, messageIntro)
        filterLogic.setSurfaceParkDistanceStatus()
    }

    fun onClickStructureParkFilter(TAG: String, context: Context, messageIntro: String) {
        feedback.createFullMessage(TAG, context, messageIntro)
        filterLogic.setStructureParkAvailabilityStatus()
    }

    fun onClickAllParksFilter(TAG: String, context: Context, messageIntro: String) {
        feedback.createFullMessage(TAG, context, messageIntro)
        filterLogic.setAllParkAllStatus()
    }

    fun onClickCheckableDisablePeopleFilter(
        TAG: String,
        context: Context,
        messageIntro: String,
        status: Boolean
    ) {
        feedback.createFullMessage(TAG, context, messageIntro)
        filterLogic.setAccessibilityStatus(status)
    }

    fun manageMovementSeekBar(progress: Int, distanceValue: TextView) {
        distanceBarValue = progress
        val value: String = "${distanceBarValue}m"
        distanceValue.text = value
    }

    fun manageStopMovementSeekBar(TAG: String, context: Context, messageIntro: String) {
        feedback.createFullMessage(TAG, context, "$messageIntro $distanceBarValue")
        filterLogic.setDistanceValueStatus(distanceBarValue)
    }

    fun manageStartMovementSeekBar() = null

    fun onClickApplyButton(
        TAG: String,
        context: Context,
        messageIntro: String,
        fm: FragmentManager,
        fav:Boolean = false
    ) {
        feedback.createFullMessage(TAG, context, messageIntro)
        if (fav) {
            NavBarNavigationManager.goToFavorites(fm)
        } else {
            NavBarNavigationManager.goToHomePage(fm)
        }
    }

}
