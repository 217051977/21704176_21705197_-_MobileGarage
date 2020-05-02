package pt.ulusofona.cm.mobilegarage.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import butterknife.ButterKnife
import butterknife.OnClick
import kotlinx.android.synthetic.main.fragment_filter_options.*
import pt.ulusofona.cm.mobilegarage.R
import pt.ulusofona.cm.mobilegarage.ui.viewmodels.FilterOptionsViewModel

private val TAG: String = FilterOptionsFragment::class.java.simpleName

class FilterOptionsFragment : Fragment() {

    private lateinit var viewModel: FilterOptionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_filter_options,
            container,
            false
        )
        viewModel = ViewModelProvider(this).get(FilterOptionsViewModel::class.java)
        ButterKnife.bind(this, view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpSeekBar()
        when (viewModel.getFilterSortStatus()) {
            "availability" -> filter_sort_by_availability.isChecked = true
            else -> filter_sort_by_distance.isChecked = true
        }
        when (viewModel.getFilterParkTypeStatus()) {
            "structure" -> filter_park_type_structure.isChecked = true
            "surface" -> filter_park_type_surface.isChecked = true
            else -> filter_park_type_all.isChecked = true
        }

    }

    @OnClick(
        R.id.filter_sort_by_distance
    )
    fun onClickSortByDistanceFilter(view: View) {
        viewModel.onClickSortByDistanceFilter(
            TAG,
            activity as Context,
            "filter_ascending_order_distance"
        )
    }

    @OnClick(
        R.id.filter_sort_by_availability
    )
    fun onClickSortByAvailabilityFilter(view: View) {
        viewModel.onClickSortByAvailabilityFilter(
            TAG,
            activity as Context,
            "filter_ascending_order_availability"
        )
    }

    @OnClick(
        R.id.filter_park_type_surface
    )
    fun onClickSurfaceParkFilter(view: View) {
        viewModel.onClickSurfaceParkFilter(
            TAG,
            activity as Context,
            "filter_park_type_surface"
        )
    }

    @OnClick(
        R.id.filter_park_type_structure
    )
    fun onClickStructureParkFilter(view: View) {
        viewModel.onClickStructureParkFilter(
            TAG,
            activity as Context,
            "filter_park_type_structure"
        )
    }

    @OnClick(
        R.id.filter_park_type_all
    )
    fun onClickAllParksFilter(view: View) {
        viewModel.onClickAllParksFilter(
            TAG,
            activity as Context,
            "filter_park_type_structure"
        )
    }

    @OnClick(
        R.id.filter_checkable_accessible_to_disable_people
    )
    fun onClickCheckableDisablePeopleFilter(view: View) {
        viewModel.onClickCheckableDisablePeopleFilter(
            TAG,
            activity as Context,
            "filter_checkable_accessible_to_disable_people")
    }

    @OnClick(
        R.id.filter_apply_button
    )
    fun onClickApplyButton(view: View) {
        viewModel.onClickApplyButton(
            TAG,
            activity as Context,
            "filter_apply_button",
            activity?.supportFragmentManager!!
        )
    }

    private fun setUpSeekBar() {
        filter_distance_bar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                viewModel.manageMovementSeekBar(progress, filter_distance_value)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                viewModel.manageStartMovementSeekBar()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                viewModel.manageStopMovementSeekBar(
                    TAG,
                    activity as Context,
                    resources.getString(R.string.variable_filter_distance)
                )
            }
        })
    }

}