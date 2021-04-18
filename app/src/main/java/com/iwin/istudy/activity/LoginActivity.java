package com.iwin.istudy.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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

//        if (!UserUtils.validateLogin(this,phone,password)){
//            return;
//        }

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}