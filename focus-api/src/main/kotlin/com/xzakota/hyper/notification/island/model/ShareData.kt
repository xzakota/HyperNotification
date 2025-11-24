package com.xzakota.hyper.notification.island.model

import kotlinx.serialization.Serializable

@Suppress("unused")
@Serializable
class ShareData {
    /**
     * 拖拽时卡片上的标题文案
     */
    var title : String? = null

    /**
     * 拖拽时卡片上的正文文案
     */
    var content : String? = null

    /**
     * 拖拽时卡片上的展示图片
     */
    var pic : String? = null

    /**
     * 分享内容
     */
    var shareContent : String? = null

    /**
     * 分享图片
     */
    var sharePic : String? = null
}
