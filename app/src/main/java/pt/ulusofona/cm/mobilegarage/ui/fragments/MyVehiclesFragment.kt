package pt.ulusofona.cm.mobilegarage.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import butterknife.ButterKnife
import kotlinx.android.synthetic.main.fragment_my_vehicles.*
import pt.ulusofona.cm.mobilegarage.R
import pt.ulusofona.cm.mobilegarage.data.local.entities.Car
import pt.ulusofona.cm.mobilegarage.data.local.entities.Vehicle
import pt.ulusofona.cm.mobilegarage.ui.adapters.MyVehiclesAdapter
import java.util.*

class MyVehiclesFragment : Fragment() {

    private val vehicles: List<Vehicle> = listOf(
        Car(
            "25-SW-00",
            Calendar.getInstance()
        ),
        Car(
            "DF-08-23",
            Calendar.getInstance()
        ),
        Car(
            "25-26-AD",
            Calendar.getInstance()
        )
    )

    init {
        vehicles[1].setInsuranceDate(2020, 6, 2)
        vehicles[2].setInsuranceDate(1999, 5, 2)
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

        ButterKnife.bind(this, view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        vehicle_list.layoutManager = LinearLayoutManager(activity as Context)
        vehicle_list.adapter = MyVehiclesAdapter(
            activity as Context,
            R.layout.item_vehicle_list,
            vehicles as MutableList<Vehicle>
        )
    }

}
