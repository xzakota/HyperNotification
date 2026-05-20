package com.xzakota.hyper.notification.focus.example.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberDecoratedNavEntries
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.LaunchedEffect
import com.xzakota.hyper.notification.focus.example.ui.miuix.NotificationState
import com.xzakota.hyper.notification.focus.example.ui.miuix.PagerNormalNotification
import com.xzakota.hyper.notification.focus.example.ui.miuix.PagerV2Params
import com.xzakota.hyper.notification.focus.example.ui.miuix.PagerV3Params
import com.xzakota.hyper.notification.focus.example.ui.miuix.PagerBehaviorAod

import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch
import top.yukonga.miuix.kmp.basic.Scaffold
import top.yukonga.miuix.kmp.basic.NavigationBar
import top.yukonga.miuix.kmp.basic.NavigationBarItem
import top.yukonga.miuix.kmp.basic.Icon
import top.yukonga.miuix.kmp.icon.MiuixIcons
import top.yukonga.miuix.kmp.icon.extended.HorizontalSplit
import top.yukonga.miuix.kmp.icon.extended.Create
import top.yukonga.miuix.kmp.icon.extended.Image
import top.yukonga.miuix.kmp.icon.extended.Settings
import top.yukonga.miuix.kmp.icon.extended.Send

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.graphics.Color
import top.yukonga.miuix.kmp.basic.FloatingActionButton
import top.yukonga.miuix.kmp.basic.FabPosition
import top.yukonga.miuix.kmp.basic.Text
import com.xzakota.hyper.notification.focus.example.core.NotificationUtils
import com.xzakota.hyper.notification.focus.example.ui.utils.rememberMainPagerState

@Composable
fun AppNavigation(startRoute: Route) {
    val backStack = remember { mutableStateListOf<NavKey>(startRoute) }
    val navigator = remember { Navigator(backStack) }

    CompositionLocalProvider(LocalNavigator provides navigator) {
        val entryProvider = remember(backStack) {
            entryProvider<NavKey> {
                entry<Route.Main> {
                    val pagerState = rememberPagerState(pageCount = { 4 })
                    val mainPagerState = rememberMainPagerState(pagerState)
                    LaunchedEffect(pagerState.currentPage) {
                        mainPagerState.syncPage()
                    }
                    BackHandler(enabled = mainPagerState.selectedPage != 0) {
                        mainPagerState.animateToPage(0)
                    }

                    val notificationState = remember { NotificationState() }
                    val scope = rememberCoroutineScope()
                    val context = LocalContext.current

                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        bottomBar = {
                            NavigationBar {
                                NavigationBarItem(
                                    selected = mainPagerState.selectedPage == 0,
                                    onClick = {
                                        mainPagerState.animateToPage(0)
                                    },
                                    icon = MiuixIcons.HorizontalSplit,
                                    label = "普通通知"
                                )
                                NavigationBarItem(
                                    selected = mainPagerState.selectedPage == 1,
                                    onClick = {
                                        mainPagerState.animateToPage(1)
                                    },
                                    icon = MiuixIcons.Create,
                                    label = "焦点通知"
                                )
                                NavigationBarItem(
                                    selected = mainPagerState.selectedPage == 2,
                                    onClick = {
                                        mainPagerState.animateToPage(2)
                                    },
                                    icon = MiuixIcons.Image,
                                    label = "超级岛"
                                )
                                NavigationBarItem(
                                    selected = mainPagerState.selectedPage == 3,
                                    onClick = {
                                        mainPagerState.animateToPage(3)
                                    },
                                    icon = MiuixIcons.Settings,
                                    label = "其他"
                                )
                            }
                        },
                        floatingActionButton = {
                            FloatingActionButton(
                                onClick = {
                                    NotificationUtils.sendBaseInfoNotification(context, notificationState)
                                }
                            ) {
                                Icon(
                                    imageVector = MiuixIcons.Send,
                                    contentDescription = "发送",
                                    tint = Color.White
                                )
                            }
                        },
                        floatingActionButtonPosition = FabPosition.End
                    ) { outerPadding ->
                        HorizontalPager(
                            state = pagerState,
                            modifier = Modifier.fillMaxSize(),
                            userScrollEnabled = true,
                            beyondViewportPageCount = 1,
                            verticalAlignment = Alignment.Top,
                            pageContent = { page ->
                                when (page) {
                                    0 -> PagerNormalNotification(
                                        state = notificationState,
                                        outerPadding = outerPadding
                                    )
                                    1 -> PagerV2Params(
                                        state = notificationState,
                                        outerPadding = outerPadding
                                    )
                                    2 -> PagerV3Params(
                                        state = notificationState,
                                        outerPadding = outerPadding
                                    )
                                    else -> PagerBehaviorAod(
                                        state = notificationState,
                                        outerPadding = outerPadding
                                    )
                                }
                            }
                        )
                    }
                }
            }
        }
        val entries = rememberDecoratedNavEntries(
            backStack = backStack, 
            entryDecorators = listOf(rememberSaveableStateHolderNavEntryDecorator()),
            entryProvider = entryProvider
        )
        
        NavDisplay(
            entries = entries,
            onBack = { navigator.pop() }
        )
    }
}
