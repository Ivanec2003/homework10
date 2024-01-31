package com.example.homework10.listContacts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homework10.R;


import java.util.ArrayList;

public class ListContactsAdapter extends RecyclerView.Adapter<ListContactsAdapter.MyViewHolder> {
    private final ArrayList<Contact> data;
    private OnClickListener onClickListener;

    public ListContactsAdapter(ArrayList<Contact> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Contact contact = data.get(position);
        holder.bind(contact);
        holder.itemView.setOnClickListener(v -> {
            if (onClickListener != null) {
                if (position != RecyclerView.NO_POSITION) {
                    onClickListener.onItemClick(position, contact);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return data.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewNameContact;
        private final TextView textViewNumberPhone;

        MyViewHolder(View view) {
            super(view);
            textViewNameContact = view.findViewById(R.id.textViewNameContact);
            textViewNumberPhone = view.findViewById(R.id.textViewNumberPhone);
        }
        void bind(Contact contact){
            textViewNameContact.setText(contact.getName());
            textViewNumberPhone.setText(contact.getPhoneNumber());
        }
    }
    public void setOnClickListener(ListContactsAdapter.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener {
        void onItemClick(int position, Contact contact);
    }
}
