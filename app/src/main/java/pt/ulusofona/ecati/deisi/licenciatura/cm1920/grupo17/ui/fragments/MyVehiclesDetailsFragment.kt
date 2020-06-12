package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import butterknife.ButterKnife
import butterknife.OnClick
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_my_vehicles_details.*

import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.R
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities.Vehicle
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.listeners.OnReceiveVehicle
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.viewmodels.MyVehiclesViewModel

private val TAG = MyVehiclesDetailsFragment::class.java.simpleName

class MyVehiclesDetailsFragment(vehicle: Vehicle) : Fragment(), OnReceiveVehicle {

    private lateinit var viewModel: MyVehiclesViewModel
    private val vehicle = vehicle

    override fun onStart() {
        viewModel.registerListenerVehicle(this, vehicle)
        super.onStart()
    }

    override fun onDestroy() {
        viewModel.unregisterListenerVehicle()
        super.onDestroy()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_my_vehicles_details,
            container,
            false
        )
        viewModel = ViewModelProvider(this).get(MyVehiclesViewModel::class.java)
        ButterKnife.bind(this, view)
        return view
    }

    override fun onReceiveVehicle(vehicle: Vehicle) {

        vehicle.let {

            Log.i(TAG, "Vehicle: $vehicle")
            vehicle_detail_brand.text = vehicle.brand
            vehicle_detail_model.text = vehicle.model
            vehicle_detail_plate.text = vehicle.plate
            vehicle_detail_plate_date.text = vehicle.plateDate

        }
    }

    @OnClick(R.id.my_vehicles_details_delete)
    fun onClickDeleteVehicle(view: View) {
        viewModel.onClickDeleteVehicle(activity?.supportFragmentManager!!, vehicle)
        val snackbar: Snackbar = Snackbar.make(view, "Deleted ${vehicle.plate} Vehicle", Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    @OnClick(R.id.my_vehicles_details_edit)
    fun onClickEditVehicle(view: View) {
        viewModel.onClickEditVehicle(activity?.supportFragmentManager!!, vehicle)
    }

    @OnClick(R.id.vehicle_detail_contact)
    fun onClickBlockVehicle(view: View) {
        viewModel.onClickBlockVehicle(activity as Context, vehicle)
    }

    @OnClick(R.id.my_vehicles_details_back)
    fun onClickCancel(view: View) {
        viewModel.onClickCancelAddVehicle(activity?.supportFragmentManager!!)
    }
}

