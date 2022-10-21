package com.example.apptonghop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import de.hdodenhof.circleimageview.CircleImageView;

public class FriendProfileActivity extends AppCompatActivity {

    TextView name, follower, following, introduce;
    CircleImageView avata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_profile);

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
                        startActivity(new Intent(getApplicationContext(),ListFriendsActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });

//        Nhận gói từ ListFriend
        Intent intent = getIntent();
        String nd1 = (String)intent.getSerializableExtra("ten");
        int nd2 = (Integer) intent.getSerializableExtra("ngtheodoi");
        int nd3 = (Integer)intent.getSerializableExtra("anhdaidien");
        int nd4 = (Integer)intent.getSerializableExtra("dangtheodoi");
        String nd5 = (String)intent.getSerializableExtra("gioithieu") ;

        name = (TextView) findViewById(R.id.nameFriend);
        follower = (TextView) findViewById(R.id.followers);
        avata = (CircleImageView) findViewById(R.id.userImage);
        following = findViewById(R.id.following);
        introduce = findViewById(R.id.introduce);

        name.setText(nd1);
        follower.setText(String.valueOf(nd2) );
        avata.setImageResource(nd3);
        following.setText(String.valueOf(nd4) );
        introduce.setText(nd5);


        ImageButton back_btn = findViewById(R.id.back_button);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(FriendProfileActivity.this, ListFriendsActivity.class);
                startActivity(intent1);
            }
        });

    }
}