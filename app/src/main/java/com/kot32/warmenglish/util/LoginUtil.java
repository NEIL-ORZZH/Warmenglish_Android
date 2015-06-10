package com.kot32.warmenglish.util;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.kot32.warmenglish.WarmApplication;
import com.kot32.warmenglish.global.Const;
import com.kot32.warmenglish.model.pojo.Student;
import com.tencent.android.tpush.XGPushManager;

import java.util.HashMap;

/**
 * Created by kot32 on 15/6/10.
 */
public class LoginUtil implements finishLogin {

    private Student student;
    private Context context;
    private String username;
    private String password;
    private int LOGIN_TYPE;
    private LoginTask task;

    public static final int AUTO_LOGIN = 0;
    public static final int CLICK_LOGIN = 1;

    private Handler loginHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    Toast.makeText(context, "登录失败！请检查用户名或密码！", Toast.LENGTH_SHORT).show();

                    break;
                case 1:
                    Toast.makeText(context, "登录失败！网络连接失败", Toast.LENGTH_SHORT).show();

                    break;

            }
        }
    };

    public LoginUtil(Context context, int login_type) {
        this.context = context;
        LOGIN_TYPE = login_type;
    }

    public void login() {
        //本地初始化用户资料
        initStudentInfoLocal();
        task = new LoginTask();
        //开始尝试登陆在线获取用户资料
        task.execute();

    }

    @Override
    public void finish() {

    }

    class LoginTask extends AsyncTask<Void, Void, HttpObjectWithStatus> {

        @Override
        protected HttpObjectWithStatus doInBackground(Void... params) {
            HashMap p = new HashMap();
            if (student != null) {
                p.put("username", student.getUsername());
                p.put("password", student.getPassword());
            } else {
                //如果是自动登录，本地学号密码为空，直接返回空
                if (LOGIN_TYPE == AUTO_LOGIN) {
                    return null;
                } else if (LOGIN_TYPE == CLICK_LOGIN) {
                    //如果是手动登陆，读取输入的用户名和密码
                    p.put("username", username);
                    p.put("password", password);
                }

            }
            p.put("format", "json");
            HttpObjectWithStatus result = (HttpObjectWithStatus) HttpTool.doRequestAndReturnObject(context,
                    HttpObjectWithStatus.class, Const.LOGIN, p, HttpTool.GET);

            return result;
        }

        @Override
        protected void onPostExecute(final HttpObjectWithStatus httpObjectWithStatus) {
            super.onPostExecute(httpObjectWithStatus);
            if (null != httpObjectWithStatus) {
                if (httpObjectWithStatus.getStatus().equals("success")) {
                    if (httpObjectWithStatus.getStudent() != null) {
                        student = (httpObjectWithStatus.getStudent());
                        finish();
                    } else {
                        loginHandler.sendEmptyMessage(0);
                    }
                    //存储用户信息
                    storeStudentInfo();
                } else {
                    loginHandler.sendEmptyMessage(0);
                }
            } else {
                loginHandler.sendEmptyMessage(1);
            }


        }
    }

    void initStudentInfoLocal() {
        //尚未第一次登录时为空，第一次登陆后读取本地值
        student = (Student) ACache.get(context.getApplicationContext()).getAsObject("user");
    }

    void storeStudentInfo() {
        if (student != null) {
            //缓存
            ACache cache = ACache.get(context.getApplicationContext());
            cache.put("user", student, 360 * ACache.TIME_DAY);
            ((WarmApplication) context.getApplicationContext()).setStudent(student);
            if (student.getGroup() != null) {
                //设定标签
                XGPushManager.setTag(context.getApplicationContext(), student.getGroup().getClazz().getUuid());
            }
        }
    }

    class HttpObjectWithStatus {
        private String status;
        private Student student;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Student getStudent() {
            return student;
        }

        public void setStudent(Student student) {
            this.student = student;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void cancel() {
        task.cancel(true);
    }





}

interface finishLogin {
    void finish();
}
