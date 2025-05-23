/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import vista.Pagos.PanelPagos;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import control.AdmDatos;
import control.UsuarioJpaController;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import modelo.Usuario;

/**
 *
 * @author carlo
 */
public class MainView extends javax.swing.JFrame {

    /**
     * Creates new form MainView
     */
    public MainView() {
        try {
            // Cargar la fuente Manrope desde los recursos
            InputStream is = getClass().getResourceAsStream("/fuentes/Manrope-Regular.ttf");
            if (is == null) {
                throw new IOException("No se encontró el archivo de fuente Manrope");
            }

            Font manrope = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(14f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(manrope);

            // Establecer la fuente como fuente predeterminada
            UIManager.put("defaultFont", manrope);

            // Configuración del tema FlatLaf
            FlatLaf.registerCustomDefaultsSource("mytheme"); // Si tienes un archivo .properties
            FlatMacLightLaf.setup();
            UIManager.setLookAndFeel(new FlatMacLightLaf());

        } catch (Exception ex) {
            System.err.println("Error al establecer FlatLaf o cargar la fuente: " + ex);
        }

        // Aplicar el nuevo Look & Feel al árbol de componentes
        SwingUtilities.updateComponentTreeUI(this);

        initComponents();
        panelContenedor.setLayout(new CardLayout());
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContenedor = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        inicioMenu = new javax.swing.JMenu();
        configMenu = new javax.swing.JMenu();
        recetasItem = new javax.swing.JMenu();
        pacienteItem = new javax.swing.JMenuItem();
        ExpedienteItem = new javax.swing.JMenuItem();
        tratamientoItem = new javax.swing.JMenuItem();
        Recetas = new javax.swing.JMenuItem();
        adminMenu = new javax.swing.JMenu();
        usuariosItem = new javax.swing.JMenuItem();
        pagosItem = new javax.swing.JMenuItem();
        facturasItem = new javax.swing.JMenuItem();
        invenItem = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        medicamentoItem = new javax.swing.JMenuItem();
        citasItem = new javax.swing.JMenuItem();
        notiMenu = new javax.swing.JMenu();
        sesionMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Estar Bien");
        setBackground(new java.awt.Color(255, 255, 255));
        setExtendedState(6);

        panelContenedor.setMaximumSize(new java.awt.Dimension(1397, 882));
        panelContenedor.setMinimumSize(new java.awt.Dimension(1397, 882));

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1397, Short.MAX_VALUE)
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 882, Short.MAX_VALUE)
        );

        getContentPane().add(panelContenedor, java.awt.BorderLayout.CENTER);

        inicioMenu.setText("Inicio");
        inicioMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inicioMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(inicioMenu);

        configMenu.setText("Configuracion");
        configMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                configMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(configMenu);

        recetasItem.setText("Pacientes");

        pacienteItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        pacienteItem.setText("Pacientes");
        pacienteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pacienteItemActionPerformed(evt);
            }
        });
        recetasItem.add(pacienteItem);

        ExpedienteItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        ExpedienteItem.setText("Expedientes");
        ExpedienteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExpedienteItemActionPerformed(evt);
            }
        });
        recetasItem.add(ExpedienteItem);

        tratamientoItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        tratamientoItem.setText("Tratamiento");
        tratamientoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tratamientoItemActionPerformed(evt);
            }
        });
        recetasItem.add(tratamientoItem);

        Recetas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        Recetas.setText("Recetas");
        Recetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecetasActionPerformed(evt);
            }
        });
        recetasItem.add(Recetas);

        jMenuBar1.add(recetasItem);

        adminMenu.setText("Administrador");

        usuariosItem.setText("Usuarios");
        usuariosItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuariosItemActionPerformed(evt);
            }
        });
        adminMenu.add(usuariosItem);

        pagosItem.setText("Pagos");
        pagosItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagosItemActionPerformed(evt);
            }
        });
        adminMenu.add(pagosItem);

        facturasItem.setText("Facturas");
        facturasItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturasItemActionPerformed(evt);
            }
        });
        adminMenu.add(facturasItem);

        invenItem.setText("Inventario");
        invenItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invenItemActionPerformed(evt);
            }
        });
        adminMenu.add(invenItem);

        jMenuBar1.add(adminMenu);

        jMenu3.setText("Medicos");

        medicamentoItem.setText("Medicamentos");
        medicamentoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicamentoItemActionPerformed(evt);
            }
        });
        jMenu3.add(medicamentoItem);

        citasItem.setText("Citas");
        citasItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                citasItemActionPerformed(evt);
            }
        });
        jMenu3.add(citasItem);

        jMenuBar1.add(jMenu3);

        notiMenu.setText("Notificaciones");
        notiMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notiMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(notiMenu);

        sesionMenu.setText("Iniciar Sesion");
        sesionMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sesionMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(sesionMenu);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tratamientoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tratamientoItemActionPerformed
        mostrarPanel("Tratamientos", new PanelTratamientos());
    }//GEN-LAST:event_tratamientoItemActionPerformed

    private void pacienteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pacienteItemActionPerformed
        mostrarPanel("Pacientes", new PanelPacientes());
    }//GEN-LAST:event_pacienteItemActionPerformed

    private void ExpedienteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExpedienteItemActionPerformed
        mostrarPanel("Expediente", new PanelExpedientes());
    }//GEN-LAST:event_ExpedienteItemActionPerformed

    private void RecetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecetasActionPerformed
        // TODO add your handling code here:
        mostrarPanel("Recetas", new PanelReceta());
    }//GEN-LAST:event_RecetasActionPerformed

    private void medicamentoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicamentoItemActionPerformed
        // TODO add your handling code here:
        mostrarPanel("Medicamentos", new PanelMedicamentos());
    }//GEN-LAST:event_medicamentoItemActionPerformed

    private void citasItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_citasItemActionPerformed
        // TODO add your handling code here:
        mostrarPanel("Citas", new PanelCitas());
    }//GEN-LAST:event_citasItemActionPerformed

    private void invenItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invenItemActionPerformed
        // TODO add your handling code here:
        mostrarPanel("Inventario", new PanelInventario());
    }//GEN-LAST:event_invenItemActionPerformed

    private void facturasItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturasItemActionPerformed
        // TODO add your handling code here:
        mostrarPanel("Facturas", new PanelFacturas());
    }//GEN-LAST:event_facturasItemActionPerformed

    private void pagosItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagosItemActionPerformed
        // TODO add your handling code here:
        mostrarPanel("Pagos", new PanelPagos());
    }//GEN-LAST:event_pagosItemActionPerformed

    private void usuariosItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuariosItemActionPerformed
        // TODO add your handling code here:
        mostrarPanel("Usuarios", new PanelUsuarios());
    }//GEN-LAST:event_usuariosItemActionPerformed

    private void sesionMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sesionMenuMouseClicked
        // TODO add your handling code here:
        mostrarPanel("IniciarSesion", new PanelInicioSesion());
    }//GEN-LAST:event_sesionMenuMouseClicked

    private void notiMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notiMenuMouseClicked
        // TODO add your handling code here:
        mostrarPanel("Notificaciones", new PanelNotificaciones());
    }//GEN-LAST:event_notiMenuMouseClicked

    private void configMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_configMenuMouseClicked
        // TODO add your handling code here:        
        mostrarPanel("Configuracion", new PanelConfiguracion());
    }//GEN-LAST:event_configMenuMouseClicked

    private void inicioMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inicioMenuMouseClicked
        // TODO add your handling code here:
        mostrarPanel("Inicio", new PanelInicio());
    }//GEN-LAST:event_inicioMenuMouseClicked

    /**
     * Muestra un panel específico en el contenedor utilizando CardLayout. Si el panel ya existe, simplemente lo muestra. Si no existe, lo añade al contenedor antes de mostrarlo.
     *
     * @param nombrePanel Identificador único del panel
     * @param panel Panel a mostrar
     */
    public void mostrarPanel(String nombrePanel, JPanel panel) {
        CardLayout layout = (CardLayout) panelContenedor.getLayout();

        // Verifica si el panel ya existe en el contenedor
        boolean panelExiste = false;
        for (Component comp : panelContenedor.getComponents()) {
            if (nombrePanel.equals(comp.getName())) {
                panelExiste = true;
                break;
            }
        }

        // Si el panel no existe, lo añade al contenedor
        if (!panelExiste) {
            panel.setName(nombrePanel);
            panelContenedor.add(panel, nombrePanel);
        }

        // Muestra el panel y actualiza la interfaz
        layout.show(panelContenedor, nombrePanel);
        panelContenedor.revalidate();
    }

    public void registrarPanel(String nombrePanel, JPanel panel) {
        boolean panelExiste = false;
        for (Component comp : panelContenedor.getComponents()) {
            if (nombrePanel.equals(comp.getName())) {
                panelExiste = true;
                break;
            }
        }

        if (!panelExiste) {
            panel.setName(nombrePanel);
            panelContenedor.revalidate();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // 1. Establecer el estilo de la interfaz gráfica
        try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 2. Inicializar la ventana principal en el hilo de eventos
        EventQueue.invokeLater(() -> {
            MainView mainView = new MainView();

            // 3. Precargar paneles en segundo plano
            new Thread(() -> {
                System.out.println("Precargando paneles...");
                PanelUsuarios panelUsuarios = new PanelUsuarios();
                PanelInicioSesion panelInicioSesion = new PanelInicioSesion();
                PanelConfiguracion panelConfiguracion = new PanelConfiguracion();

                // Registrar paneles en el hilo de eventos para seguridad en Swing
                SwingUtilities.invokeLater(() -> {
                    mainView.registrarPanel("Usuarios", panelUsuarios);
                    mainView.registrarPanel("IniciarSesion", panelInicioSesion);
                    mainView.registrarPanel("Configuracion", panelConfiguracion);
                    System.out.println("Paneles precargados y registrados.");
                });
            }).start();

            // 4. Inicializar la conexión JPA en segundo plano
            new Thread(() -> {
                System.out.println("Inicializando conexión JPA en segundo plano...");
                AdmDatos adm = new AdmDatos();  // Se inicializa pero aún no crea la conexión
                adm.getEmf(); // Esto crea la EntityManagerFactory
                System.out.println("Conexión JPA inicializada.");
            }).start();

            // 5. Mostrar la ventana
            mainView.setVisible(true);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ExpedienteItem;
    private javax.swing.JMenuItem Recetas;
    private javax.swing.JMenu adminMenu;
    private javax.swing.JMenuItem citasItem;
    private javax.swing.JMenu configMenu;
    private javax.swing.JMenuItem facturasItem;
    private javax.swing.JMenu inicioMenu;
    private javax.swing.JMenuItem invenItem;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem medicamentoItem;
    private javax.swing.JMenu notiMenu;
    private javax.swing.JMenuItem pacienteItem;
    private javax.swing.JMenuItem pagosItem;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JMenu recetasItem;
    private javax.swing.JMenu sesionMenu;
    private javax.swing.JMenuItem tratamientoItem;
    private javax.swing.JMenuItem usuariosItem;
    // End of variables declaration//GEN-END:variables
}
