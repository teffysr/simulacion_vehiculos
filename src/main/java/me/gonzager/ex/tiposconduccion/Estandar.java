package me.gonzager.ex.tiposconduccion;

public class Estandar implements TipoConduccion {

    @Override
    public Double consumo() {
        return 10.0;
    }

    @Override
    public Double velocidadMaxima() {
        return 150.0;
    }

    @Override
    public TipoConduccion siguiente() {
        return new Deportiva();
    }

    @Override
    public TipoConduccion anterior() {
        return new Ecologica();
    }

}
