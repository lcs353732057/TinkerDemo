# TinkerDemo
1、gradle接入

gradle是推荐的接入方式，在gradle插件tinker-patch-gradle-plugin中我们帮你完成proguard、multiDex以及Manifest处理等工作。

添加gradle依赖

在项目的build.gradle中，添加tinker-patch-gradle-plugin的依赖

`buildscript {
    dependencies {
        classpath ('com.tencent.tinker:tinker-patch-gradle-plugin:1.7.9')
    }
}`

然后在app的gradle文件app/build.gradle，我们需要添加tinker的库依赖以及apply tinker的gradle插件.

`dependencies {
	//可选，用于生成application类 
	provided('com.tencent.tinker:tinker-android-anno:1.7.9')
    //tinker的核心库
    compile('com.tencent.tinker:tinker-android-lib:1.7.9') 
}`
...
...

`//apply tinker插件
apply plugin: 'com.tencent.tinker.patch'`

2、生成一个签名文件app_release.apk，将其放到oldApk文件夹下

3、然后修改MainActivity代码，在onCreate中加入一行代码

`Toast.makeText(MainActivity.this,"Hot fix Scuess!!!!!",Toast.LENGTH_SHORT).show();
`

4、执行命令gradle tinkerPatchRelease，补丁包与相关日志会保存在/build/outputs/tinkerPatch/。然后我们将patch_signed_7zip.apk推送到手机的sdcard中。

`adb push ./app/build/outputs/tinkerPatch/debug/patch_signed_7zip.apk /storage/sdcard0/`

5、点击LOAD PATCH按钮, 如果看到patch success, please restart process的toast，退出程序，重新进入。

目前发现在第五个步骤有问题，执行不成功，正在找问题中。。。。