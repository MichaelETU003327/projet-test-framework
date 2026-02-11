<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Administration</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; background: #f5f5f5; }
        .container { max-width: 600px; margin: 0 auto; background: white; padding: 30px; border-radius: 10px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); }
        h1 { color: #f44336; }
        .badge { display: inline-block; padding: 5px 15px; background: #f44336; color: white; border-radius: 20px; font-size: 12px; }
        .content { padding: 20px; background: #ffebee; border-radius: 5px; margin: 20px 0; }
        .nav { margin: 20px 0; }
        .nav a { display: inline-block; margin: 5px; padding: 10px 20px; background: #2196f3; color: white; text-decoration: none; border-radius: 5px; }
    </style>
</head>
<body>
    <div class="container">
        <h1>🔧 Administration <span class="badge">@Role("admin")</span></h1>
        
        <div class="content">
            <p>Bienvenue <strong>${username}</strong>!</p>
            <p>${message}</p>
        </div>
        
        <p><em>Cette page est accessible uniquement aux utilisateurs avec le rôle "admin"</em></p>
        
        <div class="nav">
            <a href="${pageContext.request.contextPath}/security/home">Accueil</a>
            <a href="${pageContext.request.contextPath}/security/logout">Déconnexion</a>
        </div>
    </div>
</body>
</html>
