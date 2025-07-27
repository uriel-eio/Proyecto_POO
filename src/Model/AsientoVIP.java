package Model;

public class AsientoVIP extends Asiento {
    private boolean espacioExtraPiernas;
    private boolean reclinable;
    private static final double aumentoVIP = 2.0; 

    public AsientoVIP(String numero, boolean espacioExtraPiernas, boolean reclinable) {
        super(numero); 
        this.espacioExtraPiernas = espacioExtraPiernas;
        this.reclinable = reclinable;
    }

    @Override
    public double obtenerPrecio(double precioBase) {
        // El precio de un asiento VIP es el doble del precio base.
        return precioBase * aumentoVIP;
    }

    @Override
    public boolean isVIP() {
        return true;
    }

    public boolean getTieneEspacioExtraPiernas() {
        return espacioExtraPiernas;
    }

    public boolean getEsReclinable() {
        return reclinable;
    }
}