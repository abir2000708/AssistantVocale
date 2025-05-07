package com.example.assistantvocal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ForgotPassword extends AppCompatActivity {
    private Button backtotignin;
    private EditText emailforgotpassword;
    private Button btnforgotpassword;
    private String inputEmailForgotPassword;
    private static final String REGEX_EMAIL = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_forgot_password);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        backtotignin = findViewById(R.id.back_to_sign_in);
        emailforgotpassword = findViewById(R.id.email_forgot_password);
        btnforgotpassword = findViewById(R.id.btn_forgot_password);


        backtotignin.setOnClickListener(v -> {
            startActivity(new Intent(this, SignInActivity.class));
            finish();
        });


        btnforgotpassword.setOnClickListener(v -> {
            if (validate()) {
                Toast.makeText(this, "Hello welcome back", Toast.LENGTH_SHORT).show();
            }


        });
    }


    private boolean validate() {
        boolean result = false;
        inputEmailForgotPassword = emailforgotpassword.getText().toString().trim();
        if (!isValidString(inputEmailForgotPassword, REGEX_EMAIL)) {
            emailforgotpassword.setError("Email is invalid !");
        } else {
            result = true;
        }
        return result;
    }

    private boolean isValidString(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher mtacher = pattern.matcher(input);
        return mtacher.matches();


    }



}

