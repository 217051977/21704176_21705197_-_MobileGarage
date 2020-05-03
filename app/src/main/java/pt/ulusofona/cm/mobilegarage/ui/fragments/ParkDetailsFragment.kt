package pt.ulusofona.cm.mobilegarage.ui.fragments

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import butterknife.ButterKnife
import butterknife.OnClick
import kotlinx.android.synthetic.main.fragment_park_details.*
import pt.ulusofona.cm.mobilegarage.R
import pt.ulusofona.cm.mobilegarage.data.local.entities.Park
import pt.ulusofona.cm.mobilegarage.ui.viewmodels.ParkViewModel
import java.net.URI

class ParkDetailsFragment : Fragment() {

    private lateinit var viewModel: ParkViewModel
    private lateinit var parkToShow: Park

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_park_details,
            container,
            false
        )
        viewModel = ViewModelProvider(this).get(ParkViewModel::class.java)
//        val position = intent.get
//        view.park_details_name =
        ButterKnife.bind(this, view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        parkToShow = viewModel.getParkToShow()!!
        park_details_name.text = parkToShow.name
        park_details_address.text = parkToShow.getAddressNotification()
        park_details_last_update.text = parkToShow.getLastUpdateNotification()
        park_details_distance.text = parkToShow.distance.toString()
        park_details_type.text = parkToShow.type
        park_details_nr_parks.text = parkToShow.nrParkingSpot.toString()
        park_details_availability.text = parkToShow.getAvailabilityStatus()
        park_details_availability_nr_parks.text =
            parkToShow.nrParkingSpotForDisablePeople.toString()
    }

    @OnClick(
        R.id.park_details_go_to
    )
    fun goTo(view: View) {
        val gmmIntentURI: Uri = Uri.parse("google.navigation:q=${parkToShow.address}")
        val mapIntent: Intent = Intent(Intent.ACTION_VIEW, gmmIntentURI)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
    }

}
