<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Biblioteca UNTEC - Login</title>
    <style>
        body { font-family: 'Segoe UI', sans-serif; background: #2c3e50; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }
        .login-box { background: white; padding: 40px; border-radius: 10px; box-shadow: 0 10px 25px rgba(0,0,0,0.3); width: 350px; }
        h2 { text-align: center; color: #34495e; margin-bottom: 25px; }
        h3 { text-align: center; color: #7f8c8d; font-size: 16px; margin-bottom: 20px; font-weight: normal; }
        label { color: #34495e; font-weight: bold; font-size: 14px; }
        input { width: 100%; padding: 12px; margin: 8px 0 20px 0; border: 1px solid #ddd; border-radius: 5px; box-sizing: border-box; }
        button { width: 100%; padding: 12px; background: #3498db; color: white; border: none; border-radius: 5px; cursor: pointer; font-size: 16px; font-weight: bold; }
        button:hover { background: #2980b9; }
        .error { color: #e74c3c; text-align: center; font-size: 14px; margin-top: 15px; }
    </style>
</head>
<body>
    <div class="login-box">
        <h2>Biblioteca UNTEC</h2>
        <h3>Identificación de Usuario</h3>
        
        <form action="login" method="post">
            <label>Nombre de Usuario</label>
            <input type="text" name="txtUsuario" required>
            
            <label>Contraseña</label>
            <input type="password" name="txtPassword" required>
            
            <button type="submit">Entrar al Sistema</button>
        </form>

        <c:if test="${not empty error}">
            <p class="error">${error}</p>
        </c:if>
    </div>
</body>
</html>