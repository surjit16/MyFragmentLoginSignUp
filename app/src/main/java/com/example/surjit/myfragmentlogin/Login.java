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

public class Login extends Fragment {

    EditText username, password;
    Button login;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View a = getLayoutInflater().inflate(R.layout.login_fag, null);


        username = a.findViewById(R.id.username);
        password = a.findViewById(R.id.password);

        login = a.findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u = username.getText().toString();
                String p = password.getText().toString();
                if (u.isEmpty() || u == null) {
                    username.setError("Please enter username");
                } else if (p.isEmpty() || p == null) {
                    password.setError("Please enter password");
                } else {
                    int cnt = 0;
                    for (int i = 0; i < MainActivity.userData.size(); i = i + 2) {
                        if (u.equals(MainActivity.userData.get(i)) && p.equals(MainActivity.userData.get(i + 1))) {
                            Toast.makeText(getContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                            cnt = 1;
                            break;
                        }
                    }
                    if (cnt != 1) {
                        Toast.makeText(getContext(), "Incorrect username/password", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        return a;
    }
}
