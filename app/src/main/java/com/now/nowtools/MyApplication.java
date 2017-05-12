package com.now.nowtools;

import android.app.Application;

import com.umeng.analytics.MobclickAgent;


/**
 * 作者：now on 2017/4/28 09:32
 * 邮箱：3198751771@qq.com
 */
public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        MobclickAgent.setDebugMode(true);
        // SDK在统计Fragment时，需要关闭Activity自带的页面统计，
        // 然后在每个页面中重新集成页面统计的代码(包括调用了 onResume 和 onPause 的Activity)。
        MobclickAgent.openActivityDurationTrack(false);
        // MobclickAgent.setAutoLocation(true);
        // MobclickAgent.setSessionContinueMillis(1000);
        // MobclickAgent.startWithConfigure(
        // new UMAnalyticsConfig(mContext, "4f83c5d852701564c0000011", "Umeng",
        // EScenarioType.E_UM_NORMAL));

    }
}
