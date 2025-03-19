package com.example.praktekketiga;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button login, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.etLoginUsername);
        password = findViewById(R.id.etLoginPassword);
        login = findViewById(R.id.btLoginLogin);
        cancel = findViewById(R.id.btLoginCancel);

        cancel.setOnClickListener(v -> {
           new AlertDialog.Builder(this)
                   .setTitle("Konfirmasi")
                   .setMessage("Apakah Anda yakin ingin keluar?")
                   .setPositiveButton("Ya", (dialog, which) -> finish())
                   .setNegativeButton("Tidak", null)
                   .show();
        });
        login.setOnClickListener(v->{
            String user = username.getText().toString();
            String pass = password.getText().toString();
            if (user.isEmpty() || pass.isEmpty()){
                new AlertDialog.Builder(this)
                        .setTitle("Perhatian")
                        .setMessage("Username atau password tidak boleh kosong")
                        .setPositiveButton("OK", null)
                        .show();
            }
            else if(user.equals("admin") && pass.equals("admin")){
                // Buat Intent hanya jika login berhasil
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                i.putExtra("USERNAME", user);
                // Tampilkan AlertDialog sukses dan pindah ke MainActivity setelah OK ditekan
                new AlertDialog.Builder(this)
                        .setTitle("Selamat Datang")
                        .setMessage("Anda berhasil login")
                        .setPositiveButton("OK", (dialog, which) -> {
                            startActivity(i);
                            finish(); // Tutup LoginActivity setelah pindah
                        })
                        .show();
            }
            else {
                // AlertDialog untuk login gagal
                new AlertDialog.Builder(this)
                        .setTitle("Login Gagal")
                        .setMessage("Username atau password salah")
                        .setPositiveButton("OK", null)
                        .show();
            }
        });

    }
}