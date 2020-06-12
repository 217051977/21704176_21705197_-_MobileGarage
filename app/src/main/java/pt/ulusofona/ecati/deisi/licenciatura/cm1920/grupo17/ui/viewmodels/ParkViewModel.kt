package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.viewmodels

import android.app.Activity
import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log
import android.view.View
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
private val TAG = ParkViewModel::class.java.simpleName

class ParkViewModel(application: Application): AndroidViewModel(application) {

    private val local = MobileGarageDatabase.getInstance(application).parkDao()
    private val remote = RetrofitBuilder.getInstance(ENDPOINT)

    private val parksLogic: ParksLogic = ParksLogic(ParkRepository(local = local, remote = remote))
    private val feedback: Feedback = Feedback.getInstance()

    // LISTENERS
    private var listenerParks: OnReceiveParks? = null
    private var listenerFavorites: OnReceiveFavorites? = null
    var listenerPark: OnReceivePark? = null

    var favorites = listOf<Park>()
    var park: Park? = null

    /**************** REGISTERS AND UNREGISTERS ************************/
    fun registerListenerParks(listener: OnReceiveParks, view: View?, context: Context) {
        this.listenerParks = listener

        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
        val isConnected: Boolean? = activeNetwork?.isConnected

        if (isConnected!!) {
            parksLogic.getParksOnline(listenerParks, view)
        } else {
            parksLogic.getParksOffline(listenerParks, view)
        }
    }

    fun registerListenerPark(listener: OnReceivePark, park: Park) {
        this.listenerPark = listener
        parksLogic.getPark(listener, park)
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
    /************************ END ********************************/

    fun goToFilterOption(
        context: Context,
        TAG: String,
        supportFragmentManager: FragmentManager,
        fav: Boolean = false
    ) {
        feedback.createFullButton(TAG, context, "filter")
        ParkNavigationManager.goToFilterOptions(supportFragmentManager, fav)
    }

}