package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.fragments

import android.content.Context
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
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.viewmodels.ParkViewModel

private val TAG = HomeMenuFragment::class.java.simpleName

class HomeMenuFragment : Fragment(), OnReceiveParks {

    private lateinit var viewModel: ParkViewModel

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
        ButterKnife.bind(this, view)
        return view
    }

    override fun onReceiveParks(parks: List<Park>) {

        parks.let {

            Log.i(TAG, "Parks: $parks")
            parking_list.layoutManager = LinearLayoutManager(activity as Context)
            if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                parking_list.adapter =
                    ParkingListLandScapeAdapter(
                        activity as Context,
                        R.layout.item_park_element,
                        parks as MutableList<Park>,
                        activity?.supportFragmentManager!!
                    )
            } else {
                parking_list.adapter =
                    ParkingListAdapter(
                        activity as Context,
                        R.layout.item_park_element,
                        parks as MutableList<Park>,
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