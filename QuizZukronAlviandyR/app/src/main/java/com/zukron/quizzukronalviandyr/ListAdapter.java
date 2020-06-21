package com.zukron.quizzukronalviandyr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter {
    Makanan[] listMakanan;
    LayoutInflater inflater;

    public ListAdapter(Context context, Makanan[] listMakanan) {
        this.inflater = LayoutInflater.from(context);
        this.listMakanan = listMakanan;
    }

    @Override
    public int getCount() {
        return listMakanan.length;
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
        convertView = inflater.inflate(R.layout.list_item, null);

        TextView tvNoItem = convertView.findViewById(R.id.no_item);
        ImageView ivImg = convertView.findViewById(R.id.iv_img);
        TextView tvTitle = convertView.findViewById(R.id.tv_title);
        TextView tvDescription = convertView.findViewById(R.id.tv_description);
        TextView tvPrice = convertView.findViewById(R.id.tv_price);

        tvNoItem.setText(listMakanan[position].getNo());
        ivImg.setImageResource(listMakanan[position].getImg());
        tvTitle.setText(listMakanan[position].getTitle());
        tvDescription.setText(listMakanan[position].getDescription());
        tvPrice.setText(listMakanan[position].getPrice());

        return convertView;
    }
}
