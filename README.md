# Sistema de Biblioteca Digital UNTEC - Modulo 5

## Descripcion del Proyecto
Esta aplicacion web dinamica permite la gestion de libros y prestamos de la **Biblioteca UNTEC**. El proyecto aplica el patron de diseño **MVC** y asegura la persistencia de datos mediante **JDBC** conectandose a una base de datos **MySQL**.

## Requerimientos Tecnicos
* **IDE:** Eclipse Enterprise Edition (Dynamic Web Project).
* **Java:** JDK 11
* **Servidor:** Apache Tomcat 9.0.
* **Base de Datos:** MySQL 8.0.
* **Librerias:** JSTL 1.2.1 y MySQL Connector (ubicados en WEB-INF/lib).

# Instrucciones de Instalacion y Uso
1. Importacion: En Eclipse, ir a File > Import > General > Existing Projects into Workspace y seleccionar la carpeta del proyecto.
2. Base de Datos: Ejecutar el script SQL superior en MySQL Workbench.
3. Conexion: Revisar la clase Conexion.java en el paquete cl.untec.utils para verificar credenciales.
4. Despliegue: Clic derecho en el proyecto > Run As > Run on Server seleccionando Tomcat 9.0.
5. Acceso: Ingresar al sistema mediante el formulario de Login en index.jsp (usuario: admin, contraseña: 1234).

# Estructura del Proyecto (Patron MVC)
* cl.untec.controller: Servlets que actuan como controladores.
* cl.untec.model: Clases de entidad y objetos de acceso a datos (DAOs).
* cl.untec.utils: Utilidades de conexion con patron Singleton.
* webapp: Vistas desarrolladas en JSP con etiquetas JSTL y estilos CSS.

# Evidencia de Funcionamiento
Las capturas de pantalla que demuestran el flujo funcional se encuentran adjuntas en la carpeta evidencia dentro del zip de entrega.

## Documentacion Tecnica: Base de Datos
Para que el sistema funcione, se debe crear la base de datos `biblioteca_untec`. A continuacion, se detalla el script necesario para replicar el entorno de desarrollo:

### Script de Configuracion 

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY, 
    nombre_usuario VARCHAR(50), 
    clave VARCHAR(50)
);

CREATE TABLE libros (
    id INT AUTO_INCREMENT PRIMARY KEY, 
    titulo VARCHAR(100), 
    autor VARCHAR(100)
);

CREATE TABLE prestamos (
    id INT AUTO_INCREMENT PRIMARY KEY, 
    id_libro INT, 
    usuario VARCHAR(50), 
    fecha_prestamo DATE, 
    estado VARCHAR(20) DEFAULT 'Activo'
);

INSERT INTO usuarios (nombre_usuario, clave) VALUES ('admin', '1234');

INSERT INTO libros (titulo, autor) VALUES 
('El Cuervo', 'Edgar Allan Poe'),
('Los Crimenes de la Calle Morgue', 'Edgar Allan Poe'),
('La Llamada de Cthulhu', 'H.P. Lovecraft'),
('En las Montañas de la Locura', 'H.P. Lovecraft'),
('Decimas', 'Violeta Parra'),
('Poesia Popular Chilena', 'Violeta Parra');
