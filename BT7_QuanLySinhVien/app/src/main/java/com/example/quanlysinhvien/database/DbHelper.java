package com.example.quanlysinhvien.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(@Nullable Context context) {
        super(context, "QLSinhVien.sqlite", null, 1);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlSVCreate = "CREATE TABLE IF NOT EXISTS " +
                "SinhVien(MaSV INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "HoTen NVARCHAR (200), "+
                "GioiTinh INTEGER ,"+
                "DienThoai VARCHAR (13),"+
                "Email VARCHAR(200))";

        db.execSQL(sqlSVCreate);

        String sqlSVInsert = "INSERT INTO SinhVien(HoTen,GioiTinh,DienThoai,Email) VALUES('Lê Hoàng Anh Tuấn',1,'0917480604','tuan@gmail.com')";


        db.execSQL(sqlSVInsert);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
