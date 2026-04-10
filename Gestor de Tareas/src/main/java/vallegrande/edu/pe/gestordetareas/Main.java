package vallegrande.edu.pe.gestordetareas;

import vallegrande.edu.pe.gestordetareas.controlador.ControladorTareas;
import vallegrande.edu.pe.gestordetareas.vista.VistaTareas;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            VistaTareas vista = new VistaTareas();
            new ControladorTareas(vista);
            vista.setVisible(true);
        });
    }
}