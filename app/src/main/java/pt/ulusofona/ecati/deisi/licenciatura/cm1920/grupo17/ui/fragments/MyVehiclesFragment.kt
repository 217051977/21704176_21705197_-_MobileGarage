package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import butterknife.ButterKnife
import butterknife.OnClick
import kotlinx.android.synthetic.main.fragment_my_vehicles.*
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.R
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities.Vehicle
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.listeners.OnReceiveVehicles
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.viewmodels.MyVehiclesViewModel

class MyVehiclesFragment : Fragment(), OnReceiveVehicles {

    private lateinit var viewModel: MyVehiclesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_my_vehicles,
            container,
            false
        )
        viewModel = ViewModelProvider(this).get(MyVehiclesViewModel::class.java)
        ButterKnife.bind(this, view)
        return view
    }

    override fun onReceiveVehicles(vehicles: List<Vehicle>) {

        vehicles.let { viewModel.vehicles = vehicles }

        vehicle_list.layoutManager = LinearLayoutManager(activity as Context)
        vehicle_list.adapter = viewModel.setAdapter(
            activity as Context,
            activity?.supportFragmentManager!!
        )
    }


    @OnClick(
        R.id.add_vehicle
    )
    fun onClickAddVehicle(view: View) {
        viewModel.onClickAddVehicle(activity?.supportFragmentManager!!)
    }

    override fun onStart() {
        viewModel.registerListenerVehicles(this)
        super.onStart()
    }

    override fun onDestroy() {
        viewModel.unregisterListenerVehicles()
        super.onDestroy()
    }

}
