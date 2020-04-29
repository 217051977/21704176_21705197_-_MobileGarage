package pt.ulusofona.cm.mobilegarage.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_app.*
import pt.ulusofona.cm.mobilegarage.R
import pt.ulusofona.cm.mobilegarage.ui.utils.NavBarNavigationManager
import pt.ulusofona.cm.mobilegarage.ui.viewmodels.NavBarViewModel

class AppActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var navBarViewModel: NavBarViewModel
//    private lateinit var viewModel: NavBarViewModel

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_log_out -> finish()
            R.id.nav_contacts -> navBarViewModel.onClickContacts(
                this,
                this::class.java.simpleName,
                this.supportFragmentManager
            )
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
        navBarViewModel = ViewModelProvider(this).get(NavBarViewModel::class.java)
        NavBarNavigationManager.goToHomePage(supportFragmentManager)
    }

    private fun setupNavBar() {

        nav_bar.setOnNavigationItemSelectedListener { item ->

            when(item.itemId) {

                R.id.nav_bar_my_vehicles -> {
                    navBarViewModel.onClickMyVehicles(
                        this,
                        this::class.java.simpleName,
                        this.supportFragmentManager
                    )

                    return@setOnNavigationItemSelectedListener true

                }

                R.id.nav_bar_favorites -> {
                    navBarViewModel.onClickFavorites(
                        this,
                        this::class.java.simpleName,
                        this.supportFragmentManager
                    )

                    return@setOnNavigationItemSelectedListener true

                }

                R.id.nav_bar_home -> {
                    navBarViewModel.onClickHome(
                        this,
                        this::class.java.simpleName,
                        this.supportFragmentManager
                    )

                    return@setOnNavigationItemSelectedListener true

                }

                R.id.nav_bar_park_me_now -> {
                    navBarViewModel.onClickParkMeNow(
                        this,
                        this::class.java.simpleName,
                        this.supportFragmentManager
                    )

                    return@setOnNavigationItemSelectedListener true

                }

                R.id.nav_bar_profile -> {
                    navBarViewModel.onClickProfile(
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
