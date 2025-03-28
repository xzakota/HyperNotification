package com.xzakota.hyper.notification.focus.example.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.graphics.drawable.Icon
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.xzakota.hyper.notification.focus.FocusNotification
import com.xzakota.hyper.notification.focus.example.BuildConfig
import com.xzakota.hyper.notification.focus.example.databinding.LayoutActivityMainBinding
import com.xzakota.hyper.notification.focus.example.extension.toBitmap

@Suppress("SameParameterValue")
@SuppressLint("SetTextI18n")
class MainActivity : Activity() {
    private lateinit var notificationManager : NotificationManager

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)

        notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        val binding = LayoutActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.postNotificationButton.setOnClickListener {
            postFocus("Ticker", "Title", "Content")
        }
    }

    private fun postFocus(tickerText : String, titleText : String, contentText : String) {
        if (!notificationManager.areNotificationsEnabled()) {
            showToast("No notification permission")
            return
        }

        // create channel
        if (notificationManager.getNotificationChannel(ID_FOCUS_CHANNEL) == null) {
            notificationManager.createNotificationChannel(
                NotificationChannel(
                    ID_FOCUS_CHANNEL, "Focus Notification", NotificationManager.IMPORTANCE_DEFAULT
                ).apply {
                    description = "Post focus notification for HyperOS"
                    setSound(null, null)
                    setAllowBubbles(true)
                }
            )
        }

        val intent = packageManager.getLaunchIntentForPackage(BuildConfig.APPLICATION_ID) ?: return
        val iconBitmap = packageManager.getActivityIcon(intent).toBitmap()
        val icon = Icon.createWithBitmap(iconBitmap)
        val uri = intent.toUri(Intent.URI_INTENT_SCHEME)

        // build focus bundle
        val extras = FocusNotification.buildV2 {
            enableFloat = true
            ticker = tickerText
            tickerPic = createParcelable("miui.focus.ticker_pic", icon)

            baseInfo {
                type = 1
                title = titleText
                content = contentText
            }

            hintInfo {
                type = 2
                title = titleText + "2"
                content = contentText + "2"

                actionInfo {
                    actionTitle = "Action"
                    actionIntent = uri
                }
            }

            actions {
                addActionInfo {
                    actionIcon = createParcelable("miui.focus.action_pic", icon)
                    actionIntent = uri
                }
            }
        }

        // free bitmap
        iconBitmap.recycle()

        if (BuildConfig.DEBUG) {
            Log.d("FocusNotify", extras.toString())
        }

        // notify
        notificationManager.notify(
            ID_FOCUS_CHANNEL.hashCode(),
            Notification.Builder(this, ID_FOCUS_CHANNEL)
                .setSmallIcon(icon)
                .setTicker(tickerText)
                .setContentTitle(titleText)
                .setContentText(contentText)
                .addExtras(extras)
                .build()
        )
    }

    private fun showToast(massage : CharSequence) = Toast.makeText(this, massage, Toast.LENGTH_SHORT).show()

    private companion object {
        var ID_FOCUS_CHANNEL = "focus_channel"
    }
}
