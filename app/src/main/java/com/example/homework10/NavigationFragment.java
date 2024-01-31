package com.example.homework10;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homework10.helloUserTask3.HelloUserFragment;
import com.example.homework10.listContacts.ListContactsFragment;
import com.example.homework10.listFruits.ListFruitsFragment;
import com.example.homework10.databinding.FragmentNavigationBinding;
import com.example.homework10.listUsers.ListUserFragment;

public class NavigationFragment extends Fragment {

    private FragmentNavigationBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNavigationBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @SuppressLint("CommitTransaction")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonNavigationListFruits.setOnClickListener(v -> getParentFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new ListFruitsFragment())
                .addToBackStack(null)
                .commit());

        binding.buttonNavigationListContacts.setOnClickListener(v -> getParentFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new ListContactsFragment())
                .addToBackStack(null)
                .commit());

        binding.buttonNavigationHelloUser.setOnClickListener(v -> getParentFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new HelloUserFragment())
                .addToBackStack(null)
                .commit());

        binding.buttonNavigationListUsers.setOnClickListener(v -> getParentFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new ListUserFragment())
                .addToBackStack(null)
                .commit());
    }
}