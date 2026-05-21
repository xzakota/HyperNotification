package com.xzakota.hyper.notification.focus.example.ui.miuix

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import top.yukonga.miuix.kmp.basic.Text
import top.yukonga.miuix.kmp.basic.IconButton
import top.yukonga.miuix.kmp.basic.Icon
import top.yukonga.miuix.kmp.icon.MiuixIcons
import top.yukonga.miuix.kmp.icon.extended.Delete
import top.yukonga.miuix.kmp.preference.ArrowPreference
import com.xzakota.hyper.notification.focus.example.core.ImagePickerAndProcessor
import top.yukonga.miuix.kmp.theme.MiuixTheme


@Composable
fun ImagePickerPreference(
    title: String,
    summary: String? = null,
    imageSpec: ImagePickerAndProcessor.ImageSpec,
    currentPath: String,
    onPathChange: (String) -> Unit
) {
    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        uri?.let {
            val processedPath = ImagePickerAndProcessor.processImage(
                context = context,
                uri = it,
                spec = imageSpec,
                fileName = "processed_${imageSpec.name.lowercase()}_${System.currentTimeMillis()}.png"
            )
            if (processedPath != null) {
                onPathChange(processedPath)
            }
        }
    }

    ArrowPreference(
        title = title,
        summary = summary,
        endActions = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (currentPath.isNotEmpty() && currentPath.startsWith("/")) {
                    Text(
                        text = "已上传图片",
                        color = MiuixTheme.colorScheme.primary,
                        fontSize = MiuixTheme.textStyles.body2.fontSize
                    )
                    IconButton(
                        onClick = { onPathChange("") },
                        modifier = Modifier.size(24.dp)
                    ) {
                        Icon(
                            imageVector = MiuixIcons.Delete,
                            contentDescription = "清除图片",
                            modifier = Modifier.size(16.dp)
                        )
                    }
                } else {
                    Text(
                        text = "默认",
                        fontSize = MiuixTheme.textStyles.body2.fontSize,
                        color = MiuixTheme.colorScheme.onSurfaceVariantActions
                    )
                }
            }
        },
        onClick = {
            launcher.launch("image/*")
        }
    )
}
