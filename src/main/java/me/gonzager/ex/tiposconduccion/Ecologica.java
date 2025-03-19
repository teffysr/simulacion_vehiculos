package me.gonzager.ex.tiposconduccion;

public class Ecologica implements TipoConduccion {

    @Override
    public Double consumo() {
        return 16.0;
    }

    @Override
    public Double velocidadMaxima() {
        return 120.0;
    }

    @Override
    public TipoConduccion siguiente() {
        return new Estandar();
    }

    @Override
    public TipoConduccion anterior() {
        return this;
    }

}
