package pt.ulusofona.cm.mobilegarage.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import butterknife.ButterKnife
import kotlinx.android.synthetic.main.fragment_home_menu.*
import pt.ulusofona.cm.mobilegarage.R
import pt.ulusofona.cm.mobilegarage.data.local.entities.Park
import pt.ulusofona.cm.mobilegarage.ui.adapters.ParkingListAdapter
import java.util.*

class HomeMenuFragment : Fragment() {

    private val parks: List<Park> = listOf(
        Park(
            "park1",
            90.1,
            25.0,
            Calendar.getInstance(),
            "Structure",
            0.0
        ), Park(
            "park2",
            0.0,
            25.0,
            Calendar.getInstance(),
            "Surface",
            0.0
        ), Park(
            "park3",
            10.0,
            25.0,
            Calendar.getInstance(),
            "Structure",
            0.0
        )
    )

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

        ButterKnife.bind(this, view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        parking_list.layoutManager = LinearLayoutManager(activity as Context)
        parking_list.adapter = ParkingListAdapter(
            activity as Context,
            R.layout.item_park_element,
            parks as MutableList<Park>
        )
    }

//    @OnClick(
//        R.id.add_favorite
//    )
//    fun onClickAddFavorite(view: View) {
//
//
////        val imageToChange: Drawable? = if (view.)
////            Drawable.createFromPath("drawable/ic_favorite_black_24dp.xml")
////        add_favorite.setImageDrawable(imageToChange)
//
////        parking_list.item
//
//    }

}
