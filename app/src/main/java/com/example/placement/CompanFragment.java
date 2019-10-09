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
        compname=(EditText)getView().findViewById(R.id.compname);
        location=(EditText)getView().findViewById(R.id.location);
        payscale=(EditText)getView().findViewById(R.id.payscale);
        bond=(EditText)getView().findViewById(R.id.bond);
        addcomp=(Button)getView().findViewById(R.id.addcomp);
        viewcomp=(Button)getView().findViewById(R.id.viewcomp);
        addcomp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=compname.getText().toString();
                String s2=location.getText().toString();
                String s3=payscale.getText().toString();
                String s4=bond.getText().toString();
                if(s1.equals("")|| s2.equals("")||s3.equals("")||s4.equals(""))
                {
                    Toast.makeText(getContext(), "Fields are empty!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if (s1.equals(s1))
                    {
                        Boolean chkecompnam=db.chkecompname(s1);
                        if(chkecompnam==true)
                        {
                            Boolean insert=db.insert(s1,s2,s3,s4);
                            if(insert==true)
                            {
                                Toast.makeText(getContext(),"Company Data added successfully!",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(getContext(),"Company already exists!",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
            }
        });
    }
}
