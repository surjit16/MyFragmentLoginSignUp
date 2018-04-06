package com.example.surjit.myfragmentlogin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by surji on 03-04-2018.
 */

public class SignUp extends Fragment {


    EditText username,password,conf;
    Button signup;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View a = getLayoutInflater().inflate(R.layout.sign_up_fag, null);

        username = a.findViewById(R.id.username);
        password = a.findViewById(R.id.password);
        conf = a.findViewById(R.id.confirm_password);

        signup = a.findViewById(R.id.signUp);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u = username.getText().toString();
                String p = password.getText().toString();
                String c = conf.getText().toString();
                if (u.isEmpty() || u == null)
                {
                    username.setError("Please enter username");
                }
                else if (p.isEmpty() || p == null){
                    password.setError("Please enter password");
                }
                else if (c.isEmpty() || c == null){
                    conf.setError("Please enter confirm password");
                }
                else if (!p.equals(c))
                {
                    password.setError("Password/Confirm Password does not matched");
                    conf.setError("Password/Confirm Password does not matched");
                }
                else if (p.equals(c)){
                    MainActivity.userData.add(u);
                    MainActivity.userData.add(p);
                    Toast.makeText(getContext(), "Sucessfully SignUp", Toast.LENGTH_SHORT).show();
                    a.findViewById(R.id.goto_another).callOnClick();
                }
            }
        });


        return a;
    }
}
