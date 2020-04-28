package pt.ulusofona.cm.mobilegarage.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import butterknife.ButterKnife
import butterknife.OnClick
import pt.ulusofona.cm.mobilegarage.R
import pt.ulusofona.cm.mobilegarage.ui.utils.NavigationManager
import pt.ulusofona.cm.mobilegarage.ui.activities.AppActivity

class LogInFragment : Fragment() {

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

        ButterKnife.bind(this, view)
        return view
    }

    @OnClick(
        R.id.button_register
    )
    fun onClickRegister(view: View) {
        Log.i(this::class.java.simpleName, "Sending to register fragment")
        NavigationManager.goToRegisterPage(activity?.supportFragmentManager!!)
    }

    @OnClick(
        R.id.button_log_in
    )
    fun onClickLogIn(view: View) {
        Log.i(this::class.java.simpleName, "Sending to ")
        val intent = Intent(this.context, AppActivity::class.java)
        startActivity(intent)
//        NavigationManager.goToRegisterPage(activity?.supportFragmentManager!!)
    }

}
