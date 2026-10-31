package control;

import java.util.Random;
import modelo.Carta;
import modelo.Jugador;

public class JuegoMemoria extends Partida {

    private String[] nombres = {
        "Pikachu", "Bulbasaur", "Charmander", "Squirtle", "Eevee", "Jigglypuff",
        "Meowth", "Psyduck", "Snorlax", "Gengar", "Magikarp", "Ditto",
        "Vulpix", "Oddish", "Poliwag", "Cubone", "Mew", "Mewtwo"
    };
    private Random azar = new Random();

    @Override
    public void iniciar(String nombre1, String nombre2) {
        Jugador.validarNombres(nombre1, nombre2);
        jugadores[0] = new Jugador(nombre1);
        jugadores[1] = new Jugador(nombre2);
        cartas = new Carta[TOTAL_CARTAS];
        turno = 0;
        primera = -1;
        segunda = -1;
        bloqueada = false;
        terminada = false;
    }

    private void crearTablero() {
        throw new UnsupportedOperationException("Persona 2: crear las 18 parejas usando clone");
    }

    private void mezclar(int posicion) {
        throw new UnsupportedOperationException("Persona 2: completar mezcla recursiva");
    }

    private int contarEmparejadas(int posicion) {
        throw new UnsupportedOperationException("Persona 2: completar conteo recursivo");
    }

    @Override
    public void seleccionarCarta(int posicion) {
        throw new UnsupportedOperationException("Persona 2: completar seleccion de cartas");
    }

    @Override
    public boolean verificarPareja() {
        throw new UnsupportedOperationException("Persona 2: completar comparacion de cartas");
    }

    @Override
    public void resolverFallo() {
        throw new UnsupportedOperationException("Persona 2: ocultar cartas y cambiar turno");
    }

    @Override
    public void cambiarTurno() {
        throw new UnsupportedOperationException("Persona 2: completar cambio de turno");
    }

    @Override
    public boolean finalizar() {
        throw new UnsupportedOperationException("Persona 2: detectar las 36 cartas emparejadas");
    }

    @Override
    public String getResultado() {
        throw new UnsupportedOperationException("Persona 2: comparar puntos y devolver resultado");
    }
}
