package pt.ulusofona.cm.mobilegarage.ui.viewmodels

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import pt.ulusofona.cm.mobilegarage.R
import pt.ulusofona.cm.mobilegarage.data.local.entities.Park
import pt.ulusofona.cm.mobilegarage.domain.mobilegarage.ParksLogic
import pt.ulusofona.cm.mobilegarage.ui.adapters.FavoritesAdapter
import pt.ulusofona.cm.mobilegarage.ui.adapters.ParkingListAdapter

class ParkViewModel : ViewModel() {

    private val parksLogic: ParksLogic = ParksLogic()

    fun setFavoritesAdapter(
        context: Context,
        supportFragmentManager: FragmentManager
    ): FavoritesAdapter {
        return FavoritesAdapter(
            context,
            R.layout.item_park_element,
            parksLogic.getAllFavorites() as MutableList<Park>,
            supportFragmentManager
        )
    }

    fun setAdapter(
        context: Context,
        supportFragmentManager: FragmentManager
    ): ParkingListAdapter {
        return ParkingListAdapter(
            context,
            R.layout.item_park_element,
            parksLogic.getAll() as MutableList<Park>,
            supportFragmentManager
        )
    }

}