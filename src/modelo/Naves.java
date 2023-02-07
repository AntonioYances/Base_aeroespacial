
package modelo;

/**
 *
 * @author Antonio Yances
 */
public class Naves {
    
    private String nombre, status,biografia,combustible,tipo,pais;
    private double Velocidad;
    private String estado = "";   
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }     
   

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public double getVelocidad() {
        return Velocidad;
    }

    public void setVelocidad(double Velocidad) {
        this.Velocidad = Velocidad;
    }
   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
    
    
}
