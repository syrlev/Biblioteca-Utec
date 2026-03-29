<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Biblioteca UNTEC - Inicio</title>
    <style>
        body { font-family: 'Segoe UI', sans-serif; background: #f4f7f6; margin: 0; padding: 20px; }
        .container { max-width: 1000px; margin: auto; background: white; padding: 30px; border-radius: 8px; box-shadow: 0 2px 15px rgba(0,0,0,0.1); }
        h1, h3 { color: #2c3e50; border-bottom: 2px solid #3498db; padding-bottom: 10px; }
        .form-registro { background: #f9f9f9; padding: 20px; border-radius: 8px; margin: 20px 0; border: 1px solid #eee; }
        input[type="text"] { padding: 10px; border: 1px solid #ddd; border-radius: 4px; width: 250px; margin-right: 10px; }
        button[type="submit"] { padding: 10px 20px; background: #3498db; color: white; border: none; border-radius: 4px; cursor: pointer; }
        button[type="submit"]:hover { background: #2980b9; }
        table { width: 100%; border-collapse: collapse; margin: 20px 0; }
        th { background: #3498db; color: white; padding: 12px; text-align: left; }
        td { padding: 12px; border-bottom: 1px solid #eee; }
        tr:hover { background: #f9f9f9; }
        .btn { display: inline-block; padding: 6px 12px; text-decoration: none; border-radius: 4px; font-size: 13px; font-weight: bold; }
        .btn-solicitar { background: #2ecc71; color: white; }
        .btn-eliminar { background: #e74c3c; color: white; }
        .btn-devolver { background: #e67e22; color: white; }
        .header-info { display: flex; justify-content: space-between; align-items: center; background: #34495e; color: white; padding: 15px 25px; border-radius: 5px; margin-bottom: 20px; }
        .header-info a { color: #f1c40f; text-decoration: none; font-weight: bold; }
        .nav-home { margin-bottom: 20px; display: block; }
    </style>
</head>
<body>
    <div class="container">
        <div class="header-info">
            <span>Bienvenido, <strong>${usuarioLogueado}</strong></span>
            <a href="logout">Cerrar Sesión</a>
        </div>

        <a href="home" class="nav-home" style="text-decoration: none; color: #5c67f2; font-weight: bold;">
            🏠 Inicio / Actualizar Lista
        </a>

        <h1>Sistema de Biblioteca UNTEC</h1>

        <div class="form-registro">
            <h3>Registrar Nuevo Libro</h3>
            <form action="insertar" method="post">
                <input type="text" name="txtTitulo" placeholder="Título del libro" required>
                <input type="text" name="txtAutor" placeholder="Autor" required>
                <button type="submit">Guardar Libro</button>
            </form>
        </div>

        <h3>Catálogo de Libros</h3>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Título</th>
                    <th>Autor</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="libro" items="${libros}">
                    <tr>
                        <td>${libro.id}</td>
                        <td>${libro.titulo}</td>
                        <td>${libro.autor}</td>
                        <td>
                            <a href="prestamo?accion=solicitar&idLibro=${libro.id}" class="btn btn-solicitar">Solicitar</a>
                            <a href="eliminar?id=${libro.id}" class="btn btn-eliminar" 
                               onclick="return confirm('¿Seguro que quieres eliminar este libro?')">Eliminar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <h3>Mis Préstamos y Devoluciones</h3>
        <table>
            <thead>
                <tr>
                    <th>Libro</th>
                    <th>Fecha</th>
                    <th>Estado</th>
                    <th>Acción</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="p" items="${listaPrestamos}">
                    <tr>
                        <td><c:out value="${p.tituloLibro}" /></td>
                        <td>${p.fecha}</td>
                        <td><strong>${p.estado}</strong></td>
                        <td>
                            <c:if test="${p.estado == 'Activo'}">
                                <a href="prestamo?accion=devolver&id=${p.id}" class="btn btn-devolver">Devolver</a>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>