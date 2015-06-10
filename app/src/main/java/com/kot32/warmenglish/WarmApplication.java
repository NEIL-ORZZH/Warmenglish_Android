package com.kot32.warmenglish;

import android.app.Application;

import com.kot32.warmenglish.model.pojo.Student;
import com.squareup.leakcanary.LeakCanary;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;

/**
 * Created by kot32 on 15/5/29.
 */
public class WarmApplication extends Application {

    private Student student;

    @Override
    public void onCreate() {
        super.onCreate();
        //注册内存泄露检测
        LeakCanary.install(this);
        //初始化信鸽推送
        XGPushConfig.enableDebug(this, true);
        XGPushManager.registerPush(this);
    }



    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
