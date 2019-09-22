package com.bluefish.marketimandroidtechchallenge.ui.login;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bluefish.marketimandroidtechchallenge.data.Repository;

public class LoginViewModel extends ViewModel {

    public MutableLiveData<String> username = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();

    MutableLiveData<String> isValid = new MutableLiveData<>();

    public MutableLiveData<Boolean> rememberMe = new MutableLiveData<>();

    public void onTextChangedUsername(CharSequence s, int start, int before, int count) {
        username.setValue(s.toString());
    }

    public void onTextChangedPassword(CharSequence s, int start, int before, int count) {
        password.setValue(s.toString());
    }

    public void doLogin(){
        if(username.getValue() == null || password.getValue() == null) {
            isValid.setValue("fail");
        }else{
            isValid.setValue(Repository.getRepository().doLogin(username.getValue(), password.getValue()).getValue());
        }

    }

    public void rememberMeChanged(Boolean value){
        rememberMe.setValue(value);


    }




}
