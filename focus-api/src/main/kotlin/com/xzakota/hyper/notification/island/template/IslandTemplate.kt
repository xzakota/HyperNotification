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
    var islandProperty : Int? = null
    var expandedTime : Int? = null
    var islandTimeout : Int? = null
    var dismissIsland : Boolean? = null
    var islandOrder : Boolean? = null
    var maxSize : Boolean? = null
    var needCloseAnimation : Boolean? = null
    var business : String? = null
    var highlightColor : String? = null
    var smallIslandArea : SmallIslandArea? = null
    var bigIslandArea : BigIslandArea? = null
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
