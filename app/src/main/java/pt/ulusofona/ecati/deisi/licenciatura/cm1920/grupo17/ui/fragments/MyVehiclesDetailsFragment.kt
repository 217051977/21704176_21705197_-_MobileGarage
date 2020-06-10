package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.fragments

import android.os.Bundle
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

class MyVehiclesDetailsFragment : Fragment(), OnReceiveVehicle {

    private lateinit var viewModel: MyVehiclesViewModel

    override fun onStart() {
        viewModel.registerListenerVehicle(this)
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

        vehicle.let { viewModel.vehicle = vehicle }

        vehicle_detail_brand.text = vehicle.brand
        vehicle_detail_model.text = vehicle.model
        vehicle_detail_plate.text = vehicle.plate
        vehicle_detail_plate_date.text = vehicle.plateDate

    }

    /**************** FUNCTIONS ************************/
    @OnClick(R.id.my_vehicles_details_delete)
    fun onClickDeleteVehicle(view: View) {
        val vehicle = viewModel.vehicle!!
        val snackbar: Snackbar = Snackbar.make(view, "Deleted ${vehicle.plate} Vehicle", Snackbar.LENGTH_LONG);
        snackbar.show();
        viewModel.onClickDeleteVehicle(activity?.supportFragmentManager!!, vehicle)
    }

    @OnClick(R.id.my_vehicles_details_back)
    fun onClickCancel(view: View) {
        viewModel.onClickCancelAddVehicle(activity?.supportFragmentManager!!)
    }

    /**************** END ************************/

}

