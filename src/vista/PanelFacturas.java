/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import control.AdmDatos;
import control.FacturaJpaController;
import control.PacienteJpaController;
import control.PagoJpaController;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import modelo.ModListPacientesPago;
import modelo.ModListPagos;
import modelo.Paciente;
import modelo.Pago;





/**
 *
 * @author carlo
 */
public class PanelFacturas extends javax.swing.JPanel {
    private final AdmDatos admDatos = new AdmDatos();
    private List <Paciente> pacientes;
    private List<Pago> pagos;
    private PacienteJpaController pacienteController;
    private FacturaJpaController facturaController;
    private PagoJpaController pagoController;
    private ModListPacientesPago listaPacientes;
    private ModListPagos listaPagos;
    private Paciente pacienteSeleccionado;
    private Pago pagoSeleccionado;

    
    public PanelFacturas() {
        initComponents();
        cargarControladores();
        configurarListeners();
        inicializarModelos();
        cargarListaPacientes();
        buscadorListaPacientes.setListaPrincipal(jListPacientes);
        buscadorListaPagos.setListaPrincipal(JListPago);
    }
    
    public void cargarControladores(){
        pacienteController = new PacienteJpaController(admDatos.getEmf());
        facturaController = new FacturaJpaController(admDatos.getEmf());
        pagoController = new PagoJpaController(admDatos.getEmf());
    }
    
    private void inicializarModelos() {
        jListPacientes.setModel(new ModListPacientesPago(new ArrayList<>()));
        JListPago.setModel(new ModListPagos(new ArrayList<>()));
    }
    
    private void cargarListaPacientes() {
        pacientes = pacienteController.findPacienteEntities();
        listaPacientes = new ModListPacientesPago(pacientes);
        jListPacientes.setModel(listaPacientes);
    }
    
