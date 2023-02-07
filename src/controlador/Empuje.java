
package controlador;
import controlador.controladorNaves;
import javax.swing.JOptionPane;
/**
 *
 * @author Antonio Yances
 */
public class Empuje extends Mision{
    private double result;
    
    @Override
    public void calcular() {
        double masa = controladorNaves.masa, aceleracion = controladorNaves.aceleracion;
        result = masa * aceleracion;
        JOptionPane.showMessageDialog(null,"El empuje del cohete es: "+result);
    }
    
}
