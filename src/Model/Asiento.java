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
                this.estado = true;
            }
        }

       @Override
       public void liberar() {
            // Simplemente cambia el estado si el asiento estaba reservado.
            if (this.estado) {
                this.estado = false;
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