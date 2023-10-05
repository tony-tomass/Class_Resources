package com.mobile.fragmentexample;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.mobile.fragmentexample.model.Pet;

import java.util.LinkedList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayFragment extends Fragment {

    ListView listView;
    private PetViewModel petViewModel;

    public DisplayFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentRoot = inflater.inflate(R.layout.fragment_display, container, false);

        listView = fragmentRoot.findViewById(R.id.pet_listView);
        //LinkedList<Pet> pets = new LinkedList<>();
        /*
        pets.add(new Pet("Kenny", "Husky", 15));
        pets.add(new Pet("Roscoe", "Pomeranian", 1));
        pets.add(new Pet("Darwin", "Husky", 7));
        pets.add(new Pet("Luna", "Pomsky", 3));
        pets.add(new Pet("Bridey", "Golden Retriever", 2));
        pets.add(new Pet("Molly", "Pomeranian", 5));

         */

        //ArrayAdapter<Pet> adapter =  new ArrayAdapter<Pet>(getActivity(), android.R.layout.simple_list_item_1, pets);
        //listView.setAdapter(adapter);
        //Moved down to onChanged

        return fragmentRoot;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Get PetViewModel that exists for the context for the activity
        petViewModel = ViewModelProviders.of(getActivity()).get(PetViewModel.class);
        //Observe changes in the pets in the viewmodel
        petViewModel.getPets().observe(getViewLifecycleOwner(), new Observer<LinkedList<Pet>>() {
            @Override
            public void onChanged(LinkedList<Pet> pets) {
                ArrayAdapter<Pet> adapter =  new ArrayAdapter<Pet>(getActivity(), android.R.layout.simple_list_item_1, pets);
                listView.setAdapter(adapter);
            }
        });
    }
}
