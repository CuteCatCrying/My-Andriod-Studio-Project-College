package com.zukron.quizzukronalviandyr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    Makanan[] listMakanan;

    public RecyclerAdapter(Makanan[] listMakanan) {
        this.listMakanan = listMakanan;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        holder.tvNoItem.setText(listMakanan[position].getNo());
        holder.tvImg.setImageResource(listMakanan[position].getImg());
        holder.tvTitle.setText(listMakanan[position].getTitle());
        holder.tvDescription.setText(listMakanan[position].getDescription());
        holder.tvPrice.setText(listMakanan[position].getPrice());
    }

    @Override
    public int getItemCount() {
        return listMakanan.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNoItem;
        ImageView tvImg;
        TextView tvTitle;
        TextView tvDescription;
        TextView tvPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvNoItem = itemView.findViewById(R.id.no_item);
            this.tvImg = itemView.findViewById(R.id.iv_img);
            this.tvTitle = itemView.findViewById(R.id.tv_title);
            this.tvDescription = itemView.findViewById(R.id.tv_description);
            this.tvPrice = itemView.findViewById(R.id.tv_price);
        }
    }
}
