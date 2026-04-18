package views;

import data.Persistencia;
import domain.*;
import views.ListarVehiculosView;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;


// PARTE 3 - VENTANA DE REGISTRO DE VEHICULOS

public class IngresarVehiculosView extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(IngresarVehiculosView.class.getName());

    /**
     * Creates new form IngresarVehiculosView
     */
    public IngresarVehiculosView() {
        initComponents();
        setNoVisible();
        cargarComboxes();
        this.setDefaultCloseOperation(IngresarVehiculosView.DISPOSE_ON_CLOSE);
    }
    
    private void setNoVisible(){
        jLabel8.setVisible(false);
        jLabel9.setVisible(false);
        jLabel10.setVisible(false);
        fieldKwBase.setVisible(false);
        fieldKmPorLitro.setVisible(false);
        fieldLitrosExtra.setVisible(false);
    }
    private void setCombVisible(){
        jLabel8.setVisible(false);
        fieldKwBase.setVisible(false);
        jLabel9.setVisible(true);
        jLabel10.setVisible(true);
        fieldKmPorLitro.setVisible(true);
        fieldLitrosExtra.setVisible(true);
    }
    private void setElectVisible(){
        jLabel8.setVisible(true);
        fieldKwBase.setVisible(true);
        jLabel9.setVisible(false);
        jLabel10.setVisible(false);
        fieldKmPorLitro.setVisible(false);
        fieldLitrosExtra.setVisible(false);
    }
    
    private void cargarComboxes(){

        ArrayList<Marca> marcas = Persistencia.getMarcas();
        for(Marca m: marcas){
            comboBoxMarca.addItem(m);
        }
        ArrayList<Sucursal> sucursales = Persistencia.getSucursales();
        for(Sucursal s: sucursales){
            comboBoxSucursal.addItem(s);
        }
        comboBoxTipo.addItem("Electrico");
        comboBoxTipo.addItem("Combustible");

        
    }
    
    private Sucursal datosSucursal(){
        Sucursal s = (Sucursal) comboBoxSucursal.getSelectedItem();
        String codigo = s.getCodigo();
        String direccion = s.getDireccion();
        String ciudad = s.getCiudad();
        Responsable r = s.getResponsable();
        return new Sucursal(codigo,direccion,ciudad,r);
    }
    
    private Marca datosMarca(){
        Marca m = (Marca)comboBoxMarca.getSelectedItem();
        String nombre = m.getNombre();
        String pais = m.getPais();
        return new Marca(nombre,pais);
    }
  
    private VehiculoElectrico ingresarVehiculoElectrico(){
        double CapacidadCarga = Double.parseDouble(fieldCapDeCarga.getText());
        int Anio = Integer.parseInt(fieldAnio.getText());
        String Patente = fieldPatente.getText();
        String Modelo = fieldModelo.getText();
        
        Marca m = datosMarca();
        Sucursal s = datosSucursal();
        
        double kwhBase = Double.parseDouble(fieldKwBase.getText());
        
        return new VehiculoElectrico(Patente,m,Modelo,Anio,CapacidadCarga,s,kwhBase);
    }
    
    private VehiculoCombustible ingresarVehiculoCombustible(){
        double CapacidadCarga = Double.parseDouble(fieldCapDeCarga.getText());
        int Anio = Integer.parseInt(fieldAnio.getText());
        String Patente = fieldPatente.getText();
        String Modelo = fieldModelo.getText();
        
        Marca m = datosMarca();
        Sucursal s = datosSucursal();
        
        double KilometrosPorLitro = Double.parseDouble(fieldKmPorLitro.getText());
        double LitrosExtra = Double.parseDouble(fieldLitrosExtra.getText());
        
        return new VehiculoCombustible(Patente,m,Modelo,Anio,CapacidadCarga,s,KilometrosPorLitro,LitrosExtra);
    }
    
    private void chequearErrores(){
        String Tipo = comboBoxTipo.getSelectedItem().toString();
        if (fieldAnio.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ingrese el Año del Vehiculo", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if (fieldCapDeCarga.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ingrese la Capacidad de Carga", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if (fieldModelo.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ingrese un Modelo de Vehiculo", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if (Tipo.equals("Electrico") && fieldKwBase.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "Ingrese los Kilowatts Base del Vehiculo",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        if (Tipo.equals("Combustible") && fieldKmPorLitro.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "Ingrese los Kilometros por Litro del Vehiculo",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        if (Tipo.equals("Combustible") && fieldLitrosExtra.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "Ingrese los Litros Extra del Vehiculo",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void IngresarVehiculos(){
        String Tipo = comboBoxTipo.getSelectedItem().toString();
        if (Tipo.equals("Electrico"))
        {
            Persistencia.agregarVehiculoElectrico(ingresarVehiculoElectrico());
        }
        if (Tipo.equals("Combustible"))
        {
            Persistencia.agregarVehiculoCombustible(ingresarVehiculoCombustible());
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fieldPatente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        fieldModelo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        fieldAnio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        fieldCapDeCarga = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        fieldKwBase = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        fieldKmPorLitro = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        fieldLitrosExtra = new javax.swing.JTextField();
        botonIngresar = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboBoxMarca = new javax.swing.JComboBox<>();
        comboBoxTipo = new javax.swing.JComboBox<>();
        comboBoxSucursal = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ingreso de Vehiculos");

        jLabel1.setText("Tipo de Vehiculo");

        jLabel2.setText("Patente");

        jLabel4.setText("Modelo");

        jLabel6.setText("Año");

        fieldAnio.addActionListener(this::fieldAnioActionPerformed);

        jLabel7.setText("Capacidad de Carga");

        jLabel8.setText("Kilowatts Base");

        jLabel9.setText("Kilometros Por Litro");

        fieldKmPorLitro.addActionListener(this::fieldKmPorLitroActionPerformed);

        jLabel10.setText("Litros Extra");

        botonIngresar.setText("Ingresar Vehiculo");
        botonIngresar.addActionListener(this::botonIngresarActionPerformed);

        jLabel15.setText("Sucursal");

        jLabel5.setText("Marca");

        comboBoxMarca.addActionListener(this::comboBoxMarcaActionPerformed);

        comboBoxTipo.addActionListener(this::comboBoxTipoActionPerformed);

        comboBoxSucursal.addActionListener(this::comboBoxSucursalActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldPatente, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fieldAnio, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(fieldCapDeCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldModelo)
                            .addComponent(comboBoxMarca, 0, 122, Short.MAX_VALUE)))
                    .addComponent(jLabel10)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(fieldKwBase)
                                    .addGap(267, 267, 267)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(fieldLitrosExtra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                    .addComponent(fieldKmPorLitro, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(258, 258, 258)))
                        .addComponent(botonIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addComponent(comboBoxSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(comboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldPatente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldAnio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fieldCapDeCarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(comboBoxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldKmPorLitro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(fieldLitrosExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldKwBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botonIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIngresarActionPerformed
        chequearErrores();
        IngresarVehiculos();
    }//GEN-LAST:event_botonIngresarActionPerformed

    private void fieldKmPorLitroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldKmPorLitroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldKmPorLitroActionPerformed

    private void fieldAnioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldAnioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldAnioActionPerformed

    private void comboBoxMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxMarcaActionPerformed
        
    }//GEN-LAST:event_comboBoxMarcaActionPerformed

    private void comboBoxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxTipoActionPerformed
        String Tipo = comboBoxTipo.getSelectedItem().toString();
        if(Tipo.equals("Electrico")){
            setElectVisible();
        }
        if(Tipo.equals("Combustible")){
            setCombVisible();
        }
        
    }//GEN-LAST:event_comboBoxTipoActionPerformed

    private void comboBoxSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxSucursalActionPerformed
        
    }//GEN-LAST:event_comboBoxSucursalActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new IngresarVehiculosView().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonIngresar;
    private javax.swing.JComboBox<Marca> comboBoxMarca;
    private javax.swing.JComboBox<Sucursal> comboBoxSucursal;
    private javax.swing.JComboBox<String> comboBoxTipo;
    private javax.swing.JTextField fieldAnio;
    private javax.swing.JTextField fieldCapDeCarga;
    private javax.swing.JTextField fieldKmPorLitro;
    private javax.swing.JTextField fieldKwBase;
    private javax.swing.JTextField fieldLitrosExtra;
    private javax.swing.JTextField fieldModelo;
    private javax.swing.JTextField fieldPatente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JTextField getFieldAnio() {
        return fieldAnio;
    }

    public javax.swing.JTextField getFieldCapDeCarga() {
        return fieldCapDeCarga;
    }

    public javax.swing.JTextField getFieldKmPorLitro() {
        return fieldKmPorLitro;
    }

    public javax.swing.JTextField getFieldKwBase() {
        return fieldKwBase;
    }

    public javax.swing.JTextField getFieldLitrosExtra() {
        return fieldLitrosExtra;
    }
    
    public javax.swing.JTextField getFieldModelo() {
        return fieldModelo;
    }


    public javax.swing.JTextField getFieldPatente() {
        return fieldPatente;
    }
}
