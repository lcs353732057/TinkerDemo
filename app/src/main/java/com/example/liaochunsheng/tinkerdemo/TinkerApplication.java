package com.example.liaochunsheng.tinkerdemo;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;

import com.tencent.tinker.anno.DefaultLifeCycle;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.app.DefaultApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * Created by zhoumanqing on 2017/5/17.
 */

@DefaultLifeCycle(
        application = "com.example.liaochunsheng.tinkerdemo.app.MyApplication",
        flags = ShareConstants.TINKER_ENABLE_ALL
)

public class TinkerApplication extends DefaultApplicationLike {

    public TinkerApplication(Application application, int tinkerFlags,
                             boolean tinkerLoadVerifyFlag, long applicationStartElapsedTime,
                             long applicationStartMillisTime, Intent tinkerResultIntent,
                             Resources[] resources, ClassLoader[] classLoader, AssetManager[] assetManager) {
        super(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime,
                applicationStartMillisTime, tinkerResultIntent, resources, classLoader, assetManager);
    }

    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);
        TinkerInstaller.install(this);
    }
}
