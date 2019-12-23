package com.spksolutions.appointmentmaster.mui.logout;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.spksolutions.appointmentmaster.util.GifImageView;

public class LogoutViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private GifImageView gifImageView;

    public LogoutViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is logout fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}