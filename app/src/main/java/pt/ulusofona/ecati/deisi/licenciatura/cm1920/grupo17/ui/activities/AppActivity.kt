package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.activities

import android.content.Intent
import android.content.IntentFilter
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.GravityCompat
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_app.*
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.R
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.utils.BatteryReceiver
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.utils.NavBarNavigationManager
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.viewmodels.DrawerViewModel
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.viewmodels.NavBarViewModel
import java.lang.Exception
import java.time.LocalTime

private val TAG = AppActivity::class.java.simpleName

class AppActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var navBarViewModel: NavBarViewModel
    private lateinit var drawerViewModel: DrawerViewModel

    private var baterryReceiver =  BatteryReceiver()
    private var intentFilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.profile -> {
                toolbar.title = resources.getString(R.string.drawer_profile)
                /*supportActionBar?.setDisplayHomeAsUpEnabled(true)
                toolbar.setNavigationOnClickListener(View.OnClickListener {
                    onBackPressed()
                    supportActionBar?.setDisplayHomeAsUpEnabled(false)
                    ****NEED DO WORK ON THE NUMBER OF CLICKS NEED TO GO BACK TO HOME PAGE****
                    setupDrawerMenu()
                    nav_bar.menu[1].isChecked = true
                    NavBarNavigationManager.goToHomePage(supportFragmentManager)
                })*/
                drawerViewModel.onClickProfile(
                    this,
                    TAG,
                    this.supportFragmentManager
                )
            }
            R.id.vehicles -> {
                toolbar.title = resources.getString(R.string.drawer_my_vehicles)
                drawerViewModel.onClickMyVehicles(
                    this,
                    this::class.java.simpleName,
                    this.supportFragmentManager
                )
            }
            R.id.nav_contacts -> {
                toolbar.title = resources.getString(R.string.drawer_option_contacts)
                drawerViewModel.onClickContacts(
                    this,
                    TAG,
                    this.supportFragmentManager
                )
            }
            R.id.gira -> {
                toolbar.title = resources.getString(R.string.drawer_option_gira)
                var playStoreUri: Uri
                var playStoreIntent: Intent
                val packageName: String = "pt.emel.bikeshare"
                try {
                    packageManager.getPackageInfo(packageName, 0)
                    startActivity(
                        Intent(
                            packageManager.getLaunchIntentForPackage(packageName)
                        )
                    )
                } catch (packageNotInstalled: PackageManager.NameNotFoundException) {
                    try {
                        playStoreUri = Uri.parse("market://details?id=$packageName")
                        playStoreIntent = Intent(Intent.ACTION_VIEW, playStoreUri)
                        startActivity(playStoreIntent)
                    } catch (e: Exception) {
                        playStoreUri = Uri.parse(
                            "http://play.google.com/store/apps/details?id=$packageName"
                        )
                        playStoreIntent = Intent(Intent.ACTION_VIEW, playStoreUri)
                        startActivity(playStoreIntent)
                    }
                }
            }
            R.id.traffic -> {
                toolbar.title = resources.getString(R.string.drawer_option_traffic)
                drawerViewModel.onClickTraffic(
                    this,
                    TAG,
                    this.supportFragmentManager
                )
            }
            R.id.map -> {
                toolbar.title = resources.getString(R.string.drawer_option_map)
                drawerViewModel.onClickMap(
                    this,
                    TAG,
                    this.supportFragmentManager
                )
            }
            R.id.find_vehicle -> {
                toolbar.title = resources.getString(R.string.drawer_option_find_vehicle)
                drawerViewModel.onClickFindVehicle(
                    this,
                    TAG,
                    this.supportFragmentManager
                )
            }
            R.id.share_location -> {
                toolbar.title = resources.getString(R.string.drawer_option_share_location)
                drawerViewModel.onClickShareLocation(
                    this,
                    TAG,
                    this.supportFragmentManager
                )
            }

            R.id.nav_settings -> {
                drawerViewModel.onClickSettings(
                    this,
                    TAG,
                    this.supportFragmentManager
                )
            }

            R.id.nav_log_out -> finish()
        }
        nav_bar.menu.getItem(nav_bar.menu.size() - 1).isChecked = true
        drawer.closeDrawers()
        return true
    }

    override fun onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        }
        super.onBackPressed()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)
        setSupportActionBar(toolbar)
        setupDrawerMenu()
        setupNavBar()
        setLastInitVars()
        NavBarNavigationManager.goToHomePage(supportFragmentManager)
        startThread()
    }

    private fun setLastInitVars() {
        navBarViewModel = ViewModelProvider(this).get(NavBarViewModel::class.java)
        drawerViewModel = ViewModelProvider(this).get(DrawerViewModel::class.java)
    }

    private fun setupNavBar() {

        nav_bar.menu.findItem(R.id.nav_bar_home).isChecked = true

        nav_bar.setOnNavigationItemSelectedListener { item ->

            when(item.itemId) {

                R.id.nav_bar_favorites -> {
                    toolbar.title = resources.getString(R.string.app_name)
                    navBarViewModel.onClickFavorites(
                        this,
                        this::class.java.simpleName,
                        this.supportFragmentManager
                    )
                    return@setOnNavigationItemSelectedListener true

                }

                R.id.nav_bar_home -> {
                    toolbar.title = resources.getString(R.string.app_name)
                    navBarViewModel.onClickHome(
                        this,
                        this::class.java.simpleName,
                        this.supportFragmentManager
                    )
                    return@setOnNavigationItemSelectedListener true

                }

                R.id.nav_bar_park_me_now -> {
                    toolbar.title = resources.getString(R.string.app_name)
                    navBarViewModel.onClickParkMeNow(
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

    override fun onResume() {
        super.onResume()
        registerReceiver(baterryReceiver, intentFilter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(baterryReceiver)
    }

    private fun startThread() {
        val t = TimeThread(this)
        t.start()
    }

    class TimeThread(val activity: AppActivity) : Thread() {

        @RequiresApi(Build.VERSION_CODES.O)
        fun checkLightMode() {

            val appSettingPrefs: SharedPreferences =  activity.getSharedPreferences("AppSettingPrefs", 0)
            val sharedPrefsEdit: SharedPreferences.Editor = appSettingPrefs.edit()

            val presentTime: LocalTime = LocalTime.now()

            val nightTimeInit = LocalTime.of(20, 0)
            val nightTimeEnd = LocalTime.of(5,0)

            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

            // BETWEEN 20:00 AND 05:00 -> NIGHT else -> DAY
            Log.i(this::class.java.simpleName, "present: $presentTime e limiteIni: $nightTimeInit limiteFim: $nightTimeEnd")
            if (presentTime.isAfter(nightTimeEnd) && presentTime.isBefore(nightTimeInit)) {
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
            for (i in 0..90) {
                try {
                    checkLightMode()
                }catch (e:Exception) {
                    Log.i(this::class.java.simpleName, "Erro")
                }
                Log.d(this::class.java.simpleName, i.toString())
                sleep(1000)
            }
        }
    }

}
