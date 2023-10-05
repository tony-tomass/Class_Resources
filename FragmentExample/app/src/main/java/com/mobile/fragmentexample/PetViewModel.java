package com.mobile.fragmentexample;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mobile.fragmentexample.model.Pet;

import java.util.LinkedList;

public class PetViewModel extends ViewModel {

    //private LinkedList<Pet> petList;
    private MutableLiveData<LinkedList<Pet>> pets;

    // If you want to have multiple data:
    // Create MutableLiveData like below
    // private MutableLiveData<String> appname;
    // Then create the proper add, set, and get methods to do whatever for that data
    // Then you can use those anywhere in the activities

    public MutableLiveData<LinkedList<Pet>> getPets() {
        if (pets == null) {
            pets = new MutableLiveData<>();
            LinkedList<Pet> list = new LinkedList<>();
            list.add(new Pet("Kenny", "Husky", 15));
            list.add(new Pet("Roscoe", "Pomeranian", 1));
            list.add(new Pet("Darwin", "Husky", 7));
            list.add(new Pet("Luna", "Pomsky", 3));
            list.add(new Pet("Bridey", "Golden Retriever", 2));
            list.add(new Pet("Molly", "Pomeranian", 5));
            pets.setValue(list);
        }
        return pets;
    }

    public void addPet(Pet p) {
        LinkedList<Pet> list = pets.getValue();
        list.add(p);
        pets.setValue(list);
    }
}
