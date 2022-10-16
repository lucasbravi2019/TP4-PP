package com.bravi.dispositivos;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Locale;

public class Pantalla extends JFrame {
    public static final String INVENTARIO = "Inventario";
    public static final String VEHICULO = "Vehículo";
    public static final String COMPONENTES = "Componentes";
    private JRadioButton inventarioRadio;
    private JRadioButton vehiculoRadio;
    private JRadioButton componentesRadio;
    private JPanel activacionPanel;
    private JButton inventarioCrearButton;
    private JPanel componentesPanel;
    private JPanel camposTexto;
    private JPanel appGui;
    private JList listaObjetos;
    private JTextField marcaInput;
    private JTextField pesoInput;
    private JTextField numeroInput;
    private JTextField precioInput;
    private JTextField cilindradaInput;
    private JTextField descripcionInput;
    private JTextField cilindrosInput;
    private JTextField colorInput;
    private JLabel listadoPropiedadesLabel;
    private JTextArea listadoPropiedadesTextArea;
    private JPanel marcaPanel;
    private JPanel vehiculoPanel;
    private JLabel vehiculoLabel;
    private JLabel inventarioLabel;
    private JLabel listaObjetosLabel;
    private JLabel carroceriaLabel;
    private JLabel motorLabel;
    private JLabel cilindradaLabel;
    private JLabel cilindrosLabel;
    private JLabel descripcionLabel;
    private JLabel colorLabel;
    private JPanel inventarioPanel;
    private JButton vehiculoCrearButton;
    private JButton mostrarEnTextAreaButton;
    private JButton componentesCrearButton;
    private JButton grabarButton;
    private DefaultListModel<String> model = new DefaultListModel<>();

    private Impresora impresora = new Impresora();

    public Pantalla() {
        addModelToList();
        addActionListeners();


    }

    private void addModelToList() {
        listaObjetos.setModel(model);
    }

