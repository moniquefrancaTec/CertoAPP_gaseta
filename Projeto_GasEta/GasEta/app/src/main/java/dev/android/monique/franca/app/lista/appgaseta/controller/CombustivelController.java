package dev.android.monique.franca.app.lista.appgaseta.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import dev.android.monique.franca.app.lista.appgaseta.view.MainActivity;
import dev.android.monique.franca.app.lista.appgaseta.model.Combustivel;

public class CombustivelController {

    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;

    public  static  final  String NOME_PREFERENCES ="pref_listavip";

    public CombustivelController(MainActivity mainActivity){

        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES,0);
        listaVip = preferences.edit();

    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "Controller iniciada....");
        return super.toString();
    }


    public void salvar(Combustivel combustivel) {
        Log.d("MVC_Controller", "Salvo: "+combustivel.toString());
        listaVip.putString("precoGasolina", String.valueOf(combustivel.getPrecoGasolina()));
        listaVip.putString("precoEtanol", String.valueOf(combustivel.getPrecoEtanol()));
        listaVip.putString("Resultado", String.valueOf(combustivel.getResultado()));
        listaVip.apply();

    }


    public  void limpar(Combustivel combustivel){
        listaVip.clear();
        listaVip.apply();
    }

    public  String calcular(Combustivel combustivel){

        double precoGasolina = combustivel.getPrecoGasolina();
        double precoEtanol = combustivel.getPrecoEtanol();
        double resultado = (precoEtanol/ precoGasolina)*100;
        String frase;

        if (resultado <=70){
            frase = String.format("Resultado: Melhor opção - Etanol  %.2f",resultado);
        } else {
            frase =String.format("Resultado: Melhor opção - Gasolina %.2f", resultado);
        }
        return frase;


    }








}
