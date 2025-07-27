package Model;

public class AsientoEstandar extends Asiento {

    public AsientoEstandar(String numero) {
        super(numero);
    }

    @Override
    public double obtenerPrecio(double precioBase) {
        // @TODO: Falta el precio y como determinarlo
        return precioBase;
    }

    @Override
    public boolean isVIP() {
        return false;
    }
}