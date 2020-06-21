package com.zukron.project5_zukron_alviandy_r;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ProgrammingAdapter extends BaseAdapter {
    String[] progList;
    int[] imageIcon;
    Context context;
    LayoutInflater inflater;

    public ProgrammingAdapter(Context applicationContext, String[] progList, int[] imageIcon) {
        this.context = applicationContext;
        this.progList = progList;
        this.imageIcon = imageIcon;
        inflater = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return progList.length;
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
        convertView = inflater.inflate(R.layout.list_image, null);

        ImageView ivProgramming = convertView.findViewById(R.id.iv_programming);
        TextView tvProgramming = convertView.findViewById(R.id.tv_programming);
        ivProgramming.setImageResource(imageIcon[position]);
        tvProgramming.setText(progList[position]);

        return convertView;
    }
}
