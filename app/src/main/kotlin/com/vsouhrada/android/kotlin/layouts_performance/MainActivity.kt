package com.vsouhrada.android.kotlin.layouts_performance

import android.content.Context
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

  lateinit var drawer: DrawerLayout

  var now: Long = 0

  open override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    now = System.currentTimeMillis()

    setContentView(R.layout.activity_main)

    drawer = findViewById(R.id.drawer_layout) as DrawerLayout

    val toolbar = findViewById(R.id.toolbar) as Toolbar
    setSupportActionBar(toolbar)

    val fab = findViewById(R.id.fab) as FloatingActionButton
    fab.setOnClickListener { view ->
      Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
              .setAction("Action", null).show()
    }

    val toggle = ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)

    drawer.setDrawerListener(toggle)
    toggle.syncState()

    val navigationView = findViewById(R.id.nav_view) as NavigationView
    navigationView.setNavigationItemSelectedListener(this)
  }

  override fun onStart() {
    val time = System.currentTimeMillis() - now
    Log.w("A_MAIN_LAYOUT_TIME", "Time[$time ms]")
    super.onStart()
  }

  open override fun onBackPressed() {
    if (drawer.isDrawerOpen(GravityCompat.START)) {
      drawer.closeDrawer(GravityCompat.START)
    } else {
      super.onBackPressed()
    }
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    // Inflate the menu; this adds items to the action bar if it is present.
    menuInflater.inflate(R.menu.main, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    val id = item.itemId


    if (id == R.id.action_settings) {
      return true
    }

    return super.onOptionsItemSelected(item)
  }

  override fun onNavigationItemSelected(item: MenuItem): Boolean {
    // Handle navigation view item clicks here.
    when (item.itemId) {
      R.id.nav_camera -> toast("Click Camera")
      R.id.nav_gallery -> toast("Click Gallery")
      R.id.nav_slideshow -> toast("Click Slideshow")
      R.id.nav_manage -> toast("Click Manage")
      R.id.nav_share -> toast("Click Share")
      R.id.nav_send -> toast("Click Send")
    }

    drawer.closeDrawer(GravityCompat.START)

    return true
  }

  fun Context.toast(message: CharSequence) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

}