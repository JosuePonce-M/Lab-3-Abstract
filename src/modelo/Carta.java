package modelo;

public abstract class Carta implements Cloneable {

    private int id;
    private String nombre;
    private boolean descubierta;
    private boolean emparejada;

    public Carta(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean estaDescubierta() {
        return descubierta;
    }

    public boolean estaEmparejada() {
        return emparejada;
    }

    public void mostrar() {
        descubierta = true;
    }

    public void ocultar() {
        if (!emparejada) {
            descubierta = false;
        }
    }

    public void marcarEmparejada() {
        emparejada = true;
        descubierta = true;
    }

    public abstract int getPuntos();

    @Override
    public Carta clone() {
        throw new UnsupportedOperationException("Persona 1: completar clonacion de cartas");
    }
}
