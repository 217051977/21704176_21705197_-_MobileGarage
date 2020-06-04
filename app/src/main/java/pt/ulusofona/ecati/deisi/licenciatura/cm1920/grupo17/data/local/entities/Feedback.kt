package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities

import android.content.Context
import android.util.Log
import android.widget.Toast

class Feedback private constructor(){

    companion object {

        private var instance: Feedback? = null

        fun getInstance(): Feedback {
            synchronized(this) {
                if (instance == null) {
                    instance =
                        Feedback()
                }
                return instance as Feedback
            }
        }

    }

    fun createFullMessage(TAG: String?, context: Context, message: String) {
        makeToastMessage(context, message)
        makeLogMessage(TAG, message)
    }

    fun createFullButton(TAG: String?, context: Context, message: String) {
        makeToastButton(context, message)
        makeLogButton(TAG, message)
    }

    private fun makeToastMessage(context: Context, message: String) {
        Toast.makeText(
            context,
            message,
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun makeLogMessage(TAG: String?, message: String) {
        Log.i(TAG,
            message
        )
    }

    private fun makeToastButton(context: Context, buttonName: String) {
        Toast.makeText(
            context,
            "Button $buttonName has been pressed!",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun makeLogButton(TAG: String?, buttonName: String) {
        Log.i(TAG,
            "Button $buttonName has been pressed!"
        )
    }

}