package com.kot32.warmenglish.view;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import com.kot32.warmenglish.R;
import com.kot32.warmenglish.global.Const;
import com.kot32.warmenglish.model.HttpStatus;
import com.kot32.warmenglish.util.HttpTool;
import com.kot32.warmenglish.util.LoginUtil;
import com.kot32.warmenglish.wight.MyLoadingDialog;

import java.util.HashMap;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class LoginPage extends Activity {

    @InjectView(R.id.username)
    EditText username;
    @InjectView(R.id.password)
    EditText password;

    private MyLoadingDialog loadingDialog = null;
    private LoginUtil loginUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login_page);
        ButterKnife.inject(this);
        loadingDialog = new MyLoadingDialog(this);
        loginUtil=new LoginUtil(LoginPage.this,LoginUtil.CLICK_LOGIN){
            @Override
            public void finish() {
                super.finish();
                loadingDialog.dismiss();
                LoginPage.this.finish();
            }
        };
    }

    @OnClick(R.id.login)
    public void login() {
        loadingDialog.show();
        loginUtil.setUsername(username.getText().toString());
        loginUtil.setPassword(password.getText().toString());
        loginUtil.login();
    }

    //点击注册按钮
    @OnClick(R.id.regist)
    public void regist() {
        new RegistTask().execute();
    }


    class RegistTask extends AsyncTask<Void, Void, HttpStatus> {

        @Override
        protected HttpStatus doInBackground(Void... params) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    loadingDialog.show();
                }

            });

            HashMap p = new HashMap();
            p.put("username", username.getText().toString());
            p.put("password", password.getText().toString());
            p.put("format", "json");
            HttpStatus result = (HttpStatus) HttpTool.doRequestAndReturnObject(LoginPage.this,
                    HttpStatus.class, Const.REGIST, p, HttpTool.GET);

            return result;
        }

        @Override
        protected void onPostExecute(HttpStatus httpStatus) {
            super.onPostExecute(httpStatus);
            if (null == httpStatus) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(LoginPage.this, "注册失败！连接服务器失败！", Toast.LENGTH_LONG).show();
                        loadingDialog.dismiss();
                    }

                });
                return;
            }
            if (httpStatus.getResult().equals("success")) {
                //注册成功
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(LoginPage.this, "注册成功！", Toast.LENGTH_LONG).show();
                        loadingDialog.dismiss();
                    }

                });

            } else {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(LoginPage.this, "注册失败！用户名已存在！", Toast.LENGTH_LONG).show();
                        loadingDialog.dismiss();
                    }

                });
            }

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginUtil.cancel();
    }
}
