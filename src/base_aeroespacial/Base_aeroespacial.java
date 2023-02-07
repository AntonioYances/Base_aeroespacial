package base_aeroespacial;

import controlador.Mision;
import controlador.Tripulacion;
import controlador.controladorNaves;
import modelo.ConsultasNaves;
import modelo.Naves;
import vista.Vista_formulario;


/**
 *
 * @author Antonio Yances
 */
public class Base_aeroespacial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Naves naves = new Naves();
       ConsultasNaves consultas = new ConsultasNaves();
       Vista_formulario vista = new Vista_formulario();
       
       controladorNaves controlador = new controladorNaves(naves,consultas,vista);
       controlador.iniciar();
       vista.setVisible(true);
       
       Mision mision = new Tripulacion();
       
    }
    
}
