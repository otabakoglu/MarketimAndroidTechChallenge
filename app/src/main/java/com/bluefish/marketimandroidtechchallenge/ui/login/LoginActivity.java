package com.bluefish.marketimandroidtechchallenge.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.bluefish.marketimandroidtechchallenge.R;
import com.bluefish.marketimandroidtechchallenge.databinding.ActivityLoginBinding;
import com.bluefish.marketimandroidtechchallenge.ui.main.MainActivity;

public class LoginActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginViewModel mViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

         ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
         binding.setViewModel(mViewModel);

         //remember me switch
        if(isLogin()) openMainActivity();

        mViewModel.isValid.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if(s.equals("success")){
                    openMainActivity();
                }else{
                    Toast.makeText(LoginActivity.this, "Kullanıcı Adı / Şifre Hatalı veya Boş..", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mViewModel.rememberMe.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                SharedPreferences sp =  getSharedPreferences("data", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();

                editor.putBoolean("rememberMe", aBoolean);
                editor.apply();

            }
        });


    }

    void openMainActivity(){
        Intent i = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(i);
    }

    public boolean isLogin(){
        SharedPreferences sp =  getSharedPreferences("data", Context.MODE_PRIVATE);
        return sp.getBoolean("rememberMe",false);
    }
}
