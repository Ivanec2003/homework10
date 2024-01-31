package com.example.homework10.listContacts;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homework10.databinding.FragmentDetailContactBinding;

public class DetailContactFragment extends Fragment {

    private FragmentDetailContactBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailContactBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (this.getArguments() != null) {
            binding.textViewDetailContactName.setText(this.getArguments().getString("NameContact"));
            binding.textViewDetailContactPhoneNumber.setText(this.getArguments().getString("PhoneNumber"));
        }
    }
}