package com.example.hamziii.boolawa;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.login.widget.LoginButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.squareup.picasso.Picasso;

public class Account extends AppCompatActivity
{

    private Button mLogOutBtn;
    private FirebaseAuth maAuth;
    private FirebaseAuth.AuthStateListener mAuthListner;
    private FirebaseAuth mAuth;
    private Button btnOut;
    private TextView txtEmail, txtUser;
    private ImageView imgProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        mAuth = FirebaseAuth.getInstance();
        btnOut = (LoginButton) findViewById(R.id.btnOut);
        txtUser = (TextView) findViewById(R.id.txtUser);
        txtEmail = (TextView) findViewById(R.id.txtEmail);
        imgProfile = (ImageView) findViewById(R.id.imgProfile);

        btnOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
            }
        });
        mAuthListner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {

                    for (UserInfo userInfo : user.getProviderData()) {
                        Log.d("TAG", userInfo.getProviderId());
                    }

                    txtUser.setText(user.getDisplayName());
                    txtEmail.setText(user.getEmail());
                    Picasso.with(Account.this).load(user.getPhotoUrl()).into(imgProfile);
                } else {
                    Intent intent = new Intent(Account.this, LoginActivity.class);
                    intent.putExtra("logout", true);
                    startActivity(intent);
                    finish();
                }

            }
        };
        maAuth = FirebaseAuth.getInstance();
        mAuthListner = new FirebaseAuth.AuthStateListener()
        {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth)
            {
                if (firebaseAuth.getCurrentUser()==null)
                {
                    startActivity(new Intent(Account.this, LoginActivity.class));
                }
            }
        };
        mLogOutBtn = (Button)findViewById(R.id.logOutBtn);

        mLogOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                maAuth.signOut();
            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListner);
    }
}
