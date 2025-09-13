package me.gonzager.ex.tiposDeConduccion;

public interface TipoConduccion {
    Double consumo();

    Double velocidadMaxima();

    TipoConduccion siguiente();

    TipoConduccion anterior();

}