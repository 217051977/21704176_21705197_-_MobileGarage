package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import butterknife.ButterKnife
import com.google.android.material.tabs.TabLayout
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.R
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.adapters.ViewPagerAdapter
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.viewmodels.DrawerViewModel

class ContactsFragment : Fragment() {

    private lateinit var viewModel: DrawerViewModel

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

        viewModel = ViewModelProvider(this).get(DrawerViewModel::class.java)

        viewPager.adapter = setAdapter(childFragmentManager)

        tabLayout.setupWithViewPager(viewPager)

        ButterKnife.bind(this, view)
        return view
    }

    private fun setAdapter(childFragmentManager: FragmentManager): ViewPagerAdapter {
        val adapter =
            ViewPagerAdapter(
                childFragmentManager
            )
        adapter.addFragment(ServiceStationFragment(), "Station")
        adapter.addFragment(ContactGeneralFragment(), "General")
        adapter.addFragment(ServiceVehiclesFragment(), "Vehicles")
        return adapter
    }
}