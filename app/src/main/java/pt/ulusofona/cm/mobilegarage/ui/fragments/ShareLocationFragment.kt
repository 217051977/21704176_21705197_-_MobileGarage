package pt.ulusofona.cm.mobilegarage.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife

import pt.ulusofona.cm.mobilegarage.R

class ShareLocationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_share_location,
            container,
            false
        )
        ButterKnife.bind(this, view)
        return view
    }

}