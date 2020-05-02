package pt.ulusofona.cm.mobilegarage.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import butterknife.ButterKnife

import pt.ulusofona.cm.mobilegarage.R
import pt.ulusofona.cm.mobilegarage.ui.viewmodels.MyVehiclesViewModel
import pt.ulusofona.cm.mobilegarage.ui.viewmodels.ParkViewModel

class MyVehiclesDetailsFragment : Fragment() {

    private lateinit var viewModel: MyVehiclesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_my_vehicles, // change to details
            container,
            false
        )
        viewModel = ViewModelProvider(this).get(MyVehiclesViewModel::class.java)
        ButterKnife.bind(this, view)
        return view
    }
}

