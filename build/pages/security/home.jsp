<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Accueil - Test Sécurité</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; background: #f5f5f5; }
        .container { max-width: 800px; margin: 0 auto; background: white; padding: 30px; border-radius: 10px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); }
        h1 { color: #333; }
        .message { padding: 15px; background: #e8f5e9; border-left: 4px solid #4caf50; margin: 20px 0; }
        .nav { margin: 20px 0; }
        .nav a { display: inline-block; margin: 5px; padding: 10px 20px; background: #2196f3; color: white; text-decoration: none; border-radius: 5px; }
        .nav a:hover { background: #1976d2; }
        .nav a.protected { background: #ff9800; }
        .nav a.admin { background: #f44336; }
        .section { margin: 20px 0; padding: 15px; background: #fafafa; border-radius: 5px; }
        .section h3 { margin-top: 0; color: #666; }
    </style>
</head>
<body>
    <div class="container">
        <h1>🏠 Page d'Accueil</h1>
        
        <div class="message">
            ${message != null ? message : "Bienvenue sur la page de test de sécurité"}
        </div>
        
        <div class="section">
            <h3>🔓 Pages Publiques</h3>
            <div class="nav">
                <a href="${pageContext.request.contextPath}/security/home">Accueil</a>
                <a href="${pageContext.request.contextPath}/security/login">Se connecter</a>
            </div>
        </div>
        
        <div class="section">
            <h3>🔐 Pages Protégées (@Authorized)</h3>
            <div class="nav">
                <a href="${pageContext.request.contextPath}/security/profile" class="protected">Mon Profil</a>
                <a href="${pageContext.request.contextPath}/security/dashboard" class="protected">Dashboard</a>
            </div>
        </div>
        
        <div class="section">
            <h3>👑 Pages avec Rôle (@Role)</h3>
            <div class="nav">
                <a href="${pageContext.request.contextPath}/security/admin" class="admin">Admin Only</a>
                <a href="${pageContext.request.contextPath}/security/chef" class="admin">Chef Only</a>
                <a href="${pageContext.request.contextPath}/security/user-only" class="admin">User Only</a>
            </div>
        </div>
        
        <div class="section">
            <h3>🚪 Déconnexion</h3>
            <div class="nav">
                <a href="${pageContext.request.contextPath}/security/logout">Se déconnecter</a>
            </div>
        </div>
    </div>
</body>
</html>
