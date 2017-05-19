# TinkerDemo
gradle接入

gradle是推荐的接入方式，在gradle插件tinker-patch-gradle-plugin中我们帮你完成proguard、multiDex以及Manifest处理等工作。

添加gradle依赖

在项目的build.gradle中，添加tinker-patch-gradle-plugin的依赖

buildscript {
    dependencies {
        classpath ('com.tencent.tinker:tinker-patch-gradle-plugin:1.7.9')
    }
}

然后在app的gradle文件app/build.gradle，我们需要添加tinker的库依赖以及apply tinker的gradle插件.

dependencies {
	//可选，用于生成application类 
	provided('com.tencent.tinker:tinker-android-anno:1.7.9')
    //tinker的核心库
    compile('com.tencent.tinker:tinker-android-lib:1.7.9') 
}
...
...
//apply tinker插件
apply plugin: 'com.tencent.tinker.patch'
