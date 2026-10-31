package modelo;

import excepciones.NombreInvalidoException;

public class Jugador {

    private String nombre;
    private int aciertos;
    private int puntos;

    public Jugador(String nombre) {
        this.nombre = nombre.trim();
    }

    public String getNombre() {
        return nombre;
    }

    public int getAciertos() {
        return aciertos;
    }

    public int getPuntos() {
        return puntos;
    }

    public void sumarPareja(int puntosPareja) {
        throw new UnsupportedOperationException("Persona 1: completar puntaje y aciertos");
    }

    public void reiniciar() {
        throw new UnsupportedOperationException("Persona 1: reiniciar puntos y aciertos");
    }

    public static void validarNombres(String nombre1, String nombre2) {
        if (nombre1 == null || nombre1.trim().isEmpty()) {
            throw new NombreInvalidoException("Escriba el nombre del jugador 1");
        }
        if (nombre2 == null || nombre2.trim().isEmpty()) {
            throw new NombreInvalidoException("Escriba el nombre del jugador 2");
        }
        if (nombre1.trim().length() > 20 || nombre2.trim().length() > 20) {
            throw new NombreInvalidoException("Los nombres deben tener hasta 20 caracteres");
        }
        if (nombre1.trim().equalsIgnoreCase(nombre2.trim())) {
            throw new NombreInvalidoException("Los jugadores deben tener nombres diferentes");
        }
    }
}
