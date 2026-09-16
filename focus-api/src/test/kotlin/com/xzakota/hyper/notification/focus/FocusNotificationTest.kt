package com.xzakota.hyper.notification.focus

import com.xzakota.BaseTestCallback
import com.xzakota.hyper.notification.focus.template.FocusTemplateV3
import org.junit.jupiter.api.Assertions.assertEquals
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
        println(json)

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
        println(json)

        assertNotNull(json)
        assertTrue(json.contains("Title1"))
        assertTrue(json.contains("param_island"))
        assertTrue(json.contains("miui.focus.placeholder"))
    }

    @Test
    fun copyFromTest() {
        val src = FocusTemplateV3().apply {
            ticker = "Original Ticker"
            enableFloat = true
            business = "Test Business"
            baseInfo {
                title = "Original Title"
            }
        }

        val dest = FocusTemplateV3().apply {
            copyFrom(src)
        }

        assertEquals("Original Ticker", dest.ticker)
        assertEquals(true, dest.enableFloat)
        assertEquals("Test Business", dest.business)
        assertEquals("Original Title", dest.baseInfo?.title)
    }

    @Test
    fun standaloneCreatePictureTest() {
        val template = FocusTemplateV3().apply {
            ticker = "Test Ticker"
            val key = createPicture("key_logo", android.os.Bundle())
            tickerPic = key
        }

        assertEquals("key_logo", template.tickerPic)
    }
}
