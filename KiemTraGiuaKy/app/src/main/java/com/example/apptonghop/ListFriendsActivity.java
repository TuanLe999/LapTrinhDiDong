package com.example.apptonghop;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class ListFriendsActivity extends AppCompatActivity {

    ArrayList<Friend> listFriend; //Mảng dữ liệu sản phẩm
    ProductListViewAdapter productListViewAdapter;
    ListView listViewProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_friends);

        //Nav
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setSelectedItemId(R.id.friend);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.friend:

                        return true;
                }
                return false;
            }
        });

        ImageButton signIn_btn =(ImageButton) findViewById(R.id.back_button);
        signIn_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListFriendsActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });


        listFriend = new ArrayList<>();
        listFriend.add(new Friend(1,R.drawable.hai_duong,  "Nguyễn Hải Dương", 1500,56, "Thích tập gym. Ước gì thứ anh nâng mỗi ngày là em chứ không phải tạ"));
        listFriend.add(new Friend(2,R.drawable.thanh_thuy,  "Thanh Thủy", 700,23 ,"Em thích hoa và trà vì nó xinh đẹp và ngọt ngào. Nhưng anh biết thứ gì còn xinh và ngọt hơn ko \n Là em đấy"));
        listFriend.add(new Friend(3,R.drawable.tien_dat,  "Tiến Đạt Trần", 2800,62 ,"Anh đã bỏ 25k để mua Tinder Gold chỉ để được gặp em đấy"));
        listFriend.add(new Friend(4,R.drawable.hong_anh,  "Hồng Ánh", 900,95, "Quoooaaaaa"));


        productListViewAdapter = new ProductListViewAdapter(listFriend);

        listViewProduct = findViewById(R.id.listproduct);
        listViewProduct.setAdapter(productListViewAdapter);

        listViewProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//               Lưu thông tin của friend
                String name = listFriend.get(position).getName();
                int ava = listFriend.get(position).getImg();
                int folower = listFriend.get(position).getFollower();
                int following = listFriend.get(position).getFollowing();
                String introduce = listFriend.get(position).getIntroduce();


//                Chuyển đến profile của friend
                Intent intent = new Intent(ListFriendsActivity.this, FriendProfileActivity.class);
//                Gói thông tin friend
                intent.putExtra("ten", name);
                intent.putExtra("anhdaidien", ava);
                intent.putExtra("ngtheodoi", folower);
                intent.putExtra("dangtheodoi",following);
                intent.putExtra("gioithieu", introduce);
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
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ListFriendsActivity.this);
        alertDialogBuilder.setTitle("Xác nhận!");
        alertDialogBuilder.setMessage("Bạn có muốn xóa ?");
        alertDialogBuilder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listFriend.remove(position);
                productListViewAdapter.notifyDataSetChanged();
                Toast.makeText(ListFriendsActivity.this, "Xóa thành công", Toast.LENGTH_LONG).show();
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