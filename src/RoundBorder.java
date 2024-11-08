import javax.swing.border.Border;
import java.awt.*;

public class RoundBorder implements Border {
    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLUE); // Set border color
        g2.setStroke(new BasicStroke(2)); // Set border thickness
        g2.drawRoundRect(x, y, width - 1, height - 1, 15, 15); // Draw rounded rectangle
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(10, 10, 10, 10); // Define padding around the border
    }

    @Override
    public boolean isBorderOpaque() {
        return true; // Makes the border non-transparent
    }
}
