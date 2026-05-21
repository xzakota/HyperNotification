package com.xzakota.hyper.notification.focus.example.core

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.graphics.Rect
import android.graphics.RectF
import android.net.Uri
import android.util.Log
import java.io.File
import java.io.FileOutputStream
import kotlin.math.min
import androidx.core.graphics.scale
import androidx.core.graphics.createBitmap

object ImagePickerAndProcessor {

    enum class ImageSpec(val width: Int, val height: Int) {
        BASE_PIC_FUNCTION(80, 80),
        HIGHLIGHT_PIC_FUNCTION(96, 96),
        PIC_INFO_TYPE_1_5(96, 96),
        PIC_INFO_TYPE_2(176, 176),
        PIC_INFO_TYPE_3(224, 224),
        COVER_PIC_COVER(224, 288),
        CHAT_PIC_PROFILE(224, 224),
        CHAT_APP_ICON_PKG(96, 96),
        HINT_PIC_CONTENT(96, 96),
        BG_PIC_BG(360, 240), // 卡片背景官方无建议，预设 360*240 px (1.5:1)
        SHARE_PIC(224, 224),
        ISLAND_LEFT_PIC(88, 88),
        ISLAND_RIGHT_PIC(128, 88), // 右侧支持更宽图形，选用最宽的 128*88 px
        ISLAND_SMALL_PIC(88, 88),
        TICKER_PIC(88, 88),
        AOD_PIC(88, 88),
        ICON_TEXT_SRC(224, 224),
        ACTION_ICON(96, 96),
        PROGRESS_FORWARD(240, 188),
        PROGRESS_MIDDLE_END(120, 188)
    }

    /**
     * 智能裁剪、等比缩放、1/4圆角裁剪并以压缩的 PNG 格式转存至私有缓存目录中。
     * @return 转存后的本地绝对路径文件字符串；若发生错误则返回空。
     */
    fun processImage(
        context: Context,
        uri: Uri,
        spec: ImageSpec,
        fileName: String
    ): String? {
        return try {
            val contentResolver = context.contentResolver
            val inputStream = contentResolver.openInputStream(uri) ?: return null
            val originalBitmap = BitmapFactory.decodeStream(inputStream)
            inputStream.close()

            if (originalBitmap == null) return null

            val finalBitmap: Bitmap
            if (spec == ImageSpec.BG_PIC_BG) {
                // 仅压缩图片，不对它进行裁剪，也不切圆角。系统会自动处理拉伸铺满。
                val maxDimension = 720
                val width = originalBitmap.width
                val height = originalBitmap.height
                if (width > maxDimension || height > maxDimension) {
                    val ratio = width.toFloat() / height
                    val targetW: Int
                    val targetH: Int
                    if (width > height) {
                        targetW = maxDimension
                        targetH = (maxDimension / ratio).toInt()
                    } else {
                        targetH = maxDimension
                        targetW = (maxDimension * ratio).toInt()
                    }
                    finalBitmap = Bitmap.createScaledBitmap(originalBitmap, targetW, targetH, true)
                    originalBitmap.recycle()
                } else {
                    finalBitmap = originalBitmap
                }
            } else {
                // 1. 等比例居中裁剪 (Center-Crop) 缩放至目标规格像素大小
                val croppedBitmap = centerCropAndScale(originalBitmap, spec.width, spec.height)
                if (croppedBitmap != originalBitmap) {
                    originalBitmap.recycle()
                }

                // 2. 取短边尺寸 1/4 作为优雅圆角数值进行 Bitmap 透明圆角截取
                val shortSide = min(spec.width, spec.height)
                val cornerRadius = shortSide / 4f
                finalBitmap = getRoundedCornerBitmap(croppedBitmap, cornerRadius)
                croppedBitmap.recycle()
            }

            // 3. 转存至 App 私有 cache 目录
            val cacheFile = File(context.cacheDir, fileName)
            FileOutputStream(cacheFile).use { out ->
                finalBitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
            }
            finalBitmap.recycle()

            Log.d("ImagePickerAndProcessor", "Successfully processed image to ${cacheFile.absolutePath}")
            cacheFile.absolutePath
        } catch (e: Throwable) {
            Log.e("ImagePickerAndProcessor", "Error processing image", e)
            null
        }
    }

    private fun centerCropAndScale(source: Bitmap, targetWidth: Int, targetHeight: Int): Bitmap {
        val sourceWidth = source.width
        val sourceHeight = source.height

        val targetRatio = targetWidth.toFloat() / targetHeight
        val sourceRatio = sourceWidth.toFloat() / sourceHeight

        var cropWidth = sourceWidth
        var cropHeight = sourceHeight
        var cropLeft = 0
        var cropTop = 0

        if (sourceRatio > targetRatio) {
            // 原图偏宽，裁剪左右
            cropWidth = (sourceHeight * targetRatio).toInt()
            cropLeft = (sourceWidth - cropWidth) / 2
        } else {
            // 原图偏高，裁剪上下
            cropHeight = (sourceWidth / targetRatio).toInt()
            cropTop = (sourceHeight - cropHeight) / 2
        }

        val cropped = Bitmap.createBitmap(source, cropLeft, cropTop, cropWidth, cropHeight)
        val scaled = cropped.scale(targetWidth, targetHeight)
        if (cropped != source) {
            cropped.recycle()
        }
        return scaled
    }

    private fun getRoundedCornerBitmap(bitmap: Bitmap, cornerRadius: Float): Bitmap {
        val output = createBitmap(bitmap.width, bitmap.height)
        val canvas = Canvas(output)
        val paint = Paint().apply {
            isAntiAlias = true
        }
        val rect = Rect(0, 0, bitmap.width, bitmap.height)
        val rectF = RectF(rect)

        canvas.drawARGB(0, 0, 0, 0)
        paint.color = 0xff424242.toInt()
        canvas.drawRoundRect(rectF, cornerRadius, cornerRadius, paint)

        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        canvas.drawBitmap(bitmap, rect, rect, paint)
        return output
    }
}
