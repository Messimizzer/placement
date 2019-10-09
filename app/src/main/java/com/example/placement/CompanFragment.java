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

public class CompanFragment extends Fragment {
    DatabaseHelperCompany db;
    EditText compname, location, payscale, bond;
    Button addcomp, viewcomp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_company,container,false);
    }
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        db=new DatabaseHelperCompany(this.getActivity());
        compname=(EditText)getView().findViewById(R.id.compname);
        location=(EditText)getView().findViewById(R.id.location);
        payscale=(EditText)getView().findViewById(R.id.payscale);
        bond=(EditText)getView().findViewById(R.id.bond);
        addcomp=(Button)getView().findViewById(R.id.addcomp);
        viewcomp=(Button)getView().findViewById(R.id.viewcomp);
        addData();

    }

    public void addData() {
        addcomp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.insert
                        (compname.getText().toString(),
                location.getText().toString(),
                        payscale.getText().toString(),
                        bond.getText().toString());


            }
        });
    }
}
