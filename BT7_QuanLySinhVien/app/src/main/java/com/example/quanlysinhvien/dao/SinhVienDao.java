package com.example.quanlysinhvien.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlysinhvien.database.DbHelper;
import com.example.quanlysinhvien.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienDao {

    private DbHelper csdl;
    public SinhVienDao(Context context){
        csdl = new DbHelper(context);
    }

    public List<SinhVien> TatCaSinhVien(){
        String sql = "SELECT * FROM SinhVien";
        List<SinhVien> sinhVienList = new ArrayList<SinhVien>();
        SQLiteDatabase database = csdl.getReadableDatabase();
        Cursor cursor = database.rawQuery(sql, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int masv = cursor.getInt(0);
            String hoten = cursor.getString(1);
            int gioitinh = cursor.getInt(2);
            String dienthoai = cursor.getString(3);
            String email = cursor.getString(4);

            SinhVien sv = new SinhVien(masv,hoten,gioitinh,dienthoai,email);
            sinhVienList.add(sv);
            cursor.moveToNext();
        }
        return sinhVienList;
    }
}
