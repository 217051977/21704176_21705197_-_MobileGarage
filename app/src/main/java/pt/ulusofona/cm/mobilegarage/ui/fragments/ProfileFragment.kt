package pt.ulusofona.cm.mobilegarage.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import butterknife.ButterKnife
import kotlinx.android.synthetic.main.fragment_profile.*
import pt.ulusofona.cm.mobilegarage.R

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_profile,
            container,
            false
        )

//        profile_edit_profile_button.visibility = View.INVISIBLE

        ButterKnife.bind(this, view)
        return view
    }

}
