package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.viewmodels

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities.Feedback

class ContactViewModel : ViewModel() {

    private val feedback: Feedback = Feedback.getInstance()

    fun callNumber(
        context: Context,
        TAG: String?,
        number: String
    ) {
        feedback.createFullButton(TAG, context, "go to dial")
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:913931358")
        context.startActivity(intent)
    }

}