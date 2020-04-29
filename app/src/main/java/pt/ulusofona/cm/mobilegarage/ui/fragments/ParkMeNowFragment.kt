package pt.ulusofona.cm.mobilegarage.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import butterknife.ButterKnife
import pt.ulusofona.cm.mobilegarage.R

class ParkMeNowFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_park_me_now,
            container,
            false
        )

        ButterKnife.bind(this, view)
        return view
    }

}
