package com.xzakota.hyper.notification.focus.example.ui.miuix

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateListOf

class NotificationState {
    // ==========================================
    // 0. 折叠展开与全局控制状态
    // ==========================================
    
    // 0.1 控制子模块折叠/展开的状态 (针对 V2) - 核心图文组件互斥防错
    private var _showBaseInfo = mutableStateOf(true)
    var showBaseInfo: Boolean
        get() = _showBaseInfo.value
        set(value) {
            _showBaseInfo.value = value
            if (value) {
                _showChatInfo.value = false
                _showHighlightInfo.value = false
                _showIconTextInfo.value = false
                _showCoverInfo.value = false
            }
        }

    private var _showChatInfo = mutableStateOf(false)
    var showChatInfo: Boolean
        get() = _showChatInfo.value
        set(value) {
            _showChatInfo.value = value
            if (value) {
                _showBaseInfo.value = false
                _showHighlightInfo.value = false
                _showIconTextInfo.value = false
                _showCoverInfo.value = false
            }
        }

    private var _showHighlightInfo = mutableStateOf(false)
    var showHighlightInfo: Boolean
        get() = _showHighlightInfo.value
        set(value) {
            _showHighlightInfo.value = value
            if (value) {
                _showBaseInfo.value = false
                _showChatInfo.value = false
                _showIconTextInfo.value = false
                _showCoverInfo.value = false
            }
        }

    private var _showIconTextInfo = mutableStateOf(false)
    var showIconTextInfo: Boolean
        get() = _showIconTextInfo.value
        set(value) {
            _showIconTextInfo.value = value
            if (value) {
                _showBaseInfo.value = false
                _showChatInfo.value = false
                _showHighlightInfo.value = false
                _showCoverInfo.value = false
            }
        }

    private var _showCoverInfo = mutableStateOf(false)
    var showCoverInfo: Boolean
        get() = _showCoverInfo.value
        set(value) {
            _showCoverInfo.value = value
            if (value) {
                _showBaseInfo.value = false
                _showChatInfo.value = false
                _showHighlightInfo.value = false
                _showIconTextInfo.value = false
            }
        }

    // 0.1.2 其他辅助及增强功能组件开关
    var showProgressInfo by mutableStateOf(false)
    var showMultiProgressInfo by mutableStateOf(false)
    var showActionInfo by mutableStateOf(false)
    var showTimerInfo by mutableStateOf(false)
    var showPicInfo by mutableStateOf(false)
    var showBgInfo by mutableStateOf(false)
    var showHintInfo by mutableStateOf(false)
    var showHighlightInfoV3 by mutableStateOf(false)

    // 0.3 普通通知独立参数 (解耦焦点通知内容)
    var normalTitle by mutableStateOf("普通通知标题")
    var normalContent by mutableStateOf("这里是普通安卓通知的内容，可以与焦点通知的文本不一致。")

    // 0.2 控制子模块折叠/展开的状态 (针对 V3)
    var enableIsland by mutableStateOf(true)
    var showExtraV3Param by mutableStateOf(true)
    var showIslandTemplate by mutableStateOf(true)
    var showIslandLeftInfo by mutableStateOf(true)
    var showIslandRightInfo by mutableStateOf(false)
    var showShareData by mutableStateOf(false)

    // ==========================================
    // 状态定义 - 全面对齐标准/超级岛 API
    // ==========================================
    
    // 1. 公共参数 (BaseFocusTemplate)
    var tickerText by mutableStateOf("外卖配送中")
    var tickerPicText by mutableStateOf("")
    var tickerPicDark by mutableStateOf("")
    var showSmallIconVal by mutableStateOf(true)
    var timeoutText by mutableStateOf("720")
    var updatableVal by mutableStateOf(false)
    var enableFloatVal by mutableStateOf(false)
    var aodPicText by mutableStateOf("")
    var aodTitleText by mutableStateOf("美团外卖")
    var reopenText by mutableStateOf("close")
    var filterWhenNoPermissionVal by mutableStateOf(false)

