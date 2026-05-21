# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in C:\Users\30307\.gemini\antigravity\sdk/tools/proguard/proguard-android.txt
# You can edit the include path and value by changing the proguardFiles
# directive in build.gradle.kts.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any custom rules here to keep classes, methods or fields that should not be obfuscated.

# Keep Compose and Kotlin internals
-keepclassmembers class * {
    @androidx.compose.runtime.Composable *;
}

# Keep Kotlinx Serialization if used
-keepattributes *Annotation*,Signature,InnerClasses,EnclosingMethod

# Keep focus-api classes
-keep class com.xzakota.hyper.notification.focus.example.api.** { *; }
-keep class com.xzakota.hyper.notification.focus.example.core.** { *; }

# Keep AIDL interfaces and their generated stub/proxy classes
-keep class com.xzakota.hyper.notification.focus.example.IPrivilegedService { *; }
-keep class com.xzakota.hyper.notification.focus.example.IPrivilegedService$** { *; }
-keep class com.xzakota.hyper.notification.focus.example.IPrivilegedLogCallback { *; }
-keep class com.xzakota.hyper.notification.focus.example.IPrivilegedLogCallback$** { *; }

# Keep Shizuku SDK classes and methods used via reflection/IPC
-keep class rikka.shizuku.** { *; }
-keep interface rikka.shizuku.** { *; }
