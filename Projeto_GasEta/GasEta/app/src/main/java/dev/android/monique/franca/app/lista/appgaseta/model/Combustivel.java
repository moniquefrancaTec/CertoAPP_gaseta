package dev.android.monique.franca.app.lista.appgaseta.model;

public class Combustivel {
    private double precoGasolina;
    private double precoEtanol;
    private String resultado;

    public Combustivel() {
    }

    public double getPrecoGasolina() {
        return precoGasolina;
    }

    public void setPrecoGasolina(double precoGasolina) {
        this.precoGasolina = precoGasolina;
    }

    public double getPrecoEtanol() {
        return precoEtanol;
    }

    public void setPrecoEtanol(double precoEtanol) {
        this.precoEtanol = precoEtanol;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Combustível{" +
                "Preço gasolina = R$'" + precoGasolina + '\'' +
                ", Preço Etanoç= R$'" + precoEtanol + '\'' +
                ", Resultado='" + resultado + '}';
    }
}




