package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.fragments

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
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.R
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities.Park
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.adapters.FavoritesAdapter
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.adapters.FavoritesLandScapeAdapter
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.listeners.OnReceiveFavorites
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.viewmodels.ParkViewModel

class FavoritesFragment : Fragment(), OnReceiveFavorites {

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

    override fun onStart() {
        viewModel.registerListenerFavorites(this)
        super.onStart()
    }

    override fun onDestroy() {
        viewModel.unregisterListenerFavorites()
        super.onDestroy()
    }

    override fun onReceiveFavorites(favorites: List<Park>) {

        favorites.let {
            parking_list.layoutManager = LinearLayoutManager(activity as Context)
            if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                parking_list.adapter =
                    FavoritesLandScapeAdapter(
                        activity as Context,
                        R.layout.item_park_element,
                        favorites as MutableList<Park>,
                        activity?.supportFragmentManager!!
                )
            } else {
                parking_list.adapter =
                    FavoritesAdapter(
                        activity as Context,
                        R.layout.item_park_element,
                        favorites as MutableList<Park>,
                        activity?.supportFragmentManager!!
                    )
            }
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
