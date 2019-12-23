package com.spksolutions.appointmentmaster.mui.sp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SignInViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SignInViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is SP sign In fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}