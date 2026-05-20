package com.xzakota.hyper.notification.focus.example.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.xzakota.hyper.notification.focus.example.ui.utils.Constants
import com.xzakota.hyper.notification.focus.example.ui.navigation.AppNavigation
import com.xzakota.hyper.notification.focus.example.ui.navigation.Route
import com.xzakota.hyper.notification.focus.example.ui.utils.ThemeUtils

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        com.xzakota.hyper.notification.focus.example.ui.utils.AppUtils.initPredictiveBackGesture(application)
        super.onCreate(savedInstanceState)
        
        val prefs = getSharedPreferences(Constants.PREF_NAME, MODE_PRIVATE)
        val excludeFromRecents = prefs.getBoolean(Constants.KEY_EXCLUDE_FROM_RECENTS, Constants.DEFAULT_EXCLUDE_FROM_RECENTS)
        if (excludeFromRecents) {
            try {
                val am = getSystemService(ACTIVITY_SERVICE) as android.app.ActivityManager
                am.appTasks?.forEach { it.setExcludeFromRecents(true) }
            } catch (_: Exception) { }
        }

        enableEdgeToEdge()
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
            window.isNavigationBarContrastEnforced = false
        }

        setContent {
            ThemeUtils.MiuixThemeWrapper {
                AppNavigation(startRoute = Route.Main)
            }
        }
    }
}
