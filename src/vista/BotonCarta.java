package vista;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JButton;
import modelo.Carta;

public class BotonCarta extends JButton {

    private Carta carta;

    public BotonCarta() {
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(false);
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D dibujo = (Graphics2D) g.create();
        int ancho = getWidth();
        int alto = getHeight();
        boolean visible = carta != null && carta.estaDescubierta();
        dibujo.setColor(visible ? Color.WHITE : new Color(91, 57, 140));
        dibujo.fillRoundRect(4, 4, ancho - 8, alto - 8, 14, 14);
        dibujo.setColor(new Color(45, 34, 70));
        dibujo.drawRoundRect(4, 4, ancho - 8, alto - 8, 14, 14);
        if (visible) {
            try {
                Graphics2D cara = (Graphics2D) dibujo.create();
                try {
                    DibujosPokemon.dibujar(cara, carta.getId(), ancho, alto);
                } finally {
                    cara.dispose();
                }
            } catch (Exception e) {
                dibujo.setColor(Color.WHITE);
                dibujo.fillRoundRect(7, 7, ancho - 14, alto - 14, 12, 12);
                escribir(dibujo, carta.getNombre(), ancho, alto, Color.BLACK, 12);
            }
            if (carta.getPuntos() == 2) {
                dibujo.setColor(new Color(218, 165, 32));
                dibujo.setStroke(new BasicStroke(4));
                dibujo.drawRoundRect(6, 6, ancho - 12, alto - 12, 14, 14);
            }
        } else {
            escribir(dibujo, "?", ancho, alto, Color.WHITE, 26);
        }
        dibujo.dispose();
    }

    private void escribir(Graphics2D g, String texto, int ancho, int alto, Color color, int tamano) {
        g.setColor(color);
        g.setFont(new Font("SansSerif", Font.BOLD, tamano));
        FontMetrics medidas = g.getFontMetrics();
        int x = (ancho - medidas.stringWidth(texto)) / 2;
        int y = (alto + medidas.getAscent()) / 2 - 3;
        g.drawString(texto, x, y);
    }
}