    // 2. 文本组件 (baseInfo)
    var baseTypeVal by mutableStateOf(true) // False = 1, True = 2
    var baseTitle by mutableStateOf("骑手已接单")
    var baseColorTitle by mutableStateOf("")
    var baseColorTitleDark by mutableStateOf("")
    var baseSubTitle by mutableStateOf("正在全力送达中")
    var baseColorSubTitle by mutableStateOf("")
    var baseColorSubTitleDark by mutableStateOf("")
    var baseContent by mutableStateOf("预计 12:45 送达")
    var baseColorContent by mutableStateOf("")
    var baseColorContentDark by mutableStateOf("")
    var baseSubContent by mutableStateOf("小计: 35.5元")
    var baseColorSubContent by mutableStateOf("")
    var baseColorSubContentDark by mutableStateOf("")
    var baseExtraTitle by mutableStateOf("准时宝已生效")
    var baseColorExtraTitle by mutableStateOf("")
    var baseColorExtraTitleDark by mutableStateOf("")
    var baseSpecialTitle by mutableStateOf("新订单")
    var baseColorSpecialTitle by mutableStateOf("")
    var baseColorSpecialTitleDark by mutableStateOf("")
    var baseColorSpecialBg by mutableStateOf("")
    var basePicFunction by mutableStateOf("")
    var baseShowDividerVal by mutableStateOf(false)
    var baseShowContentDividerVal by mutableStateOf(false)
    var baseSetMarginTopVal by mutableStateOf(false)
    var baseSetMarginBottomVal by mutableStateOf(false)

    // 3. 按钮提示组件 (hintInfo)
    var hintType by mutableStateOf("1")
    var hintTitle by mutableStateOf("联系骑手")
    var hintColorTitle by mutableStateOf("")
    var hintColorTitleDark by mutableStateOf("")
    var hintSubTitle by mutableStateOf("")
    var hintColorSubTitle by mutableStateOf("")
    var hintColorSubTitleDark by mutableStateOf("")
    var hintExtraTitle by mutableStateOf("")
    var hintColorExtraTitle by mutableStateOf("")
    var hintColorExtraTitleDark by mutableStateOf("")
    var hintSpecialTitle by mutableStateOf("")
    var hintColorSpecialTitle by mutableStateOf("")
    var hintColorSpecialTitleDark by mutableStateOf("")
    var hintColorSpecialBg by mutableStateOf("")
    var hintContent by mutableStateOf("打个电话问问吧")
    var hintColorContent by mutableStateOf("")
    var hintColorContentDark by mutableStateOf("")
    var hintSubContent by mutableStateOf("")
    var hintColorSubContent by mutableStateOf("")
    var hintColorSubContentDark by mutableStateOf("")
    var hintTitleLineCount by mutableStateOf("1")
    var hintColorContentBg by mutableStateOf("")
    var hintPicContent by mutableStateOf("")

    // 4. 图文组件 (chatInfo)
    var chatTitle by mutableStateOf("小米客服")
    var chatColorTitle by mutableStateOf("")
    var chatColorTitleDark by mutableStateOf("")
    var chatSubTitle by mutableStateOf("")
    var chatColorSubTitle by mutableStateOf("")
    var chatColorSubTitleDark by mutableStateOf("")
    var chatExtraTitle by mutableStateOf("")
    var chatColorExtraTitle by mutableStateOf("")
    var chatColorExtraTitleDark by mutableStateOf("")
    var chatSpecialTitle by mutableStateOf("")
    var chatColorSpecialTitle by mutableStateOf("")
    var chatColorSpecialTitleDark by mutableStateOf("")
    var chatColorSpecialBg by mutableStateOf("")
    var chatContent by mutableStateOf("您有一条新的未读消息，请点击查看。")
    var chatColorContent by mutableStateOf("")
    var chatColorContentDark by mutableStateOf("")
    var chatSubContent by mutableStateOf("")
    var chatColorSubContent by mutableStateOf("")
    var chatColorSubContentDark by mutableStateOf("")
    var chatPicProfile by mutableStateOf("https://avatars.githubusercontent.com/u/1373333?v=4")
    var chatPicProfileDark by mutableStateOf("")
    var chatAppIconPkg by mutableStateOf("")

    // 5. 强调图文组件 (highlightInfo)
    var highlightTypeVal by mutableStateOf(0)
    var highlightTitle by mutableStateOf("")
    var highlightColorTitle by mutableStateOf("")
    var highlightColorTitleDark by mutableStateOf("")
    var highlightSubTitle by mutableStateOf("")
    var highlightColorSubTitle by mutableStateOf("")
    var highlightColorSubTitleDark by mutableStateOf("")
    var highlightExtraTitle by mutableStateOf("")
    var highlightColorExtraTitle by mutableStateOf("")
    var highlightColorExtraTitleDark by mutableStateOf("")
    var highlightSpecialTitle by mutableStateOf("")
    var highlightColorSpecialTitle by mutableStateOf("")
    var highlightColorSpecialTitleDark by mutableStateOf("")
    var highlightColorSpecialBg by mutableStateOf("")
    var highlightContent by mutableStateOf("")
    var highlightColorContent by mutableStateOf("")
    var highlightColorContentDark by mutableStateOf("")
    var highlightSubContent by mutableStateOf("")
    var highlightColorSubContent by mutableStateOf("")
    var highlightColorSubContentDark by mutableStateOf("")
    var highlightPicFunction by mutableStateOf("")
    var highlightPicFunctionDark by mutableStateOf("")

