package org.example.model;

public class Direccion {

    public String calle, comuna, region, dpto;
    public int numero;

    public Direccion(String calle, int numero, String dpto, String comuna, String region) {
        this.calle = calle;
        this.comuna = comuna;
        this.region = region;
        this.dpto = dpto;
        this.numero = numero;
    }

    public Direccion(String calle, int numero, String comuna, String region) {
        this.calle = calle;
        this.comuna = comuna;
        this.region = region;
        this.numero = numero;
    }

    @Override
    public String toString() {
        String departamento = (dpto==null) ? "S/N" : dpto;

        return calle + ", " + numero + ", dpto: " + departamento + ", " + comuna + ", " + region ;
    }
}
