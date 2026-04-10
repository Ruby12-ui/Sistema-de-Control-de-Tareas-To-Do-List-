package vallegrande.edu.pe.gestordetareas.controlador;



import vallegrande.edu.pe.gestordetareas.modelo.Tarea;
import vallegrande.edu.pe.gestordetareas.vista.VistaTareas;

import javax.swing.*;
import java.util.ArrayList;

public class ControladorTareas {

    private VistaTareas vista;
    private ArrayList<Tarea> tareas;

    public ControladorTareas(VistaTareas vista) {
        this.vista = vista;
        this.tareas = new ArrayList<>();

        eventos();
    }

    private void eventos() {

        vista.btnAgregar.addActionListener(e -> agregarTarea());
        vista.btnEliminar.addActionListener(e -> eliminarTarea());
        vista.btnCompletar.addActionListener(e -> completarTarea());
        vista.btnFiltrar.addActionListener(e -> filtrarTareas());
    }

    private void agregarTarea() {
        String texto = vista.txtTarea.getText().trim();

        if (texto.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "No se permiten tareas vacías");
            return;
        }

        Tarea tarea = new Tarea(texto);
        tareas.add(tarea);

        actualizarLista();

        vista.txtTarea.setText("");
        JOptionPane.showMessageDialog(vista,
                "Tarea agregada");
    }

    private void eliminarTarea() {
        int index = vista.listaTareas.getSelectedIndex();

        if (index == -1) {
            JOptionPane.showMessageDialog(vista, "Selecciona una tarea");
            return;
        }

        tareas.remove(index);
        actualizarLista();

        JOptionPane.showMessageDialog(vista, "Tarea eliminada");
    }

    private void completarTarea() {
        int index = vista.listaTareas.getSelectedIndex();

        if (index == -1) {
            JOptionPane.showMessageDialog(vista, "Selecciona una tarea");
            return;
        }

        tareas.get(index).marcarCompletada();
        actualizarLista();

        JOptionPane.showMessageDialog(vista, "Tarea completada");
    }

    private void actualizarLista() {
        vista.modeloLista.clear();

        for (Tarea t : tareas) {
            vista.modeloLista.addElement(t.toString());
        }

        vista.lblTotal.setText("Total: " + tareas.size());
    }

    private void filtrarTareas() {
        String[] opciones = {"Todas", "Completadas", "Pendientes"};

        int opcion = JOptionPane.showOptionDialog(
                vista,
                "Filtrar tareas",
                "Filtro",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        vista.modeloLista.clear();

        for (Tarea t : tareas) {
            if (opcion == 1 && t.isCompletada()) {
                vista.modeloLista.addElement(t.toString());
            } else if (opcion == 2 && !t.isCompletada()) {
                vista.modeloLista.addElement(t.toString());
            } else if (opcion == 0) {
                vista.modeloLista.addElement(t.toString());
            }
        }
    }
}