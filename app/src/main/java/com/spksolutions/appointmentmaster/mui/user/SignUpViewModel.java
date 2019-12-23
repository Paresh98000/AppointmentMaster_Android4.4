package com.spksolutions.appointmentmaster.mui.user;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SignUpViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SignUpViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is User Sign Up fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}