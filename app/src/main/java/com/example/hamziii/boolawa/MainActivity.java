package com.example.hamziii.boolawa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToLoginActivity(View view)
    {
        Intent  startNewActivity= new Intent(MainActivity.this,LoginActivity.class);
        startActivity(startNewActivity);

    }

    public void goToSignUpActivity(View view)
    {
        Intent startNewActivity = new Intent(MainActivity.this,SignUpActivity.class);
        startActivity(startNewActivity);

    }

}

