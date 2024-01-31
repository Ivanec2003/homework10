package com.example.homework10.listUsers;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homework10.R;
import com.example.homework10.databinding.FragmentDetailUserBinding;


public class DetailUserFragment extends Fragment {
    private FragmentDetailUserBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailUserBinding.inflate(inflater, container, false);

        // Inflate the layout for this fragment
        return binding.getRoot();
    }
    private User user;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (this.getArguments() != null) {
            user = this.getArguments().getParcelable("User");
        }
        if (user != null) {
            binding.textViewDetailIdUser.setText(String.valueOf(user.getId()));
            binding.textViewDetailNameUser.setText(user.getName());
            binding.textViewDetailDescriptions.setText(user.getDescription());
        }

        EditUserFragment fragment = new EditUserFragment();
        fragment.setArguments(this.getArguments());
        binding.buttonNavigationEditUser.setOnClickListener(view1 -> getParentFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit());
    }
}