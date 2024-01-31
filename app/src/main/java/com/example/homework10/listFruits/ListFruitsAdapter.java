package com.example.homework10.listFruits;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homework10.R;

import java.util.ArrayList;

public class ListFruitsAdapter extends RecyclerView.Adapter<ListFruitsAdapter.MyViewHolder> {
    private final ArrayList<Fruit> data;
    private OnClickListener onClickListener;

    public ListFruitsAdapter(ArrayList<Fruit> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fruit, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Fruit fruit = data.get(position);
        holder.bind(fruit);
        holder.itemView.setOnClickListener(v -> {
            if (onClickListener != null) {
                if (position != RecyclerView.NO_POSITION) {
                    onClickListener.onItemClick(position, fruit);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageViewFruit;
        MyViewHolder(View view) {
            super(view);
            imageViewFruit = view.findViewById(R.id.imageViewFruit);
        }
        void bind(Fruit fruit){
            imageViewFruit.setImageResource(fruit.getImage());
        }
    }
    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener {
        void onItemClick(int position, Fruit fruit);
    }
}
