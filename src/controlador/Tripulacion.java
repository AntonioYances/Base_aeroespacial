
package controlador;

import controlador.controladorNaves;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ConsultasNaves;
import modelo.Naves;
import vista.Vista_formulario;

/**
 *
 * @author Antonio Yances
 */
public class Tripulacion extends Mision implements ActionListener {

    private Naves modelo;
    private ConsultasNaves conN;
    private Vista_formulario formulario;
    

    public Tripulacion(Naves mod, ConsultasNaves modc, Vista_formulario formulario) {
        this.modelo = mod;
        this.conN = modc;
        this.formulario = formulario;
        this.formulario.btnCalcularVuelo.addActionListener(this);

    }

    public Tripulacion() {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
    }

    @Override
    public void calcular() {
        String valor = controladorNaves.valor;
        if (valor.equalsIgnoreCase("Activo")) {
            JOptionPane.showMessageDialog(null, "La nave puede salir.... embarcando tripualcion ...... nos vemos...");
        }else{
            JOptionPane.showMessageDialog(null, "Lo sentimos su nave no puede salir....no esta disponible");
        }

    }
    
   
    
    

}
