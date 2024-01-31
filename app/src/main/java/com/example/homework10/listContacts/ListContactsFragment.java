package com.example.homework10.listContacts;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homework10.R;
import com.example.homework10.databinding.FragmentListContactsBinding;

import java.util.ArrayList;


public class ListContactsFragment extends Fragment {
    private FragmentListContactsBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentListContactsBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    private final ArrayList<Contact> listContacts = new ArrayList<>();
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(listContacts.isEmpty()) {
            setListContacts();
        }
        ListContactsAdapter adapter = new ListContactsAdapter(listContacts);
        binding.listContacts.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.listContacts.setAdapter(adapter);

        adapter.setOnClickListener((position, contact) -> {
            DetailContactFragment fragment = new DetailContactFragment();
            Bundle bundle = new Bundle();
            bundle.putString("NameContact", contact.getName());
            bundle.putString("PhoneNumber", contact.getPhoneNumber());
            fragment.setArguments(bundle);
            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();
        });
        binding.buttonAddContact.setOnClickListener(view1 -> {
            listContacts.add(new Contact("User", "+999 999 9999"));
            adapter.notifyItemInserted(listContacts.size());
        });
        binding.buttonDeleteContact.setOnClickListener(view12 -> {
            if (!listContacts.isEmpty()) {
                listContacts.remove(listContacts.size() - 1);
                adapter.notifyItemRemoved(listContacts.size());
            }
        });

    }
    private void setListContacts(){
        listContacts.add(new Contact("Vlad", "+096 888 8888"));
        listContacts.add(new Contact("Max", "+096 888 8888"));
        listContacts.add(new Contact("Dan", "+096 888 8888"));
        listContacts.add(new Contact("John", "+096 888 8888"));
        listContacts.add(new Contact("Vlad", "+096 888 8888"));
        listContacts.add(new Contact("Max", "+096 888 8888"));
        listContacts.add(new Contact("Dan", "+096 888 8888"));
        listContacts.add(new Contact("John", "+096 888 8888"));
    }
}