    private void addActionListeners() {
        inventarioCrearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vehiculoPanel.setVisible(true);
                inventarioRadio.setEnabled(false);
                vehiculoRadio.setEnabled(true);
                marcaInput.setEditable(false);
                model.addElement(INVENTARIO);
                vehiculoRadio.setSelected(true);
            }
        });
        vehiculoCrearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vehiculoRadio.setEnabled(false);
                componentesRadio.setEnabled(true);
                pesoInput.setEditable(false);
                componentesPanel.setVisible(true);
                componentesRadio.setSelected(true);
                model.addElement(VEHICULO);
            }
        });
        componentesCrearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numeroInput.setEditable(false);
                precioInput.setEditable(false);
                cilindradaInput.setEditable(false);
                cilindrosInput.setEditable(false);
                descripcionInput.setEditable(false);
                colorInput.setEditable(false);
                grabarButton.setVisible(true);
                model.addElement(COMPONENTES);
            }
        });
        grabarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ObjetoResultanteDto dto = crearObjeto();
                try {
                    impresora.grabar(dto);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                resetInputs();
            }

            private ObjetoResultanteDto crearObjeto() {
                String marca = marcaInput.getText();
                int peso = Integer.parseInt(pesoInput.getText());
                int numero = Integer.parseInt(numeroInput.getText());
                float precio = Float.parseFloat(precioInput.getText());
                int cilindrada = Integer.parseInt(cilindradaInput.getText());
                int cilindros = Integer.parseInt(cilindrosInput.getText());
                String descripcion = descripcionInput.getText();
                String color = colorInput.getText();
                ObjetoResultanteDto objetoResultanteDto = new ObjetoResultanteDto(marca, peso, numero, precio,
                        cilindrada, cilindros, descripcion, color);
                return objetoResultanteDto;
            }

            private void resetInputs() {
                inventarioRadio.setEnabled(true);
                inventarioRadio.setSelected(true);
                vehiculoRadio.setEnabled(false);
                componentesRadio.setEnabled(false);
                marcaInput.setText("");
                pesoInput.setText("");
                numeroInput.setText("");
                precioInput.setText("");
                cilindradaInput.setText("");
                cilindrosInput.setText("");
                descripcionInput.setText("");
                colorInput.setText("");
                listadoPropiedadesTextArea.setText("");
                marcaInput.setEditable(true);
                pesoInput.setEditable(true);
                vehiculoPanel.setVisible(false);
                numeroInput.setEditable(true);
                precioInput.setEditable(true);
                cilindradaInput.setEditable(true);
                cilindrosInput.setEditable(true);
                descripcionInput.setEditable(true);
                colorInput.setEditable(true);
                componentesPanel.setVisible(false);
                model.clear();
                grabarButton.setVisible(false);
            }
        });
        mostrarEnTextAreaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = "Marca: " + marcaInput.getText()
                        + "\nPeso: " + pesoInput.getText()
                        + "\nNúmero: " + numeroInput.getText()
                        + "\nPrecio: " + precioInput.getText()
                        + "\nCilindrada: " + cilindradaInput.getText()
                        + "\nCilindros: " + cilindrosInput.getText()
                        + "\nDescripción: " + descripcionInput.getText()
                        + "\nColor: " + colorInput.getText();

                listadoPropiedadesTextArea.setText(result);
            }
        });
    }

    public JPanel getAppGui() {
        return appGui;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        appGui = new JPanel();
        appGui.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 4, new Insets(10, 10, 10, 10), -1, -1));
        appGui.setMinimumSize(new Dimension(800, 600));
        appGui.setPreferredSize(new Dimension(1280, 720));
        componentesPanel = new JPanel();
        componentesPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 5, new Insets(10, 10, 10, 10), -1, -1));
        componentesPanel.setVisible(false);
        appGui.add(componentesPanel, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        componentesPanel.setBorder(BorderFactory.createTitledBorder(null, "Componentes", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, this.$$$getFont$$$(null, -1, 22, componentesPanel.getFont()), null));
        numeroInput = new JTextField();
        componentesPanel.add(numeroInput, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        precioInput = new JTextField();
        precioInput.setText("");
        componentesPanel.add(precioInput, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        cilindradaLabel = new JLabel();
        cilindradaLabel.setText("Cilindrada");
        componentesPanel.add(cilindradaLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cilindradaInput = new JTextField();
        componentesPanel.add(cilindradaInput, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        descripcionLabel = new JLabel();
        descripcionLabel.setText("Descripción");
        componentesPanel.add(descripcionLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        carroceriaLabel = new JLabel();
        Font carroceriaLabelFont = this.$$$getFont$$$(null, -1, 22, carroceriaLabel.getFont());
        if (carroceriaLabelFont != null) carroceriaLabel.setFont(carroceriaLabelFont);
        carroceriaLabel.setText("Carrocería");
        componentesPanel.add(carroceriaLabel, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        motorLabel = new JLabel();
        Font motorLabelFont = this.$$$getFont$$$(null, -1, 22, motorLabel.getFont());
        if (motorLabelFont != null) motorLabel.setFont(motorLabelFont);
        motorLabel.setText("Motor");
        componentesPanel.add(motorLabel, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Número");
        componentesPanel.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Precio");
        componentesPanel.add(label2, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        descripcionInput = new JTextField();
        componentesPanel.add(descripcionInput, new com.intellij.uiDesigner.core.GridConstraints(2, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        cilindrosLabel = new JLabel();
        cilindrosLabel.setText("Cilindros");
        componentesPanel.add(cilindrosLabel, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cilindrosInput = new JTextField();
        componentesPanel.add(cilindrosInput, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        colorInput = new JTextField();
        componentesPanel.add(colorInput, new com.intellij.uiDesigner.core.GridConstraints(3, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        colorLabel = new JLabel();
        colorLabel.setText("Color");
        componentesPanel.add(colorLabel, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        componentesCrearButton = new JButton();
        componentesCrearButton.setText("Crear");
        componentesPanel.add(componentesCrearButton, new com.intellij.uiDesigner.core.GridConstraints(1, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        activacionPanel = new JPanel();
        activacionPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 3, new Insets(10, 10, 10, 10), -1, -1));
        appGui.add(activacionPanel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        activacionPanel.setBorder(BorderFactory.createTitledBorder(null, "Activación", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, this.$$$getFont$$$(null, -1, 22, activacionPanel.getFont()), null));
        inventarioRadio = new JRadioButton();
        inventarioRadio.setEnabled(true);
        inventarioRadio.setSelected(true);
        inventarioRadio.setText("Inventario");
        activacionPanel.add(inventarioRadio, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        vehiculoRadio = new JRadioButton();
        vehiculoRadio.setEnabled(false);
        vehiculoRadio.setText("Vehículo");
        activacionPanel.add(vehiculoRadio, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        componentesRadio = new JRadioButton();
        componentesRadio.setEnabled(false);
        componentesRadio.setText("Componentes");
        activacionPanel.add(componentesRadio, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        camposTexto = new JPanel();
        camposTexto.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 1, new Insets(15, 10, 5, 10), -1, -1));
        appGui.add(camposTexto, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        listadoPropiedadesLabel = new JLabel();
        listadoPropiedadesLabel.setText("Listado de propiedades");
        camposTexto.add(listadoPropiedadesLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        listadoPropiedadesTextArea = new JTextArea();
        camposTexto.add(listadoPropiedadesTextArea, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        inventarioPanel = new JPanel();
        inventarioPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 3, new Insets(0, 0, 0, 0), -1, -1));
        appGui.add(inventarioPanel, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        listaObjetos = new JList();
        final DefaultListModel defaultListModel1 = new DefaultListModel();
        listaObjetos.setModel(defaultListModel1);
        inventarioPanel.add(listaObjetos, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        marcaPanel = new JPanel();
        marcaPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 3, new Insets(0, 0, 0, 0), -1, -1));
        inventarioPanel.add(marcaPanel, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Marca");
        marcaPanel.add(label3, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        marcaInput = new JTextField();
        marcaPanel.add(marcaInput, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        inventarioLabel = new JLabel();
        Font inventarioLabelFont = this.$$$getFont$$$(null, -1, 16, inventarioLabel.getFont());
        if (inventarioLabelFont != null) inventarioLabel.setFont(inventarioLabelFont);
        inventarioLabel.setText("Inventario");
        marcaPanel.add(inventarioLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        inventarioCrearButton = new JButton();
        inventarioCrearButton.setText("Crear");
        marcaPanel.add(inventarioCrearButton, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        vehiculoPanel = new JPanel();
        vehiculoPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 3, new Insets(0, 0, 0, 0), -1, -1));
        vehiculoPanel.setVisible(false);
        inventarioPanel.add(vehiculoPanel, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Peso");
        vehiculoPanel.add(label4, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        pesoInput = new JTextField();
        vehiculoPanel.add(pesoInput, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        vehiculoLabel = new JLabel();
        Font vehiculoLabelFont = this.$$$getFont$$$(null, -1, 16, vehiculoLabel.getFont());
        if (vehiculoLabelFont != null) vehiculoLabel.setFont(vehiculoLabelFont);
        vehiculoLabel.setText("Vehículo");
        vehiculoPanel.add(vehiculoLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        vehiculoCrearButton = new JButton();
        vehiculoCrearButton.setText("Crear");
        vehiculoPanel.add(vehiculoCrearButton, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        listaObjetosLabel = new JLabel();
        listaObjetosLabel.setText("Seleccione un objeto creado");
        inventarioPanel.add(listaObjetosLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        mostrarEnTextAreaButton = new JButton();
        mostrarEnTextAreaButton.setText("Mostrar en Text Area");
        inventarioPanel.add(mostrarEnTextAreaButton, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        grabarButton = new JButton();
        grabarButton.setText("Grabar");
        grabarButton.setVisible(false);
        appGui.add(grabarButton, new com.intellij.uiDesigner.core.GridConstraints(1, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ButtonGroup buttonGroup;
        buttonGroup = new ButtonGroup();
        buttonGroup.add(inventarioRadio);
        buttonGroup.add(vehiculoRadio);
        buttonGroup.add(componentesRadio);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return appGui;
    }

}
