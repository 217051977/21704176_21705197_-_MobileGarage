package pt.ulusofona.cm.mobilegarage.data.local.entities

import android.content.Context
import android.util.Log
import android.widget.Toast

class Feedback private constructor(){

    companion object {

        private var instance: Feedback? = null

        fun getInstance(): Feedback {
            synchronized(this) {
                if (instance == null) {
                    instance = Feedback()
                }
                return instance as Feedback
            }
        }

    }

    fun makeToast(context: Context, buttonName: String) {
        Toast.makeText(
            context,
            "Button $buttonName has been pressed!",
            Toast.LENGTH_SHORT
        ).show()
    }

    fun makeLog(TAG: String?, buttonName: String) {
        Log.i(TAG,
            "Button $buttonName has been pressed!"
        )
    }

}