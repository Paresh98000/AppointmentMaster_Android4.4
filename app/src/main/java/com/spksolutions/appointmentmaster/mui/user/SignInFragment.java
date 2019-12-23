package com.spksolutions.appointmentmaster.mui.user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.spksolutions.appointmentmaster.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class SignInFragment extends Fragment {

    private SignInViewModel signInViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        signInViewModel =
                ViewModelProviders.of(this).get(SignInViewModel.class);
        View root = inflater.inflate(R.layout.fragment_user_sign_in, container, false);
        final TextView textView = root.findViewById(R.id.text_user_sign_in);
        signInViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}