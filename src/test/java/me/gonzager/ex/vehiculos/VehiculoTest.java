package me.gonzager.ex.vehiculos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VehiculoTest {

    @Test
    void vehículoRetrocediendoYAvanzandoTiposDeConduccionDeberíaRetornarCorrectamenteLaVelocidad() {

        Vehiculo vehiculo = new Vehiculo(3.0);
        vehiculo.retroceder();
        for (int i = 0; i < 3; i++) {
            vehiculo.avanzar();
        }
        vehiculo.retroceder();

        assertEquals(150, vehiculo.velodadMaxima());
    }

    @Test
    void vehículoEnConduccionEstandarDeberíaAvanzarCorrectamenteYReducirElCombustible() {
        Vehiculo vehiculo = new Vehiculo(25.0);
        vehiculo.avanzar();
        vehiculo.desplazar(200.0);
        
        assertEquals(200.0, vehiculo.getKilometros());        
        assertEquals(5.0, vehiculo.getCombustible());
    }

    @Test
    void vehiculoEnConduccionDeportivaDeberíaLanzarUnaExcepcionSiNoHaySuficienteCombustible() {

        Vehiculo vehiculo = new Vehiculo(13.0);
        vehiculo.avanzar();
        vehiculo.avanzar();

        assertThrows(RuntimeException.class,() -> {
                    vehiculo.desplazar(75.0);
                },"Combustible insuficiente, solo pude recorrer 65 del total de 75.0 kilometros.");
       
        assertEquals(65.0, vehiculo.getKilometros());        
        assertEquals(0.0, vehiculo.getCombustible());
    }

    @Test
    void valorDeCombustibleMenorACeroAlCrearVehiculoLanzaExcepcion() {
        
        assertThrows(RuntimeException.class,() -> {
                    new Vehiculo(-10.0);
                },"La cantidad de combustible no puede ser negativa.");
        
    }

    @Test
    void velocidadMaximaDiferenteSegunTipoDeConduccion() {

        Vehiculo vehiculo = new Vehiculo(10.0);        
        Double velocidadEcologica = vehiculo.velodadMaxima();

        vehiculo.avanzar();
        Double velocidadEstandar = vehiculo.velodadMaxima();

        vehiculo.avanzar();
        Double velocidadDeportiva = vehiculo.velodadMaxima();
        vehiculo.avanzar();

        assertTrue(velocidadEcologica < velocidadEstandar);
        assertFalse(velocidadEstandar > velocidadDeportiva);
        assertNotEquals(velocidadEstandar, velocidadDeportiva);
    }
}
