# Manual de Usuario — Proyecto POO

## Índice

1. [Introducción](#introducción)
2. [Requisitos del Sistema](#requisitos-del-sistema)
3. [Instalación y Ejecución](#instalación-y-ejecución)
4. [Opciones Principales](#opciones-principales)
   - [1. Inicio de sesión (Login)](#inicio-de-sesión-login)
   - [2. Gestión de Películas](#gestión-de-películas)
   - [3. Gestión de Clientes](#gestión-de-clientes)
   - [4. Gestión de Salas](#gestión-de-salas)
   - [5. Ventas](#ventas)
5. [Preguntas Frecuentes (FAQ)](#preguntas-frecuentes-faq)
6. [Contacto y Soporte](#contacto-y-soporte)

---

## Introducción

Se presenta el Cine Poorfis, creado a partir del lenguaje Java utilizando el entorno NetBeans. Se construye un sistema el cual emula a la página web de un cine en general, teniendo como características principales la implementación de gestión de películas, gestión de clientes, gestión de salas, ventas e inicio de sesión, usando distintas herramientas para el desarrollo del GUI correspondiente y su parte lógica o codificación, todo desde una interfaz sencilla e intuitiva.

## Requisitos del Sistema

### Hardware

- Procesador: Intel Core i3 o equivalente
- Memoria RAM: 4gb mínimo

### Software

- Windows 10 o superior
- Linux (Ubuntu 18.04+, Fedora 30+)
- macOS 10.13 High Sierra o superior
- Java Development Kit (JDK) versión 11 o superior instalado y configurado en el PATH del sistema.
- Editor de texto o IDE recomendado: NetBeans, Eclipse, IntelliJ IDEA, VS Code (con soporte Java).

## Instalación y Ejecución

Para poder instalar y utilizar el Banco Poorfis, se recomienda seguir los siguientes pasos:

### 1. Clonar el repositorio de GitHub

Abre un terminal en tu dispositivo y ejecuta el siguiente comando para que se descargue el proyecto en tu computadora de manera local.
```
git clone https://github.com/uriel-eio/Proyecto_POO.git
```

### 2. Verificar la versión de Java en tu dispositivo

Asegúrate de haber instalado Java JDK 11 o una versión superior.

```
java -version
```

En caso de no tenerlo instalado, puedes descargarlo desde el siguiente enlace:
[https://www.oracle.com/java/technologies/downloads/]

### 3. Abre tu IDE favorito y selecciona 'Open Project'

Para poder hacer uso del programa, dirígete a esta ruta en tu computador: C:\Users\[tu_usuario]\Proyecto_POO
En ella se encontrará el proyecto de la aplicación. Por ejemplo, puede mostrarse de esta manera:

(Ingresar captura)

### 4. Ejecutar el proyecto

Luego de haber abierto el proyecto correctamente, busca la opción 'Run' en la barra de herramientas de tu editor de texto, en ella seleccionas la opción 'Run File o Run Project', posterior a ello podrás disfrutar de la aplicación sin problemas.

## Opciones Principales

En esta sección se describe cómo usar las principales funcionalidades del programa.

### Inicio de sesión (Login)

- **Descripción:**

Al momento de ejecutar el programa, se despliega la siguiente ventana la cual contiene dos casillas que deben ser rellenadas para que se pueda accerder a las opciones principales, es decir, iniciar sesión. A continuación el usuario y contraseña que debes ingresar:
Usuario: admin
Contraseña: admin

![login](login.jpg)

- **Pasos:**  
  1. Ingresar usuario y contraseña.
  2. Acceso según rol (administrador, cliente, etc.).

### Gestión de Salas

- **Descripción:**

Se permite administrar las salas del Cine, además de su capacidad y disponibilidad.
  
- **Pasos:**
  1. Por defecto, el programa después de iniciar sesión te llevará a la ventana de Salas.
  2. (Aqui van las funcionalidades de la ventana Salas)

### Ventas

- **Descripción:** Proceso de venta de boletos.
- **Pasos:**
  1. Seleccionar película, sala y horario.
  2. Seleccionar cliente.
  3. Confirmar y registrar la venta.

### Gestión de Películas

- **Descripción:**

Se permite visualizar las películas en cartelera y sus características, tales como título, género, calificación y su portada.
  
- **Pasos para su uso:**
  1. Acceder al menú de Películas, en él se desplegarán los largometrajes que están en cartelera.
  2. En caso de querer agregar una nueva película, debes seleccionar el botón Agregar Película, en el introducirás los siguientes datos: nombre de la película, género, tiempo de duración en minutos, restricción de edad.
  3. Para finalizar la tarea de agregar una película, debes seleccionar una imagen para que sea la portada de la película; el programa te llevará directamente al explorador de archivos en donde deberás escoger una buena portada para tu película.

### Gestión de Clientes

- **Descripción:**

Esta sección del programa permite registrar nuevos clientes, actualizar su información, eliminar los registros y consultar el historial de las compras.
  
- **Pasos para su uso:**
  1. Selecciona la ventana Clientes.
  2. Si deseas registrar un nuevo cliente, selecciona el botón registrar e introduce los datos correspondientes: número de cédula, nombre, número de teléfono.
  3. En caso de requerir editar la información del cliente que registraste, debes seleccionar el botón modificar.
  4. Para poder acceder a las transacciones que realizó el cliente registrado, por favor pulsa el botón carrito.

## Preguntas Frecuentes (FAQ)

- ¿Qué hacer si olvidé mi contraseña?
- ¿Cómo agregar una nueva película?
- ¿Cómo consultar ventas realizadas?

## Contacto y Soporte

- Email de contacto: uriel.duenas@epn.edu.ec
- Enlace a issues en GitHub

---

**Consejo:** Puedes acompañar cada paso con capturas de pantalla y ejemplos para mayor claridad.
