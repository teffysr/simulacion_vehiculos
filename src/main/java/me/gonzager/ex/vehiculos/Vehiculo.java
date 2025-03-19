package me.gonzager.ex.vehiculos;

import me.gonzager.ex.tiposconduccion.Ecologica;
import me.gonzager.ex.tiposconduccion.TipoConduccion;

public class Vehiculo {
    private Double combustible;
    private Double kilomentros = 0.0;
    private TipoConduccion tipoConduccion = new Ecologica();

    public Vehiculo(double combustible) {
        this.combustible = combustible;
    }

    public void avanzarTipoConduccion() {
        this.tipoConduccion = this.tipoConduccion.siguiente();
    }

    public void retrocederTipoConduccion() {
        this.tipoConduccion = this.tipoConduccion.anterior();
    }

    public void desplazar(Double cantKms) {
        Double combustibleNecesario = (1 / this.tipoConduccion.consumo()) * cantKms;
        double kilometrosPosibles = this.combustible / (1 / this.tipoConduccion.consumo());
        this.kilomentros += Double.min(cantKms, kilometrosPosibles);
        this.combustible = Double.max(0.0, this.combustible - combustibleNecesario);

        if (cantKms > kilometrosPosibles)
            throw new RuntimeException("Combustible insuficiente, solo pude recorrer " + kilometrosPosibles
                    + " del total de " + cantKms + " kilometros.");
    }

    public double getCombustible() {
        return combustible;
    }

    public double getKilomentros() {
        return kilomentros;
    }

    public Double velodadMaxima() {
        return this.tipoConduccion.velocidadMaxima();
    }

    public Double consumo() {
        return this.tipoConduccion.consumo();
    }

}
