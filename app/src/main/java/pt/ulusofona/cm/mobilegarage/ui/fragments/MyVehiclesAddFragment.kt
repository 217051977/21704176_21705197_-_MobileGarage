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
import com.google.android.material.snackbar.Snackbar

import pt.ulusofona.cm.mobilegarage.R
import pt.ulusofona.cm.mobilegarage.data.local.entities.Vehicle
import pt.ulusofona.cm.mobilegarage.ui.viewmodels.MyVehiclesViewModel
import java.util.*

class MyVehiclesAddFragment : Fragment() {

    private lateinit var viewModel: MyVehiclesViewModel
    private lateinit var vehicleCreated: Vehicle

    lateinit var vehicleBrand: EditText
    lateinit var vehicleModel: EditText
    lateinit var vehiclePlate: EditText
    lateinit var vehiclePlateDate: EditText

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

        vehicleBrand = view.findViewById(R.id.vehicle_brand)
        vehicleModel = view.findViewById(R.id.vehicle_model)
        vehiclePlate = view.findViewById(R.id.vehicle_plate)
        vehiclePlateDate = view.findViewById(R.id.vehicle_plate_date)



        viewModel = ViewModelProvider(this).get(MyVehiclesViewModel::class.java)
        ButterKnife.bind(this, view)
        return view
    }


    @OnClick(R.id.vehicles_submit)
    fun onClickSubmitAdd(view: View) {

        vehicleCreated = Vehicle(
            brand = vehicleBrand.text.toString(),
            model = vehicleModel.text.toString(),
            plate = vehiclePlate.text.toString(),
            plateDate = vehiclePlateDate.text.toString(),
            insuranceDeadLineDate = Calendar.getInstance(),
            isParked = false
        )


        val snackbar: Snackbar = Snackbar.make(view, "Added ${vehicleCreated.plate} Vehicle", Snackbar.LENGTH_LONG);
        snackbar.show();
        viewModel.onClickSubmitAddVehicle(activity?.supportFragmentManager!!, vehicleCreated)
    }

    @OnClick(R.id.vehicles_cancel)
    fun onClickCancelAdd(view: View) {
        viewModel.onClickCancelAddVehicle(activity?.supportFragmentManager!!)
    }
}

