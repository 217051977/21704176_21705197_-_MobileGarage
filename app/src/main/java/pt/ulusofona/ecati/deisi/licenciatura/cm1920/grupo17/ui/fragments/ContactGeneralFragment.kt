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
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.viewmodels.ContactViewModel

class ContactGeneralFragment : Fragment() {

    private lateinit var viewModel: ContactViewModel;

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_contact_general,
            container,
            false
        )

        viewModel = ViewModelProvider(this).get(ContactViewModel::class.java)

        ButterKnife.bind(this, view)
        return view
    }

    @OnClick(
        R.id.phoneNumber
    )
    fun callNumber(view: View) {
        viewModel.callNumber(
            activity as Context,
            this::class.java.simpleName,
            R.string.contact_phone_general_vehicles.toString()
        )
    }

}
