<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Mon Profil</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; background: #f5f5f5; }
        .container { max-width: 600px; margin: 0 auto; background: white; padding: 30px; border-radius: 10px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); }
        h1 { color: #ff9800; }
        .badge { display: inline-block; padding: 5px 15px; background: #ff9800; color: white; border-radius: 20px; font-size: 12px; }
        .profile-info { padding: 20px; background: #fff3e0; border-radius: 5px; margin: 20px 0; }
        table { width: 100%; }
        td { padding: 10px; }
        td:first-child { font-weight: bold; width: 30%; }
        .nav { margin: 20px 0; }
        .nav a { display: inline-block; margin: 5px; padding: 10px 20px; background: #2196f3; color: white; text-decoration: none; border-radius: 5px; }
    </style>
</head>
<body>
    <div class="container">
        <h1>👤 Mon Profil <span class="badge">@Authorized</span></h1>
        
        <div class="profile-info">
            <table>
                <tr><td>Utilisateur:</td><td>${username}</td></tr>
                <tr><td>Rôle:</td><td>${role}</td></tr>
            </table>
        </div>
        
        <p><em>Cette page est accessible uniquement aux utilisateurs authentifiés (annotation @Authorized)</em></p>
        
        <div class="nav">
            <a href="${pageContext.request.contextPath}/security/home">Accueil</a>
            <a href="${pageContext.request.contextPath}/security/logout">Déconnexion</a>
        </div>
    </div>
</body>
</html>
