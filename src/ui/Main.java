package ui;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaApp app = new VentanaApp();
                app.setVisible(true);
            }
        });
    }
}