package com.example.bt5_taolist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductListViewAdapter extends BaseAdapter {


    final ArrayList<Product> listProduct;

    ProductListViewAdapter(ArrayList<Product> listProduct) {
        this.listProduct = listProduct;
    }

    @Override
    public int getCount() {

        return listProduct.size();
    }

    @Override
    public Object getItem(int position) {

        return listProduct.get(position);
    }

    @Override
    public long getItemId(int position) {
        //Trả về một ID của phần
        return listProduct.get(position).productID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View viewProduct;
        if (convertView == null) {
            viewProduct = View.inflate(parent.getContext(), R.layout.product_view, null);
        } else viewProduct = convertView;


        //Bind sữ liệu phần tử vào View
        Product product = (Product) getItem(position);
        ((ImageView) viewProduct.findViewById(R.id.imgProduct)).setBackgroundResource(Integer.parseInt(String.format("%d",product.img)));
        ((TextView) viewProduct.findViewById(R.id.nameproduct)).setText(String.format("%s", product.name));
        ((TextView) viewProduct.findViewById(R.id.saleproduct)).setText(String.format(" - %d %%", product.sale));
        ((TextView) viewProduct.findViewById(R.id.priceproduct)).setText(String.format(" $%d", product.price));
        ((TextView)viewProduct.findViewById(R.id.statusproduct)).setText(String.format("%s", product.status));


        return viewProduct;
    }
}
