package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.viewmodels

import android.app.Application
import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.AndroidViewModel
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
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.listeners.OnReceiveFavorites
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.listeners.OnReceivePark
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.listeners.OnReceiveParks
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.utils.ParkNavigationManager

const val ENDPOINT = "https://emel.city-platform.com/opendata/"

class ParkViewModel(application: Application): AndroidViewModel(application) {

    private val local = MobileGarageDatabase.getInstance(application).parkDao()
    private val remote = RetrofitBuilder.getInstance(ENDPOINT)

    private val parksLogic: ParksLogic = ParksLogic(ParkRepository(local = local, remote = remote))
    private val feedback: Feedback = Feedback.getInstance()

    private var listenerParks: OnReceiveParks? = null
    private var listenerFavorites: OnReceiveFavorites? = null
    private var listenerPark: OnReceivePark? = null

    var parks = listOf<Park>()
    var favorites = listOf<Park>()
    var park: Park? = null

    fun registerListenerParks(listener: OnReceiveParks) {
        this.listenerParks = listener
        parksLogic.getParks(listenerParks)
    }

    fun registerListenerPark(listener: OnReceivePark) {
        this.listenerPark = listener
    }

    fun registerListenerFavorites(listener: OnReceiveFavorites) {
        this.listenerFavorites = listener
        parksLogic.getFavorites(listenerFavorites)

    }

    fun unregisterListenerParks() {
        listenerParks = null
    }

    fun unregisterListenerPark() {
        listenerPark = null
    }


    fun unregisterListenerFavorites() {
        listenerFavorites = null
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

    fun setFavoritesLandScapeAdapter(
        context: Context,
        supportFragmentManager: FragmentManager
    ): FavoritesLandScapeAdapter {
        return FavoritesLandScapeAdapter(
            context,
            R.layout.item_park_element,
            favorites as MutableList<Park>,
            listenerPark,
            supportFragmentManager
        )
    }

    fun setFavoritesAdapter(
        context: Context,
        supportFragmentManager: FragmentManager
    ): FavoritesAdapter {
        return FavoritesAdapter(
            context,
            R.layout.item_park_element,
            favorites as MutableList<Park>,
            listenerPark,
            supportFragmentManager
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