package Ejercicio_10;
public class NodoPro {
    private int idCultivo;
    private double toneladas, hectareas;
    private NodoPro sig; //definiendo el campo enlace sig

    public NodoPro() {  //constructor
            sig = null;
    }

    public NodoPro getSig() {
            return sig;
    }

    public void setSig(NodoPro sig) {
            this.sig = sig;
    }

    public int getIdCultivo() {
        return idCultivo;
    }

    public void setIdCultivo(int idCultivo) {
        this.idCultivo = idCultivo;
    }

    public double getToneladas() {
        return toneladas;
    }

    public void setToneladas(double toneladas) {
        this.toneladas = toneladas;
    }

    public double getHectareas() {
        return hectareas;
    }

    public void setHectareas(double hectareas) {
        this.hectareas = hectareas;
    }
    
	
}
