package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.fragments

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
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
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.adapters.ParkingListAdapter
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.adapters.ParkingListLandScapeAdapter
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.listeners.OnReceiveParks
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.viewmodels.FilterOptionsViewModel
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.viewmodels.ParkViewModel

private val TAG = HomeMenuFragment::class.java.simpleName

class HomeMenuFragment : Fragment(), OnReceiveParks {

    private lateinit var viewModel: ParkViewModel
    private lateinit var viewModelFilters: FilterOptionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(
            R.layout.fragment_home_menu,
            container,
            false
        )
        viewModel = ViewModelProvider(this).get(ParkViewModel::class.java)
        viewModelFilters = ViewModelProvider(this).get(FilterOptionsViewModel::class.java)
        ButterKnife.bind(this, view)
        return view
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

    override fun onReceiveParks(parks: List<Park>) {

        val filterStatus = viewModelFilters.getFilters()/* activity?.intent!!.getStringArrayExtra(EXTRA_FILTERS)*/
        var parksToShow = parks

        if (filterStatus != null) {
            parksToShow = sortParks(filterStatus, parks.toMutableList())
        }

        parks.let {

            Log.i(TAG, "Parks: $parks")
            parking_list.layoutManager = LinearLayoutManager(activity as Context)
            if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                parking_list.adapter =
                    ParkingListLandScapeAdapter(
                        activity as Context,
                        R.layout.item_park_element,
                        parksToShow as MutableList<Park>,
                        activity?.supportFragmentManager!!
                    )
            } else {
                parking_list.adapter =
                    ParkingListAdapter(
                        activity as Context,
                        R.layout.item_park_element,
                        parksToShow as MutableList<Park>,
                        activity?.supportFragmentManager!!
                    )
            }
        }
    }

    override fun onStart() {
        viewModel.registerListenerParks(this, view, activity as Context)
        super.onStart()
    }

    override fun onDestroy() {
        viewModel.unregisterListenerParks()
        super.onDestroy()
    }

    @OnClick(
        R.id.filter_button_home_menu
    )
    fun onClickFilter(view: View) {
        viewModel.goToFilterOption(
            activity as Context,
            this::class.java.simpleName,
            activity?.supportFragmentManager!!
        )
    }
}