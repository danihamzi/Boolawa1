package com.example.hamziii.boolawa;

import android.content.Intent;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Hamziii on 8/14/2017.
 */

public class Users
{
    String u_id;
    String user_name;
    String user_email;
    String user_password;
    String user_retype_password;

    public Users(String u_id, String user_name, String user_email, String user_password, String user_retype_password) {
        this.u_id = u_id;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_retype_password = user_retype_password;

    }

   /* public String getId()

    {
        return u_id;
    }

    public String getUser_name()
    {
        return user_name;
    }

    public String getUser_email()
    {
        return user_email;
    }

    public String getUser_passeord()
    {
        return user_password;
    }

    public String getUser_retype_password()
    {
        return user_retype_password;
    }*/

}
