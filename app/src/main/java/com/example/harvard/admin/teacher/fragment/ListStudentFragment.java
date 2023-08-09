package com.example.harvard.admin.teacher.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.harvard.R;
import com.example.harvard.admin.teacher.adapter.ListStudentAdapter;
import com.example.harvard.common.Common;
import com.example.harvard.oop.Student;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;


public class ListStudentFragment extends Fragment {
    Spinner spinnerSubject, spinnerClassID;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference, databaseReference2;
    List<String> Subject, ClassID;
    List<Student> students;
    ValueEventListener eventListener, eventListener1;
    RecyclerView listStudent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_student, container, false);
        Context context = container.getContext();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference2 = firebaseDatabase.getReference("Room").child(Common.currentTeacher.getTeachingInformation().getChuyenNganh() + "");

        AnhXa(view, context);
        InsertDataToSpinner(context);
        students = new ArrayList<>();
        ListStudentAdapter adapter = new ListStudentAdapter(students, context);
        listStudent.setAdapter(adapter);
        spinnerSubject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView1, View view, int i, long l) {
                if (!adapterView1.getItemAtPosition(i).equals("Chọn môn")) {
                    spinnerClassID.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView2, View view, int i, long l) {
                            if (!adapterView2.getItemAtPosition(i).equals("Chọn mã lớp học phần")) {
                                databaseReference2.addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        for (DataSnapshot item : snapshot.getChildren()) {

                                            DatabaseReference danhsachHocSinh = databaseReference2.child(adapterView2.getSelectedItem().toString() + "").child("Danh sách học sinh");
                                            eventListener1 = danhsachHocSinh.addValueEventListener(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                    students.clear();
                                                    for (DataSnapshot itemsnap : snapshot.getChildren()) {
                                                        Student student = itemsnap.getValue(Student.class);
                                                        students.add(student);
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

        return view;
    }

    private void InsertDataToSpinner(Context context) {
        Subject = new ArrayList<>();
        Subject.add(0, "Chọn môn");
        Subject.add(Common.currentTeacher.getTeachingInformation().getMonday());
        ArrayAdapter<String> dataAdapter2;
        dataAdapter2 = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, Subject);
        spinnerSubject.setAdapter(dataAdapter2);
        databaseReference = firebaseDatabase.getReference("teachers").child(Common.currentTeacher.getTeacherID() + "").child("Schedule");
        ClassID = new ArrayList<>();
        ArrayAdapter<String> dataAdapter1;
        dataAdapter1 = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, ClassID);
        eventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ClassID.clear();
                ClassID.add(0, "Chọn mã lớp học phần");
                for (DataSnapshot itemsnap : snapshot.getChildren()) {
                    String id = itemsnap.child("classID").getValue(String.class);
                    ClassID.add(id);
                }
                dataAdapter1.notifyDataSetChanged();
                spinnerClassID.setAdapter(dataAdapter1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void AnhXa(View view, Context context) {
        spinnerSubject = (Spinner) view.findViewById(R.id.spinnerSubject);
        spinnerClassID = (Spinner) view.findViewById(R.id.spinnerClassID);
        listStudent = (RecyclerView) view.findViewById(R.id.listStudent);
        listStudent.setHasFixedSize(true);
        listStudent.setLayoutManager(new LinearLayoutManager(context));
    }
}