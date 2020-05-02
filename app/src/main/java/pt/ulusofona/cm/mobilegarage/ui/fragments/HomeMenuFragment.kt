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
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.fragment_home_menu.*
import pt.ulusofona.cm.mobilegarage.R
import pt.ulusofona.cm.mobilegarage.ui.viewmodels.ParkViewModel

class HomeMenuFragment : Fragment() {

    private lateinit var viewModel: ParkViewModel

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
        viewModel = ViewModelProvider(this).get(ParkViewModel::class.java)
        ButterKnife.bind(this, view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        parking_list.layoutManager = LinearLayoutManager(activity as Context)
        parking_list.adapter = viewModel.setAdapter(
            activity as Context,
            activity?.supportFragmentManager!!,
            viewModel
        )
    }

    @OnClick(
        R.id.filter_button_home_menu
    )
    fun onClickFilter(view: View) {
        viewModel.goToFilterOption(
            activity as Context,
            this::class.java.simpleName,
            activity?.supportFragmentManager!!
        )
//        MaterialAlertDialogBuilder(activity as Context)
//            .setTitle(resources.getString(R.string.filter_title))
//            .setNeutralButton(resources.getString(R.string.filter_cancel)) { dialog, which ->
//
//            }
//            .setPositiveButton(resources.getString(R.string.filter_ok)) { dialog, which ->
//
//            }
//            .setMultiChoiceItems(arrayOf("q", "w", "e", "r"), booleanArrayOf(false, false, true, true)) { dialog, which, isChecked ->
//
//            }
//            .show()
    }

}
