package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.utils

import android.app.AlertDialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatDelegate
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.R


class BatteryReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        val level: Int = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
        val scale: Int = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)

        val batteryPct: Float? = level * 100 / scale.toFloat()

        if (batteryPct!! < 20) {
            AlertDialog.Builder(context)
                .setTitle(R.string.dialog_message_low_battery)
                // Specifying a listener allows you to take an action before dismissing the dialog.
                .setMessage(R.string.dialog_message)
                .setPositiveButton(R.string.dialog_response_yes, DialogInterface.OnClickListener() { dialog, which ->
                    //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    })
                .setNegativeButton(R.string.dialog_response_no, null)
                .show()
        }
        // AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

}