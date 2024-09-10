# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable
-renamesourcefileattribute SourceFile
-keep public class * extends java.lang.Exception  # Optional: Keep custom exceptions.

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
-keep class androidx.lifecycle.** {*;}
-dontwarn org.jetbrains.annotations.**
-keep class kotlin.Metadata { *; }
-keepclassmembers class kotlin.Metadata {
    public <methods>;
}


-keep class kotlin.jvm.internal.**CompanionObject {
    public static *** INSTANCE;
}

# Remove log
-assumenosideeffects class android.util.Log {
public static boolean isLoggable(java.lang.String, int);
public static int d(...);
public static int w(...);
public static int v(...);
public static int i(...);
public static int e(...);
}

-assumenosideeffects class timber.log.Timber* {
public static *** d(...);
public static *** w(...);
public static *** v(...);
public static *** i(...);
public static *** e(...);
}

-keepclassmembers class * extends java.lang.Enum {
    <fields>;
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keep class com.google.android.gms.ads.** { *; }
-dontwarn okio.**


-dontwarn com.google.android.gms.safetynet.SafetyNetApi$AttestationResponse
-dontwarn com.google.android.gms.maps.GoogleMap$SnapshotReadyCallback
-dontwarn com.google.android.gms.maps.GoogleMap
-dontwarn com.google.android.gms.maps.MapFragment
-dontwarn com.google.android.gms.maps.MapView
-dontwarn com.google.android.gms.maps.OnMapReadyCallback
-dontwarn com.google.android.gms.maps.SupportMapFragment
-dontwarn io.flutter.embedding.android.FlutterSurfaceView
-dontwarn io.flutter.embedding.engine.FlutterJNI
-dontwarn io.flutter.embedding.engine.renderer.FlutterRenderer
-dontwarn io.flutter.view.FlutterNativeView
-dontwarn io.flutter.view.FlutterView
-dontwarn org.bouncycastle.jsse.BCSSLParameters
-dontwarn org.bouncycastle.jsse.BCSSLSocket
-dontwarn org.bouncycastle.jsse.provider.BouncyCastleJsseProvider
-dontwarn org.conscrypt.Conscrypt$Version
-dontwarn org.conscrypt.Conscrypt
-dontwarn org.conscrypt.ConscryptHostnameVerifier
-dontwarn org.joda.convert.FromString
-dontwarn org.joda.convert.ToString
-dontwarn org.openjsse.javax.net.ssl.SSLParameters
-dontwarn org.openjsse.javax.net.ssl.SSLSocket
-dontwarn org.openjsse.net.ssl.OpenJSSE
-dontwarn org.slf4j.impl.StaticLoggerBinder