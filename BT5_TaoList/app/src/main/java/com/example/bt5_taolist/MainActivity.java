package com.example.bt5_taolist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Product> listProduct; //Mảng dữ liệu sản phẩm
    ProductListViewAdapter productListViewAdapter;
    ListView listViewProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listProduct = new ArrayList<>();
        listProduct.add(new Product(1,R.drawable.ggpixel4, "Google Pixel 4", 2199, "Hàng mới về", 5));
        listProduct.add(new Product(1,R.drawable.iphone7, "Apple Iphone 7 Plus", 500, "Hàng mới về", 5));
        listProduct.add(new Product(1,R.drawable.iphone14, "Apple Iphone 14 Plus", 2699, "Hàng mới về", 15));
        listProduct.add(new Product(1,R.drawable.xiaomi, "Xiaomi Redmi 10T", 1000, "Hàng mới về", 5));
        listProduct.add(new Product(1,R.drawable.ssflip4, "Samsung Galaxy Z Flip 4", 2500, "Hàng mới về", 5));


        productListViewAdapter = new ProductListViewAdapter(listProduct);

        listViewProduct = findViewById(R.id.listproduct);
        listViewProduct.setAdapter(productListViewAdapter);





        listViewProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });


        listViewProduct.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                return false;
            }
        });

        listViewProduct.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                confirmDelete(i);

                return false;
            }
        });

    }

    private void confirmDelete (final int position){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setTitle("Xác nhận!");
        alertDialogBuilder.setMessage("Bạn có muốn xóa ?");
        alertDialogBuilder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listProduct.remove(position);
                productListViewAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Xóa thành công", Toast.LENGTH_LONG).show();
            }
        });

        alertDialogBuilder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        alertDialogBuilder.show();
    }

}