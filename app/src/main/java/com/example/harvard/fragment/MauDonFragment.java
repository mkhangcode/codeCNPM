package com.example.harvard.fragment;

import android.app.DownloadManager;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.harvard.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MauDonFragment extends Fragment {
    Context context;
    Button btndownBaoLuu, btndownChuyenNganh, btndownXacNhanSinhVien, btndownCapBangDiem, btndownXinThoiHoc, btndownGiaHanHocPhi;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mau_don, container, false);
        context = container.getContext();
        AnhXa(view);
        btndownBaoLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File outDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString());
                copyAssets("Don xin bao luu 2023.pdf",outDir.toString(), context);
            }
        });
        btndownChuyenNganh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File outDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString());
                copyAssets("Don xin chuyen nganh.pdf",outDir.toString(), context);
            }
        });
        btndownCapBangDiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File outDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString());
                copyAssets("Phieu yeu cau bang diem.pdf",outDir.toString(), context);
            }
        });
        btndownXacNhanSinhVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File outDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString());
                copyAssets("Phieu xac nhan SV.pdf",outDir.toString(), context);
            }
        });
        btndownXinThoiHoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File outDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString());
                copyAssets("Don xin thoi hoc.pdf",outDir.toString(), context);
            }
        });
        btndownGiaHanHocPhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File outDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString());
                copyAssets("Don xin gia han hoc phi.pdf",outDir.toString(), context);
            }
        });
        return view;
    }

    private void AnhXa(View view) {
        btndownBaoLuu = (Button) view.findViewById(R.id.btndownBaoLuu);
        btndownChuyenNganh = (Button) view.findViewById(R.id.btndownChuyenNganh);
        btndownCapBangDiem = (Button) view.findViewById(R.id.btndownCapBangDiem);
        btndownXacNhanSinhVien = (Button) view.findViewById(R.id.btndownXacNhanSinhVien);
        btndownXinThoiHoc = (Button) view.findViewById(R.id.btndownXinThoiHoc);
        btndownGiaHanHocPhi = (Button) view.findViewById(R.id.btndownGiaHanHocPhi);
    }

    private void copyAssets(String path, String outPath, Context context) {
        AssetManager assetManager = context.getAssets();
        String assets[];
        try {
            assets = assetManager.list(path);
            if (assets.length == 0) {
                copyFile(path, outPath);
                Toast.makeText(context, "Tải thành công", Toast.LENGTH_LONG).show();
            } else {
                String fullPath = outPath + "/" + path;
                File dir = new File(fullPath);
                if (!dir.exists())
                    if (!dir.mkdir()) Log.e("TAG", "No create external directory: " + dir );
                for (String asset : assets) {
                    copyAssets(path + "/" + asset, outPath, context);
                }
            }
        } catch (IOException ex) {
            Log.e("TAG", "I/O Exception", ex);
        }
    }

    private void copyFile(String filename, String outPath) {
        AssetManager assetManager = context.getAssets();

        InputStream in;
        OutputStream out;
        try {
            in = assetManager.open(filename);
            String newFileName = outPath + "/" + filename;
            out = new FileOutputStream(newFileName);

            byte[] buffer = new byte[1024];
            int read;
            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
            in.close();
            out.flush();
            out.close();
            Toast.makeText(context, "Đang tải", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Log.e("TAG", e.getMessage());
        }

    }
}