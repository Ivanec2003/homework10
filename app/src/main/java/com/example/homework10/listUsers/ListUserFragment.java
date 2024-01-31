package com.example.homework10.listUsers;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homework10.R;
import com.example.homework10.databinding.FragmentListUserBinding;

import java.util.ArrayList;


public class ListUserFragment extends Fragment {
    private FragmentListUserBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentListUserBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
    private final ArrayList<User> listUser = new ArrayList<>();
    private ListUsersAdapter adapter;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(listUser.isEmpty()) {
            setListUsers();
        }
        adapter = new ListUsersAdapter(listUser);
        binding.listUsers.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.listUsers.setAdapter(adapter);

        adapter.setOnClickListener(((position, user) -> {
            Bundle bundle = new Bundle();
            bundle.putParcelable("User", user);
            DetailUserFragment fragment = new DetailUserFragment();
            fragment.setArguments(bundle);
            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment, "tagListUserFragment")
                    .addToBackStack(null)
                    .commit();
        }));
    }
    private void setListUsers(){
        listUser.add(new User(1, "Vlad2123", "Something description"));
        listUser.add(new User(2, "Max213", "Something description"));
        listUser.add(new User(3, "Use421r", "Something description"));
        listUser.add(new User(4, "Dan423", "Something description"));
        listUser.add(new User(5, "John123", "Something description"));
        listUser.add(new User(6, "Zak41", "Something description"));
        listUser.add(new User(7, "Nik123", "Something description"));
        listUser.add(new User(8, "User200", "Something description"));
        listUser.add(new User(9, "Max92", "Something description"));
        listUser.add(new User(10, "Zero3333", "Something description"));

    }
    public void updateUserData(User redactedUser) {
        listUser.set(redactedUser.getId(), redactedUser);
        adapter.updateData(listUser);
    }
}