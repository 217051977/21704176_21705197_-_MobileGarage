package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.viewmodels

import android.app.Application
import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import kotlinx.android.synthetic.main.fragment_park_details.*
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.R
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities.Feedback
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities.Park
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.room.MobileGarageDatabase
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.remote.RetrofitBuilder
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.repositories.ParkRepository
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.domain.mobilegarage.ParksLogic
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.adapters.FavoritesAdapter
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.adapters.FavoritesLandScapeAdapter
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.adapters.ParkingListAdapter
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.adapters.ParkingListLandScapeAdapter
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.listeners.OnReceivePark
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.listeners.OnReceiveParkingLots
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.utils.ParkNavigationManager

const val ENDPOINT = "https://emel.city-platform.com/opendata/"

class ParkViewModel(application: Application): AndroidViewModel(application) {

    private val local = MobileGarageDatabase.getInstance(application).parkDao()
    private val remote = RetrofitBuilder.getInstance(ENDPOINT)

    private val parksLogic: ParksLogic = ParksLogic(ParkRepository(local = local, remote = remote))
    private val feedback: Feedback = Feedback.getInstance()

    private var listenerParks: OnReceiveParkingLots? = null
    private var listenerPark: OnReceivePark? = null
    var parks = listOf<Park>(
        /*Park(
            parkID = "park1",
            name = "park1",
            lastDate = Calendar.getInstance(),
            type = "Estruturado",
            nrParkingSpot = 0
        )*/
    )
    var park: Park? = null

    fun registerListenerParks(listener: OnReceiveParkingLots) {
        this.listenerParks = listener
        parksLogic.getParks(listenerParks)
    }


    fun registerListenerPark(listener: OnReceivePark) {
        this.listenerPark = listener
    }


    fun unregisterListenerParks() {
        listenerParks = null
    }

    fun unregisterListenerPark() {
        listenerPark = null
    }

    fun goToFilterOption(
        context: Context,
        TAG: String,
        supportFragmentManager: FragmentManager,
        fav: Boolean = false
    ) {
        feedback.createFullButton(TAG, context, "filter")
        ParkNavigationManager.goToFilterOptions(supportFragmentManager, fav)
    }

    fun setParkToShow(park: Park) {
        //parksLogic.setParkToShow(park)
    }

    fun setFavoritesLandScapeAdapter(
        context: Context,
        supportFragmentManager: FragmentManager,
        viewModel: ParkViewModel
    ): FavoritesLandScapeAdapter {
        return FavoritesLandScapeAdapter(
            context,
            R.layout.item_park_element,
           /* parksLogic.getAllFavorites()*/ null as MutableList<Park>,
            supportFragmentManager,
            viewModel
        )
    }

    fun setFavoritesAdapter(
        context: Context,
        supportFragmentManager: FragmentManager,
        viewModel: ParkViewModel
    ): FavoritesAdapter {
        return FavoritesAdapter(
            context,
            R.layout.item_park_element,
            /* parksLogic.getAllFavorites()*/ null as MutableList<Park>,
            supportFragmentManager,
            viewModel
        )
    }

     fun setLandScapeAdapter(
        context: Context,
        supportFragmentManager: FragmentManager
    ): ParkingListLandScapeAdapter {
        return if (parks.isNotEmpty()) {
            ParkingListLandScapeAdapter(
                context,
                R.layout.item_park_element,
                parks as MutableList <Park>,
                listenerPark,
                supportFragmentManager
            )
        } else {
            ParkingListLandScapeAdapter(
                context,
                R.layout.item_park_element,
                mutableListOf(),
                listenerPark,
                supportFragmentManager
            )
        }
    }

     fun setAdapter(
        context: Context,
        supportFragmentManager: FragmentManager
    ): ParkingListAdapter {
        return if (parks.isNotEmpty()) {
            ParkingListAdapter(
                context,
                R.layout.item_park_element,
                parks as MutableList <Park>,
                listenerPark,
                supportFragmentManager
            )
        } else {
            ParkingListAdapter(
                context,
                R.layout.item_park_element,
                mutableListOf(),
                listenerPark,
                supportFragmentManager
            )
        }
    }

}