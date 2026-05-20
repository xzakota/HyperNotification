package com.xzakota.hyper.notification.focus.example.core

import android.util.Log
import com.xzakota.hyper.notification.focus.FocusNotification

object TestScript {
    fun runTest() {
        val bundle = FocusNotification.buildV2 {
            enableFloat = true
            updatable = true
            baseInfo {
                type = 1
                title = "Test Title"
                content = "Test Content"
            }
        }
        val jsonString = bundle.getString("miui.focus.param")
        Log.e("TestScriptOutput", "Generated JSON: $jsonString")
    }
}
