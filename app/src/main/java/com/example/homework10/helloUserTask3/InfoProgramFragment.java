package com.example.homework10.helloUserTask3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homework10.databinding.FragmentInfoProgramBinding;


public class InfoProgramFragment extends Fragment {
    private FragmentInfoProgramBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInfoProgramBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (this.getArguments() != null) {
            binding.textViewNameProgram.setText(this.getArguments().getString("NameProgram"));
            binding.textViewVersionProgram.setText(this.getArguments().getString("Version"));
        }
    }
}