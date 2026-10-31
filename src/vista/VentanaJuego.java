package vista;

import control.Partida;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import modelo.Carta;
import modelo.Jugador;

public class VentanaJuego extends JFrame {

    private Partida partida;
    private BotonCarta[] botones = new BotonCarta[Partida.TOTAL_CARTAS];
    private JLabel[] lblJugadores = new JLabel[2];
    private JLabel lblTurno = new JLabel();
    private JLabel lblEstado = new JLabel("Plantilla: faltan las reglas y los dibujos");
    private Timer pausa;

    public VentanaJuego(Partida partida) {
        this.partida = partida;
        setTitle("Tablero Pokemon");
        setSize(820, 780);
        setMinimumSize(new java.awt.Dimension(700, 660));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel principal = new JPanel(new BorderLayout(10, 10));
        principal.setBorder(BorderFactory.createEmptyBorder(30, 15, 15, 15));
        JPanel datos = new JPanel(new GridLayout(3, 1, 5, 5));
        for (int i = 0; i < lblJugadores.length; i++) {
            lblJugadores[i] = new JLabel();
            datos.add(lblJugadores[i]);
        }
        datos.add(lblTurno);
        principal.add(datos, BorderLayout.NORTH);
        JPanel tablero = new JPanel(new GridLayout(Partida.FILAS, Partida.COLUMNAS, 5, 5));
        for (int i = 0; i < botones.length; i++) {
            final int posicion = i;
            botones[i] = new BotonCarta();
            botones[i].addActionListener(e -> seleccionar(posicion));
            tablero.add(botones[i]);
        }
        principal.add(tablero, BorderLayout.CENTER);
        JPanel abajo = new JPanel(new BorderLayout(10, 10));
        JButton btnNueva = new JButton("Nueva partida");
        btnNueva.addActionListener(e -> nuevaPartida());
        abajo.add(lblEstado, BorderLayout.CENTER);
        abajo.add(btnNueva, BorderLayout.EAST);
        principal.add(abajo, BorderLayout.SOUTH);
        pausa = new Timer(1000, e -> resolverFallo());
        pausa.setRepeats(false);
        add(principal);
        actualizar();
    }

    private void seleccionar(int posicion) {
        try {
            throw new UnsupportedOperationException("Persona 3: conectar seleccion, pareja y temporizador");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void resolverFallo() {
        try {
            throw new UnsupportedOperationException("Persona 3: resolver el fallo al terminar la pausa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void mostrarResultado() {
        throw new UnsupportedOperationException("Persona 3: mostrar ganador o empate");
    }

    private void nuevaPartida() {
        try {
            throw new UnsupportedOperationException("Persona 3: detener la pausa y reiniciar la partida");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void actualizar() {
        for (int i = 0; i < lblJugadores.length; i++) {
            Jugador jugador = partida.getJugador(i);
            lblJugadores[i].setText(jugador.getNombre() + " | Aciertos: "
                    + jugador.getAciertos() + " | Puntos: " + jugador.getPuntos());
            lblJugadores[i].setForeground(i == partida.getTurno()
                    ? new Color(30, 95, 170) : Color.DARK_GRAY);
        }
        lblTurno.setText("Turno: " + partida.getJugador(partida.getTurno()).getNombre());
        for (int i = 0; i < botones.length; i++) {
            Carta carta = partida.getCarta(i);
            botones[i].setCarta(carta);
            botones[i].setEnabled(carta != null && !partida.estaBloqueada()
                    && !partida.estaTerminada() && !carta.estaDescubierta()
                    && !carta.estaEmparejada());
        }
    }
}
