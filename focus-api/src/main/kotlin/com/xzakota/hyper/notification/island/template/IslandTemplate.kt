@file:Suppress("unused")

package com.xzakota.hyper.notification.island.template

import com.xzakota.hyper.notification.island.model.BigIslandArea
import com.xzakota.hyper.notification.island.model.ShareData
import com.xzakota.hyper.notification.island.model.SmallIslandArea
import kotlinx.serialization.Serializable
import java.util.function.Consumer

@Serializable
class IslandTemplate {
    var islandPriority : Int? = null

    /**
     * 岛属性
     * - `1` (默认值) 信息展示为主
     * - `2` 操作为主
     */
    var islandProperty : Int? = null

    var expandedTime : Int? = null

    /**
     * 岛自动消失的时间
     * - 单位: s
     * - 默认值: 60 * 60
     */
    var islandTimeout : Int? = null

    /**
     * 摘要态是否消失
     */
    var dismissIsland : Boolean? = null

    /**
     * 通知更新时, 但摘要态隐藏时, 是否更新岛排序
     * - 默认值: false
     */
    var islandOrder : Boolean? = null

    var maxSize : Boolean? = null

    var needCloseAnimation : Boolean? = null

    /**
     * 运营场景
     */
    var business : String? = null

    /**
     * 文字本强调色
     */
    var highlightColor : String? = null

    /**
     * 小岛内容
     */
    var smallIslandArea : SmallIslandArea? = null

    /**
     * 大岛内容
     */
    var bigIslandArea : BigIslandArea? = null

    /**
     * 拖拽分享属性参数
     */
    var shareData : ShareData? = null

    fun smallIslandArea(consumer : Consumer<SmallIslandArea>) = smallIslandArea {
        consumer.accept(this)
    }

    @JvmSynthetic
    fun smallIslandArea(block : SmallIslandArea.() -> Unit) {
        val info = smallIslandArea ?: SmallIslandArea().also { smallIslandArea = it }
        info.apply(block)
    }

    fun bigIslandArea(consumer : Consumer<BigIslandArea>) = bigIslandArea {
        consumer.accept(this)
    }

    @JvmSynthetic
    fun bigIslandArea(block : BigIslandArea.() -> Unit) {
        val info = bigIslandArea ?: BigIslandArea().also { bigIslandArea = it }
        info.apply(block)
    }

    fun shareData(consumer : Consumer<ShareData>) = shareData {
        consumer.accept(this)
    }

    @JvmSynthetic
    fun shareData(block : ShareData.() -> Unit) {
        val info = shareData ?: ShareData().also { shareData = it }
        info.apply(block)
    }
}

internal interface IIslandTemplateCreator {
    /**
     * 岛相关数据
     */
    var island : IslandTemplate?

    fun island(consumer : Consumer<IslandTemplate>) = island {
        consumer.accept(this)
    }

    @JvmSynthetic
    fun island(block : IslandTemplate.() -> Unit) {
        val info = island ?: IslandTemplate().also { island = it }
        info.apply(block)
    }
}
