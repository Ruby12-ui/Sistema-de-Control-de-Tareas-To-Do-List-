package vallegrande.edu.pe.gestordetareas.vista;

import javax.swing.*;
import java.awt.*;

public class VistaTareas extends JFrame {

    public JTextField txtTarea;
    public JButton btnAgregar, btnEliminar, btnCompletar, btnFiltrar;
    public DefaultListModel<String> modeloLista;
    public JList<String> listaTareas;
    public JLabel lblTotal;

    public VistaTareas() {
        setTitle("Gestor de Tareas");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        txtTarea = new JTextField(20);
        btnAgregar = new JButton("Agregar");
        btnEliminar = new JButton("Eliminar");
        btnCompletar = new JButton("Marcar completada");
        btnFiltrar = new JButton("Filtrar");

        modeloLista = new DefaultListModel<>();
        listaTareas = new JList<>(modeloLista);

        lblTotal = new JLabel("Total: 0");

        JPanel panel = new JPanel();
        panel.add(txtTarea);
        panel.add(btnAgregar);
        panel.add(btnEliminar);
        panel.add(btnCompletar);
        panel.add(btnFiltrar);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(listaTareas), BorderLayout.CENTER);
        add(lblTotal, BorderLayout.SOUTH);
    }
}