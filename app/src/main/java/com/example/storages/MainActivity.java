package com.example.storages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
        public static final String mypreference="knpref";
        public static  final String Name="name";
        public static final String Email="email";
        SharedPreferences sharedPreferences;
        EditText name;
        EditText email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.namees);
        email=(EditText)findViewById(R.id.itEmail);
        sharedPreferences =getSharedPreferences(mypreference, Context.MODE_PRIVATE);

    }

    public void save(View view) {
        String n=name.getText().toString();
        String e=email.getText().toString();
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString(Name,n);
        editor.putString(Email,e);
        editor.commit();

    }

    public void clear(View view) {
        name=(EditText)findViewById(R.id.namees);
        email=(EditText)findViewById(R.id.itEmail);
        name.setText("");
        email.setText("");
        sharedPreferences=getSharedPreferences(mypreference,Context.MODE_PRIVATE);
    }

    public void Get(View view) {
        name=(EditText)findViewById(R.id.namees);
        email=(EditText)findViewById(R.id.itEmail);
        sharedPreferences=getSharedPreferences(mypreference,Context.MODE_PRIVATE);
        if (sharedPreferences.contains((Name))) {
            name.setText(sharedPreferences.getString(Name,""));
        }
        if (sharedPreferences.contains(Email)){
            email.setText(sharedPreferences.getString(Email,""));

        }

    }
}