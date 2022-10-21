package com.example.apptonghop;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProductListViewAdapter extends BaseAdapter {


    final ArrayList<Friend> listFriend;

    ProductListViewAdapter(ArrayList<Friend> listFriend) {
        this.listFriend = listFriend;
    }

    @Override
    public int getCount() {

        return listFriend.size();
    }

    @Override
    public Object getItem(int position) {

        return listFriend.get(position);
    }

    @Override
    public long getItemId(int position) {
        //Trả về một ID của phần
        return listFriend.get(position).id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View viewProduct;
        if (convertView == null) {
            viewProduct = View.inflate(parent.getContext(), R.layout.product_view, null);
        } else viewProduct = convertView;


        //Bind sữ liệu phần tử vào View
        Friend friend = (Friend) getItem(position);
        ((CircleImageView) viewProduct.findViewById(R.id.imgProduct)).setImageResource(Integer.parseInt(String.format("%d", friend.img)));
        ((TextView) viewProduct.findViewById(R.id.nameproduct)).setText(String.format("%s", friend.name));
        ((TextView) viewProduct.findViewById(R.id.priceproduct)).setText(String.format("%d người theo dõi", friend.follower));


        return viewProduct;
    }
}
