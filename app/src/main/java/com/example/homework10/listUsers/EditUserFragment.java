
package com.example.homework10.listUsers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.homework10.databinding.FragmentEditUserBinding;

import java.util.Objects;


public class EditUserFragment extends Fragment {

    private FragmentEditUserBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEditUserBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        assert this.getArguments() != null;
        User user = this.getArguments().getParcelable("User");
        if (user != null) {
            Objects.requireNonNull(binding.redactName.getEditText()).setText(user.getName());
            Objects.requireNonNull(binding.redactDescription.getEditText()).setText(user.getDescription());
        }

        ListUserFragment listUserFragment = (ListUserFragment) getParentFragmentManager().findFragmentByTag("listUserFragmentTag");
        binding.buttonEdit.setOnClickListener(view1 -> {
            if (user != null) {
                user.setName(binding.redactName.getEditText().getText().toString());
                user.setDescription(binding.redactDescription.getEditText().getText().toString());
                if (listUserFragment != null) {
                    listUserFragment.updateUserData(user);
                }
                getParentFragmentManager().popBackStack();
            }
        });

    }
}