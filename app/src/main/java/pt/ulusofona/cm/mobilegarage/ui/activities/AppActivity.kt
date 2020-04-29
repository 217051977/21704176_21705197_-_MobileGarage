package pt.ulusofona.cm.mobilegarage.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.lifecycle.ViewModelProviders
import butterknife.OnClick
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_app.*
import pt.ulusofona.cm.mobilegarage.R
import pt.ulusofona.cm.mobilegarage.ui.utils.NavBarNavigationManager
import pt.ulusofona.cm.mobilegarage.ui.viewmodels.NavBarViewModel

class AppActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var viewModel: NavBarViewModel

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
/*        remove title bar
        this.supportActionBar?.hide()
        remove notification bar
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        set content view AFTER ABOVE sequence (to avoid crash)*/
        setContentView(R.layout.activity_app)
        setSupportActionBar(toolbar)
        setupDrawerMenu()
//        viewModel = ViewModelProvider(this).get(NavBarViewModel::class.java)
        viewModel = ViewModelProviders.of(this).get(NavBarViewModel::class.java)
        NavBarNavigationManager.goToHomePage(supportFragmentManager)
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

    @OnClick(
        R.id.nav_bar_my_vehicles
    )
    fun onClickMyVehicles(view: View) {
        viewModel.onClickMyVehicles(
            this,
            this::class.java.simpleName,
            this.supportFragmentManager
        )
    }

    @OnClick(
        R.id.nav_bar_favorites
    )
    fun onClickFavorites(view: View) {
        viewModel.onClickFavorites(
            this,
            this::class.java.simpleName,
            this.supportFragmentManager
        )
    }

    @OnClick(
        R.id.nav_bar_home
    )
    fun onClickHome(view: View) {
        viewModel.onClickHome(
            this,
            this::class.java.simpleName,
            this.supportFragmentManager
        )
    }

    @OnClick(
        R.id.nav_bar_park_me_now
    )
    fun onClickParkMeNow(view: View) {
        viewModel.onClickParkMeNow(
            this,
            this::class.java.simpleName,
            this.supportFragmentManager
        )
    }

    @OnClick(
        R.id.nav_bar_profile
    )
    fun onClickProfile(view: View) {
        viewModel.onClickProfile(
            this,
            this::class.java.simpleName,
            this.supportFragmentManager
        )
    }

}
