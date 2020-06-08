package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.fragments

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import butterknife.ButterKnife
import butterknife.OnClick
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.fragment_home_menu.*
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.R
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities.Park
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.adapters.ParkingListAdapter
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.adapters.ParkingListLandScapeAdapter
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.listeners.OnReceiveParkingLots
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.viewmodels.ParkViewModel

class HomeMenuFragment : Fragment(), OnReceiveParkingLots {

    private lateinit var viewModel: ParkViewModel
    private var parks = listOf<Park>()

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel.getParks()
        Thread.sleep(60)

        parking_list.layoutManager = LinearLayoutManager(activity as Context)
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            parking_list.adapter = setLandScapeAdapter(
                activity as Context,
                activity?.supportFragmentManager!!,
                viewModel
            )
        } else {
            parking_list.adapter = setAdapter(
                activity as Context,
                activity?.supportFragmentManager!!,
                viewModel
            )
        }
    }

    override fun onReceiveParkingLots(parks: List<Park>) = parks.let { this.parks = it }

    override fun onStart() {
        viewModel.registerListenerParks(this)
        super.onStart()
    }

    override fun onDestroy() {
        viewModel.unregisterListener()
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

    private fun setLandScapeAdapter(
        context: Context,
        supportFragmentManager: FragmentManager,
        viewModel: ParkViewModel
    ): ParkingListLandScapeAdapter {
        return if (parks.isNotEmpty()) {
            ParkingListLandScapeAdapter(
                context,
                R.layout.item_park_element,
                parks as MutableList <Park>,
                supportFragmentManager,
                viewModel
            )
        } else {
            ParkingListLandScapeAdapter(
                context,
                R.layout.item_park_element,
                mutableListOf(),
                supportFragmentManager,
                viewModel
            )
        }
    }

    private fun setAdapter(
        context: Context,
        supportFragmentManager: FragmentManager,
        viewModel: ParkViewModel
    ): ParkingListAdapter {
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
