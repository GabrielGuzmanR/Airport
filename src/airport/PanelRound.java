package airport;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * JPanel personalizado con bordes redondeados y características mejoradas
 */
public class PanelRound extends JPanel {
    private int radius = 30;
    private Color borderColor = null;
    private int borderThickness = 0;

    /**
     * Constructor que crea un panel transparente con bordes redondeados
     */
    public PanelRound() {
        setOpaque(false);
        setBorder(new EmptyBorder(5, 5, 5, 5)); // Margen interno por defecto
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        // Pintar el fondo redondeado
        Area area = new Area(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), radius, radius));
        
        g2.setColor(getBackground());
        g2.fill(area);

        // Pintar borde si está configurado
        if(borderColor != null && borderThickness > 0) {
            g2.setColor(borderColor);
            g2.setStroke(new java.awt.BasicStroke(borderThickness));
            g2.drawRoundRect(borderThickness/2, borderThickness/2, 
                           getWidth()-borderThickness, getHeight()-borderThickness, 
                           radius, radius);
        }

        g2.dispose();
        super.paintComponent(grphcs);
    }

    /**
     * Establece el radio de los bordes redondeados
     * @param radius Radio en píxeles
     */
    public void setRadius(int radius) {
        this.radius = radius;
        repaint();
    }

    /**
     * Obtiene el radio actual de los bordes redondeados
     * @return Radio en píxeles
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Establece el color de fondo del panel
     * @param color Color a aplicar
     */
    public void setColor(Color color) {
        setBackground(color);
        repaint();
    }

    /**
     * Establece un borde para el panel
     * @param color Color del borde
     * @param thickness Grosor del borde en píxeles
     */
    public void setBorder(Color color, int thickness) {
        this.borderColor = color;
        this.borderThickness = thickness;
        repaint();
    }

    /**
     * Elimina el borde del panel
     */
    public void removeBorder() {
        this.borderColor = null;
        this.borderThickness = 0;
        repaint();
    }
}