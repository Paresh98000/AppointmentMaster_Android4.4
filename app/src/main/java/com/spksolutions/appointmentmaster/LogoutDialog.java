package com.spksolutions.appointmentmaster;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.spksolutions.appointmentmaster.R;

public class LogoutDialog extends Dialog {

    public LogoutDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_logout);

    }

    @Override
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, @Nullable Menu menu, int deviceId) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
