package com.example.harvard.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.harvard.R;
import com.example.harvard.adapter.ProgramAdapter;
import com.example.harvard.common.Common;
import com.example.harvard.oop.Result;
import com.example.harvard.oop.Subject;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ProgramActivity extends AppCompatActivity {
    Spinner spinnerSemester, spinnerMajor;
    List<String> Semester, Major;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    List<Subject> subjectsBatBuoc, subjectsTuChon;
    ValueEventListener eventListener, eventListener1;
    RecyclerView listBatBuoc, listTuChon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program);
        AnhXa();
        InsertDataToSpinner();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("subjects");
        subjectsBatBuoc = new ArrayList<>();
        ProgramAdapter adapter = new ProgramAdapter(subjectsBatBuoc, this);
        listBatBuoc.setAdapter(adapter);
        subjectsTuChon = new ArrayList<>();
        ProgramAdapter adapter1 = new ProgramAdapter(subjectsTuChon, this);
        listTuChon.setAdapter(adapter1);
        spinnerMajor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(!adapterView.getItemAtPosition(i).equals("Chọn ngành")){
                    spinnerSemester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView1, View view, int i, long l) {
                            if(!adapterView1.getItemAtPosition(i).equals("Chọn học kì")){
                                DatabaseReference programBatBuoc = databaseReference.child(adapterView.getSelectedItem().toString() + "").child(adapterView1.getSelectedItem().toString() + "").child("Bắt buộc");
                                eventListener = programBatBuoc.addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        subjectsBatBuoc.clear();
                                        for (DataSnapshot itemshot : snapshot.getChildren()){
                                            Subject subject = itemshot.getValue(Subject.class);
                                            subjectsBatBuoc.add(subject);
                                        }
                                        adapter.notifyDataSetChanged();
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                });
                                DatabaseReference programTuChon = databaseReference.child(adapterView.getSelectedItem().toString() + "").child(adapterView1.getSelectedItem().toString() + "").child("Tự chọn");
                                eventListener = programTuChon.addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        subjectsTuChon.clear();
                                        for (DataSnapshot itemshot : snapshot.getChildren()){
                                            Subject subject1 = itemshot.getValue(Subject.class);
                                            subjectsTuChon.add(subject1);
                                        }
                                        adapter1.notifyDataSetChanged();
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


    }

    private void AnhXa() {
        spinnerSemester = (Spinner) findViewById(R.id.spinnerSemester);
        spinnerMajor = (Spinner) findViewById(R.id.spinnerMajor);
        listBatBuoc = (RecyclerView) findViewById(R.id.listBatBuoc);
        listTuChon = (RecyclerView) findViewById(R.id.listTuChon);
        listTuChon.setHasFixedSize(true);
        listTuChon.setLayoutManager(new LinearLayoutManager(this));
        listBatBuoc.setHasFixedSize(true);
        listBatBuoc.setLayoutManager(new LinearLayoutManager(this));
    }

    private void InsertDataToSpinner() {
        Semester = new ArrayList<>();
        Semester.add(0, "Chọn học kì");
        Semester.add("Học kì 1");
        Semester.add("Học kì 2");
        Semester.add("Học kì 3");
        Semester.add("Học kì 4");
        Semester.add("Học kì hè năm 2");
        Semester.add("Học kì 5");
        Semester.add("Học kì 6");
        Semester.add("Học kì hè năm 3");
        Semester.add("Học kì 7");
        ArrayAdapter<String> dataAdapter1;
        dataAdapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Semester);
        spinnerSemester.setAdapter(dataAdapter1);
        Major = new ArrayList<>();
        Major.add(0,"Chọn ngành");
        Major.add(Common.currentUser.getCourseInfo().getChuyenNganh() + "");
        ArrayAdapter<String>  dataAdapter2;
        dataAdapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Major);
        spinnerMajor.setAdapter(dataAdapter2);
    }
}