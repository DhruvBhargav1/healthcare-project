package com.example.healthcare

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView

class Appointmentactivity: AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
//step 1 to initialize all layout

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.appointment_activity)

        drawerLayout=findViewById<DrawerLayout>(R.id.drawable_layout)

        //step 2 intialize the toolbar
        val toolbar=findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        //Extend navigation
        val navigationView=findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)


        //step4 create a toogle
        val toogle=ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()

        //here we set the default frament
        if(savedInstanceState==null){
            replaceFragment(HomeScreen())
                navigationView.setCheckedItem(R.id.nav_home)

        }

    }
    //last step8
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_home -> replaceFragment(HomeScreen())
            R.id.nav_appointment -> replaceFragment(appointmentfragment())
            R.id.nav_setting -> replaceFragment(settingfragment())
            R.id.nav_about -> replaceFragment(aboutFragment())
            R.id.nav_logout -> Toast.makeText(this,"logout!",Toast.LENGTH_SHORT).show()



        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    //step 5 create fragment method using fragment transaction
    private fun replaceFragment(fragment:Fragment){
        val transaction: FragmentTransaction =supportFragmentManager.beginTransaction()
        transaction.replace(androidx.fragment.R.id.fragment_container_view_tag,fragment)
            transaction.commit()
    }

    //step 6 onbacktack
    override fun onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }
        else{
            onBackPressedDispatcher.onBackPressed()
        }

            }
}