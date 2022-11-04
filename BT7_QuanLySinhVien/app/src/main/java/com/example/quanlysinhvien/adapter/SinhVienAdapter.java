package com.example.quanlysinhvien.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quanlysinhvien.R;
import com.example.quanlysinhvien.model.SinhVien;

import java.util.List;

public class SinhVienAdapter extends BaseAdapter {
    private List<SinhVien> sinhVienList_320;
    private Context context_320;

    public SinhVienAdapter(Context context, List<SinhVien> listSinhVien_320) {
        this.context_320 = context_320;
        this.sinhVienList_320 = listSinhVien_320;

    }

    @Override
    public int getCount() {
        return sinhVienList_320.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            //convert resource to view
            LayoutInflater inflater = (LayoutInflater) context_320.getSystemService(context_320.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_sinhvien, null);

            //Ánh xạ
            viewHolder.tvMaSV = convertView.findViewById(R.id.tv_masv_320);
            viewHolder.tvHoTen = convertView.findViewById(R.id.tv_hoten_320);
            viewHolder.tvDienThoai = convertView.findViewById(R.id.tv_dienthoai_320);
            viewHolder.tvEmail = convertView.findViewById(R.id.tv_email_320);
            viewHolder.ivGioiTinh = convertView.findViewById(R.id.iv_gioitinh);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        SinhVien sv = sinhVienList_320.get(position);
        viewHolder.tvMaSV.setText("Mã sinh viên: " + sv.getMaSV());
        viewHolder.tvHoTen.setText("Họ tên: " + sv.getHoTen());
        viewHolder.tvDienThoai.setText("Mã sinh viên: " + sv.getDienThoai());
        viewHolder.tvEmail.setText("Mã sinh viên: " + sv.getEmail());
        if (sv.getGioiTinh() == 1)
            viewHolder.ivGioiTinh.setImageResource(R.drawable.man);
        if (sv.getGioiTinh() == 0)
            viewHolder.ivGioiTinh.setImageResource(R.drawable.woman);
        return convertView;
    }

    class ViewHolder {

        ImageView ivGioiTinh;
        TextView tvMaSV, tvHoTen, tvDienThoai, tvEmail;
    }
}