    private void configurarListeners() {
        // Listener para selección de pacientes
        jListPacientes.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                pacienteSeleccionado = pacientes.get(jListPacientes.getSelectedIndex());
                cargarPagosPorPaciente(pacienteSeleccionado);
            }
        });

        // Listener para selección de pagos
        JListPago.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                pagoSeleccionado = pagos.get(JListPago.getSelectedIndex());
                actualizarDatosFactura(pagoSeleccionado);
            }
        });
    }

    private void cargarPagosPorPaciente(Paciente paciente) {
        // Asumiendo que Pago tiene relación con Paciente a través de Cita
        List<Pago> pagosPaciente = pagoController.findPagosByPaciente(paciente);
        listaPagos = new ModListPagos(pagosPaciente);
        JListPago.setModel(listaPagos);
        listaPagos.actualizar(pagosPaciente);
    }

    private void actualizarDatosFactura(Pago pago) {
        if (pago == null || pago.getMonto() == null) return;

        BigDecimal monto = pago.getMonto();

        // Cálculos con BigDecimal
        BigDecimal iva = monto.multiply(new BigDecimal("0.16"))
                             .setScale(2, RoundingMode.HALF_UP);

        BigDecimal total = monto.add(iva)
                               .setScale(2, RoundingMode.HALF_UP);

        // Actualización de labels
        folioFacturaLabel.setText("Folio de factura: " + pago.getFactura().getIdFactura());
        fechaLabel.setText("Fecha: " + pago.getFecha().toString());
        folioPagoLabel.setText("Folio de pago: " + pago.getIdPago());
        subtotalLabel.setText(String.format("Subtotal: $%.2f", monto));
        ivaLabel.setText(String.format("IVA: $%.2f", iva));
        totalLabel.setText(String.format("Total: $%.2f", total));
    }
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDatos = new javax.swing.JPanel();
        tituloLabel = new javax.swing.JLabel();
        folioFacturaLabel = new javax.swing.JLabel();
        fechaLabel = new javax.swing.JLabel();
        subtotalLabel = new javax.swing.JLabel();
        ivaLabel = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        folioPagoLabel = new javax.swing.JLabel();
        scrollPaneFactura = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        razonSocialField = new javax.swing.JTextField();
        conceptoField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cpField = new javax.swing.JTextField();
        calleField = new javax.swing.JTextField();
        numeroInteriorField = new javax.swing.JTextField();
        numeroExteriorField = new javax.swing.JTextField();
        localidadField = new javax.swing.JTextField();
        entidadFederativaField = new javax.swing.JTextField();
        coloniaField = new javax.swing.JTextField();
        buttonGenerarFactura = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();
        pacienteLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        JListPago = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListPacientes = new javax.swing.JList<>();
        buscadorListaPacientes = new miscomponentes.JBuscadorLista();
        buscadorListaPagos = new miscomponentes.JBuscadorLista();

        tituloLabel.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        tituloLabel.setText("Datos de Factura");

        folioFacturaLabel.setText("Folio de factura:");

        fechaLabel.setText("Fecha:");

        subtotalLabel.setText("Subtotal:");

        ivaLabel.setText("IVA:");

        totalLabel.setText("Total:");

        folioPagoLabel.setText("Folio de pago:");

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tituloLabel)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(folioFacturaLabel)
                            .addComponent(fechaLabel)
                            .addComponent(folioPagoLabel))
                        .addGap(113, 113, 113)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(subtotalLabel)
                            .addComponent(ivaLabel)
                            .addComponent(totalLabel))))
                .addContainerGap(609, Short.MAX_VALUE))
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(folioFacturaLabel)
                    .addComponent(subtotalLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ivaLabel)
                    .addComponent(fechaLabel))
                .addGap(18, 18, 18)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalLabel)
                    .addComponent(folioPagoLabel))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        razonSocialField.setText("Razón social");

        conceptoField.setText("Concepto");

        jLabel1.setText("Dirección fiscal:");

        cpField.setText("Codigo postal");

        calleField.setText("Calle");

        numeroInteriorField.setText("Número interior");

        numeroExteriorField.setText("Número exterior");

        localidadField.setText("Nombre de la localidad o municipio");

        entidadFederativaField.setText("Nombre de la entidad federativa");

        coloniaField.setText("Colonia");

        buttonGenerarFactura.setText("Generar Factura");

        buttonCancelar.setText("Cancelar");

        pacienteLabel.setText("Buscar paciente::");

        jLabel2.setText("Buscar Pago");

        jScrollPane3.setViewportView(JListPago);

        jScrollPane4.setViewportView(jListPacientes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(pacienteLabel)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(numeroInteriorField, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(numeroExteriorField, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(cpField, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(razonSocialField)
                    .addComponent(conceptoField)
                    .addComponent(calleField)
                    .addComponent(localidadField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(entidadFederativaField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(coloniaField)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonGenerarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane4)
                    .addComponent(buscadorListaPacientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                    .addComponent(buscadorListaPagos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pacienteLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscadorListaPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscadorListaPagos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(razonSocialField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(conceptoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cpField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(calleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeroInteriorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numeroExteriorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(localidadField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(entidadFederativaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(coloniaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonGenerarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollPaneFactura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneFactura)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> JListPago;
    private miscomponentes.JBuscadorLista buscadorListaPacientes;
    private miscomponentes.JBuscadorLista buscadorListaPagos;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonGenerarFactura;
    private javax.swing.JTextField calleField;
    private javax.swing.JTextField coloniaField;
    private javax.swing.JTextField conceptoField;
    private javax.swing.JTextField cpField;
    private javax.swing.JTextField entidadFederativaField;
    private javax.swing.JLabel fechaLabel;
    private javax.swing.JLabel folioFacturaLabel;
    private javax.swing.JLabel folioPagoLabel;
    private javax.swing.JLabel ivaLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jListPacientes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField localidadField;
    private javax.swing.JTextField numeroExteriorField;
    private javax.swing.JTextField numeroInteriorField;
    private javax.swing.JLabel pacienteLabel;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JTextField razonSocialField;
    private javax.swing.JScrollPane scrollPaneFactura;
    private javax.swing.JLabel subtotalLabel;
    private javax.swing.JLabel tituloLabel;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables
}
