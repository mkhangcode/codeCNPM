package com.example.harvard.admin.trainingDepartment.adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.harvard.R;
import com.example.harvard.admin.teacher.viewholder.ListStudentViewHolder;
import com.example.harvard.admin.trainingDepartment.activity.QuanLyHocSinhActivity;
import com.example.harvard.admin.trainingDepartment.viewholder.EditStudentViewHolder;
import com.example.harvard.oop.CourseInfo;
import com.example.harvard.oop.Information;
import com.example.harvard.oop.Student;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EditStudentAdapter extends RecyclerView.Adapter<EditStudentViewHolder>{
    List<Student> studentList;
    Context context;
    TextInputLayout txtInputLayoutFirstName, txtInputLayoutLastName, txtInputLayoutIdenti, txtInputLayoutEmail, txtInputLayoutAddress,
            txtInputLayoutClass, txtInputLayoutDanToc, txtInputLayoutTonGiao, txtInputLayoutQuocGia, txtInputLayoutSoDienThoai, txtInputLayoutDiaChiThuongTru, txtInputLayoutTinhThanh,
            txtInputLayoutQuanHuyen, txtInputLayoutHoTenThanNhan, txtInputLayoutSdtThanNhan, txtInputLayoutDiaChiThanNhan;
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = firebaseDatabase.getReference("students");
    Spinner SpinnerSex, SpinnerMajor, SpinnerKhoaHoc, SpinnerLoaiHinhDaoTao;
    Button btnSangTrang2, btnSangTrang3, btnThemHocSinh;
    List<String> Sex, Major, KhoaHoc, LoaiHinhDaoTao;
    ValueEventListener eventListener1;
    public EditStudentAdapter(List<Student> studentList, Context context) {
        this.studentList = studentList;
        this.context = context;
    }

    @NonNull
    @Override
    public EditStudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_quan_ly_hoc_sinh, parent, false);
        return new EditStudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EditStudentViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.txtMSSV.setText(student.getStudentID());
        holder.txtSTT.setText(position + 1 + "");
        holder.txtTen.setText(student.getLastName() + "");
        holder.txtHoTenLot.setText(student.getFirstName() + "");
        holder.editStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog1 = new Dialog(context);
                dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog1.setContentView(R.layout.layout_dialog_add_student);
                dialog1.setCancelable(true);
                Window window1 = dialog1.getWindow();
                // ánh xạ dialog 1
                txtInputLayoutFirstName = (TextInputLayout) dialog1.findViewById(R.id.txtInputLayoutFirstName);
                txtInputLayoutLastName = (TextInputLayout) dialog1.findViewById(R.id.txtInputLayoutLastName);
                txtInputLayoutIdenti = (TextInputLayout) dialog1.findViewById(R.id.txtInputLayoutIdenti);
                txtInputLayoutEmail = (TextInputLayout) dialog1.findViewById(R.id.txtInputLayoutEmail);
                txtInputLayoutAddress = (TextInputLayout) dialog1.findViewById(R.id.txtInputLayoutAddress);
                SpinnerSex = (Spinner) dialog1.findViewById(R.id.SpinnerSex);
                btnSangTrang2 = (Button) dialog1.findViewById(R.id.btnSangTrang);
                TextView titleDialog1 = (TextView) dialog1.findViewById(R.id.titleDialog1);
                titleDialog1.setText("Chỉnh sửa sinh viên");
                // Insert dữ liệu vào Spinner của dialog 1
                InsertDataToSpinnerDialog1();
                SetData1(student);
                // xử lý sự kiện dialog 1
                btnSangTrang2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String firstName = txtInputLayoutFirstName.getEditText().getText().toString();
                        String lastName = txtInputLayoutLastName.getEditText().getText().toString();
                        String identi = txtInputLayoutIdenti.getEditText().getText().toString();
                        String email = txtInputLayoutEmail.getEditText().getText().toString();
                        String address = txtInputLayoutAddress.getEditText().getText().toString();
                        String sex = SpinnerSex.getSelectedItem().toString();
                        dialog1.dismiss();
                        //dialog 2
                        Dialog dialog2 = new Dialog(context);
                        dialog2.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        dialog2.setContentView(R.layout.layout_dialog_add_student_2);
                        dialog2.setCancelable(true);
                        Window window2 = dialog2.getWindow();
                        // ánh xạ dialog 2
                        txtInputLayoutClass = (TextInputLayout) dialog2.findViewById(R.id.txtInputLayoutClass);
                        SpinnerMajor = (Spinner) dialog2.findViewById(R.id.SpinnerMajor);
                        SpinnerKhoaHoc = (Spinner) dialog2.findViewById(R.id.SpinnerKhoaHoc);
                        SpinnerLoaiHinhDaoTao = (Spinner) dialog2.findViewById(R.id.SpinnerLoaiHinhDaoTao);
                        btnSangTrang3 = (Button) dialog2.findViewById(R.id.btnSangTrang);
                        // Insert dữ liệu vào Spinner của dialog 2
                        InsertDataToSpinnerDialog2();
                        SetData2(student);
                        // xử lý sự kiện dialog 2
                        btnSangTrang3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String Class = txtInputLayoutClass.getEditText().getText().toString();
                                String Major = SpinnerMajor.getSelectedItem().toString();
                                String KhoaHoc = SpinnerKhoaHoc.getSelectedItem().toString();
                                String LoaiHinhDaoTao = SpinnerLoaiHinhDaoTao.getSelectedItem().toString();
                                CourseInfo CourseInFo = new CourseInfo(KhoaHoc, LoaiHinhDaoTao, Class, Major);
                                dialog2.dismiss();
                                //dialog3
                                Dialog dialog3 = new Dialog(context);
                                dialog3.requestWindowFeature(Window.FEATURE_NO_TITLE);
                                dialog3.setContentView(R.layout.layout_dialog_add_student_3);
                                dialog3.setCancelable(true);
                                Window window3 = dialog3.getWindow();
                                // ánh xạ dialog 3
                                txtInputLayoutDanToc = (TextInputLayout) dialog3.findViewById(R.id.txtInputLayoutDanToc);
                                txtInputLayoutTonGiao = (TextInputLayout) dialog3.findViewById(R.id.txtInputLayoutTonGiao);
                                txtInputLayoutQuocGia = (TextInputLayout) dialog3.findViewById(R.id.txtInputLayoutQuocGia);
                                txtInputLayoutSoDienThoai = (TextInputLayout) dialog3.findViewById(R.id.txtInputLayoutSoDienThoai);
                                txtInputLayoutDiaChiThuongTru = (TextInputLayout) dialog3.findViewById(R.id.txtInputLayoutDiaChiThuongTru);
                                txtInputLayoutTinhThanh = (TextInputLayout) dialog3.findViewById(R.id.txtInputLayoutTinhThanh);
                                txtInputLayoutQuanHuyen = (TextInputLayout) dialog3.findViewById(R.id.txtInputLayoutQuanHuyen);
                                txtInputLayoutHoTenThanNhan = (TextInputLayout) dialog3.findViewById(R.id.txtInputLayoutHoTenThanNhan);
                                txtInputLayoutSdtThanNhan = (TextInputLayout) dialog3.findViewById(R.id.txtInputLayoutSdtThanNhan);
                                txtInputLayoutDiaChiThanNhan = (TextInputLayout) dialog3.findViewById(R.id.txtInputLayoutDiaChiThanNhan);
                                SetData3(student);
                                btnThemHocSinh = (Button) dialog3.findViewById(R.id.btnThemHocSinh);
                                btnThemHocSinh.setText("Xong");
                                // xử lý sự kiện dialog 3
                                btnThemHocSinh.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        String DanToc = txtInputLayoutDanToc.getEditText().getText().toString();
                                        String TonGiao = txtInputLayoutTonGiao.getEditText().getText().toString();
                                        String QuocGia = txtInputLayoutQuocGia.getEditText().getText().toString();
                                        String SoDienThoai = txtInputLayoutSoDienThoai.getEditText().getText().toString();
                                        String DiaChiThuongTru = txtInputLayoutDiaChiThuongTru.getEditText().getText().toString();
                                        String TinhThanh = txtInputLayoutTinhThanh.getEditText().getText().toString();
                                        String QuanHuyen = txtInputLayoutQuanHuyen.getEditText().getText().toString();
                                        String HoTenThanNhan = txtInputLayoutHoTenThanNhan.getEditText().getText().toString();
                                        String SdtThanNhan = txtInputLayoutSdtThanNhan.getEditText().getText().toString();
                                        String DiaChiThanNhan = txtInputLayoutDiaChiThanNhan.getEditText().getText().toString();
                                        Information Information = new Information(DanToc, TonGiao, QuocGia, TinhThanh, QuanHuyen, SoDienThoai, HoTenThanNhan, SdtThanNhan, DiaChiThanNhan, DiaChiThuongTru);
                                        Student student1 = new Student(student.getStudentID() ,firstName, lastName, sex, identi, student.getAcademicStatus(), email, address, student.getPassword() + "", Information, CourseInFo);
                                        databaseReference.child(student.getStudentID() + "").setValue(student1);
                                        Map<String, Object> updates = new HashMap<>();
                                        updates.put(student.getStudentID() + "/CourseInFo", student1.getCourseInfo());
                                        updates.put(student.getStudentID() + "/Information", student1.getInformation());
                                        databaseReference.updateChildren(updates);
                                        databaseReference.child(student.getStudentID() + "/courseInfo").removeValue();
                                        databaseReference.child(student.getStudentID() + "/information").removeValue();
                                        dialog3.dismiss();
                                    }
                                });
                                //Window 3
                                window3.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                                dialog3.show();
                            }
                        });
                        //Window 2
                        window2.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        dialog2.show();
                    }
                });

                //Window 1
                window1.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog1.show();
            }
        });
    }

    private void SetData3(Student student) {
        txtInputLayoutDanToc.getEditText().setText(student.getInformation().getDanToc() + "");
        txtInputLayoutTonGiao.getEditText().setText(student.getInformation().getTonGiao() + "");
        txtInputLayoutQuocGia.getEditText().setText(student.getInformation().getQuocGia() + "");
        txtInputLayoutSoDienThoai.getEditText().setText(student.getInformation().getDiDong() + "");
        txtInputLayoutDiaChiThuongTru.getEditText().setText(student.getInformation().getDiachiThuongTru() + "");
        txtInputLayoutTinhThanh.getEditText().setText(student.getInformation().getTinhThanh() + "");
        txtInputLayoutQuanHuyen.getEditText().setText(student.getInformation().getQuanHuyen() + "");
        txtInputLayoutHoTenThanNhan.getEditText().setText(student.getInformation().getThanNhan() + "");
        txtInputLayoutSdtThanNhan.getEditText().setText(student.getInformation().getDiDongThanNhan() + "");
        txtInputLayoutDiaChiThanNhan.getEditText().setText(student.getInformation().getDiachiThanNhan() + "");
    }

    private void SetData2(Student student) {
        for(int i = 0; i < Major.size(); i ++){
            SpinnerMajor.setSelection(i);
            if(SpinnerMajor.getSelectedItem().toString().equals(student.getCourseInfo().getChuyenNganh())){
                SpinnerMajor.setSelection(i);
                break;
            }
        }
        for(int i = 0; i < LoaiHinhDaoTao.size(); i ++){
            SpinnerLoaiHinhDaoTao.setSelection(i);
            if(SpinnerLoaiHinhDaoTao.getSelectedItem().toString().equals(student.getCourseInfo().getLoaihinhDaoTao())){
                SpinnerLoaiHinhDaoTao.setSelection(i);
                break;
            }
        }
        for(int i = 0; i < KhoaHoc.size(); i ++){
            SpinnerKhoaHoc.setSelection(i);
            if(SpinnerKhoaHoc.getSelectedItem().toString().equals(student.getCourseInfo().getKhoaHoc())){
                SpinnerKhoaHoc.setSelection(i);
                break;
            }
        }
        txtInputLayoutClass.getEditText().setText(student.getCourseInfo().getLop() + "");
    }

    private void SetData1(Student student) {
        txtInputLayoutFirstName.getEditText().setText(student.getFirstName() + "");
        txtInputLayoutLastName.getEditText().setText(student.getLastName() + "");
        txtInputLayoutIdenti.getEditText().setText(student.getIdentificationCode() + "");
        txtInputLayoutEmail.getEditText().setText(student.getPersonalEmail() + "");
        txtInputLayoutAddress.getEditText().setText(student.getAddress() + "");
        for(int i = 0; i < Sex.size(); i ++){
            SpinnerSex.setSelection(i);
            if(SpinnerSex.getSelectedItem().toString().equals(student.getSex())){
                SpinnerSex.setSelection(i);
                break;
            }
        }
    }

    private void InsertDataToSpinnerDialog2() {
        // Spinner Major
        DatabaseReference databaseReference1 = firebaseDatabase.getReference("Major");
        Major = new ArrayList<>();
        ArrayAdapter<String> adapter2;
        adapter2 = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, Major);
        eventListener1 = databaseReference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Major.clear();
                Major.add(0, "Chọn ngành");
                for (DataSnapshot itemsnap : snapshot.getChildren()) {
                    String id = itemsnap.child("TenNganh").getValue(String.class);
                    Major.add(id);
                }
                adapter2.notifyDataSetChanged();
                SpinnerMajor.setAdapter(adapter2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        // Spinner Khóa Học
        Calendar calendar = Calendar.getInstance();
        KhoaHoc = new ArrayList<>();
        KhoaHoc.add(0, "Chọn khóa học");
        KhoaHoc.add("Đại học chính quý khóa " + calendar.get(Calendar.YEAR));
        ArrayAdapter<String> adapter3;
        adapter3 = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, KhoaHoc);
        SpinnerKhoaHoc.setAdapter(adapter3);
        // Spinner Loại hình đào tạo
        LoaiHinhDaoTao = new ArrayList<>();
        LoaiHinhDaoTao.add(0, "Chọn loại hình đào tạo");
        LoaiHinhDaoTao.add("Đại học chính quy");
        ArrayAdapter<String> adapter4;
        adapter4 = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, LoaiHinhDaoTao);
        SpinnerLoaiHinhDaoTao.setAdapter(adapter4);
    }

    private void InsertDataToSpinnerDialog1() {
        Sex = new ArrayList<>();
        Sex.add(0, "Chọn giới tính");
        Sex.add("Nam");
        Sex.add("Nữ");
        ArrayAdapter<String> adapter1;
        adapter1 = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, Sex);
        SpinnerSex.setAdapter(adapter1);
    }
    @Override
    public int getItemCount() {
        return studentList.size();
    }
}
