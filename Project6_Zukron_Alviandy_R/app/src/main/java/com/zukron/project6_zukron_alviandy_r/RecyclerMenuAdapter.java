package com.zukron.project6_zukron_alviandy_r;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerMenuAdapter extends RecyclerView.Adapter<RecyclerMenuAdapter.ViewRecHolder> {
    private RecyclerItemMenu[] listDataMenu;

    public RecyclerMenuAdapter(RecyclerItemMenu[] listDataMenu){
        this.listDataMenu = listDataMenu;
    }

    @NonNull
    @Override
    public ViewRecHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_recycler, parent, false);
        ViewRecHolder viewRecHolder = new ViewRecHolder(listItem);
        return viewRecHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerMenuAdapter.ViewRecHolder holder, int position) {
        final RecyclerItemMenu recyclerItemMenu = listDataMenu[position];
        holder.tvRecycler.setText(listDataMenu[position].getListMenu());
        holder.ivRecycler.setImageResource(listDataMenu[position].getImageMenu());
        holder.rlRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Item Selected: " + recyclerItemMenu.getListMenu(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listDataMenu.length;
    }

    class ViewRecHolder extends RecyclerView.ViewHolder {
        ImageView ivRecycler;
        TextView tvRecycler;
        RelativeLayout rlRecycler;

        public ViewRecHolder(@NonNull View itemView) {
            super(itemView);
            this.ivRecycler = (ImageView) itemView.findViewById(R.id.iv_recycler);
            this.tvRecycler = (TextView) itemView.findViewById(R.id.tv_recycler);
            this.rlRecycler = (RelativeLayout) itemView.findViewById(R.id.rl_recycler);
        }
    }
}
