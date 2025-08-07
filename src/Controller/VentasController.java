package Controller;

import Model.*;
import View.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Util.ManejoErrores;
import java.awt.HeadlessException;

public class VentasController {
    private Principal vista;
    private LogicaOrdenes logicaOrdenes;
    private Cliente clienteParaVenta;
    private ArrayList<Asiento> asientosParaVenta;
    private Funcion funcionParaVenta;
    private final SalasRepositorio repoSalas;
    private final IFuncionesRepositorio repoFunciones;
    private final IClienteRepositorio repoClientes;
    private Sala salaParaVenta;
    public Principal getVista() {
        return this.vista;
    }
    public VentasController(Principal vista, SalasRepositorio repoSalas, IFuncionesRepositorio repoFunciones, IClienteRepositorio repoClientes) {
        this.vista = vista;
        this.logicaOrdenes = new LogicaOrdenes();
        this.repoSalas = repoSalas;
        this.repoFunciones = repoFunciones;
        this.repoClientes = repoClientes;
        this.vista.botonAsignarAsientos.addActionListener(e -> {
            manejarSeleccionAsientos(this.vista.getTableSalas());
        });
        this.vista.botonAgregarCarritoV1.addActionListener(e -> registrarVenta());
        this.vista.getBotonAgregarCarritoV().addActionListener(e -> abrirRegistroVentas());

    }
    

