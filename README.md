# Hyper Notification
[![GitHub license](https://img.shields.io/github/license/xzakota/HyperNotification?color=blue)](https://github.com/xzakota/HyperNotification/blob/main/LICENSE)
[![GitHub release](https://img.shields.io/github/v/release/xzakota/HyperNotification?display_name=release&logo=github&color=green)](https://github.com/xzakota/HyperNotification/releases)


## 焦点通知 API
> 将关键通知以特殊样式展示

注：澎湃 OS 对于焦点通知有白名单应用限制，使用前请先安装无视白名单的 XP 模块。

### 依赖
```kotlin
dependencies {
    implementation("com.xzakota.hyper.notification:focus-api:${version}")
}
```

### 使用
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
    notificationID,
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
    notificationID,
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

更多使用可参考 [example](https://github.com/xzakota/HyperNotification/tree/main/example/src/main/kotlin/com/xzakota/hyper/notification/focus/example/ui/MainActivity.kt#L63) 模块或浏览源代码

### TODO
- Custom Focus

## 灵动舞台 API
咕咕咕
