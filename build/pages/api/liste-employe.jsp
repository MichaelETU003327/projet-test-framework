<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des employés</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        h1 { color: #333; }
        #employe-list { list-style: none; padding: 0; }
        #employe-list li { 
            padding: 10px; 
            margin: 5px 0; 
            background: #f5f5f5; 
            border-radius: 4px;
        }
        .loading { color: #666; font-style: italic; }
        .error { color: red; }
    </style>
</head>
<body>
    <h1>Liste des employés</h1>
    <ul id="employe-list">
        <li class="loading">Chargement...</li>
    </ul>
    <script>
        fetch('api/employes')
            .then(response => response.json())
            .then(data => {
                const list = document.getElementById('employe-list');
                list.innerHTML = '';
                
                const realData = data.data || [];
                console.log('Fetched data:', realData);
                
                if (realData.length === 0) {
                    list.innerHTML = '<li>Aucun employé trouvé</li>';
                    return;
                }
                
                realData.forEach(employe => {
                    const item = document.createElement('li');
                    item.textContent = employe.nom + ' ' + employe.prenom + ' - Age: ' + employe.age;
                    list.appendChild(item);
                });
            })
            .catch(error => {
                console.error('Error fetching employes:', error);
                const list = document.getElementById('employe-list');
                list.innerHTML = '<li class="error">Erreur lors du chargement</li>';
            });
    </script>
</body>

</html>