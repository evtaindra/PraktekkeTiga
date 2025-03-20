package com.example.praktekketiga;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
TextView txtmainAkun;
Button btMainKeluar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EdgeToEdge.enable(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtmainAkun = findViewById(R.id.txtmainAkun);
        btMainKeluar = findViewById(R.id.btMainExit);
        String username = getIntent().getStringExtra("USERNAME");
        txtmainAkun.setText(txtmainAkun.getText().toString() + username);
        btMainKeluar.setOnClickListener(v ->{
            Intent i = new Intent(MainActivity.this, LoginActivity.class);
            new AlertDialog.Builder(this)
                    .setTitle("Konfirmasi")
                    .setMessage("Apakah Anda yakin ingin keluar?")
                    .setNegativeButton("Tidak", null)
                    .setPositiveButton("Ya", (dialog, which) ->{
                            // Hapus data username dari Intent
                            i.removeExtra("USERNAME");
                            // Tambahkan kode untuk keluar dari aplikasi di sini
                            startActivity(i);
                            finish(); // Tutup MainActivity setelah pindah
                })
                .show();
        });


    }
}