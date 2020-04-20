package pt.ulusofona.cm.mobilegarage.mvvm.view.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_home_menu.*
import pt.ulusofona.cm.mobilegarage.R

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_log_out -> finish()
        }
        return true
    }

    override fun onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        }
        super.onBackPressed()
    }

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
        setContentView(R.layout.activity_home_menu)
        setSupportActionBar(toolbar)
        setupDrawerMenu()
    }

    private fun setupDrawerMenu() {

        val toggle = ActionBarDrawerToggle(

            this,
            drawer,
            toolbar,
            R.string.drawer_open,
            R.string.drawer_close

        )
        nav_drawer.setNavigationItemSelectedListener(this)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

    }

}
