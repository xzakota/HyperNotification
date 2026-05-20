package com.xzakota.hyper.notification.focus.example.core

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import org.json.JSONObject
import com.xzakota.hyper.notification.focus.example.ui.miuix.NotificationState

object NotificationUtils {

    fun sendBaseInfoNotification(context: Context, state: NotificationState) {
        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channelId = "hyper_notification_base_info"
        val channel = NotificationChannel(
            channelId,
            "Base Info Notification",
            NotificationManager.IMPORTANCE_HIGH
        )
        manager.createNotificationChannel(channel)

        val launchIntent = context.packageManager.getLaunchIntentForPackage(context.packageName)
        val pendingIntent = launchIntent?.let {
            android.app.PendingIntent.getActivity(context, 0, it, android.app.PendingIntent.FLAG_MUTABLE)
        }

        val paramV2Json = JSONObject().apply {
            put("islandFirstFloat", state.islandFirstFloatVal)
            put("enableFloat", state.enableFloatVal)
            put("timeout", state.timeoutText.toIntOrNull() ?: 720)
            put("updatable", state.updatableVal)
            put("reopen", state.reopenText)
            put("filterWhenNoPermission", state.filterWhenNoPermissionVal)

            if (state.aodTitleText.isNotEmpty()) {
                put("aodTitle", state.aodTitleText)
            }
            if (state.aodPicText.isNotEmpty()) {
                put("aodPic", state.aodPicText)
            }
            if (state.tickerText.isNotEmpty()) {
                put("ticker", state.tickerText)
            }
            if (state.tickerPicText.isNotEmpty()) {
                put("tickerPic", state.tickerPicText)
            }
            if (state.tickerPicDark.isNotEmpty()) {
                put("tickerPicDark", state.tickerPicDark)
            }

            if (state.showBaseInfo) {
                val baseInfoJson = JSONObject().apply {
                    put("type", if (state.baseTypeVal) 2 else 1)
                    if (state.baseTitle.isNotEmpty()) put("title", state.baseTitle)
                    if (state.baseColorTitle.isNotEmpty()) put("colorTitle", state.baseColorTitle)
                    if (state.baseColorTitleDark.isNotEmpty()) put("colorTitleDark", state.baseColorTitleDark)
                    if (state.baseSubTitle.isNotEmpty()) put("subTitle", state.baseSubTitle)
                    if (state.baseColorSubTitle.isNotEmpty()) put("colorSubTitle", state.baseColorSubTitle)
                    if (state.baseColorSubTitleDark.isNotEmpty()) put("colorSubTitleDark", state.baseColorSubTitleDark)
                    if (state.baseContent.isNotEmpty()) put("content", state.baseContent)
                    if (state.baseColorContent.isNotEmpty()) put("colorContent", state.baseColorContent)
                    if (state.baseColorContentDark.isNotEmpty()) put("colorContentDark", state.baseColorContentDark)
                    if (state.baseSubContent.isNotEmpty()) put("subContent", state.baseSubContent)
                    if (state.baseColorSubContent.isNotEmpty()) put("colorSubContent", state.baseColorSubContent)
                    if (state.baseColorSubContentDark.isNotEmpty()) put("colorSubContentDark", state.baseColorSubContentDark)
                    
                    if (state.baseExtraTitle.isNotEmpty()) put("extraTitle", state.baseExtraTitle)
                    if (state.baseColorExtraTitle.isNotEmpty()) put("colorExtraTitle", state.baseColorExtraTitle)
                    if (state.baseColorExtraTitleDark.isNotEmpty()) put("colorExtraTitleDark", state.baseColorExtraTitleDark)
                    if (state.baseSpecialTitle.isNotEmpty()) put("specialTitle", state.baseSpecialTitle)
                    if (state.baseColorSpecialTitle.isNotEmpty()) put("colorSpecialTitle", state.baseColorSpecialTitle)
                    if (state.baseColorSpecialTitleDark.isNotEmpty()) put("colorSpecialTitleDark", state.baseColorSpecialTitleDark)
                    if (state.baseColorSpecialBg.isNotEmpty()) put("colorSpecialBg", state.baseColorSpecialBg)
                    
                    put("showDivider", state.baseShowDividerVal)
                    put("showContentDivider", state.baseShowContentDividerVal)
                    if (state.basePicFunction.isNotEmpty()) put("picFunction", state.basePicFunction)
                    put("setMarginTop", state.baseSetMarginTopVal)
                    put("setMarginBottom", state.baseSetMarginBottomVal)
                }
                put("baseInfo", baseInfoJson)
            } else if (state.showChatInfo) {
                val chatInfoJson = JSONObject().apply {
                    if (state.chatPicProfile.isNotEmpty()) put("picProfile", state.chatPicProfile)
                    if (state.chatPicProfileDark.isNotEmpty()) put("picProfileDark", state.chatPicProfileDark)
                    if (state.chatAppIconPkg.isNotEmpty()) put("appIconPkg", state.chatAppIconPkg)
                    if (state.chatTitle.isNotEmpty()) put("title", state.chatTitle)
                    if (state.chatColorTitle.isNotEmpty()) put("colorTitle", state.chatColorTitle)
                    if (state.chatColorTitleDark.isNotEmpty()) put("colorTitleDark", state.chatColorTitleDark)
                    
                    if (state.showTimerInfo) {
                        val timerInfoJson = JSONObject().apply {
                            put("timerType", state.timerType.toIntOrNull() ?: 0)
                            if (state.timerWhen.isNotEmpty()) {
                                put("timerWhen", state.timerWhen.toLongOrNull() ?: 0L)
                            }
                            if (state.timerTotal.isNotEmpty()) {
                                put("timerTotal", state.timerTotal.toLongOrNull() ?: 0L)
                            }
                            if (state.timerSystemCurrent.isNotEmpty()) {
                                put("timerSystemCurrent", state.timerSystemCurrent.toLongOrNull() ?: 0L)
                            }
                        }
                        put("timerInfo", timerInfoJson)
                    } else {
                        if (state.chatContent.isNotEmpty()) put("content", state.chatContent)
                        if (state.chatColorContent.isNotEmpty()) put("colorContent", state.chatColorContent)
                        if (state.chatColorContentDark.isNotEmpty()) put("colorContentDark", state.chatColorContentDark)
                    }
                }
                put("chatInfo", chatInfoJson)
            } else if (state.showHighlightInfo) {
                val highlightInfoJson = JSONObject().apply {
                    if (state.highlightTypeVal == 1) {
                        put("type", 1)
                    }
                    if (state.highlightPicFunction.isNotEmpty()) put("picFunction", state.highlightPicFunction)
                    if (state.highlightPicFunctionDark.isNotEmpty()) put("picFunctionDark", state.highlightPicFunctionDark)
                    if (state.highlightContent.isNotEmpty()) put("content", state.highlightContent)
                    if (state.highlightColorContent.isNotEmpty()) put("colorContent", state.highlightColorContent)
                    if (state.highlightColorContentDark.isNotEmpty()) put("colorContentDark", state.highlightColorContentDark)
                    if (state.highlightSubContent.isNotEmpty()) put("subContent", state.highlightSubContent)
                    if (state.highlightColorSubContent.isNotEmpty()) put("colorSubContent", state.highlightColorSubContent)
                    if (state.highlightColorSubContentDark.isNotEmpty()) put("colorSubContentDark", state.highlightColorSubContentDark)
                    
                    if (state.showTimerInfo) {
                        val timerInfoJson = JSONObject().apply {
                            put("timerType", state.timerType.toIntOrNull() ?: 0)
                            if (state.timerWhen.isNotEmpty()) {
                                put("timerWhen", state.timerWhen.toLongOrNull() ?: 0L)
                            }
                            if (state.timerTotal.isNotEmpty()) {
                                put("timerTotal", state.timerTotal.toLongOrNull() ?: 0L)
                            }
                            if (state.timerSystemCurrent.isNotEmpty()) {
                                put("timerSystemCurrent", state.timerSystemCurrent.toLongOrNull() ?: 0L)
                            }
                        }
                        put("timerInfo", timerInfoJson)
                    } else {
                        if (state.highlightTitle.isNotEmpty()) put("title", state.highlightTitle)
                        if (state.highlightColorTitle.isNotEmpty()) put("colorTitle", state.highlightColorTitle)
                        if (state.highlightColorTitleDark.isNotEmpty()) put("colorTitleDark", state.highlightColorTitleDark)
                    }
                }
                put("highlightInfo", highlightInfoJson)
            } else if (state.showIconTextInfo) {
                val iconTextInfoJson = JSONObject().apply {
                    val animIconInfoJson = JSONObject().apply {
                        put("type", state.iconTextType.toIntOrNull() ?: 0)
                        if (state.iconTextSrc.isNotEmpty()) put("src", state.iconTextSrc)
                        if (state.iconTextSrcDark.isNotEmpty()) put("srcDark", state.iconTextSrcDark)
                    }
                    put("animIconInfo", animIconInfoJson)

                    if (state.iconTextTitle.isNotEmpty()) put("title", state.iconTextTitle)
                    if (state.iconTextColorTitle.isNotEmpty()) put("colorTitle", state.iconTextColorTitle)
                    if (state.iconTextColorTitleDark.isNotEmpty()) put("colorTitleDark", state.iconTextColorTitleDark)

                    if (state.iconTextContent.isNotEmpty()) put("content", state.iconTextContent)
                    if (state.iconTextColorContent.isNotEmpty()) put("colorContent", state.iconTextColorContent)
                    if (state.iconTextColorContentDark.isNotEmpty()) put("colorContentDark", state.iconTextColorContentDark)
                    if (state.iconTextSubContent.isNotEmpty()) put("subContent", state.iconTextSubContent)
                }
                put("iconTextInfo", iconTextInfoJson)
            } else if (state.showCoverInfo) {
                val coverInfoJson = JSONObject().apply {
                    if (state.coverPicCover.isNotEmpty()) put("picCover", state.coverPicCover)
                    if (state.coverTitle.isNotEmpty()) put("title", state.coverTitle)
                    if (state.coverColorTitle.isNotEmpty()) put("colorTitle", state.coverColorTitle)
                    if (state.coverColorTitleDark.isNotEmpty()) put("colorTitleDark", state.coverColorTitleDark)

                    if (state.coverContent.isNotEmpty()) put("content", state.coverContent)
                    if (state.coverColorContent.isNotEmpty()) put("colorContent", state.coverColorContent)
                    if (state.coverColorContentDark.isNotEmpty()) put("colorContentDark", state.coverColorContentDark)

                    if (state.coverSubContent.isNotEmpty()) put("subContent", state.coverSubContent)
                    if (state.coverColorSubContent.isNotEmpty()) put("colorSubContent", state.coverColorSubContent)
                    if (state.coverColorSubContentDark.isNotEmpty()) put("colorSubContentDark", state.coverColorSubContentDark)
                }
                put("coverInfo", coverInfoJson)
            }

            if (state.showPicInfo) {
                val picInfoJson = JSONObject().apply {
                    val pType = state.picType.toIntOrNull() ?: 1
                    put("type", pType)
                    if (state.pic.isNotEmpty()) put("pic", state.pic)
                    if (state.picDark.isNotEmpty()) put("picDark", state.picDark)

                    if (pType == 5) {
                        if (state.picTitle.isNotEmpty()) put("title", state.picTitle)
                        if (state.picColorTitle.isNotEmpty()) put("colorTitle", state.picColorTitle)
                    } else {
                        if (state.showActionInfo) {
                            val actionInfoJson = JSONObject().apply {
                                put("clickWithCollapse", state.actionClickWithCollapse)
                                if (state.actionWayIndex == 0) {
                                    if (state.action.isNotEmpty()) put("action", state.action)
                                    put("actionTitle", state.actionTitle)
                                } else {
                                    put("actionIcon", state.actionIcon)
                                    put("actionIconDark", state.actionIconDark)
                                    put("actionTitle", state.actionTitle)
                                    if (state.actionTitleColor.isNotEmpty()) put("actionTitleColor", state.actionTitleColor)
                                    if (state.actionTitleColorDark.isNotEmpty()) put("actionTitleColorDark", state.actionTitleColorDark)
                                    if (state.actionBgColor.isNotEmpty()) put("actionBgColor", state.actionBgColor)
                                    if (state.actionBgColorDark.isNotEmpty()) put("actionBgColorDark", state.actionBgColorDark)
                                    put("actionIntentType", state.actionIntentType.toIntOrNull() ?: 1)
                                    put("actionIntent", state.actionIntent)
                                }
                            }
                            put("actionInfo", actionInfoJson)
                        }
                    }
                }
                put("picInfo", picInfoJson)
            }

            if (state.showActions) {
                val actionsArray = org.json.JSONArray()
                state.actionsList.forEach { actionState ->
                    val actionInfoJson = JSONObject().apply {
                        val aType = actionState.type.toIntOrNull() ?: 0
                        put("type", aType)
                        put("clickWithCollapse", actionState.clickWithCollapse)

                        if (aType == 1) {
                            val progressInfoJson = JSONObject().apply {
                                put("progress", actionState.progress.toIntOrNull() ?: 50)
                                if (actionState.colorProgress.isNotEmpty()) {
                                    put("colorProgress", actionState.colorProgress)
                                }
                                put("isCCW", actionState.isCCW)
                                put("isAutoProgress", actionState.isAutoProgress)
                            }
                            put("progressInfo", progressInfoJson)
                        }

                        if (actionState.actionWayIndex == 0) {
                            if (actionState.action.isNotEmpty()) put("action", actionState.action)
                            put("actionTitle", actionState.actionTitle)
                        } else {
                            put("actionIcon", actionState.actionIcon)
                            put("actionIconDark", actionState.actionIconDark)
                            put("actionTitle", actionState.actionTitle)
                            if (actionState.actionTitleColor.isNotEmpty()) put("actionTitleColor", actionState.actionTitleColor)
                            if (actionState.actionTitleColorDark.isNotEmpty()) put("actionTitleColorDark", actionState.actionTitleColorDark)
                            if (actionState.actionBgColor.isNotEmpty()) put("actionBgColor", actionState.actionBgColor)
                            if (actionState.actionBgColorDark.isNotEmpty()) put("actionBgColorDark", actionState.actionBgColorDark)
                            put("actionIntentType", actionState.actionIntentType.toIntOrNull() ?: 1)
                            put("actionIntent", actionState.actionIntent)
                        }
                    }
                    actionsArray.put(actionInfoJson)
                }
                put("actions", actionsArray)
            }

            if (state.showHintInfo) {
                val hintInfoJson = JSONObject().apply {
                    val hType = state.hintType.toIntOrNull() ?: 1
                    put("type", hType)

                    if (hType == 1) {
                        // type 1下，两者可以并存
                        if (state.hintTitle.isNotEmpty()) put("title", state.hintTitle)
                        if (state.hintColorTitle.isNotEmpty()) put("colorTitle", state.hintColorTitle)
                        if (state.hintColorTitleDark.isNotEmpty()) put("colorTitleDark", state.hintColorTitleDark)

                        if (state.showTimerInfo) {
                            val timerInfoJson = JSONObject().apply {
                                put("timerType", state.timerType.toIntOrNull() ?: 0)
                                if (state.timerWhen.isNotEmpty()) {
                                    put("timerWhen", state.timerWhen.toLongOrNull() ?: 0L)
                                }
                                if (state.timerTotal.isNotEmpty()) {
                                    put("timerTotal", state.timerTotal.toLongOrNull() ?: 0L)
                                }
                                if (state.timerSystemCurrent.isNotEmpty()) {
                                    put("timerSystemCurrent", state.timerSystemCurrent.toLongOrNull() ?: 0L)
                                }
                            }
                            put("timerInfo", timerInfoJson)
                        }
                    } else {
                        // type 2下，二选一
                        if (state.showTimerInfo) {
                            val timerInfoJson = JSONObject().apply {
                                put("timerType", state.timerType.toIntOrNull() ?: 0)
                                if (state.timerWhen.isNotEmpty()) {
                                    put("timerWhen", state.timerWhen.toLongOrNull() ?: 0L)
                                }
                                if (state.timerTotal.isNotEmpty()) {
                                    put("timerTotal", state.timerTotal.toLongOrNull() ?: 0L)
                                }
                                if (state.timerSystemCurrent.isNotEmpty()) {
                                    put("timerSystemCurrent", state.timerSystemCurrent.toLongOrNull() ?: 0L)
                                }
                            }
                            put("timerInfo", timerInfoJson)
                        } else {
                            if (state.hintTitle.isNotEmpty()) put("title", state.hintTitle)
                            if (state.hintColorTitle.isNotEmpty()) put("colorTitle", state.hintColorTitle)
                            if (state.hintColorTitleDark.isNotEmpty()) put("colorTitleDark", state.hintColorTitleDark)
                        }
                    }

                    if (state.hintSubTitle.isNotEmpty()) put("subTitle", state.hintSubTitle)
                    if (state.hintColorSubTitle.isNotEmpty()) put("colorSubTitle", state.hintColorSubTitle)
                    if (state.hintColorSubTitleDark.isNotEmpty()) put("colorSubTitleDark", state.hintColorSubTitleDark)

                    if (state.hintContent.isNotEmpty()) put("content", state.hintContent)
                    if (state.hintColorContent.isNotEmpty()) put("colorContent", state.hintColorContent)
                    if (state.hintColorContentDark.isNotEmpty()) put("colorContentDark", state.hintColorContentDark)

                    if (state.hintSubContent.isNotEmpty()) put("subContent", state.hintSubContent)
                    if (state.hintColorSubContent.isNotEmpty()) put("colorSubContent", state.hintColorSubContent)
                    if (state.hintColorSubContentDark.isNotEmpty()) put("colorSubContentDark", state.hintColorSubContentDark)

                    if (hType == 1) {
                        if (state.hintColorContentBg.isNotEmpty()) put("colorContentBg", state.hintColorContentBg)
                        if (state.hintPicContent.isNotEmpty()) put("picContent", state.hintPicContent)
                    }

                    if (state.showActionInfo) {
                        val actionInfoJson = JSONObject().apply {
                            put("clickWithCollapse", state.actionClickWithCollapse)
                            if (state.actionWayIndex == 0) {
                                if (state.action.isNotEmpty()) put("action", state.action)
                                put("actionTitle", state.actionTitle)
                            } else {
                                put("actionIcon", state.actionIcon)
                                put("actionIconDark", state.actionIconDark)
                                put("actionTitle", state.actionTitle)
                                if (state.actionTitleColor.isNotEmpty()) put("actionTitleColor", state.actionTitleColor)
                                if (state.actionTitleColorDark.isNotEmpty()) put("actionTitleColorDark", state.actionTitleColorDark)
                                if (state.actionBgColor.isNotEmpty()) put("actionBgColor", state.actionBgColor)
                                if (state.actionBgColorDark.isNotEmpty()) put("actionBgColorDark", state.actionBgColorDark)
                                put("actionIntentType", state.actionIntentType.toIntOrNull() ?: 1)
                                put("actionIntent", state.actionIntent)
                            }
                        }
                        put("actionInfo", actionInfoJson)
                    }
                }
                put("hintInfo", hintInfoJson)
            }

            if (state.showProgressInfo) {
                val progressInfoJson = JSONObject().apply {
                    put("progress", state.progressText.toIntOrNull() ?: 0)
                    if (state.colorProgress.isNotEmpty()) {
                        put("colorProgress", state.colorProgress)
                    }
                    if (state.colorProgressEnd.isNotEmpty()) {
                        put("colorProgressEnd", state.colorProgressEnd)
                    }
                    if (state.picForward.isNotEmpty()) {
                        put("picForward", state.picForward)
                    }
                    if (state.picMiddle.isNotEmpty()) {
                        put("picMiddle", state.picMiddle)
                    }
                    if (state.picMiddleUnselected.isNotEmpty()) {
                        put("picMiddleUnselected", state.picMiddleUnselected)
                    }
                    if (state.picEnd.isNotEmpty()) {
                        put("picEnd", state.picEnd)
                    }
                    if (state.picEndUnselected.isNotEmpty()) {
                        put("picEndUnselected", state.picEndUnselected)
                    }
                }
                put("progressInfo", progressInfoJson)
            }

            if (state.showMultiProgressInfo) {
                val multiProgressInfoJson = JSONObject().apply {
                    put("title", state.multiProgressTitle)
                    put("progress", state.multiProgressVal.toIntOrNull() ?: 50)
                    if (state.multiProgressColor.isNotEmpty()) {
                        put("color", state.multiProgressColor)
                    }
                    if (state.multiProgressPoints.isNotEmpty()) {
                        put("points", state.multiProgressPoints.toIntOrNull() ?: 0)
                    }
                }
                put("multiProgressInfo", multiProgressInfoJson)
            }

            if (state.showHighlightInfoV3) {
                val highlightInfoV3Json = JSONObject().apply {
                    if (state.highlightV3PrimaryText.isNotEmpty()) put("primaryText", state.highlightV3PrimaryText)
                    if (state.highlightV3SecondaryText.isNotEmpty()) put("secondaryText", state.highlightV3SecondaryText)
                    put("showSecondaryLine", state.highlightV3ShowSecondaryLine)
                    if (state.highlightV3HighLightText.isNotEmpty()) put("highLightText", state.highlightV3HighLightText)

                    if (state.highlightV3PrimaryColor.isNotEmpty()) put("primaryColor", state.highlightV3PrimaryColor)
                    if (state.highlightV3SecondaryColor.isNotEmpty()) put("secondaryColor", state.highlightV3SecondaryColor)
                    if (state.highlightV3HighLightTextColor.isNotEmpty()) put("highLightTextColor", state.highlightV3HighLightTextColor)
                    if (state.highlightV3HighLightBgColor.isNotEmpty()) put("highLightbgColor", state.highlightV3HighLightBgColor)

                    if (state.highlightV3PrimaryColorDark.isNotEmpty()) put("primaryColorDark", state.highlightV3PrimaryColorDark)
                    if (state.highlightV3SecondaryColorDark.isNotEmpty()) put("secondaryColorDark", state.highlightV3SecondaryColorDark)
                    if (state.highlightV3HighLightTextColorDark.isNotEmpty()) put("highLightTextColorDark", state.highlightV3HighLightTextColorDark)
                    if (state.highlightV3HighLightBgColorDark.isNotEmpty()) put("highLightbgColorDark", state.highlightV3HighLightBgColorDark)

                    if (state.showActionInfo) {
                        val actionInfoJson = JSONObject().apply {
                            put("clickWithCollapse", state.actionClickWithCollapse)
                            if (state.actionWayIndex == 0) {
                                if (state.action.isNotEmpty()) put("action", state.action)
                                put("actionTitle", state.actionTitle)
                            } else {
                                put("actionIcon", state.actionIcon)
                                put("actionIconDark", state.actionIconDark)
                                put("actionTitle", state.actionTitle)
                                if (state.actionTitleColor.isNotEmpty()) put("actionTitleColor", state.actionTitleColor)
                                if (state.actionTitleColorDark.isNotEmpty()) put("actionTitleColorDark", state.actionTitleColorDark)
                                if (state.actionBgColor.isNotEmpty()) put("actionBgColor", state.actionBgColor)
                                if (state.actionBgColorDark.isNotEmpty()) put("actionBgColorDark", state.actionBgColorDark)
                                put("actionIntentType", state.actionIntentType.toIntOrNull() ?: 1)
                                put("actionIntent", state.actionIntent)
                            }
                        }
                        put("actionInfo", actionInfoJson)
                    }
                }
                put("highlightInfoV3", highlightInfoV3Json)
            }

            if (state.showBgInfo) {
                val bgInfoJson = JSONObject().apply {
                    put("type", state.bgType.toIntOrNull() ?: 1)
                    if (state.picBg.isNotEmpty()) put("picBg", state.picBg)
                    if (state.colorBg.isNotEmpty()) put("colorBg", state.colorBg)
                }
                put("bgInfo", bgInfoJson)
            }

            if (state.enableIsland) {
                val paramIslandJson = JSONObject().apply {
                    put("islandProperty", if (state.islandPropertyVal) 2 else 1)
                    put("islandOrder", state.islandOrderVal)
                    put("islandTimeout", state.islandTimeoutText.toIntOrNull() ?: 3600)
                    put("dismissIsland", state.dismissIslandVal)
                    if (state.islandHighlightColor.isNotEmpty()) {
                        put("highlightColor", state.islandHighlightColor)
                    }

                    if (state.showShareData) {
                        val shareDataJson = JSONObject().apply {
                            put("pic", state.sharePic)
                            put("title", state.shareTitle)
                            put("content", state.shareContent)
                            put("shareContent", state.shareContentText)
                            if (state.sharePicUrl.isNotEmpty()) {
                                put("sharePic", state.sharePicUrl)
                            }
                        }
                        put("shareData", shareDataJson)
                    }

                    if (state.showIslandLeftInfo || state.showIslandRightInfo) {
                        val bigIslandAreaJson = JSONObject().apply {
                            if (state.showIslandLeftInfo) {
                                if (state.islandLeftSelection == "imageTextInfoLeft5") {
                                    val leftInfoJson = JSONObject().apply {
                                        put("type", 5) // imageTextInfoLeft5 type is 5
                                        
                                        val picInfoJson = JSONObject().apply {
                                            put("type", 4) // static icon type is 4
                                            if (state.islandLeftPic.isNotEmpty()) {
                                                put("pic", state.islandLeftPic)
                                            }
                                        }
                                        put("picInfo", picInfoJson)
                                        
                                        val textInfoJson = JSONObject().apply {
                                            if (state.islandLeftTitle.isNotEmpty()) put("title", state.islandLeftTitle)
                                            if (state.islandLeftContent.isNotEmpty()) put("content", state.islandLeftContent)
                                            put("showHighlightColor", state.islandLeftShowHighlightVal)
                                        }
                                        put("textInfo", textInfoJson)
                                    }
                                    put("imageTextInfoLeft", leftInfoJson)
                                } else {
                                    val leftInfoJson = JSONObject().apply {
                                        put("type", 1) // imageTextInfoLeft type is always 1
                                        
                                        val picInfoJson = JSONObject().apply {
                                            put("type", 1)
                                            if (state.islandLeftPic.isNotEmpty()) {
                                                put("pic", state.islandLeftPic)
                                            }
                                        }
                                        put("picInfo", picInfoJson)
                                        
                                        val textInfoJson = JSONObject().apply {
                                            if (state.islandLeftTitle.isNotEmpty()) put("title", state.islandLeftTitle)
                                            if (state.islandLeftContent.isNotEmpty()) put("content", state.islandLeftContent)
                                            put("showHighlightColor", state.islandLeftShowHighlightVal)
                                            put("narrowFont", state.islandLeftNarrowFontVal)
                                        }
                                        put("textInfo", textInfoJson)
                                    }
                                    put("imageTextInfoLeft", leftInfoJson)
                                }
                            }

                            if (state.showIslandRightInfo) {
                                when (state.islandRightSelection) {
                                    "imageTextInfoRight3" -> {
                                        val right3InfoJson = JSONObject().apply {
                                            put("type", 3) // imageTextInfoRight3 type is always 3
                                            
                                            val picInfoJson = JSONObject().apply {
                                                put("type", 1)
                                                if (state.islandRightPic.isNotEmpty()) {
                                                    put("pic", state.islandRightPic)
                                                }
                                            }
                                            put("picInfo", picInfoJson)
                                            
                                            val textInfoJson = JSONObject().apply {
                                                if (state.islandRightTitle.isNotEmpty()) put("title", state.islandRightTitle)
                                                put("showHighlightColor", state.islandRightShowHighlightVal)
                                                put("narrowFont", state.islandRightNarrowFontVal)
                                            }
                                            put("textInfo", textInfoJson)
                                        }
                                        put("imageTextInfoRight3", right3InfoJson)
                                    }
                                    "textInfo" -> {
                                        val textInfoJson = JSONObject().apply {
                                            if (state.islandRightFrontTitle.isNotEmpty()) put("frontTitle", state.islandRightFrontTitle)
                                            if (state.islandRightTitle.isNotEmpty()) put("title", state.islandRightTitle)
                                            if (state.islandRightContent.isNotEmpty()) put("content", state.islandRightContent)
                                            put("showHighlightColor", state.islandRightShowHighlightVal)
                                            put("narrowFont", state.islandRightNarrowFontVal)
                                        }
                                        put("textInfo", textInfoJson)
                                    }
                                    "fixedWidthDigitInfo" -> {
                                        val fixedWidthDigitInfoJson = JSONObject().apply {
                                            if (state.islandRightDigit.isNotEmpty()) put("digit", state.islandRightDigit)
                                            if (state.islandRightContent.isNotEmpty()) put("content", state.islandRightContent)
                                            put("showHighlightColor", state.islandRightShowHighlightVal)
                                        }
                                        put("fixedWidthDigitInfo", fixedWidthDigitInfoJson)
                                    }
                                    "progressTextInfo" -> {
                                        val progressTextInfoJson = JSONObject().apply {
                                            val progressInfoJson = JSONObject().apply {
                                                val prog = state.islandRightProgress.toIntOrNull() ?: 0
                                                put("progress", prog)
                                                if (state.islandRightColorReach.isNotEmpty()) put("colorReach", state.islandRightColorReach)
                                                if (state.islandRightColorUnReach.isNotEmpty()) put("colorUnReach", state.islandRightColorUnReach)
                                                put("isCCW", state.islandRightIsCCW)
                                            }
                                            put("progressInfo", progressInfoJson)
                                            
                                            val textInfoJson = JSONObject().apply {
                                                if (state.islandRightFrontTitle.isNotEmpty()) put("frontTitle", state.islandRightFrontTitle)
                                                if (state.islandRightTitle.isNotEmpty()) put("title", state.islandRightTitle)
                                                if (state.islandRightContent.isNotEmpty()) put("content", state.islandRightContent)
                                                put("showHighlightColor", state.islandRightShowHighlightVal)
                                                put("narrowFont", state.islandRightNarrowFontVal)
                                            }
                                            put("textInfo", textInfoJson)
                                        }
                                        put("progressTextInfo", progressTextInfoJson)
                                    }
                                    "imageTextInfoRight" -> {
                                        val rightInfoJson = JSONObject().apply {
                                            put("type", 2) // imageTextInfoRight type is always 2
                                            
                                            val picInfoJson = JSONObject().apply {
                                                put("type", 1)
                                                if (state.islandRightPic.isNotEmpty()) {
                                                    put("pic", state.islandRightPic)
                                                }
                                            }
                                            put("picInfo", picInfoJson)
                                            
                                            val textInfoJson = JSONObject().apply {
                                                if (state.islandRightFrontTitle.isNotEmpty()) put("frontTitle", state.islandRightFrontTitle)
                                                if (state.islandRightTitle.isNotEmpty()) put("title", state.islandRightTitle)
                                                if (state.islandRightContent.isNotEmpty()) put("content", state.islandRightContent)
                                                put("showHighlightColor", state.islandRightShowHighlightVal)
                                                put("narrowFont", state.islandRightNarrowFontVal)
                                            }
                                            put("textInfo", textInfoJson)
                                        }
                                        put("imageTextInfoRight", rightInfoJson)
                                    }
                                }
                            }
                        }
                        put("bigIslandArea", bigIslandAreaJson)
                    }

                    if (state.showIslandSmallInfo) {
                        val smallIslandAreaJson = JSONObject().apply {
                            if (state.islandSmallSelection == "picInfo") {
                                val picInfoJson = JSONObject().apply {
                                    put("type", 1)
                                    if (state.islandSmallPic.isNotEmpty()) {
                                        put("pic", state.islandSmallPic)
                                    }
                                }
                                put("picInfo", picInfoJson)
                            } else if (state.islandSmallSelection == "combinePicInfo") {
                                val combinePicInfoJson = JSONObject().apply {
                                    val picInfoJson = JSONObject().apply {
                                        put("type", 1)
                                        if (state.islandSmallPic.isNotEmpty()) {
                                            put("pic", state.islandSmallPic)
                                        }
                                    }
                                    put("picInfo", picInfoJson)
                                    
                                    val progressInfoJson = JSONObject().apply {
                                        val prog = state.islandSmallProgress.toIntOrNull() ?: 0
                                        put("progress", prog)
                                        if (state.islandSmallColorReach.isNotEmpty()) {
                                            put("colorReach", state.islandSmallColorReach)
                                        }
                                        if (state.islandSmallColorUnReach.isNotEmpty()) {
                                            put("colorUnReach", state.islandSmallColorUnReach)
                                        }
                                        put("isCCW", state.islandSmallIsCCW)
                                    }
                                    put("progressInfo", progressInfoJson)
                                }
                                put("combinePicInfo", combinePicInfoJson)
                            }
                        }
                        put("smallIslandArea", smallIslandAreaJson)
                    }
                }
                put("param_island", paramIslandJson)
            } else {
                val paramIslandJson = JSONObject().apply {
                    put("dismissIsland", true)
                }
                put("param_island", paramIslandJson)
            }
        }

        val paramJson = JSONObject().apply {
            put("param_v2", paramV2Json)
        }

        val bundle = Bundle().apply {
            putString("miui.focus.param", paramJson.toString())
        }

        val builder = Notification.Builder(context, channelId)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle(state.normalTitle.ifEmpty { "Hyper Notification" })
            .setContentText(state.normalContent.ifEmpty { "Testing Base Info" })
            .addExtras(bundle)

        if (state.showProgressInfo) {
            val progressVal = state.progressText.toIntOrNull() ?: 0
            builder.setProgress(100, progressVal, false)
        }

        if (pendingIntent != null) {
            builder.setContentIntent(pendingIntent)
        }

        val notification = builder.build()
        manager.notify(System.currentTimeMillis().toInt(), notification)
    }
}
