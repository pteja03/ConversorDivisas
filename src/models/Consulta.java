package models;

import com.google.gson.annotations.SerializedName;

public class Consulta {

    private double cantidad;
    @SerializedName(value = "base_code")
    private String de;
    @SerializedName("target_code")
    private String a;
    @SerializedName("conversion_result")
    private double resultado;
    @SerializedName("conversion_rate")
    private double rate;
    @SerializedName("time_last_update_utc")
    private String fecha;
    @SerializedName("result")
    private String satisfactorio;

    public String getSatisfactorio() {
        return satisfactorio;
    }

    public void setSatisfactorio(String satisfactorio) {
        this.satisfactorio = satisfactorio;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }


    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public double getCantidad() {
        return resultado/rate;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
}
