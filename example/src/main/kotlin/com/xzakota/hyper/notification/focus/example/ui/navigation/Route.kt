package com.xzakota.hyper.notification.focus.example.ui.navigation

import androidx.navigation3.runtime.NavKey

sealed interface Route : NavKey {
    data object Main : Route
}
