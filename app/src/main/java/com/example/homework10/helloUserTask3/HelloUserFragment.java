package com.example.homework10.helloUserTask3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homework10.R;
import com.example.homework10.databinding.FragmentHelloUserBinding;

public class HelloUserFragment extends Fragment {

    private FragmentHelloUserBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHelloUserBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonNavigationInfoProgram.setOnClickListener(v -> {
            InfoProgramFragment fragment = new InfoProgramFragment();

            Bundle bundle = new Bundle();
            String name = "Name of program: Hello User";
            String version = "Version: 1.0.0";
            bundle.putString("NameProgram", name);
            bundle.putString("Version", version);
            fragment.setArguments(bundle);

            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();

        });
    }
}