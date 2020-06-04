package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import butterknife.ButterKnife
import butterknife.OnClick
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.R
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.viewmodels.DrawerViewModel

class ProfileFragment : Fragment() {

    private lateinit var drawerViewModel: DrawerViewModel

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
        drawerViewModel = ViewModelProvider(this).get(DrawerViewModel::class.java)
        ButterKnife.bind(this, view)
        return view
    }

    @OnClick(
        R.id.profile_emel_support_button
    )
    fun onClickEmelSupport(view: View) {
        drawerViewModel.onClickContacts(
            activity as Context,
            this::class.java.simpleName,
            activity?.supportFragmentManager!!
        )
    }

}
