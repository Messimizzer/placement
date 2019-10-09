package com.example.placement;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PlacementFragment extends Fragment {
    DatabasesHelperPlacement db;
    EditText name, rollno, marks10, marks12, graduation, pgraduation;
    Button addstud, viewstud;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_placement, container, false);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

       db=new DatabasesHelperPlacement(this.getActivity());
        name = (EditText) getView().findViewById(R.id.name);
        rollno = (EditText) getView().findViewById(R.id.rollno);
        marks10 = (EditText) getView().findViewById(R.id.marks10);
        marks12 = (EditText) getView().findViewById(R.id.marks12);
        graduation = (EditText) getView().findViewById(R.id.graduation);
        pgraduation = (EditText) getView().findViewById(R.id.pgraduation);
        addstud = (Button) getView().findViewById(R.id.addstud);
        viewstud = (Button) getView().findViewById(R.id.viewstud);
        addstud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = name.getText().toString();
                String s2 = rollno.getText().toString();
                String s3 = marks10.getText().toString();
                String s4 = marks12.getText().toString();
                String s5 = graduation.getText().toString();
                String s6 = pgraduation.getText().toString();
                if (s1.equals("") || s2.equals("") || s3.equals("") || s4.equals("") || s5.equals("") || s6.equals("")) {
                    Toast.makeText(getContext(), "Fields Are Empty!", Toast.LENGTH_SHORT).show();
                } else {
                    if (s1.equals(s1)) {
                        boolean chkeroll = db.chkerol(s2);
                        if (chkeroll == true) {
                            boolean insert = db.insert(s1, s2, s3, s4, s5, s6);
                            if (insert == true)
                            {
                                Toast.makeText(getContext(), "Added Successfully", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(getContext(), "Candidate already exists!!", Toast.LENGTH_SHORT).show();
                            }
                        }

                    }
                }
            }
        });
    }
}

