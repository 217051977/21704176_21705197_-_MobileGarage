package pt.ulusofona.cm.mobilegarage.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import butterknife.OnClick
import butterknife.OnItemSelected
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationView
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
        setupNavBar()
        viewModel = ViewModelProvider(this).get(NavBarViewModel::class.java)
        NavBarNavigationManager.goToHomePage(supportFragmentManager)
    }

    private fun setupNavBar() {

        nav_bar.setOnNavigationItemSelectedListener { item ->

            when(item.itemId) {

                R.id.nav_bar_my_vehicles -> {
                    viewModel.onClickMyVehicles(
                        this,
                        this::class.java.simpleName,
                        this.supportFragmentManager
                    )

                    return@setOnNavigationItemSelectedListener true

                }

                R.id.nav_bar_favorites -> {
                    viewModel.onClickFavorites(
                        this,
                        this::class.java.simpleName,
                        this.supportFragmentManager
                    )

                    return@setOnNavigationItemSelectedListener true

                }

                R.id.nav_bar_home -> {
                    viewModel.onClickHome(
                        this,
                        this::class.java.simpleName,
                        this.supportFragmentManager
                    )

                    return@setOnNavigationItemSelectedListener true

                }

                R.id.nav_bar_park_me_now -> {
                    viewModel.onClickParkMeNow(
                        this,
                        this::class.java.simpleName,
                        this.supportFragmentManager
                    )

                    return@setOnNavigationItemSelectedListener true

                }

                R.id.nav_bar_profile -> {
                    viewModel.onClickProfile(
                        this,
                        this::class.java.simpleName,
                        this.supportFragmentManager
                    )

                    return@setOnNavigationItemSelectedListener true

                }

            }

            false

        }

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
