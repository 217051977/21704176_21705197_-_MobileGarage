package pt.ulusofona.cm.mobilegarage.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import butterknife.ButterKnife
import com.google.android.material.tabs.TabLayout
import pt.ulusofona.cm.mobilegarage.R
import pt.ulusofona.cm.mobilegarage.ui.adapters.ViewPagerAdapter

class ContactsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_contacts,
            container,
            false
        )

        val viewPager: ViewPager = view.findViewById(R.id.pager)
        val tabLayout: TabLayout = view.findViewById(R.id.tab_layout)

        val adapter = ViewPagerAdapter(childFragmentManager)

        adapter.addFragment(ServiceStationFragment(), "Station")
        adapter.addFragment(ContactGeneralFragment(), "General")
        adapter.addFragment(ServiceVehiclesFragment(), "Vehicles")

        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)

        ButterKnife.bind(this, view)
        return view
    }








}