package com.example.hamziii.boolawa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class PasswordResetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_reset);
    }


    public void reset_display(View view)
    {
        Toast.makeText(this,"Password Has Been Reset",Toast.LENGTH_SHORT).show();

    }
}
