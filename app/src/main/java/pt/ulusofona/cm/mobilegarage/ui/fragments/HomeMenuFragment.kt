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
import kotlinx.android.synthetic.main.fragment_home_menu.*
import pt.ulusofona.cm.mobilegarage.R
import pt.ulusofona.cm.mobilegarage.data.local.entities.Park
import pt.ulusofona.cm.mobilegarage.data.local.list.MockingDBParks
import pt.ulusofona.cm.mobilegarage.ui.adapters.ParkingListAdapter
import pt.ulusofona.cm.mobilegarage.ui.viewmodels.HomeMenuViewModel
import java.util.*

class HomeMenuFragment : Fragment() {

    private val storage: MockingDBParks = MockingDBParks.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_home_menu,
            container,
            false
        )
//        homeMenuViewModel = ViewModelProvider(this).get(HomeMenuViewModel::class.java)
        ButterKnife.bind(this, view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        parking_list.layoutManager = LinearLayoutManager(activity as Context)
        parking_list.adapter = ParkingListAdapter(
            activity as Context,
            R.layout.item_park_element,
            storage.getAll() as MutableList<Park>,
            activity?.supportFragmentManager!!
        )
    }

}
