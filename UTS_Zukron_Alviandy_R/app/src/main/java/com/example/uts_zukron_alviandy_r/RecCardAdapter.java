package com.example.uts_zukron_alviandy_r;

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

import java.util.List;

public class RecCardAdapter extends RecyclerView.Adapter<RecCardAdapter.ViewHolder> {
    private List<Hotel> hotelList;

    public RecCardAdapter(List<Hotel> hotelList) {
        this.hotelList = hotelList;
    }

    @NonNull
    @Override
    public RecCardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View cardItem = layoutInflater.inflate(R.layout.item_card_hotel, parent, false);
        return new ViewHolder(cardItem);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Hotel hotel = hotelList.get(position);
        holder.tvItemJenisKamar.setText(hotel.getJenisKamar());
        holder.ivItemGambarHotel.setImageResource(hotel.getImg());
        holder.tvItemHargaHotel.setText(hotel.getHarga());
        holder.cvItemHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailKamarActivity.class);
                intent.putExtra("Hotel", hotel);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return hotelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cvItemHotel;
        TextView tvItemJenisKamar;
        ImageView ivItemGambarHotel;
        TextView tvItemHargaHotel;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cvItemHotel = itemView.findViewById(R.id.cv_item_hotel);
            tvItemJenisKamar = itemView.findViewById(R.id.tv_item_jenis_kamar);
            ivItemGambarHotel = itemView.findViewById(R.id.iv_item_gambar_hotel);
            tvItemHargaHotel = itemView.findViewById(R.id.tv_item_harga_hotel);
        }
    }
}
