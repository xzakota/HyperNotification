# Hyper Notification
[![GitHub License](https://img.shields.io/github/license/xzakota/HyperNotification?color=blue)](https://github.com/xzakota/HyperNotification/blob/main/LICENSE)
[![Maven Central](https://img.shields.io/maven-central/v/com.xzakota.hyper.notification/focus-api?color=green)](https://search.maven.org/search?q=g:com.xzakota.hyper.notification)

> 封装小米澎湃 OS (HyperOS) 焦点通知 (V2) 与超级岛 (V3) 的 Kotlin 类型安全构建库

注：澎湃 OS 对于焦点通知有白名单应用限制，测试/使用前请先安装无视白名单的 Xposed 模块。

[小米官方开发指南](https://dev.mi.com/xiaomihyperos/documentation/detail?pId=2131)

---

### 📦 依赖引入

在项目的 `build.gradle.kts` 中添加依赖：

```kotlin
dependencies {
    implementation("com.xzakota.hyper.notification:focus-api:${version}")
}
```

---

### 🚀 焦点通知 (V2) 与超级岛 (V3) 使用

#### 1. 焦点通知 V2 (Focus Notification V2)

```kotlin
val extras = FocusNotification.buildV2 {
    enableFloat = true
    ticker = "Ticker"

    baseInfo {
        type = 1
        title = "Title1"
        content = "Content1"
    }

    hintInfo {
        type = 1
        title = "Title2"
        content = "Content2"
    }
}

notificationManager.notify(
    notificationId,
    Notification.Builder(context, channelId)
        .setSmallIcon(icon)
        .setTicker("Ticker")
        .setContentTitle("Title0")
        .setContentText("Content0")
        .addExtras(extras)
        .build()
)
```

#### 2. 小米超级岛 V3 (Super Island V3)

```kotlin
val extras = FocusNotification.buildV3 {
    enableFloat = true
    islandFirstFloat = true
    ticker = "超级岛通知"

    baseInfo {
        type = 1
        title = "行程进行中"
        content = "预计 10 分钟到达"
    }

    island {
        islandProperty = 1
        bigIslandArea {
            imageTextInfoLeft {
                type = 1
                picInfo {
                    type = 1
                    pic = "key_logo"
                }
            }
            imageTextInfoRight {
                type = 2
                textInfo {
                    title = "预计 10 分钟到达"
                }
            }
        }
    }
}
```

---

### 🛠️ 工具类 `FocusUtils`

提供了查询当前 HyperOS 设备系统特性与权限的方法：

```kotlin
// 查询当前 OS 支持的焦点通知协议版本 (1: OS1, 2: OS2, 3: 超级岛 V3)
val protocolVersion = FocusUtils.getFocusProtocolVersion(context)

// 查询当前系统是否支持超级岛功能
val isIslandSupported = FocusUtils.isSupportIsland()

// 查询当前应用是否拥有焦点通知显示权限
val hasPermission = FocusUtils.hasFocusPermission(context)
```

---

### 💡 语言与兼容性说明 (Java / Kotlin)

* 本库采用 **Kotlin 优先 (Kotlin-First)** 架构设计，充分利用了 Kotlin DSL 与 `@FocusNotificationDsl` 类型安全作用域。
* 从该版本起，已废弃并移除了早期针对 Java `Consumer<T>` 回调的冗余重载方法，推荐在 Kotlin 项目中使用纯粹的 DSL 方式调用。

更多详细示例请参考 [example](https://github.com/xzakota/HyperNotification/tree/main/example/src/main/kotlin/com/xzakota/hyper/notification/focus/example/ui/MainActivity.kt) 模块。
