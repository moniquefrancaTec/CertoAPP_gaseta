package dev.android.monique.franca.app.lista.appgaseta.view;

import static dev.android.monique.franca.app.lista.appgaseta.R.layout.activity_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import dev.android.monique.franca.app.lista.appgaseta.R;
import dev.android.monique.franca.app.lista.appgaseta.controller.CombustivelController;
import dev.android.monique.franca.app.lista.appgaseta.model.Combustivel;

public class MainActivity extends AppCompatActivity {

    CombustivelController controllerCombustivel;
    Combustivel combustivel;


    EditText editPrecoGasolina;
    EditText editPrecoEtanol;
    TextView editResultado;

    Button btnbuton_limpar;
    Button btnbuton_salvar;
    Button btnbuton_Calcular;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_spinner);

        controllerCombustivel = new CombustivelController(MainActivity.this);
        controllerCombustivel.toString();

        combustivel = new Combustivel();

        editPrecoGasolina = findViewById(R.id.text_Precogasolina);
        editPrecoEtanol = findViewById(R.id.text_precoEtanol);
        editResultado =findViewById(R.id.txt_Resultado);


        btnbuton_limpar = findViewById(R.id.button_limpar);
        btnbuton_salvar = findViewById(R.id.button_salvar);
        btnbuton_Calcular = findViewById(R.id.button_Calcular);



        btnbuton_Calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editResultado.setText("");

                boolean dadosOk = true;

                if(TextUtils.isEmpty(editPrecoGasolina.getText())){
                    editPrecoGasolina.setError("Obrigatório");
                    editPrecoGasolina.requestFocus();
                    dadosOk = false;
                }
                if(TextUtils.isEmpty(editPrecoEtanol.getText())){
                    editPrecoEtanol.setError("Obrigatório");
                    editPrecoEtanol.requestFocus();
                    dadosOk = false;
                }

                if(dadosOk){
                    double precoGasolina = Double.parseDouble(String.valueOf(editPrecoGasolina.getText()));
                    double precoEtanol = Double.parseDouble(String.valueOf(editPrecoEtanol.getText()));
                    String fraseFinal;

                    combustivel.setPrecoGasolina(precoGasolina);
                    combustivel.setPrecoEtanol(precoEtanol);

                    fraseFinal = controllerCombustivel.calcular(combustivel);

                    editResultado.setText(fraseFinal);

                    btnbuton_salvar.setEnabled(true);

                }else{
                    Toast.makeText(MainActivity.this, "Digite os dados!", Toast.LENGTH_LONG).show();
                }



            }
        });

        btnbuton_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                combustivel.setPrecoEtanol(Double.parseDouble(String.valueOf(editPrecoEtanol.getText())));
                combustivel.setPrecoGasolina(Double.parseDouble(String.valueOf(editPrecoGasolina.getText())));
                combustivel.setResultado(editResultado.getText().toString());


                Toast.makeText(MainActivity.this, "Dados salvos com sucesso " + combustivel.toString(), Toast.LENGTH_LONG).show();

                controllerCombustivel.salvar(combustivel);
            }
        });

        btnbuton_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editPrecoGasolina.setText("");
                editPrecoEtanol.setText("");
                editResultado.setText("Resultado");

                controllerCombustivel.limpar(combustivel);
                btnbuton_salvar.setEnabled(false);

            }
        });






    }
}


