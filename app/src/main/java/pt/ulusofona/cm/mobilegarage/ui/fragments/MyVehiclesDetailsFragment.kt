package pt.ulusofona.cm.mobilegarage.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import butterknife.ButterKnife
import butterknife.OnClick
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.fragment_my_vehicles_details.*

import pt.ulusofona.cm.mobilegarage.R
import pt.ulusofona.cm.mobilegarage.data.local.entities.Vehicle
import pt.ulusofona.cm.mobilegarage.ui.viewmodels.MyVehiclesViewModel

class MyVehiclesDetailsFragment : Fragment() {

    private lateinit var viewModel: MyVehiclesViewModel
    private lateinit var vehicleToShow: Vehicle

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        vehicleToShow = viewModel.getVehicleToShow()!!
        vehicle_detail_brand.text = vehicleToShow.brand
        vehicle_detail_model.text = vehicleToShow.model
        vehicle_detail_plate.text = vehicleToShow.plate
        vehicle_detail_plate_date.text = vehicleToShow.plateDate
    }

    @OnClick(R.id.my_vehicles_details_delete)
    fun onClickDeleteVehicle(view: View) {
        viewModel.onClickCancelAddVehicle(activity?.supportFragmentManager!!)
    }

}

