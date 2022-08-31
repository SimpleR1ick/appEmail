package com.example.appemail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtendo o id do botão
        Button btnEnviar = findViewById(R.id.btnEnviar);

        // Criando evento click do botão
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtendo o id dos campos email, assunto e texto
                EditText etEmail = findViewById(R.id.etEmail);
                EditText etAssunto = findViewById(R.id.etAssunto);
                EditText etTexto = findViewById(R.id.etTexto);

                // Obtendo os textos dentro dos campos e convertendo para string
                String email = etEmail.getText().toString();
                String assunto = etAssunto.getText().toString();
                String texto = etTexto.getText().toString();

                // Criando uma lista de emails
                String[] emails = {email};

                // Criando o intent
                Intent i = new Intent(Intent.ACTION_SENDTO);

                // Passando os atributos extras ao intent
                i.setData(Uri.parse("mailto:"));
                i.putExtra(Intent.EXTRA_EMAIL, emails);
                i.putExtra(Intent.EXTRA_SUBJECT, assunto);
                i.putExtra(Intent.EXTRA_TEXT, texto);

                startActivity(i);
            }
        });
    }
}