package com.vsouhrada.android.kotlin.layouts_performance.app

import android.app.Application
import com.frogermcs.androiddevmetrics.AndroidDevMetrics
import com.vsouhrada.android.kotlin.layouts_performance.BuildConfig

/**
 * @author vsouhrada
 * @see[Application]
 * @since 0.1.0
 */
class PerformanceApp : Application() {

  override fun onCreate() {
    super.onCreate()
    // Use it only in debug builds
    if (BuildConfig.DEBUG) {
      AndroidDevMetrics.initWith(this)
    }
  }

}