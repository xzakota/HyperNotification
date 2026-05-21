package com.xzakota.hyper.notification.focus.example.ui.miuix

import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import top.yukonga.miuix.kmp.basic.Card
import top.yukonga.miuix.kmp.basic.MiuixScrollBehavior
import top.yukonga.miuix.kmp.basic.Scaffold
import top.yukonga.miuix.kmp.basic.TopAppBar
import top.yukonga.miuix.kmp.basic.SmallTitle
import top.yukonga.miuix.kmp.basic.TextField
import top.yukonga.miuix.kmp.theme.MiuixTheme
import top.yukonga.miuix.kmp.preference.SwitchPreference
import com.xzakota.hyper.notification.focus.example.core.shizuku.ShizukuManager
import com.xzakota.hyper.notification.focus.example.ui.utils.pageContentPadding
import com.xzakota.hyper.notification.focus.example.ui.utils.pageScrollModifiers
import kotlinx.coroutines.launch
import rikka.shizuku.Shizuku

@Composable
fun PagerNormalNotification(
    state: NotificationState,
    outerPadding: PaddingValues
) {
    val context = LocalContext.current
    val topAppBarScrollBehavior = MiuixScrollBehavior()
    val scope = rememberCoroutineScope()

    DisposableEffect(Unit) {
        val binderDeadListener = Shizuku.OnBinderDeadListener {
            state.bypassFocusLimit = false
            Handler(Looper.getMainLooper()).post {
                Toast.makeText(context, "shizuku 服务已停止，绕过已关闭", Toast.LENGTH_SHORT).show()
            }
        }
        if (ShizukuManager.isShizukuServiceRunning()) {
            try {
                Shizuku.addBinderDeadListener(binderDeadListener)
            } catch (_: Throwable) {
                // Ignore
            }
        }
        ShizukuManager.onServiceDisconnectedCallback = {
            state.bypassFocusLimit = false
            Handler(Looper.getMainLooper()).post {
                Toast.makeText(context, "shizuku 服务离线，绕过已关闭", Toast.LENGTH_SHORT).show()
            }
        }

        onDispose {
            try {
                Shizuku.removeBinderDeadListener(binderDeadListener)
            } catch (_: Throwable) {
                // Ignore
            }
            ShizukuManager.onServiceDisconnectedCallback = null
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                color = MiuixTheme.colorScheme.surface,
                title = "普通通知参数",
                scrollBehavior = topAppBarScrollBehavior,
            )
        }
    ) { innerPadding ->
        val contentPadding = pageContentPadding(
            innerPadding = innerPadding,
            outerPadding = outerPadding,
            isWideScreen = false,
            extraStart = 0.dp,
            extraEnd = 0.dp,
        )

        Box {
            LazyColumn(
                modifier = Modifier.pageScrollModifiers(
                    enableScrollEndHaptic = true,
                    showTopAppBar = true,
                    topAppBarScrollBehavior = topAppBarScrollBehavior,
                ),
                contentPadding = contentPadding
            ) {
                item {
                    SmallTitle(text = "普通通知基本参数")
                }
                item {
                    Card(
                        modifier = Modifier
                            .padding(horizontal = 12.dp)
                            .padding(bottom = 12.dp)
                            .fillMaxWidth()
                    ) {
                        TextField(
                            value = state.normalTitle,
                            onValueChange = { state.normalTitle = it },
                            label = "Title (标题)",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 12.dp, vertical = 12.dp)
                        )
                        TextField(
                            value = state.normalContent,
                            onValueChange = { state.normalContent = it },
                            label = "Content (通知内容)",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
                        )
                    }
                }

                item {
                    Card(
                        modifier = Modifier
                            .padding(horizontal = 12.dp)
                            .padding(bottom = 12.dp)
                            .fillMaxWidth()
                    ) {
                        SwitchPreference(
                            title = "绕过焦点通知限制（shizuku）",
                            checked = state.bypassFocusLimit,
                            onCheckedChange = { checked ->
                                if (checked) {
                                    scope.launch {
                                        val granted = ShizukuManager.checkShizukuPermission()
                                        if (granted) {
                                            state.bypassFocusLimit = true
                                            Toast.makeText(context, "已开启", Toast.LENGTH_SHORT).show()
                                        } else {
                                            state.bypassFocusLimit = false
                                            Toast.makeText(context, "Shizuku 授权失败", Toast.LENGTH_SHORT).show()
                                        }
                                    }
                                } else {
                                    state.bypassFocusLimit = false
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}

