package com.example.harvard.admin.teacher.fragment;

import static android.app.Activity.RESULT_OK;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.harvard.R;
import com.example.harvard.common.Common;
import com.example.harvard.oop.Exercise;
import com.example.harvard.oop.Student;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
import java.util.UUID;

public class HomeTeacherFragment extends Fragment {
    ImageButton btnCreateExercise;
    private int PICK_IMAGE_REQUEST = 71;
    Uri uri;
    FirebaseStorage storage;
    StorageReference storageReference;
    TextInputLayout txtInputLayoutContentEx, txtInputLayoutTittleEx;
    Button btnUploadImage, btnCreateAssignment;
    Exercise exercise;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Spinner SpinnerSubject, SpinnerClassID;
    List<String> Subject, ClassID;
    ValueEventListener eventListener;
    ImageButton imgbtnSelectImage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_teacher, container, false);
        Context context = container.getContext();
        firebaseDatabase = FirebaseDatabase.getInstance();
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        AnhXa(view);
        btnCreateExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog(context);
            }
        });
        return view;
    }

    private void AnhXa(View view) {
        btnCreateExercise = (ImageButton) view.findViewById(R.id.btnCreateExercise);
    }

    private void showCustomDialog(Context context) {
        databaseReference = firebaseDatabase.getReference("Room").child(Common.currentTeacher.getTeachingInformation().getChuyenNganh() + "");
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_diabog_exercise);
        dialog.setCancelable(true);
        Window window = dialog.getWindow();
        btnUploadImage = dialog.findViewById(R.id.ThemHinhAnh);
        btnCreateAssignment = dialog.findViewById(R.id.TaoBaiTap);
        txtInputLayoutTittleEx = dialog.findViewById(R.id.txtInputLayoutTitleEx);
        txtInputLayoutContentEx = dialog.findViewById(R.id.txtInputLayoutContentEx);
        imgbtnSelectImage = dialog.findViewById(R.id.imgbtnSelectImage);
        SpinnerSubject = dialog.findViewById(R.id.SpinnerSubject);
        SpinnerClassID = dialog.findViewById(R.id.SpinnerClassID);

        InsertToSpinner(context);
        imgbtnSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Chọn hình"), PICK_IMAGE_REQUEST);
            }
        });
        btnUploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tittle = txtInputLayoutTittleEx.getEditText().getText().toString().trim();
                String content = txtInputLayoutContentEx.getEditText().getText().toString().trim();
                UploadImageEx(context, tittle, content);
            }
        });
        btnCreateAssignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.child(SpinnerClassID.getSelectedItem().toString() + "").child("Exercise").push().setValue(exercise);
                dialog.dismiss();
            }
        });
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }



    private void InsertToSpinner(Context context) {
        databaseReference = firebaseDatabase.getReference("Room").child(Common.currentTeacher.getTeachingInformation().getChuyenNganh() + "");
        Subject = new ArrayList<>();
        Subject.add(0, "Chọn môn");
        Subject.add(Common.currentTeacher.getTeachingInformation().getMonday());
        ArrayAdapter<String> dataAdapter2;
        dataAdapter2 = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, Subject);
        SpinnerSubject.setAdapter(dataAdapter2);
        DatabaseReference databaseReference1 = firebaseDatabase.getReference("teachers").child(Common.currentTeacher.getTeacherID() + "").child("Schedule");
        ClassID = new ArrayList<>();
        ArrayAdapter<String> dataAdapter1;
        dataAdapter1 = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, ClassID);
        eventListener = databaseReference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ClassID.clear();
                ClassID.add(0, "Chọn mã lớp học phần");
                for (DataSnapshot itemsnap : snapshot.getChildren()) {
                    String id = itemsnap.child("classID").getValue(String.class);
                    ClassID.add(id);
                }
                dataAdapter1.notifyDataSetChanged();
                SpinnerClassID.setAdapter(dataAdapter1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void UploadImageEx(Context context, String tittle, String content) {
        if (uri != null) {
            ProgressDialog mDialog = new ProgressDialog(context);
            mDialog.setMessage("Đang tải....");
            mDialog.show();
            String imageName = UUID.randomUUID().toString();
            StorageReference imageFolder = storageReference.child("images/" + imageName);
            imageFolder.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    mDialog.dismiss();
                    Toast.makeText(context, "Tải lên thành công !!!", Toast.LENGTH_LONG).show();
                    imageFolder.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            exercise = new Exercise(SpinnerSubject.getSelectedItem().toString(), SpinnerClassID.getSelectedItem().toString() ,tittle, content, uri.toString());
                        }
                    });
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    mDialog.dismiss();
                    Toast.makeText(context, "" + e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                    double progess = (100.0 + snapshot.getBytesTransferred() / snapshot.getTotalByteCount());
                    mDialog.setMessage("Tải lên " + progess + " % ");
                }
            });
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            uri = data.getData();
            imgbtnSelectImage.setImageURI(uri);
        }
    }
}