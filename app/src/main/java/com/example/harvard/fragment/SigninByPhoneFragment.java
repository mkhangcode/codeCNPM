package com.example.harvard.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.harvard.R;
import com.google.android.material.textfield.TextInputLayout;

public class SigninByPhoneFragment extends Fragment {
    TextInputLayout txtInputLayoutCode, txtInputLayoutPhone;
    Button btnSendCode;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.layout_signin_phone, container, false);
        txtInputLayoutCode = (TextInputLayout) root.findViewById(R.id.txtInputLayoutCode);
        txtInputLayoutPhone = (TextInputLayout) root.findViewById(R.id.txtInputLayoutPhone);
        btnSendCode = (Button) root.findViewById(R.id.btnSendCode);
        txtInputLayoutCode.setTranslationX(800);
        txtInputLayoutPhone.setTranslationX(800);
        btnSendCode.setTranslationX(800);
        txtInputLayoutCode.setAlpha(0);
        txtInputLayoutPhone.setAlpha(0);
        btnSendCode.setAlpha(0);
        btnSendCode.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(800).start();
        txtInputLayoutPhone.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(800).start();
        txtInputLayoutCode.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(800).start();
        return root;
    }
}
