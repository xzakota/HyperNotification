package com.xzakota.hyper.notification.focus

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class FocusNotificationTest {
    @Test
    fun paramV2Test() {
        val config = FocusNotification.createV2 {
            enableFloat = true
            ticker = "Ticker"

            baseInfo {
                type = 1
                title = "Title1"
                content = "Content1"
            }

            hintInfo {
                type = 1
                title = "Title2"
                content = "Content2"
            }

            actions {
                addActionInfo {
                    actionIcon = "miui.focus.placeholder"
                }
            }
        }

        println(config)
        Assertions.assertNotNull(config)
    }
}
