package me.gonzager.ex.vehiculos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VehiculoTest {

    @Test
    void vehículoRetrocediendoYAvanzandoTiposDeConduccionDeberíaRetornarCorrectamenteLaVelocidad() {

        var vehiculo = new Vehiculo(3.0);

        vehiculo.retrocederTipoConduccion(); // Se queda en Ecologica
        vehiculo.avanzarTipoConduccion(); // Lo avanzo a Estandar
        vehiculo.avanzarTipoConduccion(); // Lo avanzo a Deportiva
        vehiculo.avanzarTipoConduccion(); // Se queda en Deportiva
        vehiculo.retrocederTipoConduccion(); // retrocede a Estandar

        assertEquals(150, vehiculo.velodadMaxima());
    }

    @Test
    void vehículoEnConduccionEstandarDeberíaAvanzarCorrectamenteYReducirElCombustible() {

        var vehiculo = new Vehiculo(25.0);

        vehiculo.avanzarTipoConduccion(); // Lo avanzo a Estandar
        vehiculo.desplazar(200.0);

        assertEquals(200.0, vehiculo.getKilomentros());
        assertEquals(5.0, vehiculo.getCombustible());
    }

    @Test
    void vehiculoEnConduccionDeportivaDeberíaLanzarUnaExcepcionSiNoHaySuficienteCombustible() {

        var vehiculo = new Vehiculo(13.0);

        vehiculo.avanzarTipoConduccion();
        vehiculo.avanzarTipoConduccion();

        assertThrows(
                RuntimeException.class,
                () -> {
                    vehiculo.desplazar(75.0);
                },
                "Combustible insuficiente, solo pude recorrer 65 del total de 75.0 kilometros.");
        assertEquals(65.0, vehiculo.getKilomentros());
        assertEquals(0.0, vehiculo.getCombustible());
    }

    @Test
    void valorDeCombustibleMenorACeroAlCrearVehiculoLanzaExcepcion() {

        assertThrows(
                RuntimeException.class,
                () -> {
                    new Vehiculo(-10.0);
                },
                "La cantidad de combustible no puede ser negativa.");
    }

    @Test
    void velocidadMaximaDiferenteSegunTipoDeConduccion() {

        var vehiculo = new Vehiculo(10.0);

        var velocidadEcologica = vehiculo.velodadMaxima();
        vehiculo.avanzarTipoConduccion(); // avanza a estandar
        var velocidadEstandar = vehiculo.velodadMaxima();
        vehiculo.avanzarTipoConduccion(); // avanza a deportiva
        var velocidadDeportiva = vehiculo.velodadMaxima();

        assertTrue(velocidadEcologica < velocidadEstandar);
        assertFalse(velocidadEstandar > velocidadDeportiva);
        assertNotEquals(velocidadEstandar, velocidadDeportiva);
    }
}
