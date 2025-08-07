package Model;

public class AsientoEstandar extends Asiento {

    public AsientoEstandar(String numero) {
        super(numero);
    }

    @Override
    public double obtenerPrecio(double precioBase) {
        return precioBase;
    }

    @Override
    public boolean isVIP() {
        return false;
    }
}