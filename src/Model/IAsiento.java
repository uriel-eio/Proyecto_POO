package Model;

public interface IAsiento {
    String obtenerNumero();
    boolean obtenerEstado(); // true para reservado, false para libre
    void reservar();
    void liberar();
    double obtenerPrecio(double precioBase); //@TODO: Marcar un precio base en una variable final
    boolean isVIP();
}