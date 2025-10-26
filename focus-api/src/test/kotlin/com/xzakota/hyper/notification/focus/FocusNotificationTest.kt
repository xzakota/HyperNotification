package com.xzakota.hyper.notification.focus

import com.xzakota.hyper.notification.focus.template.FocusTemplateV3
import com.xzakota.hyper.notification.focus.util.JSONUtils
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class FocusNotificationTest {
    @Test
    fun paramV2Test() {
        val config = FocusNotification.createV3 {
            copyFrom(JSONUtils.parseObject<FocusTemplateV3>("{\"isShowNotification\": true, \"timeout\": 1}"))
            Assertions.assertNotEquals(false, isShowNotification)

            enableFloat = true
            islandFirstFloat = false
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

        println(config)
        Assertions.assertNotNull(config)
    }
}