    // 6. 进度组件 (progressInfo)
    var progressText by mutableStateOf("0")
    var colorProgress by mutableStateOf("FF8514")
    var colorProgressEnd by mutableStateOf("")
    var picForward by mutableStateOf("")
    var picMiddle by mutableStateOf("")
    var picMiddleUnselected by mutableStateOf("")
    var picEnd by mutableStateOf("")
    var picEndUnselected by mutableStateOf("")

    // 6.1 多段/节点进度组件 (multiProgressInfo)
    var multiProgressTitle by mutableStateOf("配送中")
    var multiProgressVal by mutableStateOf("50")
    var multiProgressPoints by mutableStateOf("3")
    var multiProgressColor by mutableStateOf("")

    // 7. 动作组件 (actionInfo)
    var actionWayIndex by mutableStateOf(0) // 0 = 方式一 (系统 Action), 1 = 方式二 (自定义 Action)
    var actionType by mutableStateOf("0")
    var action by mutableStateOf("")
    var actionIntent by mutableStateOf("")
    var actionIntentType by mutableStateOf("1")
    var actionIcon by mutableStateOf("")
    var actionIconDark by mutableStateOf("")
    var actionTitle by mutableStateOf("")
    var actionTitleColor by mutableStateOf("")
    var actionTitleColorDark by mutableStateOf("")
    var actionBgColor by mutableStateOf("")
    var actionBgColorDark by mutableStateOf("")
    var actionClickWithCollapse by mutableStateOf(false)

    // 8. 计时器组件 (timerInfo)
    var timerType by mutableStateOf("0")
    var timerWhen by mutableStateOf("0")
    var timerTotal by mutableStateOf("0")
    var timerSystemCurrent by mutableStateOf("0")

    // 9. 识别图形组件 (picInfo)
    var picType by mutableStateOf("1")
    var pic by mutableStateOf("")
    var picDark by mutableStateOf("")
    var picTitle by mutableStateOf("")
    var picColorTitle by mutableStateOf("")

    // 9.1 按钮组组件 (actions)
    var showActions by mutableStateOf(false)
    val actionsList = mutableStateListOf<ActionState>().apply {
        add(ActionState())
    }

    // 10. 背景组件 (bgInfo)
    var bgType by mutableStateOf("1")
    var colorBg by mutableStateOf("")
    var picBg by mutableStateOf("")

    // 11. V3 专属系统配置 (IExtraV3Param)
    var cancelVal by mutableStateOf(false)
    var hideDecoVal by mutableStateOf(false)
    var isShowNotificationVal by mutableStateOf(true)
    var islandFirstFloatVal by mutableStateOf(true)
    var outEffectColor by mutableStateOf("")
    var outEffectSrc by mutableStateOf("")
    var sequenceText by mutableStateOf("1")
    var businessText by mutableStateOf("")
    var notifyIdText by mutableStateOf("")
    var orderIdText by mutableStateOf("")

    // 12. 超级岛专属配置 (IslandTemplate)
    var islandPropertyVal by mutableStateOf(false) // False = 1, True = 2
    var islandTimeoutText by mutableStateOf("3600")
    var dismissIslandVal by mutableStateOf(false)
    var islandOrderVal by mutableStateOf(false)
    var islandHighlightColor by mutableStateOf("")

    // 13. 大岛左侧图文 (imageTextInfoLeft)
    var islandLeftSelection by mutableStateOf("imageTextInfoLeft")
    var islandLeftPic by mutableStateOf("ics_delivery")
    var islandLeftTypeVal by mutableStateOf(false) // False = 1, True = 2
    var islandLeftTitle by mutableStateOf("配送中")
    var islandLeftFrontTitle by mutableStateOf("")
    var islandLeftContent by mutableStateOf("已出发")
    var islandLeftShowHighlightVal by mutableStateOf(false)
    var islandLeftNarrowFontVal by mutableStateOf(false)
    var islandLeftIsTitleDigitVal by mutableStateOf(false)
    var islandLeftTurnAnimVal by mutableStateOf(false)

    // 14. 大岛右侧图文 (imageTextInfoRight)
    var islandRightSelection by mutableStateOf(if (showIslandRightInfo) "imageTextInfoRight" else "无")
    var islandRightPic by mutableStateOf("ics_delivery")
    var islandRightTypeVal by mutableStateOf(true) // True = 2, False = 1
    var islandRightTitle by mutableStateOf("美团")
    var islandRightFrontTitle by mutableStateOf("")
    var islandRightContent by mutableStateOf("专送")
    var islandRightShowHighlightVal by mutableStateOf(false)
    var islandRightNarrowFontVal by mutableStateOf(false)
    var islandRightIsTitleDigitVal by mutableStateOf(false)
    var islandRightTurnAnimVal by mutableStateOf(false)

