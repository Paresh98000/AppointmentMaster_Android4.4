package com.spksolutions.appointmentmaster.mui.sp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.spksolutions.appointmentmaster.R;

public class SignInFragment extends Fragment {

    private SignInViewModel signInViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        signInViewModel =
                ViewModelProviders.of(this).get(SignInViewModel.class);
        View root = inflater.inflate(R.layout.fragment_sp_sign_in, container, false);
        final TextView textView = root.findViewById(R.id.text_sp_sign_in);
        signInViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}