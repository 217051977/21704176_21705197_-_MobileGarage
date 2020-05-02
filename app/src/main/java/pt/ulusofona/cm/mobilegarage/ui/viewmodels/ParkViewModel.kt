package pt.ulusofona.cm.mobilegarage.ui.viewmodels

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import pt.ulusofona.cm.mobilegarage.R
import pt.ulusofona.cm.mobilegarage.data.local.entities.Feedback
import pt.ulusofona.cm.mobilegarage.data.local.entities.Park
import pt.ulusofona.cm.mobilegarage.domain.mobilegarage.ParksLogic
import pt.ulusofona.cm.mobilegarage.ui.adapters.FavoritesAdapter
import pt.ulusofona.cm.mobilegarage.ui.adapters.ParkingListAdapter
import pt.ulusofona.cm.mobilegarage.ui.utils.ParkNavigationManager

class ParkViewModel : ViewModel() {

    private val parksLogic: ParksLogic = ParksLogic()
    private val feedback: Feedback = Feedback.getInstance()

    fun goToFilterOption(
        context: Context,
        TAG: String,
        supportFragmentManager: FragmentManager
    ) {
        feedback.createFullButton(TAG, context, "filter")
        ParkNavigationManager.goToFilterOptions(supportFragmentManager)
    }

    fun getParkToShow(): Park? = parksLogic.getParkToShow()

    fun setParkToShow(park: Park) {
        parksLogic.setParkToShow(park)
    }

    fun setFavoritesAdapter(
        context: Context,
        supportFragmentManager: FragmentManager,
        viewModel: ParkViewModel
    ): FavoritesAdapter {
        return FavoritesAdapter(
            context,
            R.layout.item_park_element,
            parksLogic.getAllFavorites() as MutableList<Park>,
            supportFragmentManager,
            viewModel
        )
    }

    fun setAdapter(
        context: Context,
        supportFragmentManager: FragmentManager,
        viewModel: ParkViewModel
    ): ParkingListAdapter {
        val parks: List<Park> = parksLogic.getAll()
        return if (parks.isNotEmpty()) {
            ParkingListAdapter(
                context,
                R.layout.item_park_element,
                parks as MutableList <Park>,
            supportFragmentManager,
            viewModel
            )
        } else {
            ParkingListAdapter(
                context,
                R.layout.item_park_element,
                mutableListOf(),
                supportFragmentManager,
                viewModel
            )
        }
    }

}