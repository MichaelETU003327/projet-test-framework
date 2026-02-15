package com.itu.gest_emp.controller;

import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.itu.gest_emp.model.Employe;
import com.itu.gest_emp.model.Departement;

import servlet.ModelView;
import servlet.annotations.Controller;
import servlet.annotations.Json;
import servlet.annotations.mapping.GetMapping;
import servlet.annotations.mapping.PostMapping;
import servlet.api.ApiResponse;

@Controller
public class ApiController {

    @GetMapping("/employes")
    public ModelView getEmployes() {
        ModelView mv = new ModelView();
        mv.setView("pages/api/liste-employe.jsp");
        return mv;
    }
    

    // ========== Exemple 1: Retour automatique en JSON ==========
    @Json
    @GetMapping("/api/employes")
    public List<Employe> getAllEmployes() {
        // Le framework va automatiquement wrapper ça dans ApiResponse.success()
        Employe e1 = new Employe(1, "RAKOTO", "Jean", 25, null);
        Employe e2 = new Employe(2, "RANDRIA", "Marie", 30, null);
        return Arrays.asList(e1, e2);
    }

    // Retour JSON:
    // {
    // "status": "success",
    // "code": 200,
    // "data": [
    // { "id": 1, "nom": "RAKOTO", "prenom": "Jean", "age": 25 },
    // { "id": 2, "nom": "RANDRIA", "prenom": "Marie", "age": 30 }
    // ]
    // }

    // ========== Exemple 2: Retour d'un objet simple ==========
    @Json
    @GetMapping("/api/employe/{id}")
    public Employe getEmploye(int id) {
        return new Employe(id, "RAKOTO", "Jean", 25, null);
    }

    // Retour JSON:
    // {
    // "status": "success",
    // "code": 200,
    // "data": {
    // "id": 1,
    // "nom": "RAKOTO",
    // "prenom": "Jean",
    // "age": 25
    // }
    // }

    // ========== Exemple 3: Retour Map ==========
    @Json
    @GetMapping("/api/stats")
    public Map<String, Object> getStats() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("totalEmployes", 150);
        stats.put("totalDepartements", 12);
        stats.put("moyenneAge", 32.5);
        return stats;
    }

    // Retour JSON:
    // {
    // "status": "success",
    // "code": 200,
    // "data": {
    // "totalEmployes": 150,
    // "totalDepartements": 12,
    // "moyenneAge": 32.5
    // }
    // }

    // ========== Exemple 4: Contrôle manuel avec ApiResponse ==========
    @Json
    @PostMapping("/api/employe/create")
    public ApiResponse<Employe> createEmploye(Employe employe) {
        // Validation
        if (employe.getNom() == null || employe.getNom().isEmpty()) {
            return ApiResponse.error(400, "Le nom est obligatoire", null);
        }

        // Simulation sauvegarde
        employe.setId(123); // ID généré

        return ApiResponse.success(employe);
    }

    // Retour JSON (succès):
    // {
    // "status": "success",
    // "code": 200,
    // "data": { "id": 123, "nom": "RAKOTO", ... }
    // }
    //
    // Retour JSON (erreur):
    // {
    // "status": "error",
    // "code": 400,
    // "error": {
    // "code": "400",
    // "message": "Le nom est obligatoire"
    // }
    // }

    // ========== Exemple 5: Liste avec count ==========
    @Json
    @GetMapping("/api/departements")
    public Map<String, Object> getDepartements() {
        List<Departement> depts = Arrays.asList(
                new Departement(1, "Informatique"),
                new Departement(2, "RH"),
                new Departement(3, "Finance"));

        Map<String, Object> result = new HashMap<>();
        result.put("count", depts.size());
        result.put("result", depts);

        return result;
    }

    // Retour JSON:
    // {
    // "status": "success",
    // "code": 200,
    // "data": {
    // "count": 3,
    // "result": [...]
    // }
    // }
}