package PaintComponents;

import models.Piece;

import javax.swing.*;
import java.awt.*;

public class PieceDraw extends JComponent {
    private final Image img;
    private final Piece piece;

    public PieceDraw(Piece piece) {
        this.piece = piece;
        this.img = piece.getImage();  // Assumes image is already loaded
    }

    public void draw(Graphics g, int width, int height) {
        // Draw the image scaled to the full square size
        g.drawImage(img, 0, 0, width, height, null);
    }
}
