package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.fragments

import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import butterknife.ButterKnife
import butterknife.OnClick
import kotlinx.android.synthetic.main.fragment_park_details.*
import org.w3c.dom.Text
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.R
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities.Park
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.listeners.OnReceivePark
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.viewmodels.ParkViewModel

const val SHARED_PREFS = "sharePrefs"
const val NAME = "name"
const val ADDRESS = "address"
const val LAST_UPDATE = "lastUpdate"
const val DISTANCE = "distance"
const val TYPE = "type"
const val NR_PARKS = "nrParks"
const val AVAILABILITY = "availability"
const val DISABLE_AVAILABILITY = "disableAvailability"

private val TAG = ParkDetailsFragment::class.java.simpleName

class ParkDetailsFragment : Fragment(), OnReceivePark {

    private lateinit var viewModel: ParkViewModel

    /*
    lateinit var parkName: TextView
    lateinit var parkAddress: TextView
    lateinit var parkLastUpdate: TextView
    lateinit var parkDistance: TextView
    lateinit var parkType: TextView
    lateinit var parkNrParks: TextView
    lateinit var parkAvailability: TextView
    lateinit var parkDisableAvailability: TextView
     */

    override fun onStart() {
        viewModel.registerListenerPark(this)
        super.onStart()
    }

    override fun onDestroy() {
        viewModel.unregisterListenerPark()
        super.onDestroy()
    }

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

        /*
        parkName = view.findViewById(R.id.park_details_name)
        parkAddress = view.findViewById(R.id.park_details_address)
        parkLastUpdate = view.findViewById(R.id.park_details_last_update)
        parkDistance = view.findViewById(R.id.park_details_distance)
        parkType = view.findViewById(R.id.park_details_type)
        parkNrParks = view.findViewById(R.id.park_details_nr_parks)
        parkAvailability = view.findViewById(R.id.park_details_availability)
        parkDisableAvailability = view.findViewById(R.id.park_details_availability_nr_parks)
         */

        viewModel = ViewModelProvider(this).get(ParkViewModel::class.java)
        ButterKnife.bind(this, view)
        return view
    }

    override fun onReceivePark(park: Park?) {

        park.let {

            viewModel.park = park

            Log.i(TAG, "Park: $park")
            park_details_name.text = park?.name
            park_details_address.text = park?.address
            park_details_last_update.text = park?.getLastUpdateNotification()
            park_details_distance.text = park?.distance.toString()
            park_details_type.text = park?.type
            park_details_nr_parks.text = park?.nrParkingSpot.toString()
            park_details_availability.text = park?.getAvailabilityStatus()
            park_details_availability_nr_parks.text =
                park?.nrParkingSpotForDisablePeople.toString()

        }
    }

    @OnClick(
        R.id.park_details_go_to
    )
    fun goTo(view: View) {
        val gmmIntentURI: Uri = Uri.parse("google.navigation:q=${viewModel.park?.address}")
        val mapIntent: Intent = Intent(Intent.ACTION_VIEW, gmmIntentURI)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
    }

}
