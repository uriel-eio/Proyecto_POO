package Model;


public abstract class Asiento implements IAsiento {
    private String numero;
    private boolean estado; // false = libre, true = reservado

    public Asiento(String numero) {
        this.numero = numero;
        //Se dejará por defecto que el asiento está libre
        this.estado = false; 
    }

    @Override
    public String obtenerNumero() {
        return this.numero;
    }

    @Override
    public boolean obtenerEstado() {
        return this.estado;
    }

    @Override
    public void reservar() {
        if (!this.estado) {
            this.estado = true;
            System.out.println("Asiento " + this.numero + " reservado correctamente.");
        } else {
            System.out.println("Error: El asiento " + this.numero + " ya se encuentra reservado.");
        }
    }

    @Override
    public void liberar() {
        if (this.estado) {
            this.estado = false;
            System.out.println("Asiento " + this.numero + " liberado correctamente.");
        } else {
            System.out.println("Info: El asiento " + this.numero + " ya se encontraba libre.");
        }
    } 
    //@TODO: debemos marcar un precio base y programarlo
    @Override
    public abstract double obtenerPrecio(double precioBase);

    @Override
    public abstract boolean isVIP();
}