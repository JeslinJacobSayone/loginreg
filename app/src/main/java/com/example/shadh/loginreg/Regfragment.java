package com.example.shadh.loginreg;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * A simple {@link Fragment} subclass.
 */
public class Regfragment extends Fragment {
    Calendar myCalendar = Calendar.getInstance();
    EditText eedob;
    private Button btn;
    private Button sbtn;
    public EditText etfname, etsname, etemail, etphno, etdob, etusr, etrpassw, etrcpassw, etlusrn, etlpassw;
    public String s_etfname, s_etsname, s_etemail, s_etphno, s_etdob, s_etusr, s_etrpassw, s_etrcpassw, s_etlusrn, s_etlpassw;
    public static final Pattern VALID_PASSWOLD_REGEX_ALPHA_NUM
            = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$");
    public static final Pattern VALID_EMAIL_REGEX_ALPHA_NUM
            = Pattern.compile("[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?");

    public static final Pattern VALID_PHONE_REGEX_NUM
            = Pattern.compile("^(\\+91[\\-\\s]?)?[0]?(91)?[789]\\d{9}$");

    public static final Pattern VALID_DOB_NUM
            = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");


    public Regfragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_regfragment, container, false);


        {
            etfname = view.findViewById(R.id.etregfname);
            etsname = view.findViewById(R.id.etregsname);
            etemail = view.findViewById(R.id.etregemail);
            etphno = view.findViewById(R.id.etregphone);
            etdob = view.findViewById(R.id.etregdate);
            etusr = view.findViewById(R.id.etregusern);
            etrpassw = view.findViewById(R.id.etregpass);
            etrcpassw = view.findViewById(R.id.etregcpass);
            etlusrn = view.findViewById(R.id.etlogusern);
            etlpassw = view.findViewById(R.id.etlogpass);

            eedob = view.findViewById(R.id.etregdate);
            final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear,
                                      int dayOfMonth) {
                    // TODO Auto-generated method stub
                    myCalendar.set(Calendar.YEAR, year);
                    myCalendar.set(Calendar.MONTH, monthOfYear);
                    myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    updateLabel();
                }

            };
            eedob.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    new DatePickerDialog(getActivity(), date, myCalendar
                            .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                            myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                }
            });


            sbtn = view.findViewById(R.id.submit);
            sbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    boolean res = validate();
                    if (res) {
                        Person person = new Person();
                        person.putdetails(s_etfname, s_etsname, s_etdob, s_etphno, s_etusr, s_etrpassw, s_etemail);
                        MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new Logfragment(), null).addToBackStack(null).commit();

                    } else {
                        Log.d("false", "error validation");
                    }
                }
            });


        }
        btn = view.findViewById(R.id.btnloginreg);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Log.d("testing shadh","inside button click");
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new Logfragment(), null).addToBackStack(null).commit();
            }
        });
        return view;
    }


    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        eedob.setText(sdf.format(myCalendar.getTime()));
    }

    public boolean validate() {
        Log.d("validation***", "inside validation");

        boolean res = true;
        s_etfname = etfname.getText().toString().trim();
        s_etsname = etsname.getText().toString().trim();
        s_etemail = etemail.getText().toString().trim();
        s_etphno = etphno.getText().toString().trim();
        s_etdob = etdob.getText().toString().trim();
        s_etusr = etusr.getText().toString().trim();
        s_etrpassw = etrpassw.getText().toString().trim();
        s_etrcpassw = etrcpassw.getText().toString().trim();

        if (s_etfname.length() == 0) {
            etfname.setError("First name cant be Empty");
            res = false;
        }
        if (s_etsname.length() == 0) {
            etsname.setError("Second name cant be Empty");
            res = false;

        }
        if (!validatePhone(s_etphno)) {
            etphno.setError("Invalid phone number entry");
            res = false;

        }

        if (!validateEmail(s_etemail)) {
            etemail.setError("Invalid Email entry");
            res = false;
        }


        if (!validatePassword(s_etrpassw)) {
            etrcpassw.setError("Invalid Password entry");
            res = false;
        }
        if (s_etusr.length() == 0) {
            etusr.setError("username cant be Empty");
            res = false;

        }
        if (s_etrcpassw.length() == 0) {
            etrcpassw.setError("Password cant be empty");
            res = false;
        } else {
            if (s_etrpassw.equals(s_etrcpassw)) {


            } else {
                etrcpassw.setError("Passwords doesnt match");
                res = false;
            }
        }
        return res;


    }

    public static boolean validatePassword(String val) {
        Log.d("testing password", "password" + val);

        Matcher matcher = VALID_PASSWOLD_REGEX_ALPHA_NUM.matcher(val);
        return matcher.matches();
    }

    public static boolean validateEmail(String val) {
        Log.d("testing Email", "Email" + val);
        Matcher matcher = VALID_EMAIL_REGEX_ALPHA_NUM.matcher(val);
        Log.d("email comparison", "matcher result" + matcher.matches());
        return matcher.matches();
    }

    public static boolean validatePhone(String val) {
        Log.d("testing phone", "phone number" + val);
        Matcher matcher = VALID_PHONE_REGEX_NUM.matcher(val);
        return matcher.matches();
    }


}



