package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.utils

import android.content.SharedPreferences
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatDelegate
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.activities.AppActivity
import java.lang.Exception
import java.time.LocalTime

private val TAG = TimeThread::class.java.simpleName
class TimeThread(val activity: AppActivity) : Thread() {

    @RequiresApi(Build.VERSION_CODES.O)
    fun checkLightMode() {

        val appSettingPrefs: SharedPreferences =  activity.getSharedPreferences("AppSettingPrefs", 0)
        val sharedPrefsEdit: SharedPreferences.Editor = appSettingPrefs.edit()

        val presentTime: LocalTime = LocalTime.now()

        val nightTimeInit = LocalTime.of(20, 0)
        val nightTimeEnd = LocalTime.of(5,0)

        // BETWEEN 20:00 AND 05:00 -> NIGHT else -> DAY
        Log.i(this::class.java.simpleName, "present: $presentTime e limiteIni: $nightTimeInit limiteFim: $nightTimeEnd")
        if (!presentTime.isBefore(nightTimeInit) && !presentTime.isAfter(nightTimeEnd)) {
            // DAY
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            sharedPrefsEdit.putBoolean("NightMode", false)
            sharedPrefsEdit.apply()
        } else {
            // NIGHT
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            sharedPrefsEdit.putBoolean("NightMode", true)
            sharedPrefsEdit.apply()
        }
        Log.i(TAG, appSettingPrefs.getBoolean("NightMode", true).toString())
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun run() {
        for (i in 0..60) {

            try {
                checkLightMode()
            }catch (e: Exception) {
                Log.i(this::class.java.simpleName, "Erro")
            }

            sleep(1000)
        }
    }
}
