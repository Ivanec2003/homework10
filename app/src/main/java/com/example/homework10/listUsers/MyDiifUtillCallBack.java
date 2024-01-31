package com.example.homework10.listUsers;

import androidx.recyclerview.widget.DiffUtil;

import java.util.ArrayList;

public class MyDiifUtillCallBack extends DiffUtil.Callback {
    private final ArrayList<User> oldList;
    private final ArrayList<User> newList;

    public MyDiifUtillCallBack(ArrayList<User> oldList, ArrayList<User> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).equals(newList.get(newItemPosition));
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        User oldUser = oldList.get(oldItemPosition);
        User newUser = newList.get(newItemPosition);
        return oldUser.getId() == newUser.getId() && oldUser.getName().equals(newUser.getName()) && oldUser.getDescription().equals(newUser.getDescription());
    }
}
