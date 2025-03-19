package me.gonzager.ex.vehiculos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class VehiculoTest {

    @Test
    void vehículoRetrocediendoYAvanzadoTiposDeConduccionDeberíaRetronarCorrectamenteLaVelocidad() {
        var vehiculo = new Vehiculo(3.0);
        vehiculo.retrocederTipoConduccion(); // Se queda en Ecologica
        vehiculo.avanzarTipoConduccion(); // Lo avanzo a Estandar
        vehiculo.avanzarTipoConduccion(); // Lo avanzo a Deportiva
        vehiculo.avanzarTipoConduccion(); // Se queda en Deportiva
        vehiculo.retrocederTipoConduccion(); // retrocede a Estandar
        assertEquals(150, vehiculo.velodadMaxima());
    }

    @Test
    void vehículoEnConducionEstandarDeberíaAvanzarCorrectamenteYReducirElCombustible() {
        var vehiculo = new Vehiculo(25.0);
        vehiculo.avanzarTipoConduccion(); // Lo avanzo a Estandar
        vehiculo.desplazar(200.0);
        assertEquals(200.0, vehiculo.getKilomentros());
        assertEquals(5.0, vehiculo.getCombustible());
    }

    @Test
    void vehiculoEnConducionDeportivaDeberíaLanzarUnaExcepcionSiNoHaySuficienteCombustible() {
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
}
