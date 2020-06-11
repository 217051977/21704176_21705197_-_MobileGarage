package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.fragments

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import butterknife.ButterKnife
import butterknife.OnClick
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.R
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.activities.AppActivity
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.viewmodels.SettingsViewModel

class SettingsFragment : Fragment() {

    private lateinit var viewModel: SettingsViewModel;

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_settings,
            container,
            false
        )

        viewModel = ViewModelProvider(this).get(SettingsViewModel::class.java)

        ButterKnife.bind(this, view)
        return view
    }

    @OnClick(R.id.dialog_message)
    fun onToogleDarkMode(view: View) {
        val switch: Switch = view.findViewById(view.id)
        viewModel.onToogleDarkMode(activity as Context, switch)
    }
}
