package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.viewmodels

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities.Feedback
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.utils.NavigationManager

class LogInViewModel : ViewModel() {

    private val feedback: Feedback = Feedback.getInstance()
//    private val logInLogic

    fun onClickRegister(context: Context, supp: FragmentManager) {
        feedback.createFullMessage(
            this::class.java.simpleName,
            context,
            "Sending to register fragment"
        )
        //NavigationManager.goToRegisterPage(supp)
    }

    fun onClickLogIn(context: Context, supp: FragmentManager) {
        feedback.createFullMessage(
            this::class.java.simpleName,
            context,
            "Sending to "
        )
    }

}