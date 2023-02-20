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
     * Nombre del paquete: El nombre del paquete no sigue la convención de nombres en formato camelCase y debería nombrarse con una letra inicial en minúscula y utilizando nombres significativos.
     * Comentarios de la documentación: Los comentarios de documentación son útiles para comprender el propósito de las diferentes partes del código, pero algunos comentarios podrían ser más detallados.
     * Nombres de clases y variables: Los nombres de las clases y variables están escritos en formato camelCase, pero algunos nombres podrían ser más descriptivos.
     * Lógica de inicialización: Sería recomendable mover la lógica de inicialización a un método de inicialización separado para facilitar la comprensión del código.
     * Manejo de excepciones: El código no maneja adecuadamente las excepciones que podrían ocurrir durante la ejecución y sería recomendable agregar bloques try-catch o lanzar excepciones para hacer el código más robusto.
     * Comentarios de código: Sería recomendable agregar más comentarios para facilitar la comprensión del código.
     * Variables no utilizadas: La variable mision se declara y se inicializa pero no se utiliza, lo cual podría ser un error o que se haya eliminado alguna parte del código.
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
