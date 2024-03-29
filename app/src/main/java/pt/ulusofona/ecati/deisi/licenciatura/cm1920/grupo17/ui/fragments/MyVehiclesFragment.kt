package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.fragments

import android.content.Context
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
import kotlinx.android.synthetic.main.fragment_my_vehicles.*
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.R
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities.Vehicle
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.adapters.MyVehiclesAdapter
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.listeners.OnReceiveVehicles
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.viewmodels.MyVehiclesViewModel

private val TAG = MyVehiclesFragment::class.java.simpleName

class MyVehiclesFragment : Fragment(), OnReceiveVehicles {

    private lateinit var viewModel: MyVehiclesViewModel

    override fun onStart() {
        viewModel.registerListenerVehicles(this, activity as Context)
        super.onStart()
    }

    override fun onDestroy() {
        viewModel.unregisterListenerVehicles()
        super.onDestroy()
    }

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

        vehicles.let {

            Log.i(TAG, vehicles.toString())
            vehicle_list.layoutManager = LinearLayoutManager(activity as Context)
            vehicle_list.adapter =
                MyVehiclesAdapter(
                    activity as Context,
                    R.layout.item_vehicle_list,
                    vehicles as MutableList<Vehicle>,
                    activity?.supportFragmentManager!!
                )
        }
    }

    /**************** FUNCTIONS ************************/
    @OnClick(
        R.id.add_vehicle
    )
    fun onClickAddVehicle(view: View) {
        viewModel.onClickAddVehicle(activity?.supportFragmentManager!!)
    }
}
