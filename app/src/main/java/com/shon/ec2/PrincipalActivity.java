package com.shon.ec2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;
import com.shon.ec2.databinding.ActivityPrincipalBinding;

public class PrincipalActivity extends AppCompatActivity {

    private ActivityPrincipalBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPrincipalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.fabAddMovie.setOnClickListener(view -> {
            Snackbar.make(binding.getRoot(), "Agregar Reservas", Snackbar.LENGTH_SHORT).show();
        });
        setSupportActionBar(binding.tbTrivago);
    }
}