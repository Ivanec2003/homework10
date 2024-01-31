package com.example.homework10.listUsers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homework10.R;

import java.util.ArrayList;

public class ListUsersAdapter extends RecyclerView.Adapter<ListUsersAdapter.MyViewHolder> {
    private final ArrayList<User> data;
    private OnClickListener onClickListener;

    public ListUsersAdapter(ArrayList<User> data) {
        this.data = data;
    }
    public void updateData(ArrayList<User> newData){
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new MyDiifUtillCallBack(this.data, newData));
        this.data.clear();
        this.data.addAll(newData);
        diffResult.dispatchUpdatesTo(this);
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user = data.get(position);
        holder.bind(user);
        holder.itemView.setOnClickListener(v -> {
            if (onClickListener != null) {
                if (position != RecyclerView.NO_POSITION) {
                    onClickListener.onItemClick(position, user);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewNameUser;
        MyViewHolder(View view) {
            super(view);
            textViewNameUser = view.findViewById(R.id.textViewNameUser);
        }
        void bind(User user){
            textViewNameUser.setText(user.getName());
        }
    }
    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener {
        void onItemClick(int position, User user);
    }
}
