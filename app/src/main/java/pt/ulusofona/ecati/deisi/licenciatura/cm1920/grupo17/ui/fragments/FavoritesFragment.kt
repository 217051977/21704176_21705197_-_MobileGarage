package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.fragments

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import butterknife.ButterKnife
import butterknife.OnClick
import kotlinx.android.synthetic.main.fragment_home_menu.*
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.R
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities.Park
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.adapters.FavoritesAdapter
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.adapters.FavoritesLandScapeAdapter
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.listeners.OnReceiveFavorites
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.viewmodels.FilterOptionsViewModel
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.viewmodels.ParkViewModel

class FavoritesFragment : Fragment(), OnReceiveFavorites {

    private lateinit var viewModel: ParkViewModel
    private lateinit var viewModelFilters: FilterOptionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_favorites,
            container,
            false
        )
        viewModel = ViewModelProvider(this).get(ParkViewModel::class.java)
        viewModelFilters = ViewModelProvider(this).get(FilterOptionsViewModel::class.java)
        ButterKnife.bind(this, view)
        return view
    }

    override fun onStart() {
        viewModel.registerListenerFavorites(this)
        super.onStart()
    }

    override fun onDestroy() {
        viewModel.unregisterListenerFavorites()
        super.onDestroy()
    }

    private fun sortParks(filterStatus: Array<String>, parksToSort: MutableList<Park>): List<Park> {

        var parks: MutableList<Park> = mutableListOf()
        val parksAux: MutableList<Park> = mutableListOf()

        when (filterStatus[1]) {
            "all" -> {
                parks = parksToSort
            }
            "structure" -> {
                for (park in parksToSort) {
                    if (park.type.toLowerCase() == "estrutura") {
                        parks.add(park)
                    }
                }
            }
            "surface" -> {
                for (park in parksToSort) {
                    if (park.type.toLowerCase() == "superfície") {
                        parks.add(park)
                    }
                }
            }
        }

        if (filterStatus[2].toBoolean()) {
            for (park in parks) {
                if (park.nrParkingSpotForDisablePeople > 0) {
                    parksAux.add(park)
                }
            }
            parks.clear()
            parks.addAll(parksAux)
            parksAux.clear()
        }

        val distance = filterStatus[3].toInt()

        if (distance > 0) {
            for (park in parks) {
                if (park.distance <= distance) {
                    parksAux.add(park)
                }
            }
            parks.clear()
            parks.addAll(parksAux)
            parksAux.clear()
        }

        when (filterStatus[0]) {
            "distance" -> parks.sortBy { it.distance }
            else -> parks.sortByDescending { it.availability }
        }

        return parks.toList()
    }

    override fun onReceiveFavorites(favorites: List<Park>) {

        val filterStatus = viewModelFilters.getFilters()/* activity?.intent!!.getStringArrayExtra(EXTRA_FILTERS)*/
        var parksToShow = favorites

        if (filterStatus != null) {
            parksToShow = sortParks(filterStatus, favorites.toMutableList())
        }

        favorites.let {
            parking_list.layoutManager = LinearLayoutManager(activity as Context)
            if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                parking_list.adapter =
                    FavoritesLandScapeAdapter(
                        activity as Context,
                        R.layout.item_park_element,
                        parksToShow as MutableList<Park>,
                        activity?.supportFragmentManager!!
                )
            } else {
                parking_list.adapter =
                    FavoritesAdapter(
                        activity as Context,
                        R.layout.item_park_element,
                        parksToShow as MutableList<Park>,
                        activity?.supportFragmentManager!!
                    )
            }
        }
    }

    @OnClick(
        R.id.filter_button_favorites
    )
    fun onClickFilter(view: View) {
        viewModel.goToFilterOption(
            activity as Context,
            this::class.java.simpleName,
            activity?.supportFragmentManager!!,
            fav = true
        )
    }
}
