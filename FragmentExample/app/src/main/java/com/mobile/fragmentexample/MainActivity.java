package com.mobile.fragmentexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private PetViewModel petViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Look if there is an existing ViewModel of the PetViewModel class and give it
        //Otherwise, create one
        petViewModel = ViewModelProviders.of(this).get(PetViewModel.class);
    }

    public PetViewModel getPetViewModel() {
        return petViewModel;
    }
}
