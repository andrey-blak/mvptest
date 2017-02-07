# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /home/andrew/ANDROID/android-sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

-dontobfuscate

## Retrofit
# http://square.github.io/retrofit/
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions
-dontwarn okio.**

## Butterknife
# http://jakewharton.github.io/butterknife/
-keep class butterknife.** { *; }
-dontwarn butterknife.internal.**
-keep class **$$ViewBinder { *; }

-keepclasseswithmembernames class * {
    @butterknife.* <fields>;
}

-keepclasseswithmembernames class * {
    @butterknife.* <methods>;
}

## Retrolambda
-dontwarn java.lang.invoke.*

## RxAndroid
-dontwarn sun.misc.Unsafe
-keep class rx.schedulers.Schedulers {
    public static <methods>;
}

## Logback
-dontwarn ch.qos.logback.core.net.*

## Dto
-keep class blak.mvx.model.dto.** { *; }
