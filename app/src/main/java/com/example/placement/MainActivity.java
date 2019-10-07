package com.example.placement;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText name, email, password, cpassword, gender, dob, phone;
    Button reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new DatabaseHelper(this);
        name=(EditText)findViewById(R.id.name);
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        cpassword=(EditText)findViewById(R.id.cpassword);
        gender=(EditText)findViewById(R.id.gender);
        dob=(EditText)findViewById(R.id.dob);
        phone=(EditText)findViewById(R.id.phone);
        reg=(Button)findViewById(R.id.reg);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=name.getText().toString();
                String s2=email.getText().toString();
                String s3=password.getText().toString();
                String s4=cpassword.getText().toString();
                String s5=gender.getText().toString();
                String s6=dob.getText().toString();
                String s7=phone.getText().toString();
                if(s1.equals("")|| s2.equals("")||s3.equals("")||s4.equals("")||s5.equals("")||s6.equals("")||s7.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(s3.equals(s3))
                    {
                        Boolean chkemail=db.chkemai(s2);
                        if(chkemail==true)
                        {
                            Boolean insert=db.insert(s1,s2,s3,s5,s6,s7);
                            if(insert==true)
                            {
                                Toast.makeText(getApplicationContext(), "Registered Successfully",Toast.LENGTH_SHORT).show();
                          db.close();
                            }

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "Email already exists!!", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
            }
        });
    }
}
