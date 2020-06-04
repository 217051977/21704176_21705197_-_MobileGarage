package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.R

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed(
            {
                kotlin.run {
                    val intent = Intent(this, AppActivity::class.java)
//                    Thread.sleep(5000)
                    startActivity(intent)
                    finish()
                }
            },
            2000
        )

    }
}
