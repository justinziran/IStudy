package com.iwin.istudy.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.iwin.istudy.MyApplication;
import com.iwin.istudy.R;
import com.iwin.istudy.view.InputView;

public class RegisterActivity extends AppCompatActivity {

    private InputView inputPhone;
    private InputView inputPassword;
    private InputView inputPassword2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inputPhone = findViewById(R.id.input_phone);
        inputPassword = findViewById(R.id.input_password);
        inputPassword2 = findViewById(R.id.input_password2);

    }


    public void onRegisterClick(View view){
        String phone = inputPhone.getInputStr();
        String password = inputPassword.getInputStr();
        String password2 = inputPassword2.getInputStr();

        if (TextUtils.isEmpty(phone)){
            Toast.makeText(MyApplication.getAppContext(),"请输入手机号",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(MyApplication.getAppContext(),"请输入密码",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password2)){
            Toast.makeText(MyApplication.getAppContext(),"请输确认密码",Toast.LENGTH_SHORT).show();
            return;
        }
        if (!password.equals(password2)){
            Toast.makeText(MyApplication.getAppContext(),"两次密码不一样",Toast.LENGTH_SHORT).show();
            return;
        }


        register(phone,password);

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();

    }

    public static void register(String phone,String password) {
        SharedPreferences sp = MyApplication.getAppContext().getSharedPreferences("database", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(phone,password);
        editor.apply();
    }
}