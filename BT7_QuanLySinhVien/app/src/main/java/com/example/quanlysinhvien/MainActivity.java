package com.example.quanlysinhvien;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.quanlysinhvien.adapter.SinhVienAdapter;
import com.example.quanlysinhvien.dao.SinhVienDao;
import com.example.quanlysinhvien.model.SinhVien;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private  ListView lvSinhVien;
    private List<SinhVien> sinhVienList;
     private SinhVienAdapter adapter;
     SinhVienDao svDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvSinhVien = (ListView) findViewById(R.id.lv_sinhvien);

        svDao= new SinhVienDao(MainActivity.this);
        sinhVienList = new ArrayList<SinhVien>();
        sinhVienList=svDao.TatCaSinhVien();

//        SinhVien sv1 = new SinhVien(1,"Lê Hoàng Anh Tuấn",1,"0917480604","tuan@gmail.com");
//        SinhVien sv2 = new SinhVien(2,"Trần Kim Vũ",0,"0917480604","Vu@gmail.com");
//        sinhVienList.add(sv1);
//        sinhVienList.add(sv2);

        adapter = new SinhVienAdapter(getApplicationContext(),sinhVienList);
        lvSinhVien.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.menu_them){
            Intent intent = new Intent(MainActivity.this,AddActivity.class);
            startActivity(intent);

        }

        if(id==R.id.menu_thoat){
            finish();

        }

        return  true;
    }
}