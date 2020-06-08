package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.activities

import android.content.SharedPreferences
import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_app.*
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.R
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
//        remove title bar
//        this.supportActionBar?.hide()
//        remove notification bar
//        this.window.setFlags(
//            WindowManager.LayoutParams.FLAG_FULLSCREEN,
//            WindowManager.LayoutParams.FLAG_FULLSCREEN
//        )
//        set content view AFTER ABOVE sequence (to avoid crash)


//        NavigationManager.goToLogInPage(supportFragmentManager)

//        Handler().postDelayed(
//            {
//                kotlin.run {
//                    val intent = Intent(this, AppActivity::class.java)
//
////                    Thread.sleep(5000)
//                    startActivity(intent)
//                    finish()
//                }
//            },
//            2000
//        )

    }

}