    public void pagarOrden(int numOrden, Cliente cliente) {
        try {
            boolean resultado = logicaOrdenes.pagarOrden(numOrden, cliente);
            
            if (resultado) {
                JOptionPane.showMessageDialog(vista, 
                    "Orden #" + numOrden + " pagada correctamente", 
                    "Pago exitoso", 
                    JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(vista, 
                    "Error al procesar el pago de la orden #" + numOrden, 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            ManejoErrores.mostrarError("Error al pagar la orden", e, vista);
        }
    }
    
    

    public void crearNuevaOrden(Cliente cliente, Funcion funcion, ArrayList<Asiento> asientos, Sala salaModificada) {
        if (cliente == null) {
            JOptionPane.showMessageDialog(vista, 
                "Debe seleccionar un cliente primero", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            OrdenCompra nuevaOrden = logicaOrdenes.crearOrden(funcion, asientos, cliente);

            if (nuevaOrden != null) {
                JOptionPane.showMessageDialog(vista, 
                    "Orden creada exitosamente para la película " + 
                    funcion.getPelicula().obtenerTitulo() + 
                    " con " + asientos.size() + " asientos.\n" +
                    "Total: $" + nuevaOrden.getPrecioTotal(), 
                    "Orden Creada", 
                    JOptionPane.INFORMATION_MESSAGE);

                this.repoSalas.actualizarSala(salaModificada);

            }
        } catch (HeadlessException e) {
            ManejoErrores.mostrarError("Error al crear la orden", e, vista);
        }
    }
    public void agregarAlCarrito(Principal vista, Cliente cliente, int cantidadTickets) {
    // Implementación para agregar items al carrito
    JOptionPane.showMessageDialog(vista, 
        "Se agregaron " + cantidadTickets + " tickets al carrito de " + cliente.getNombre(), 
        "Agregado al carrito", 
        JOptionPane.INFORMATION_MESSAGE);
    }
    
    //parte que se agregara
    public void manejarSeleccionAsientos(javax.swing.JTable tablaSalas) {
        int cantidadTickets = (int) vista.getSpinnerTicketsV().getValue();

        //Validamos que la cantidad de asientos sea valida
        if (cantidadTickets <= 0) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar al menos 1 ticket.", "Cantidad inválida", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int filaSeleccionada = tablaSalas.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(vista, "Debes seleccionar una sala primero.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Nombre de la sala está en la columna 1
        String nombreSala = (String) tablaSalas.getValueAt(filaSeleccionada, 1);
        Sala salaSeleccionada = null;

        // Busca la sala en el repositorio
        for (Sala s : repoSalas.getSala()) {
            if (s.getNombre().equals(nombreSala)) {
                salaSeleccionada = s;
                break;
            }
        }

        if (salaSeleccionada == null) {
            JOptionPane.showMessageDialog(vista, "No se encontró la sala seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        abrirSeleccionAsientos(salaSeleccionada, cantidadTickets);
    }
     

        public void abrirSeleccionAsientos(Sala salaSeleccionada, int cantidadTickets) {
                if (salaSeleccionada == null) {
                    JOptionPane.showMessageDialog(vista, "Sala inválida o no encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                 

                // Creamos la vista de asientos, pasándole el propio VentasController
                SelecAsientos vistaAsientos = new SelecAsientos(salaSeleccionada, salaSeleccionada.isVip(), this, this.repoFunciones, this.repoClientes, cantidadTickets);
                vistaAsientos.setVisible(true);
                    this.salaParaVenta = salaSeleccionada; 
    
                // Guardamos los asientos seleccionados.
                this.asientosParaVenta = vistaAsientos.getAsientosConfirmados();
                    String cedulaStr = this.vista.getTextFieldClienteV().getText().trim();
                if (!cedulaStr.isEmpty() && !cedulaStr.equals("Ingrese Cédula")) {
                    this.clienteParaVenta = this.repoClientes.buscarClientePorCedula(Long.parseLong(cedulaStr));
                }
            }
            public void registrarVenta() {
               //Validamos que haya una selección pendiente
               if (clienteParaVenta == null || asientosParaVenta == null || asientosParaVenta.isEmpty() || funcionParaVenta == null) {
                   JOptionPane.showMessageDialog(vista, "Primero debe seleccionar un cliente y asientos.", "Acción no válida", JOptionPane.WARNING_MESSAGE);
                   return;
               }

               OrdenCompra nuevaOrden = logicaOrdenes.crearOrden(funcionParaVenta, asientosParaVenta, clienteParaVenta);
               

               if (nuevaOrden != null) {
                   //La marcamos como pagada
                   logicaOrdenes.pagarOrden(nuevaOrden.getNumOrden(), clienteParaVenta);


                   RegistroVentasModelo.agregarVenta(nuevaOrden);
                   this.repoSalas.actualizarSala(this.salaParaVenta);
                   

                   JOptionPane.showMessageDialog(vista, 
                       "Venta registrada exitosamente para el cliente " + clienteParaVenta.getNombre(), 
                       "Venta Registrada", 
                       JOptionPane.INFORMATION_MESSAGE);

                   // Limpiamos la selección para la siguiente venta
                   limpiarSeleccionVenta();
               }
       }

        // literalmente limpia el metodo
        private void limpiarSeleccionVenta() {
            this.clienteParaVenta = null;
            this.asientosParaVenta = null;
            this.funcionParaVenta = null;
            this.salaParaVenta = null;
            vista.mostrarPrecioFinalVenta(0.0); // Reiniciamos el label de precio
            vista.getTableSalas().clearSelection(); // Deseleccionamos la fila de la tabla
        }
        public void abrirRegistroVentas() {
            Carrito vistaRegistro = new Carrito(this, vista); 
            
            CarritoController registroController = new CarritoController(vistaRegistro); 

            vistaRegistro.setVisible(true);
            vista.setVisible(false);
        }
        public void guardarSeleccionPendiente(Cliente cliente, Funcion funcion, ArrayList<Asiento> asientos) {
            this.clienteParaVenta = cliente;
            this.funcionParaVenta = funcion;
            this.asientosParaVenta = asientos;

            // Calculamos y mostramos el precio para que el usuario lo vea
            double precioBase = 10.0;
            double precioTotal = 0.0;
            if (this.asientosParaVenta != null) {
                for (Asiento asiento : this.asientosParaVenta) {
                    precioTotal += asiento.obtenerPrecio(precioBase);
                }
            }
            vista.mostrarPrecioFinalVenta(precioTotal);
        }

}