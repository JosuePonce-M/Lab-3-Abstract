package vista;

import control.JuegoMemoria;
import control.Partida;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VentanaInicio extends JFrame {

    private JTextField txtJugador1 = new JTextField();
    private JTextField txtJugador2 = new JTextField();
    private Partida partida = new JuegoMemoria();

    public VentanaInicio() {
        setTitle("Memoria Pokemon");
        setSize(440, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel(new BorderLayout(15, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 25, 20, 25));
        JLabel titulo = new JLabel("Memoria Pokemon", SwingConstants.CENTER);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 22));
        panel.add(titulo, BorderLayout.NORTH);
        JPanel datos = new JPanel(new GridLayout(2, 2, 10, 12));
        datos.add(new JLabel("Jugador 1"));
        datos.add(txtJugador1);
        datos.add(new JLabel("Jugador 2"));
        datos.add(txtJugador2);
        panel.add(datos, BorderLayout.CENTER);
        JButton btnIniciar = new JButton("Iniciar");
        btnIniciar.addActionListener(e -> iniciar());
        panel.add(btnIniciar, BorderLayout.SOUTH);
        add(panel);
    }

    private void iniciar() {
        try {
            partida.iniciar(txtJugador1.getText(), txtJugador2.getText());
            new VentanaJuego(partida).setVisible(true);
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
}
