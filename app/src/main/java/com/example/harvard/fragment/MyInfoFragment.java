package com.example.harvard.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.harvard.R;
import com.example.harvard.common.Common;

import org.w3c.dom.Text;


public class MyInfoFragment extends Fragment {
    TextView txtMSSV, txtHoTen, txtSex, txtCCCD, txtTinhTrang, txtEmailTruong, txtEmailCaNhan, txtDiaChiCaNhan, txtDanToc, txtTonGiao, txtQuocGia,
            txtTinh, txtQuanHuyen, txtDiaChiThuongTru, txtDiDong, txtKhoaHoc, txtChuyenNganh, txtLoaiHinhDaoTao, txtLop, txtHoTenThanNhan, txtDiDongThanNhan, txtDiaChiThanNhan;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_info, container, false);
        AnhXa(view);
        txtMSSV.setText(Common.currentUser.getStudentID() + "");
        txtHoTen.setText(Common.currentUser.getFirstName() + " " + Common.currentUser.getLastName());
        txtSex.setText(Common.currentUser.getSex() + "");
        txtTinhTrang.setText(Common.currentUser.getAcademicStatus() + "");
        txtCCCD.setText(Common.currentUser.getIdentificationCode() + "");
        txtEmailTruong.setText(Common.currentUser.getSchoolEmail() + "");
        txtEmailCaNhan.setText(Common.currentUser.getPersonalEmail() + "");
        txtDiaChiCaNhan.setText(Common.currentUser.getAddress() + "");
        txtDanToc.setText(Common.currentUser.getInformation().getDanToc() + "");
        txtTonGiao.setText(Common.currentUser.getInformation().getTonGiao() + "");
        txtQuocGia.setText(Common.currentUser.getInformation().getQuocGia() + "");
        txtTinh.setText(Common.currentUser.getInformation().getTinhThanh() + "");
        txtQuanHuyen.setText(Common.currentUser.getInformation().getQuanHuyen() + "");
        txtDiaChiThuongTru.setText(Common.currentUser.getInformation().getDiachiThuongTru() + "");
        txtDiDong.setText(Common.currentUser.getInformation().getDiDong() + "");
        txtKhoaHoc.setText(Common.currentUser.getCourseInfo().getKhoaHoc() + "");
        txtChuyenNganh.setText(Common.currentUser.getCourseInfo().getChuyenNganh() + "");
        txtLoaiHinhDaoTao.setText(Common.currentUser.getCourseInfo().getLoaihinhDaoTao() + "");
        txtLop.setText(Common.currentUser.getCourseInfo().getLop() + "");
        txtHoTenThanNhan.setText(Common.currentUser.getInformation().getThanNhan() + "");
        txtDiDongThanNhan.setText(Common.currentUser.getInformation().getDiDongThanNhan() + "");
        txtDiaChiThanNhan.setText(Common.currentUser.getInformation().getDiachiThanNhan() + "");
        return view;
    }

    private void AnhXa(View view) {
        txtMSSV = (TextView) view.findViewById(R.id.txtMSSV);
        txtHoTen = (TextView) view.findViewById(R.id.txtHoTen);
        txtSex = (TextView) view.findViewById(R.id.txtSex);
        txtCCCD = (TextView) view.findViewById(R.id.txtCCCD);
        txtTinhTrang = (TextView) view.findViewById(R.id.txtTinhTrang);
        txtEmailTruong = (TextView) view.findViewById(R.id.txtEmailTruong);
        txtEmailCaNhan = (TextView) view.findViewById(R.id.txtEmailCaNhan);
        txtDiaChiCaNhan = (TextView) view.findViewById(R.id.txtDiaChiCaNhan);
        txtDanToc = (TextView) view.findViewById(R.id.txtDanToc);
        txtTonGiao = (TextView) view.findViewById(R.id.txtTonGiao);
        txtQuocGia = (TextView) view.findViewById(R.id.txtQuocGia);
        txtTinh = (TextView) view.findViewById(R.id.txtTinh);
        txtQuanHuyen = (TextView) view.findViewById(R.id.txtQuanHuyen);
        txtDiaChiThuongTru = (TextView) view.findViewById(R.id.txtDiaChiThuongTru);
        txtDiDong = (TextView) view.findViewById(R.id.txtDiDong);
        txtKhoaHoc = (TextView) view.findViewById(R.id.txtKhoaHoc);
        txtChuyenNganh = (TextView) view.findViewById(R.id.txtChuyenNganh);
        txtLoaiHinhDaoTao = (TextView) view.findViewById(R.id.txtLoaiHinhDaoTao);
        txtLop = (TextView) view.findViewById(R.id.txtLop);
        txtHoTenThanNhan = (TextView) view.findViewById(R.id.txtHoTenThanNhan);
        txtDiDongThanNhan = (TextView) view.findViewById(R.id.txtDiDongThanNhan);
        txtDiaChiThanNhan = (TextView) view.findViewById(R.id.txtDiaChiThanNhan);
    }
}