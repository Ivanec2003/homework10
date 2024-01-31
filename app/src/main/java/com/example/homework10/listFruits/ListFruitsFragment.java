package com.example.homework10.listFruits;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.homework10.R;
import com.example.homework10.databinding.FragmentListFruitsBinding;

import java.util.ArrayList;

public class ListFruitsFragment extends Fragment {
    private FragmentListFruitsBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentListFruitsBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        return  binding.getRoot();
    }

    private final ArrayList<Fruit> listFruits = new ArrayList<>();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setListFruit();
        ListFruitsAdapter adapter = new ListFruitsAdapter(listFruits);
        binding.listFruit.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.listFruit.setAdapter(adapter);
        adapter.setOnClickListener((position, fruit) -> Toast.makeText(getActivity(), fruit.getName(), Toast.LENGTH_SHORT).show());

    }
    private void setListFruit(){
        listFruits.add(new Fruit("Apple", R.drawable.photo_apple));
        listFruits.add(new Fruit("Banana",R.drawable.photo_banana));
        listFruits.add(new Fruit("Pineapple",R.drawable.photo_pineapple));
        listFruits.add(new Fruit("Apple",R.drawable.photo_apple));
        listFruits.add(new Fruit("Banana",R.drawable.photo_banana));
        listFruits.add(new Fruit("Pineapple",R.drawable.photo_pineapple));

    }
}