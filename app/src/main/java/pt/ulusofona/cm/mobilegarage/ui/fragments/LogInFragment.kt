package pt.ulusofona.cm.mobilegarage.ui.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import butterknife.ButterKnife
import butterknife.OnClick
import pt.ulusofona.cm.mobilegarage.R
import pt.ulusofona.cm.mobilegarage.ui.activities.AppActivity
import pt.ulusofona.cm.mobilegarage.ui.viewmodels.LogInViewModel

class LogInFragment : Fragment() {

    private lateinit var viewModel: LogInViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_log_in,
            container,
            false
        )
        viewModel = ViewModelProvider(this).get(LogInViewModel::class.java)
        ButterKnife.bind(this, view)
        return view
    }

    @OnClick(
        R.id.button_register
    )
    fun onClickRegister(view: View) {
        viewModel.onClickRegister(
            activity as Context,
            activity?.supportFragmentManager!!
        )
    }

    @OnClick(
        R.id.button_log_in
    )
    fun onClickLogIn(view: View) {
        viewModel.onClickLogIn(
            activity as Context,
            activity?.supportFragmentManager!!
        )
        val intent = Intent(this.context, AppActivity::class.java)
        startActivity(intent)
    }

}
