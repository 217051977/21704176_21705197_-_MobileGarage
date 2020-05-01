package pt.ulusofona.cm.mobilegarage.ui.fragments

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
import pt.ulusofona.cm.mobilegarage.R
import pt.ulusofona.cm.mobilegarage.ui.viewmodels.MyVehiclesViewModel

class MyVehiclesFragment : Fragment() {

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
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

}
