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
 * El nombre de la clase no sigue las convenciones de nombres de Java, debería ser ControladorNaves.
 * La clase implementa la interfaz ActionListener para manejar eventos de botones de la interfaz gráfica, lo que está bien.
 * Los atributos de la clase no siguen las convenciones de nombres de Java. En general los nombres de las variables deberían ser descriptivos y cortos, por ejemplo, por qué se llama masaS y no masa? Qué significa la S?
 * Los atributos empujeR y valor son públicos y estáticos, lo que significa que pueden ser modificados desde cualquier parte del programa, lo cual no es recomendable. Además, no se utilizan en ningún momento.
 * El constructor de la clase recibe tres parámetros y asigna su valor a los atributos correspondientes, lo que está bien.
 * El método iniciar solo configura algunos atributos de la vista formulario, lo cual está bien.
 * El método actionPerformed maneja los eventos de los botones de la interfaz gráfica. Sin embargo, es bastante largo y realiza demasiadas tareas. Sería conveniente separar las distintas acciones en métodos más pequeños y fáciles de entender.
 * Los métodos limpiar y limpiarCampos son prácticamente iguales, solo que uno borra todos los campos y el otro solo algunos. Sería conveniente eliminar uno de ellos y renombrar al otro para que sea más descriptivo.
 * En general, el código tiene comentarios innecesarios que solo describen lo que hace cada método, lo cual es redundante. Los comentarios deberían explicar por qué se hace algo o aclarar conceptos complejos.
 * El código no está muy bien organizado y es difícil de seguir. Sería conveniente separar las distintas acciones en métodos más pequeños y fáciles de entender, y renombrar los métodos y atributos con nombres más descriptivos y que sigan las convenciones de nombres de Java.
 * Faltan validaciones en algunos de los campos de la vista, como la velocidad y la masa, para asegurarse de que se ingresen valores válidos.
 * No se comprende bien la diferencia de responsabilidades entre controladorNaves/Empuje/Mision/Tripulacion, tal vez agruparlos en paquetes más representativos puede ayudar a comprender eso. También el nombre de las clases ayuda a captar la idea específica del proyecto. Mision/Empuje/Tripulación se podrían asociar con nombres de modelos/entidades en lugar de lógica de negocio.
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
