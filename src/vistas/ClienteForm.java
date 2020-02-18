package vistas;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.ClienteCon;

/**
 *
 * @author sosaj
 */
public class ClienteForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form Ventas
     */
    ClienteCon cdao = new ClienteCon();
    Cliente c = new Cliente();
    DefaultTableModel modeloTabla = new DefaultTableModel();
    int id;

    public ClienteForm() {
        initComponents();
        mostrarLista();
    }

    void mostrarLista(){

        List<Cliente> lista = cdao.listar();
        modeloTabla = (DefaultTableModel) tabla.getModel();
        Object[] obj = new Object[5];
        for (int i = 0; i < lista.size(); i++) {

            obj[0] = lista.get(i).getId();
            obj[1] = lista.get(i).getNombres();
            obj[2] = lista.get(i).getDni();
            obj[3] = lista.get(i).getDireccion();
            obj[4] = lista.get(i).getTelefono();
            modeloTabla.addRow(obj);

        }

        tabla.setModel(modeloTabla);

    }

    void listarBusqueda() {

        if (dniCliente.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "Debe ingresar un dni!");

        } else {

            limpiarTabla();
            List<Cliente> lista = cdao.listarBusqueda(dniCliente.getText());
            modeloTabla = (DefaultTableModel) tabla.getModel();
            Object[] obj = new Object[5];
            for (int i = 0; i < lista.size(); i++) {

                obj[0] = lista.get(i).getId();
                obj[1] = lista.get(i).getNombres();
                obj[2] = lista.get(i).getDni();
                obj[3] = lista.get(i).getDireccion();
                obj[4] = lista.get(i).getTelefono();
                modeloTabla.addRow(obj);

            }

            tabla.setModel(modeloTabla);
            
            if (lista.isEmpty()) {
                
                JOptionPane.showMessageDialog(this, "El cliente no existe!");
                
            }

        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dniCliente = new javax.swing.JTextField();
        nombreCliente = new javax.swing.JTextField();
        dirCliente = new javax.swing.JTextField();
        telCliente = new javax.swing.JTextField();
        btnAgregarCliente = new javax.swing.JButton();
        btnActualizarCliente = new javax.swing.JButton();
        btnEliminarCliente = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(640, 480));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("DNI:");

        jLabel2.setText("Nombres:");

        jLabel3.setText("Dirección:");

        jLabel4.setText("Teléfono:");

        dniCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dniClienteActionPerformed(evt);
            }
        });

        btnAgregarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/anadir-amigo.png"))); // NOI18N
        btnAgregarCliente.setToolTipText("Agregar");
        btnAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarClienteActionPerformed(evt);
            }
        });

        btnActualizarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/recargar.png"))); // NOI18N
        btnActualizarCliente.setToolTipText("Actualizar");
        btnActualizarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarClienteActionPerformed(evt);
            }
        });

        btnEliminarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        btnEliminarCliente.setToolTipText("Eliminar");
        btnEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarClienteActionPerformed(evt);
            }
        });

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        btnLimpiar.setToolTipText("Buscar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dniCliente)
                    .addComponent(nombreCliente)
                    .addComponent(dirCliente)
                    .addComponent(telCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEliminarCliente)
                    .addComponent(btnAgregarCliente))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnActualizarCliente, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(dniCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnActualizarCliente)
                        .addComponent(btnAgregarCliente)))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(dirCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(telCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnEliminarCliente)
                    .addComponent(btnLimpiar))
                .addGap(35, 35, 35))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DNI", "NOMBRES", "DIRECCIÓN", "TELÉFONO"
            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClienteActionPerformed
        agregar();
        limpiarTabla();
        mostrarLista();
        limpiar();
    }//GEN-LAST:event_btnAgregarClienteActionPerformed

    private void btnActualizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarClienteActionPerformed
        actualizar();
        limpiarTabla();
        mostrarLista();
        limpiar();
    }//GEN-LAST:event_btnActualizarClienteActionPerformed

    private void btnEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarClienteActionPerformed
        eliminar();
        limpiarTabla();
        mostrarLista();
        limpiar();
    }//GEN-LAST:event_btnEliminarClienteActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked

        int fila = tabla.getSelectedRow();

        if (fila == -1) {

            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila!");

        } else {

            id = Integer.parseInt(tabla.getValueAt(fila, 0).toString());
            String dni = (String) tabla.getValueAt(fila, 1).toString();
            String nombre = (String) tabla.getValueAt(fila, 2).toString();
            String direccion = (String) tabla.getValueAt(fila, 3).toString();
            String telefono = (String) tabla.getValueAt(fila, 4).toString();

            dniCliente.setText(dni);
            nombreCliente.setText(nombre);
            dirCliente.setText(direccion);
            telCliente.setText(telefono);

        }

    }//GEN-LAST:event_tablaMouseClicked

    private void dniClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dniClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dniClienteActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed

        listarBusqueda();
        limpiar();

    }//GEN-LAST:event_btnLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarCliente;
    private javax.swing.JButton btnAgregarCliente;
    private javax.swing.JButton btnEliminarCliente;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JTextField dirCliente;
    private javax.swing.JTextField dniCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombreCliente;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField telCliente;
    // End of variables declaration//GEN-END:variables

    private void agregar() {

        String dni = dniCliente.getText();
        String nombre = nombreCliente.getText();
        String direccion = dirCliente.getText();
        String telefono = telCliente.getText();

        Object[] o = {nombre, dni, direccion, telefono};
        cdao.agregar(o);

    }

    private void actualizar() {
        
        int fila = tabla.getSelectedRow();

        if (fila == -1) {

            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila!");

        } else {

            String dni = dniCliente.getText();
            String nombre = nombreCliente.getText();
            String direccion = dirCliente.getText();
            String telefono = telCliente.getText();
            Object[] o = {nombre, dni, direccion, telefono, id};
            cdao.actualizar(o);

        }

    }

    private void eliminar() {

        int fila = tabla.getSelectedRow();

        if (fila == -1) {

            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila!");

        } else {

            cdao.eliminar(id);

        }

    }

    private void limpiarTabla() {

        for (int i = 0; i < modeloTabla.getRowCount(); i++) {

            modeloTabla.removeRow(i);
            i = i - 1;

        }

    }

    private void limpiar() {
        dniCliente.setText("");
        nombreCliente.setText("");
        dirCliente.setText("");
        telCliente.setText("");
    }
}