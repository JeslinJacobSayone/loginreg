package com.example.shadh.loginreg;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Logfragment extends Fragment {
    private Button btn;
    public EditText etlusr, etlpassw;
    public String usern, passwrd;

    public Logfragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for his fragment

        View view = inflater.inflate(R.layout.fragment_logfragment, container, false);
        btn = view.findViewById(R.id.button);
        etlusr = view.findViewById(R.id.etlogusern);
        etlpassw = view.findViewById(R.id.etlogpass);
        Button shbtn=view.findViewById(R.id.shiftbutton);
        shbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(getActivity(),
                        TabbedActivity.class);
                startActivity(myIntent);

            }
        });



        Button btnreginlogi = view.findViewById(R.id.btnreginlog);
        btnreginlogi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new Regfragment(), null).addToBackStack(null).commit();

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Person person = new Person();

                usern = etlusr.getText().toString().trim();
                passwrd = etlpassw.getText().toString().trim();


                if (usern.equals(Person.getUsern()) && passwrd.equals(person.getPassw())) {
                    Intent intent = new Intent(getContext(), Userprofile.class);
                    startActivity(intent);


                } else {
                    Toast.makeText(getActivity(), "Login Failed, Please try again", Toast.LENGTH_SHORT).show();
                }

            }


        });
        return view;

    }

}
