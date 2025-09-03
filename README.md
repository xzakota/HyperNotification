# Hyper Notification
[![GitHub License](https://img.shields.io/github/license/xzakota/HyperNotification?color=blue)](https://github.com/xzakota/HyperNotification/blob/main/LICENSE)
[![Maven Central](https://img.shields.io/maven-central/v/com.xzakota.hyper.notification/focus-api?color=green)](https://search.maven.org/search?q=g:com.xzakota.hyper.notification)


## 焦点通知 API(V2) / 超级岛 API(V3)
> 将关键通知以特殊样式展示

注：澎湃 OS 对于焦点通知有白名单应用限制，使用前请先安装无视白名单的 XP 模块。

### 依赖
```kotlin
dependencies {
    implementation("com.xzakota.hyper.notification:focus-api:${version}")
}
```

### 焦点通知使用
在 `Java` 项目中
```java
Bundle extras = FocusNotification.buildV2(template -> {
    template.setTicker("Ticker");
    template.setEnableFloat(true);

    template.baseInfo(info -> {
        info.setType(1);
        info.setTitle("Title1");
        info.setContent("Content1");
    });

    template.hintInfo(info -> {
        info.setType(1);
        info.setTitle("Title2");
        info.setContent("Content2");
    });
});

notificationManager.notify(
    notificationId,
    new Notification.Builder(context, channelId)
        .setSmallIcon(icon)
        .setTicker("Ticker")
        .setContentTitle("Title0")
        .setContentText("Content0")
        // 合并数据
        .addExtras(extras)
        .build()
)
```

在 `Kotlin` 项目中
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
        // 合并数据
        .addExtras(extras)
        .build()
)
```

更多使用可参考 [example](https://github.com/xzakota/HyperNotification/tree/main/example/src/main/kotlin/com/xzakota/hyper/notification/focus/example/ui/MainActivity.kt#L72) 模块或浏览源代码

## 灵动舞台 API
咕咕咕
