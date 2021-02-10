package com.example.chatsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chatsapp.databinding.ActivityPhoneNumberBinding;
import com.google.firebase.auth.FirebaseAuth;

public class PhoneNumberActivity extends AppCompatActivity {
    ActivityPhoneNumberBinding binding;
    Button continueBtn;
    EditText phoneBox;
    String str;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhoneNumberBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.phoneBox.requestFocus();
        continueBtn=findViewById(R.id.continueBtn);
        phoneBox=findViewById(R.id.phoneBox);
         auth=FirebaseAuth.getInstance();
        getSupportActionBar().hide();
       if(auth.getCurrentUser()!=null)
        {
            Intent intent=new Intent(PhoneNumberActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }



    }
    public void func(View view)
    {
        str=phoneBox.getText().toString();
        Intent intent=new Intent(this,OTP.class);
        intent.putExtra("val",str);
        startActivity(intent);




    }
}