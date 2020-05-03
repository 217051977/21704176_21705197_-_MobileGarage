package pt.ulusofona.cm.mobilegarage.ui.fragments

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import butterknife.ButterKnife
import butterknife.OnClick
import kotlinx.android.synthetic.main.fragment_home_menu.*
import pt.ulusofona.cm.mobilegarage.R
import pt.ulusofona.cm.mobilegarage.ui.viewmodels.ParkViewModel

class FavoritesFragment : Fragment() {

    private lateinit var viewModel: ParkViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_favorites,
            container,
            false
        )
        viewModel = ViewModelProvider(this).get(ParkViewModel::class.java)
        ButterKnife.bind(this, view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        parking_list.layoutManager = LinearLayoutManager(activity as Context)
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            parking_list.adapter = viewModel.setFavoritesLandScapeAdapter(
                activity as Context,
                activity?.supportFragmentManager!!,
                viewModel
            )
        } else {
            parking_list.adapter = viewModel.setFavoritesAdapter(
                activity as Context,
                activity?.supportFragmentManager!!,
                viewModel
            )
        }
    }

    @OnClick(
        R.id.filter_button_favorites
    )
    fun onClickFilter(view: View) {
        viewModel.goToFilterOption(
            activity as Context,
            this::class.java.simpleName,
            activity?.supportFragmentManager!!,
            fav = true
        )
    }

}
