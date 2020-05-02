package pt.ulusofona.cm.mobilegarage.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import butterknife.ButterKnife
import butterknife.OnClick

import pt.ulusofona.cm.mobilegarage.R
import pt.ulusofona.cm.mobilegarage.data.local.entities.Vehicle
import pt.ulusofona.cm.mobilegarage.ui.viewmodels.MyVehiclesViewModel
import java.util.*

class MyVehiclesAddFragment : Fragment() {

    private lateinit var viewModel: MyVehiclesViewModel
    private lateinit var vehicleCreated: Vehicle

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_my_vehicles_add,
            container,
            false
        )


        val vehicleBrand: EditText = view.findViewById(R.id.vehicle_brand)
        val vehicleModel: EditText = view.findViewById(R.id.vehicle_model)
        val vehiclePlate: EditText = view.findViewById(R.id.vehicle_plate)
        val vehiclePlateDate: EditText = view.findViewById(R.id.vehicle_plate_date)

        vehicleCreated = Vehicle(
            brand = vehicleBrand.toString(),
            model = vehicleModel.toString(),
            plate = vehiclePlate.toString(),
            plateDate = vehiclePlateDate.toString(),
            insuranceDeadLineDate = Calendar.getInstance(),
            category = "N",
            month = 0,
            year = 0,
            pictureSrc = "mipmap-xxxhdpi/mustang_shelby_gt500.jpg",
            isParked = false,
            vehicleTypeIconSrc = "drawable/ic_directions_car_black_24dp.xml"
            )



        viewModel = ViewModelProvider(this).get(MyVehiclesViewModel::class.java)
        ButterKnife.bind(this, view)
        return view
    }


    @OnClick(R.id.vehicles_submit)
    fun onClickSubmitAdd(view: View) {
        viewModel.onClickSubmitAddVehicle(activity?.supportFragmentManager!!, vehicleCreated)
    }

    @OnClick(R.id.vehicles_cancel)
    fun onClickCancelAdd(view: View) {
        viewModel.onClickCancelAddVehicle(activity?.supportFragmentManager!!)
    }
}

