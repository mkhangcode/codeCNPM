package com.example.harvard.admin.trainingDepartment.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.harvard.R;
import com.example.harvard.oop.CourseInfo;
import com.example.harvard.oop.Information;
import com.example.harvard.oop.Student;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageButton btnAddStudent, btnAddTeacher;



    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("students");
        AnhXa();
        btnAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, QuanLyHocSinhActivity.class));
            }
        });
        btnAddTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

//    private void DialogTeacher() {
//        // dialog 1
//        Dialog dialog1 = new Dialog(this);
//        dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog1.setContentView(R.layout.layout_dialog_add_teacher);
//        dialog1.setCancelable(true);
//        Window window1 = dialog1.getWindow();
//        // ánh xạ dialog 1
//        txtInputLayoutFirstName = (TextInputLayout) dialog1.findViewById(R.id.txtInputLayoutFirstName);
//        txtInputLayoutLastName = (TextInputLayout) dialog1.findViewById(R.id.txtInputLayoutLastName);
//        txtInputLayoutIdenti = (TextInputLayout) dialog1.findViewById(R.id.txtInputLayoutIdenti);
//        txtInputLayoutEmail = (TextInputLayout) dialog1.findViewById(R.id.txtInputLayoutEmail);
//        txtInputLayoutAddress = (TextInputLayout) dialog1.findViewById(R.id.txtInputLayoutAddress);
//        SpinnerSex = (Spinner) dialog1.findViewById(R.id.SpinnerSex);
//        btnSangTrang2 = (Button) dialog1.findViewById(R.id.btnSangTrang);
//        // Insert dữ liệu vào Spinner của dialog 1
//        InsertDataToSpinnerDialog1();
//        btnSangTrang2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String firstName = txtInputLayoutFirstName.getEditText().getText().toString();
//                String lastName = txtInputLayoutLastName.getEditText().getText().toString();
//                String identi = txtInputLayoutIdenti.getEditText().getText().toString();
//                String email = txtInputLayoutEmail.getEditText().getText().toString();
//                String address = txtInputLayoutAddress.getEditText().getText().toString();
//                String sex = SpinnerSex.getSelectedItem().toString();
//                dialog1.dismiss();
//                Dialog dialog2 = new Dialog(MainActivity.this);
//                dialog2.requestWindowFeature(Window.FEATURE_NO_TITLE);
//                dialog2.setContentView(R.layout.layout_dialog_add_teacher_2);
//                dialog2.setCancelable(true);
//                Window window2 = dialog2.getWindow();
//                // ánh xạ dialog 3
//                txtInputLayoutDanToc = (TextInputLayout) dialog2.findViewById(R.id.txtInputLayoutDanToc);
//                txtInputLayoutTonGiao = (TextInputLayout) dialog2.findViewById(R.id.txtInputLayoutTonGiao);
//                txtInputLayoutQuocGia = (TextInputLayout) dialog2.findViewById(R.id.txtInputLayoutQuocGia);
//                txtInputLayoutSoDienThoai = (TextInputLayout) dialog2.findViewById(R.id.txtInputLayoutSoDienThoai);
//                txtInputLayoutDiaChiThuongTru = (TextInputLayout) dialog2.findViewById(R.id.txtInputLayoutDiaChiThuongTru);
//                txtInputLayoutTinhThanh = (TextInputLayout) dialog2.findViewById(R.id.txtInputLayoutTinhThanh);
//                txtInputLayoutQuanHuyen = (TextInputLayout) dialog2.findViewById(R.id.txtInputLayoutQuanHuyen);
//                txtInputLayoutHoTenThanNhan = (TextInputLayout) dialog2.findViewById(R.id.txtInputLayoutHoTenThanNhan);
//                txtInputLayoutSdtThanNhan = (TextInputLayout) dialog2.findViewById(R.id.txtInputLayoutSdtThanNhan);
//                txtInputLayoutDiaChiThanNhan = (TextInputLayout) dialog2.findViewById(R.id.txtInputLayoutDiaChiThanNhan);
//                btnSangTrang3 = (Button) dialog2.findViewById(R.id.btnSangTrang);
//                btnSangTrang3.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//
//                    }
//                });
//                //Window 2
//                window2.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                dialog2.show();
//            }
//        });
//        //Window 1
//        window1.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        dialog1.show();
//    }





    private void AnhXa() {
        btnAddStudent = (ImageButton) findViewById(R.id.btnAddStudent);
        btnAddTeacher = (ImageButton) findViewById(R.id.btnAddTeacher);
    }
}