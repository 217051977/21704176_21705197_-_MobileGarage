package pt.ulusofona.cm.mobilegarage.mvvm.view.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_app.*
import pt.ulusofona.cm.mobilegarage.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        remove title bar
//        this.supportActionBar?.hide()
//        remove notification bar
//        this.window.setFlags(
//            WindowManager.LayoutParams.FLAG_FULLSCREEN,
//            WindowManager.LayoutParams.FLAG_FULLSCREEN
//        )
//        set content view AFTER ABOVE sequence (to avoid crash)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

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
