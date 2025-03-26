package com.xzakota.hyper.notification.focus.example.extension

import android.graphics.Bitmap
import android.graphics.Bitmap.Config
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.annotation.Px

// copy from androidx core
fun Drawable.toBitmap(
    @Px width : Int = intrinsicWidth,
    @Px height : Int = intrinsicHeight,
    config : Config? = null
) : Bitmap {
    if (this is BitmapDrawable) {
        if (bitmap == null) {
            throw IllegalArgumentException("bitmap is null")
        }
        if (config == null || bitmap.config == config) {
            if (width == bitmap.width && height == bitmap.height) {
                return bitmap
            }
            return Bitmap.createScaledBitmap(bitmap, width, height, true)
        }
    }

    val bitmap = Bitmap.createBitmap(width, height, config ?: Config.ARGB_8888)
    setBounds(0, 0, width, height)
    draw(Canvas(bitmap))

    setBounds(bounds.left, bounds.top, bounds.right, bounds.bottom)
    return bitmap
}