    // 新增右侧扩展组件状态
    var islandRightDigit by mutableStateOf("5")
    var islandRightProgress by mutableStateOf("0")
    var islandRightColorReach by mutableStateOf("#FF0000")
    var islandRightColorUnReach by mutableStateOf("#CCCCCC")
    var islandRightIsCCW by mutableStateOf(false)

    // 新增小岛组件状态
    var islandSmallSelection by mutableStateOf("无")
    var showIslandSmallInfo by mutableStateOf(false)
    var islandSmallPic by mutableStateOf("ics_delivery")
    var islandSmallProgress by mutableStateOf("0")
    var islandSmallColorReach by mutableStateOf("#FF0000")
    var islandSmallColorUnReach by mutableStateOf("#CCCCCC")
    var islandSmallIsCCW by mutableStateOf(false)

    // 15. 拖拽分享参数 (shareData)
    var shareTitle by mutableStateOf("外卖卡片")
    var shareContent by mutableStateOf("点击拖拽分享给好友")
    var sharePic by mutableStateOf("")
    var shareContentText by mutableStateOf("美团外卖: 骑手已接单, 预计12:45送达")
    var sharePicUrl by mutableStateOf("")

    // 16. 图标文本组件 (iconTextInfo)
    var iconTextType by mutableStateOf("0")
    var iconTextSrc by mutableStateOf("ics_delivery")
    var iconTextSrcDark by mutableStateOf("")
    var iconTextTitle by mutableStateOf("订单已接单")
    var iconTextContent by mutableStateOf("骑手正在赶往商家")
    var iconTextSubContent by mutableStateOf("")
    var iconTextColorTitle by mutableStateOf("")
    var iconTextColorTitleDark by mutableStateOf("")
    var iconTextColorContent by mutableStateOf("")
    var iconTextColorContentDark by mutableStateOf("")

    // 17. 封面图文组件 (coverInfo)
    var coverPicCover by mutableStateOf("ics_music_cover")
    var coverTitle by mutableStateOf("播放已开始")
    var coverContent by mutableStateOf("这世界那么多人")
    var coverSubContent by mutableStateOf("莫文蔚")
    var coverColorTitle by mutableStateOf("")
    var coverColorTitleDark by mutableStateOf("")
    var coverColorContent by mutableStateOf("")
    var coverColorContentDark by mutableStateOf("")
    var coverColorSubContent by mutableStateOf("")
    var coverColorSubContentDark by mutableStateOf("")

    // 18. 高亮文本组件 V3 (highlightInfoV3)
    var highlightV3PrimaryText by mutableStateOf("10.5")
    var highlightV3SecondaryText by mutableStateOf("公里")
    var highlightV3ShowSecondaryLine by mutableStateOf(false)
    var highlightV3HighLightText by mutableStateOf("剩18分钟")
    var highlightV3PrimaryColor by mutableStateOf("")
    var highlightV3SecondaryColor by mutableStateOf("")
    var highlightV3HighLightTextColor by mutableStateOf("")
    var highlightV3HighLightBgColor by mutableStateOf("")
    var highlightV3PrimaryColorDark by mutableStateOf("")
    var highlightV3SecondaryColorDark by mutableStateOf("")
    var highlightV3HighLightTextColorDark by mutableStateOf("")
    var highlightV3HighLightBgColorDark by mutableStateOf("")
}

class ActionState {
    var type by mutableStateOf("0") // "0" (圆形), "1" (进度), "2" (文字)
    var clickWithCollapse by mutableStateOf(false)
    var actionWayIndex by mutableStateOf(0) // 0: 方式一, 1: 方式二
    var action by mutableStateOf("")
    
    // 方式二
    var actionIcon by mutableStateOf("")
    var actionIconDark by mutableStateOf("")
    var actionTitle by mutableStateOf("")
    var actionTitleColor by mutableStateOf("")
    var actionTitleColorDark by mutableStateOf("")
    var actionBgColor by mutableStateOf("")
    var actionBgColorDark by mutableStateOf("")
    var actionIntentType by mutableStateOf("1")
    var actionIntent by mutableStateOf("")

    // 进度按钮特有 progressInfo
    var progress by mutableStateOf("50")
    var colorProgress by mutableStateOf("")
    var isCCW by mutableStateOf(false)
    var isAutoProgress by mutableStateOf(false)
}
