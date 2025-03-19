package me.gonzager.ex.tiposconduccion;

public interface TipoConduccion {
    Double consumo();

    Double velocidadMaxima();

    TipoConduccion siguiente();

    TipoConduccion anterior();
}
