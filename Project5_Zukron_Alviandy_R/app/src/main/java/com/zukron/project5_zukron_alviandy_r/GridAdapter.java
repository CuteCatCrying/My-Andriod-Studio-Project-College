package com.zukron.project5_zukron_alviandy_r;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class GridAdapter extends BaseAdapter {
    Context context;
    int[] imageIcon;
    LayoutInflater inflater;

    public GridAdapter(Context applicationContext, int[] imageIcon) {
        this.context = applicationContext;
        this.imageIcon = imageIcon;
        inflater = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return imageIcon.length;
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
        convertView = inflater.inflate(R.layout.grid_image, null);

        ImageView img = convertView.findViewById(R.id.grid_image);
        img.setImageResource(imageIcon[position]);

        return convertView;
    }
}
