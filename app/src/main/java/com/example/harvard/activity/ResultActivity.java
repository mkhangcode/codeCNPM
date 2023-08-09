package com.example.harvard.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.harvard.R;
import com.example.harvard.common.Common;
import com.example.harvard.oop.Result;
import com.example.harvard.adapter.ResultAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity {
    Spinner spinnerAcademicYear, spinnerSemester;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    List<String> AcademicYear, Semester;
    RecyclerView listResult;
    List<Result> result;
    ValueEventListener eventListener;
    ImageButton imageButtonBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("students").child(Common.currentUser.getStudentID());
        AnhXa();
        InsertDataToSpinner();
        result = new ArrayList<>();
        ResultAdapter adapter = new ResultAdapter(result, this);
        listResult.setAdapter(adapter);
        spinnerAcademicYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView1, View view, int i, long l) {
                if (!adapterView1.getItemAtPosition(i).equals("Chọn năm")) {
                    spinnerSemester.setSelection(0);
                    result.clear();
                    adapter.notifyDataSetChanged();
                    spinnerSemester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView2, View view, int i, long l) {
                            if (!adapterView2.getItemAtPosition(i).equals("Chọn học kì")) {
                                DatabaseReference myResult = databaseReference.child("Result").child(adapterView1.getSelectedItem().toString() + "").child(adapterView2.getSelectedItem().toString() + "");
                                eventListener = myResult.addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        result.clear();
                                        for (DataSnapshot itemsnapshot : snapshot.getChildren()) {
                                            Result result1 = itemsnapshot.getValue(Result.class);
                                            result.add(result1);
                                        }
                                        adapter.notifyDataSetChanged();
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                });

                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        imageButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void InsertDataToSpinner() {
        AcademicYear = new ArrayList<>();
        AcademicYear.add(0, "Chọn năm");
        AcademicYear.add("2021 - 2022");
        AcademicYear.add("2022 - 2023");
        AcademicYear.add("2023 - 2024");
        AcademicYear.add("2024 - 2025");
        ArrayAdapter<String> dataAdapter1;
        dataAdapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, AcademicYear);
        spinnerAcademicYear.setAdapter(dataAdapter1);
        Semester = new ArrayList<>();
        Semester.add(0, "Chọn học kì");
        Semester.add("Học kì 1");
        Semester.add("Học kì 2");
        Semester.add("Học kì 3");
        ArrayAdapter<String> dataAdapter2;
        dataAdapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Semester);
        spinnerSemester.setAdapter(dataAdapter2);
    }

    private void AnhXa() {
        spinnerAcademicYear = (Spinner) findViewById(R.id.spinnerAcademicYear);
        spinnerSemester = (Spinner) findViewById(R.id.spinnerSemester);
        listResult = (RecyclerView) findViewById(R.id.listResult);
        listResult.setHasFixedSize(true);
        listResult.setLayoutManager(new LinearLayoutManager(this));
        imageButtonBack = (ImageButton) findViewById(R.id.imageButtonBack);
//        txtTongSoTinChi = (TextView) findViewById(R.id.txtTongSoTinChi);
//        txtTongSoTinChiTichLuy = (TextView) findViewById(R.id.txtTongSoTinChiTichLuy);
//        txtTongSoTinChiDat = (TextView) findViewById(R.id.txtTongSoTinChiDat);
//        txtTongSoTinChiKhongDat = (TextView) findViewById(R.id.txtTongSoTinChiKhongDat);
    }
}