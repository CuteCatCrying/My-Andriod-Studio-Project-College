package com.zukron.project6_zukron_alviandy_r;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CardMenuAdapter extends RecyclerView.Adapter<CardMenuAdapter.ViewRecHolder> {
    private StoreData[] listStoreData;

    public CardMenuAdapter(StoreData[] listStoreData) {
        this.listStoreData = listStoreData;
    }

    @NonNull
    @Override
    public CardMenuAdapter.ViewRecHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View cardItem = layoutInflater.inflate(R.layout.item_data_detail, parent,false);
        ViewRecHolder viewRecHolder = new ViewRecHolder(cardItem);
        return viewRecHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardMenuAdapter.ViewRecHolder holder, int position) {
        final StoreData storeData = listStoreData[position];
        holder.imageView.setImageResource(storeData.getItemImg());
        holder.textView.setText(storeData.getItemTitle());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveWithObject = new Intent(v.getContext(), DetailItemActivity.class);
                moveWithObject.putExtra("storeData", storeData);
                v.getContext().startActivity(moveWithObject);
                Toast.makeText(v.getContext(), storeData.getItemTitle(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return listStoreData.length;
    }

    class ViewRecHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        CardView cardView;

        public ViewRecHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.iv_card);
            this.textView = itemView.findViewById(R.id.tv_card);
            this.cardView = itemView.findViewById(R.id.card_view);
        }
    }
}
