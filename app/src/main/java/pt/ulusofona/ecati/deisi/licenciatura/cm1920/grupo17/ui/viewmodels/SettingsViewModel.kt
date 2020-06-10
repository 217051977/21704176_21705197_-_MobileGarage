package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.viewmodels

import android.content.Context
import android.content.SharedPreferences
import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModel

class SettingsViewModel: ViewModel() {

    fun onToogleDarkMode(context: Context, switch: Switch) {

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        val appSettingPrefs: SharedPreferences = context.getSharedPreferences("AppSettingPrefs", 0)
        val sharedPrefsEdit: SharedPreferences.Editor = appSettingPrefs.edit()

        if (switch.isChecked) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            sharedPrefsEdit.putBoolean("NightMode", true)
            sharedPrefsEdit.apply()
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            sharedPrefsEdit.putBoolean("NightMode", false)
            sharedPrefsEdit.apply()
        }
    }

}