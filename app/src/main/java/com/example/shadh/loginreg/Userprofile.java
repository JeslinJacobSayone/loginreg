package com.example.shadh.loginreg;

import com.example.shadh.loginreg.Person;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class Userprofile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);
        TextView fname = findViewById(R.id.tvfname);
        TextView sname = findViewById(R.id.tvsname);
        TextView phno = findViewById(R.id.tvphno);
        TextView email = findViewById(R.id.tvemail);
        fname.setText("First name  :  " + Person.getFname());
        sname.setText("Second name  :  " + Person.getSname());
        phno.setText("Phone Number  :  " + Person.getPhno());
        email.setText("Email  :  " + Person.getEmail());
    }
}
