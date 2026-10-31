package principal;

import javax.swing.SwingUtilities;
import vista.VentanaInicio;

public class MAIN {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaInicio().setVisible(true));
    }
}
