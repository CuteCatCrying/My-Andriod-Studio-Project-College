package com.example.project7_zukron_alviandy_r.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.project7_zukron_alviandy_r.R;
import com.example.project7_zukron_alviandy_r.model.Food;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    private List<Food> foodList;
    private Context context;

    public FoodAdapter(Context context, List<Food> foodList) {
        this.context = context;
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public FoodAdapter.FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View cardItem = layoutInflater.inflate(R.layout.item_food, null);
        return new FoodViewHolder(cardItem);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food food = foodList.get(position);
        Glide.with(context).load(food.getGambar()).into(holder.ivItemFood);
        holder.tvItemFoodName.setText(food.getNama());
        holder.tvItemFoodDescription.setText(food.getKeterangan());
        holder.tvItemFoodPrice.setText("Harga : Rp. " + food.getHarga());
        holder.tvItemFoodPromo.setText("Promo : RP. " + food.getPromo());
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    static class FoodViewHolder extends RecyclerView.ViewHolder {
        ImageView ivItemFood;
        TextView tvItemFoodName;
        TextView tvItemFoodDescription;
        TextView tvItemFoodPrice;
        TextView tvItemFoodPromo;

        FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            this.ivItemFood = itemView.findViewById(R.id.iv_item_food);
            this.tvItemFoodName = itemView.findViewById(R.id.tv_item_food_name);
            this.tvItemFoodDescription = itemView.findViewById(R.id.tv_item_food_description);
            this.tvItemFoodPrice = itemView.findViewById(R.id.tv_item_food_price);
            this.tvItemFoodPromo = itemView.findViewById(R.id.tv_item_food_promo);
        }
    }
}
