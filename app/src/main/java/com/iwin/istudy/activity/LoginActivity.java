package com.iwin.istudy.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.iwin.istudy.MyApplication;
import com.iwin.istudy.R;
import com.iwin.istudy.view.InputView;

public class LoginActivity extends AppCompatActivity {

    private InputView mInputPhone, mInputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView(){
        mInputPhone = findViewById(R.id.input_phone);
        mInputPassword = findViewById(R.id.input_password);
    }

    public void onRegisterClick(View view){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);

    }


    @SuppressLint("ShowToast")
    public void onLoginClick(View view){

        String phone = mInputPhone.getInputStr();
        String password = mInputPassword.getInputStr();

        if (TextUtils.isEmpty(phone)){
            Toast.makeText(MyApplication.getAppContext(),"请输入手机号",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(MyApplication.getAppContext(),"请输入密码",Toast.LENGTH_SHORT).show();
            return;
        }

        Log.i("onLoginClick","密码正确吗"+login(phone,password));
        if (login(phone,password)){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(MyApplication.getAppContext(),"密码错误",Toast.LENGTH_SHORT).show();
        }


    }

    public static boolean login(String phone,String password) {
        SharedPreferences sp = MyApplication.getAppContext().getSharedPreferences("database", Context.MODE_PRIVATE);
        String passwordData = sp.getString(phone, "");
        return password.equals(passwordData);
    }
}