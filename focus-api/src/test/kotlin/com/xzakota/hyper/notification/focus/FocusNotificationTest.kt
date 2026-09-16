package com.xzakota.hyper.notification.focus

import com.xzakota.BaseTestCallback
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(BaseTestCallback::class)
class FocusNotificationTest {
    @Test
    fun paramV2Test() {
        val config = FocusNotification.createV2 {
            ticker = "Ticker"
            enableFloat = true

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

        val json = config.getFactoryJSON()
        assertNotNull(json)
        assertTrue(json.contains("Title1"))
        assertTrue(json.contains("Title2"))
        assertTrue(json.contains("miui.focus.placeholder"))
    }

    @Test
    fun paramV3Test() {
        val config = FocusNotification.createV3 {
            ticker = "Ticker"
            enableFloat = true
            islandFirstFloat = false

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

            island {
                islandProperty = 1
                bigIslandArea {
                    imageTextInfoLeft {
                        type = 1
                        picInfo {
                            type = 1
                        }
                    }
                }
            }

            actions {
                addActionInfo {
                    actionIcon = "miui.focus.placeholder"
                }
            }
        }

        val json = config.getFactoryJSON()
        assertNotNull(json)
        assertTrue(json.contains("Title1"))
        assertTrue(json.contains("param_island"))
        assertTrue(json.contains("miui.focus.placeholder"))
    }
}
