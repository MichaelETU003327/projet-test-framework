<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login - Test Sécurité</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; background: #f5f5f5; }
        .container { max-width: 500px; margin: 0 auto; background: white; padding: 30px; border-radius: 10px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); }
        h1 { color: #333; text-align: center; }
        .form-group { margin: 20px 0; }
        label { display: block; margin-bottom: 5px; font-weight: bold; color: #555; }
        input, select { width: 100%; padding: 12px; border: 1px solid #ddd; border-radius: 5px; box-sizing: border-box; font-size: 16px; }
        button { width: 100%; padding: 15px; background: #4caf50; color: white; border: none; border-radius: 5px; font-size: 16px; cursor: pointer; margin-top: 10px; }
        button:hover { background: #45a049; }
        .info { padding: 15px; background: #e3f2fd; border-left: 4px solid #2196f3; margin: 20px 0; font-size: 14px; }
        .back { text-align: center; margin-top: 20px; }
        .back a { color: #2196f3; }
    </style>
</head>
<body>
    <div class="container">
        <h1>🔑 Connexion</h1>
        
        <div class="info">
            <strong>Test de sécurité:</strong><br>
            Choisissez un nom d'utilisateur et un rôle pour tester les différentes pages protégées.
        </div>
        
        <form action="${pageContext.request.contextPath}/security/login" method="POST">
            <div class="form-group">
                <label for="username">Nom d'utilisateur</label>
                <input type="text" id="username" name="username" placeholder="Ex: john" required>
            </div>
            
            <div class="form-group">
                <label for="role">Rôle</label>
                <select id="role" name="role" required>
                    <option value="">-- Choisir un rôle --</option>
                    <option value="user">user (utilisateur standard)</option>
                    <option value="chef">chef</option>
                    <option value="admin">admin (administrateur)</option>
                </select>
            </div>
            
            <button type="submit">Se connecter</button>
        </form>
        
        <div class="back">
            <a href="${pageContext.request.contextPath}/security/home">← Retour à l'accueil</a>
        </div>
    </div>
</body>
</html>
