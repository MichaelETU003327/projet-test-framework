<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Connexion Réussie</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; background: #f5f5f5; }
        .container { max-width: 600px; margin: 0 auto; background: white; padding: 30px; border-radius: 10px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); }
        h1 { color: #4caf50; text-align: center; }
        .success { padding: 20px; background: #e8f5e9; border-left: 4px solid #4caf50; margin: 20px 0; }
        .info { padding: 15px; background: #fff3e0; border-left: 4px solid #ff9800; margin: 20px 0; }
        .nav { margin: 20px 0; text-align: center; }
        .nav a { display: inline-block; margin: 5px; padding: 10px 20px; background: #2196f3; color: white; text-decoration: none; border-radius: 5px; }
        .nav a:hover { background: #1976d2; }
        table { width: 100%; border-collapse: collapse; margin: 15px 0; }
        td { padding: 10px; border-bottom: 1px solid #eee; }
        td:first-child { font-weight: bold; width: 40%; }
    </style>
</head>
<body>
    <div class="container">
        <h1>✅ Connexion Réussie!</h1>
        
        <div class="success">
            <table>
                <tr><td>Utilisateur:</td><td>${username}</td></tr>
                <tr><td>Rôle:</td><td><strong>${role}</strong></td></tr>
            </table>
        </div>
        
        <div class="info">
            <strong>Session créée avec:</strong>
            <ul>
                <li><code>auth = true</code></li>
                <li><code>user = "${username}"</code></li>
                <li><code>role = "${role}"</code></li>
            </ul>
        </div>
        
        <div class="nav">
            <a href="${pageContext.request.contextPath}/security/home">Accueil</a>
            <a href="${pageContext.request.contextPath}/security/profile">Mon Profil</a>
            <a href="${pageContext.request.contextPath}/security/admin">Page Admin</a>
            <a href="${pageContext.request.contextPath}/security/chef">Page Chef</a>
        </div>
    </div>
</body>
</html>
