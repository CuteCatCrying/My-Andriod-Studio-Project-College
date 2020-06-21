package com.example.calcchellenger;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private List<Angka> listAngka;
    private List<Integer> listHasil = new ArrayList<>();

    public RecyclerAdapter(List<Angka> listAngka) {
        this.listAngka = listAngka;
    }

    public List<Integer> getListHasil() {
        return listHasil;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(listItem, new CustomListener());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvAngka1.setText(String.valueOf(listAngka.get(position).getAngka1()));
        holder.tvAngka2.setText(String.valueOf(listAngka.get(position).getAngka2()));
    }

    @Override
    public int getItemCount() {
        return listAngka.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvAngka1;
        TextView tvAngka2;
        EditText etInput;

        public ViewHolder(@NonNull View itemView, CustomListener customListener) {
            super(itemView);

            tvAngka1 = itemView.findViewById(R.id.tv_angka1);
            tvAngka2 = itemView.findViewById(R.id.tv_angka2);
            etInput = itemView.findViewById(R.id.et_input);
            etInput.addTextChangedListener(customListener);
        }
    }

    private class CustomListener implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
//            listHasil.add(Integer.parseInt(s.toString()));
//            System.out.println(s.toString());

        }

        @Override
        public void afterTextChanged(Editable s) {
            System.out.println(s.toString());
        }
    }
}
