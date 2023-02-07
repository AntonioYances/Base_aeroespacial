package controlador;

import java.awt.event.ActionEvent;
import modelo.ConsultasNaves;
import modelo.Naves;
import vista.Vista_formulario;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Antonio Yances
 */
public class controladorNaves implements ActionListener {
    private String empuje,masaS,aceleracionS;
    public static double empujeR,masa,aceleracion;
    public static String valor;
    private Naves modelo;
    private ConsultasNaves conN;
    private Vista_formulario formulario;
    

    public controladorNaves(Naves mod, ConsultasNaves modc, Vista_formulario formulario) {
        this.modelo = mod;
        this.conN = modc;
        this.formulario = formulario;
        this.formulario.btnAgregar.addActionListener(this);
        this.formulario.btnActualizar.addActionListener(this);
        this.formulario.btnEliminar.addActionListener(this);
        this.formulario.btndepurar.addActionListener(this);
        this.formulario.btnBuscar.addActionListener(this);
        this.formulario.btnCalcularVuelo.addActionListener(this);
        this.formulario.btnCalcularEmpuje.addActionListener(this);
    }

    public void iniciar() {
        formulario.setTitle("Base Aeroespacial");
        formulario.setLocationRelativeTo(null);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == formulario.btnAgregar) {
            modelo.setNombre(formulario.txtNombre.getText());
            modelo.setStatus(formulario.txtStatus.getText());
            modelo.setCombustible(formulario.txtCombustible.getText());
            modelo.setTipo(formulario.txtTipo.getText());
            modelo.setPais(formulario.txtPais.getText());
            modelo.setVelocidad(Double.parseDouble(formulario.txtVelocidad.getText()));
            modelo.setBiografia(formulario.txtBiografia.getText());

            if (conN.registrar(modelo)) {
                JOptionPane.showMessageDialog(null, "Registro guardado.");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar.");
                limpiar();
            }
        }

        if (e.getSource() == formulario.btnActualizar) {
            modelo.setNombre(formulario.txtNombre.getText());
            modelo.setStatus(formulario.txtStatus.getText());
            modelo.setCombustible(formulario.txtCombustible.getText());
            modelo.setTipo(formulario.txtTipo.getText());
            modelo.setPais(formulario.txtPais.getText());
            modelo.setVelocidad(Double.parseDouble(formulario.txtVelocidad.getText()));
            modelo.setBiografia(formulario.txtBiografia.getText());
            if (conN.modificar(modelo)) {
                JOptionPane.showMessageDialog(null, "La informacion a sido Actualizada.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al Actualizar.");
                limpiar();
            }
        }
        if (e.getSource() == formulario.btnEliminar) {
            modelo.setNombre(formulario.txtNombre.getText());

            if (conN.eliminar(modelo)) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado.");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminado.");
                limpiar();
            }
        }
        if (e.getSource() == formulario.btnBuscar) {
            modelo.setNombre(formulario.txtNombre.getText());
            if (conN.buscar(modelo)) {
                formulario.txtNombre.setText(modelo.getNombre());
                formulario.txtStatus.setText(modelo.getStatus());
                formulario.txtCombustible.setText(modelo.getCombustible());
                formulario.txtTipo.setText(modelo.getTipo());
                formulario.txtPais.setText(modelo.getPais());
                formulario.txtVelocidad.setText(String.valueOf(modelo.getVelocidad()));
                formulario.txtBiografia.setText(modelo.getBiografia());
                
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro ninguna nave.");
                
            }            
        }
        if (e.getSource() == formulario.btnCalcularVuelo) {
            formulario.txtStatus.setText(modelo.getStatus());
            valor = modelo.getStatus();
            
        }
        if (e.getSource() == formulario.btndepurar) {
            limpiar();
        }
        
        if (e.getSource() == formulario.btnCalcularEmpuje) {
            masaS = JOptionPane.showInputDialog("Ingresa el valor de la masa?");
            aceleracionS = JOptionPane.showInputDialog("Ingresa el valor de la aceleracion?");
            masa = Double.parseDouble(masaS);
            aceleracion = Double.parseDouble(aceleracionS);
        }
       
      

    }

    public void limpiar() {
        formulario.txtNombre.setText(null);
        formulario.txtStatus.setText(null);
        formulario.txtCombustible.setText(null);
        formulario.txtTipo.setText(null);
        formulario.txtPais.setText(null);
        formulario.txtVelocidad.setText(null);
        formulario.txtBiografia.setText(null);
        
    }
    
    
    
}
