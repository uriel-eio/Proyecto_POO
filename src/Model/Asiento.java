package Model;

import javax.swing.JOptionPane;

    public abstract class Asiento implements IAsiento {
        private String numero;
        private boolean estado; // false = libre, true = reservado

        public Asiento(String numero) {
            this.numero = numero;
            //Se dejará por defecto que el asiento está libre
            this.estado = false; 
            //guardarEnArchivo();
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
               this.estado = true; // Cambia el estado a "reservado"
               JOptionPane.showMessageDialog(
                   null, // Sin ventana padre (centrado en pantalla)
                   "Asiento " + this.numero + " reservado correctamente.",
                   "Reserva exitosa",  // Título del diálogo
                   JOptionPane.INFORMATION_MESSAGE // Icono de información
               );
           } else {
               JOptionPane.showMessageDialog(
                   null,
                   "Error: El asiento " + this.numero + " ya está reservado.",
                   "Error en reserva",
                   JOptionPane.WARNING_MESSAGE // Icono de advertencia
               );
           }
       }

       @Override
       public void liberar() {
           if (this.estado) {
               this.estado = false; // Cambia el estado a "libre"
               JOptionPane.showMessageDialog(
                   null,
                   "Asiento " + this.numero + " liberado correctamente.",
                   "Liberación exitosa",
                   JOptionPane.INFORMATION_MESSAGE
               );
           } else {
               JOptionPane.showMessageDialog(
                   null,
                   "Info: El asiento " + this.numero + " ya estaba libre.",
                   " Información",
                   JOptionPane.INFORMATION_MESSAGE
               );
           }
       }
       
       public void forzarReserva() {
            this.estado = true;
       }
       
        @Override
        public abstract double obtenerPrecio(double precioBase);

        @Override
        public abstract boolean isVIP();
    }