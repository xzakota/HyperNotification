package com.xzakota.hyper.notification.focus.example.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.drawable.Icon
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RemoteViews
import android.widget.Toast
import com.xzakota.hyper.notification.focus.FocusNotification
import com.xzakota.hyper.notification.focus.example.BuildConfig
import com.xzakota.hyper.notification.focus.example.R
import com.xzakota.hyper.notification.focus.example.databinding.LayoutActivityMainBinding
import com.xzakota.hyper.notification.focus.example.extension.toBitmap
import com.xzakota.hyper.notification.focus.model.CustomFocusTemplate
import kotlin.random.Random

@Suppress("SameParameterValue")
@SuppressLint("SetTextI18n")
class MainActivity : Activity(), View.OnClickListener {
    private lateinit var notificationManager : NotificationManager

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)

        notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        val binding = LayoutActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.postFocusButton.setOnClickListener(this)
        binding.postCustomFocusButton.setOnClickListener(this)
    }

    override fun onClick(v : View) {
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

        val tickerText = "Ticker"
        val titleText = "Title"
        val contentText = "Content"
        val random = Random(System.currentTimeMillis()).nextInt()

        val intent = packageManager.getLaunchIntentForPackage(BuildConfig.APPLICATION_ID) ?: return
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_MUTABLE)
        val iconBitmap = packageManager.getActivityIcon(intent).toBitmap()
        val icon = Icon.createWithBitmap(iconBitmap)
        val uri = intent.toUri(Intent.URI_INTENT_SCHEME)

        // build focus bundle
        val extras = when (v.id) {
            R.id.post_focus_button -> FocusNotification.buildV2 {
                val logo = createPicture("key_logo", icon)

                enableFloat = true
                ticker = tickerText
                tickerPic = logo

                baseInfo {
                    type = 1
                    title = titleText
                    content = contentText
                }

                hintInfo {
                    type = 2
                    title = "$random"
                    content = "Hint $contentText"

                    actionInfo {
                        actionTitle = "Action"
                        actionIntent = uri
                    }
                }

                actions {
                    addActionInfo {
                        actionIcon = logo
                        actionIntent = uri
                    }

                    addActionInfo {
                        action = createAction(
                            "key_action1",
                            Notification.Action.Builder(icon, null, pendingIntent).build()
                        )
                    }
                }
            }

            R.id.post_custom_focus_button -> FocusNotification.buildCustomV2 {
                enableFloat = true
                ticker = tickerText
                tickerPic = createPicture("key_logo", icon)

                fun initRemoteViews(key : String, layoutId : Int) {
                    createRemoteViews(key, RemoteViews(packageName, layoutId).apply {
                        setTextViewText(R.id.content, "It's a long text.It's a long text.It's a long text. $random")
                    })
                }

                initRemoteViews(CustomFocusTemplate.LAYOUT, R.layout.layout_focus_custom)
                initRemoteViews(CustomFocusTemplate.LAYOUT_NIGHT, R.layout.layout_focus_custom_night)
            }

            else -> null
        }

        // free bitmap
        iconBitmap.recycle()

        if (BuildConfig.DEBUG) {
            Log.d("FocusNotify", extras.toString())
        }

        // notify
        notificationManager.notify(
            v.id,
            Notification.Builder(this, ID_FOCUS_CHANNEL)
                .setSmallIcon(icon)
                .setTicker(tickerText)
                .setContentTitle(titleText)
                .setContentText(contentText)
                .setContentIntent(pendingIntent)
                .addExtras(extras)
                .build()
        )
    }

    private fun showToast(massage : CharSequence) = Toast.makeText(this, massage, Toast.LENGTH_SHORT).show()

    private companion object {
        var ID_FOCUS_CHANNEL = "focus_channel"
    }
}
