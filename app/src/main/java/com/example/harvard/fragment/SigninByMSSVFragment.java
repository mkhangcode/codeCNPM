package com.example.harvard.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.harvard.R;
import com.example.harvard.activity.MainActivity;
import com.example.harvard.activity.SigninActivity;
import com.example.harvard.common.Common;
import com.example.harvard.oop.Student;
import com.example.harvard.oop.Teacher;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class SigninByMSSVFragment extends Fragment {
    TextInputLayout txtInputLayoutMSSV, txtInputLayoutPassword;
    Button btnLogin;
    TextView txtForgetPass;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.layout_signin, container, false);
        txtInputLayoutMSSV = (TextInputLayout) root.findViewById(R.id.txtInputLayoutMSSV);
        txtInputLayoutPassword = (TextInputLayout) root.findViewById(R.id.txtInputLayoutPassword);
        btnLogin = (Button) root.findViewById(R.id.btnLogin);
        txtForgetPass = (TextView) root.findViewById(R.id.txtForgetPass);
        txtInputLayoutMSSV.setTranslationX(800);
        txtInputLayoutPassword.setTranslationX(800);
        txtForgetPass.setTranslationX(800);
        btnLogin.setTranslationX(800);
        txtInputLayoutMSSV.setAlpha(0);
        txtForgetPass.setAlpha(0);
        txtInputLayoutPassword.setAlpha(0);
        btnLogin.setAlpha(0);
        btnLogin.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(800).start();
        txtInputLayoutPassword.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(800).start();
        txtInputLayoutMSSV.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(800).start();
        txtForgetPass.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(800).start();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckUserLogin();

            }
        });
        return root;
    }

    public void CheckUserLogin() {
        String MSSV = txtInputLayoutMSSV.getEditText().getText().toString().trim();
        String Password = txtInputLayoutPassword.getEditText().getText().toString().trim();
        String MSGV = MSSV.substring(0, 2);
        Log.d("TAG", MSGV + "onClick: ");
        if (MSGV.equals("GV")) {
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference("teachers");
            Query checkUserDatabase = reference.orderByChild("teacherID").equalTo(MSSV);
            checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        String passwordFromDB = snapshot.child(MSSV).child("password").getValue(String.class);
                        if (Objects.equals(passwordFromDB, Password)) {
                            Teacher user = snapshot.child(MSSV).getValue(Teacher.class);
                            Common.currentTeacher = user;
                            Intent intent = new Intent(getActivity(), com.example.harvard.admin.teacher.activity.MainActivity.class);
                            startActivity(intent);
                        } else {
                            txtInputLayoutMSSV.setErrorEnabled(false);
                            txtInputLayoutPassword.setError("Sai mật khẩu");
                        }
                    } else {
                        txtInputLayoutMSSV.setError("Không tìm thấy tài khoản");
                        txtInputLayoutPassword.setErrorEnabled(false);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        } else if (MSSV.equals("admin") && Password.equals("admin")) {
            Intent intent = new Intent(getActivity(), com.example.harvard.admin.trainingDepartment.activity.MainActivity.class);
            startActivity(intent);
        } else {
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference("students");
            Query checkUserDatabase = reference.orderByChild("studentID").equalTo(MSSV);
            checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        String passwordFromDB = snapshot.child(MSSV).child("password").getValue(String.class);
                        if (Objects.equals(passwordFromDB, Password)) {
                            Student user = snapshot.child(MSSV).getValue(Student.class);
                            Common.currentUser = user;
                            Intent intent = new Intent(getActivity(), MainActivity.class);
                            startActivity(intent);
                        } else {
                            txtInputLayoutMSSV.setErrorEnabled(false);
                            txtInputLayoutPassword.setError("Sai mật khẩu");
                        }
                    } else {
                        txtInputLayoutMSSV.setError("Không tìm thấy tài khoản");
                        txtInputLayoutPassword.setErrorEnabled(false);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }


    }
}
