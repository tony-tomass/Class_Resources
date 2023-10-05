package com.mobile.fragmentexample;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mobile.fragmentexample.model.Pet;

/**
 * A simple {@link Fragment} subclass.
 */
public class InputFragment extends Fragment {

    EditText nameText;
    EditText breedText;
    EditText ageText;
    private PetViewModel petViewModel;

    View.OnClickListener addListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String name = nameText.getText().toString();
            String breed = breedText.getText().toString();
            int age = Integer.parseInt(ageText.getText().toString());
            Pet p = new Pet(name, breed, age);
            petViewModel.addPet(p);
        }
    };

    public InputFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentActivity context = getActivity();
        LinearLayout rootView = new LinearLayout(context);
        rootView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        rootView.setOrientation(LinearLayout.VERTICAL);

        LinearLayout nameLayout = new LinearLayout(context);
        nameLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        nameLayout.setOrientation(LinearLayout.HORIZONTAL);
        TextView nameTextView = new TextView(getActivity());
        nameTextView.setText(R.string.name_label);
        nameText = new EditText(context);
        nameLayout.addView(nameTextView);
        nameLayout.addView(nameText);
        rootView.addView(nameLayout);

        LinearLayout breedLayout = new LinearLayout(context);
        breedLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        breedLayout.setOrientation(LinearLayout.HORIZONTAL);
        TextView breedTextView = new TextView(getActivity());
        breedTextView.setText(R.string.breed_label);
        breedText = new EditText(context);
        breedLayout.addView(breedTextView);
        breedLayout.addView(breedText);
        rootView.addView(breedLayout);

        LinearLayout ageLayout = new LinearLayout(context);
        ageLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        ageLayout.setOrientation(LinearLayout.HORIZONTAL);
        TextView ageTextView = new TextView(getActivity());
        ageTextView.setText(R.string.age_label);
        ageText = new EditText(context);
        ageText.setInputType(InputType.TYPE_CLASS_NUMBER);
        ageLayout.addView(ageTextView);
        ageLayout.addView(ageText);
        rootView.addView(ageLayout);

        Button addButton = new Button(context);
        addButton.setText("Add Pet");
        addButton.setOnClickListener(addListener);

        rootView.addView(addButton);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Get PetViewModel that exists for the context for the activity
        petViewModel = ViewModelProviders.of(getActivity()).get(PetViewModel.class);
    }
}
