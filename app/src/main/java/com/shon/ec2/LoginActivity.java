package com.shon.ec2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.shon.ec2.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnLogin.setOnClickListener(view -> {
            //Toast.makeText(this, "Verificando Datos", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, PrincipalActivity.class);
            startActivity(intent);
            finish();
        });
        binding.tilEmail.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s , int start, int before, int cunt) {

            }

            @Override
            public void onTextChanged(CharSequence s , int start, int before, int cunt) {
                boolean Ok = ValidarDatos(s.toString(), binding.tilPassword.getEditText().getText().toString());
                binding.btnLogin.setEnabled(Ok);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.tilPassword.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s , int start, int before, int cunt) {

            }

            @Override
            public void onTextChanged(CharSequence s , int start, int before, int cunt) {
                boolean Ok = ValidarDatos(binding.tilEmail.getEditText().getText().toString(), s.toString());
                binding.btnLogin.setEnabled(Ok);
            }

            @Override
            public void afterTextChanged(Editable S) {

            }
        });
    }

    private boolean ValidarDatos(String email, String password) {
        boolean ValidadCorreo = !email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches();
        boolean ValidarContrasenia = password.length() >= 8;
        return ValidadCorreo && ValidarContrasenia;
    }
}