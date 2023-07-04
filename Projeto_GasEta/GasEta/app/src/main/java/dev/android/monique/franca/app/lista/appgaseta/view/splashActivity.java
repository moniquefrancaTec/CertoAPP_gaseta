package dev.android.monique.franca.app.lista.appgaseta.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import dev.android.monique.franca.app.lista.appgaseta.R;

public class splashActivity extends AppCompatActivity {

    public static final int TIME_OUT_SPLASH =3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TelaSplash();

    }

    private void TelaSplash(){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent telaPrincipal = new Intent(splashActivity.this,MainActivity.class);
                startActivity(telaPrincipal);
                finish();

            }
        },TIME_OUT_SPLASH);

    }
}