package me.gonzager.ex.vehiculos;

import me.gonzager.ex.tiposDeConduccion.Ecologica;
import me.gonzager.ex.tiposDeConduccion.TipoConduccion;

public class Vehiculo {
    private Double combustible;
    private Double kilometros = 0.0;
    private TipoConduccion tipoConduccion = new Ecologica();

    //contructor
    public Vehiculo(Double combustible) {
        if (combustible < 0) {
            throw new RuntimeException("La cantidad de combustible no puede ser negativa.");
        }
        this.combustible = combustible;
    }

    public Double velodadMaxima() {
        return this.tipoConduccion.velocidadMaxima();
    }

    public Double consumo() {
        return this.tipoConduccion.consumo();
    }

    public void desplazar(Double cantidadKilometros) {
        Double combustibleNecesario = cantidadKilometros * (1 / this.consumo());
        Double kilometrosPosibles = this.combustible * this.consumo();
        
        setKilometrajeTotal(kilometrosPosibles , cantidadKilometros);
        consumirCombustible(combustibleNecesario);

        if (cantidadKilometros > kilometrosPosibles)
            throw new RuntimeException("Combustible insuficiente, solo pude recorrer " + kilometrosPosibles
                    + " del total de " + cantidadKilometros + " kilometros.");
    }

    public void consumirCombustible(Double combustibleNecesario){
        this.combustible = Double.max(0.0, this.combustible - combustibleNecesario);
    }

    public void setKilometrajeTotal(Double kilometrosRecorridos , Double cantidadKilometros){
        this.kilometros += Double.min(cantidadKilometros, kilometrosRecorridos);
        System.out.println(this.kilometros);
    }
    
    public void retroceder() {
        this.tipoConduccion = this.tipoConduccion.anterior();
    }

    public void avanzar() {
        this.tipoConduccion = this.tipoConduccion.siguiente();
    }

    public Double getKilometros(){
        return this.kilometros;
    }

    public Double getCombustible(){
        return this.combustible;
    }
}
