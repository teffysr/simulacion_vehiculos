package me.gonzager.ex.vehiculos;

import me.gonzager.ex.tiposconduccion.Ecologica;
import me.gonzager.ex.tiposconduccion.TipoConduccion;

public class Vehiculo {
    private Double combustible;
    private Double kilometros = 0.0;
    private TipoConduccion tipoConduccion = new Ecologica();

    public Vehiculo(Double combustible) {
        if (combustible < 0) {
            throw new RuntimeException("La cantidad de combustible no puede ser negativa.");
        }
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
        Double kilometrosPosibles = this.combustible * this.tipoConduccion.consumo();
        this.kilometros += Double.min(cantKms, kilometrosPosibles);
        this.combustible = Double.max(0.0, this.combustible - combustibleNecesario);

        if (cantKms > kilometrosPosibles)
            throw new RuntimeException("Combustible insuficiente, solo pude recorrer " + kilometrosPosibles
                    + " del total de " + cantKms + " kilometros.");
    }

    public Double getCombustible() {
        return combustible;
    }

    public Double getKilomentros() {
        return kilometros;
    }

    public Double velodadMaxima() {
        return this.tipoConduccion.velocidadMaxima();
    }

    public Double consumo() {
        return this.tipoConduccion.consumo();
    }

}
