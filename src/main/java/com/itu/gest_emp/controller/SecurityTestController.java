package com.itu.gest_emp.controller;

import servlet.ModelView;
import servlet.annotations.Authorized;
import servlet.annotations.Controller;
import servlet.annotations.Role;
import servlet.annotations.Session;
import servlet.annotations.mapping.GetMapping;
import servlet.annotations.mapping.PostMapping;
import servlet.session.CustomSession;

/**
 * Contrôleur de test pour la fonctionnalité de sécurité (@Authorized, @Role)
 */
@Controller
public class SecurityTestController {

    // ==================== PAGES PUBLIQUES ====================

    /**
     * Page d'accueil - accessible à tous
     */
    @GetMapping("/security/home")
    public ModelView home() {
        ModelView mv = new ModelView("/pages/security/home.jsp");
        mv.addAttribute("message", "Page publique - accessible à tous");
        return mv;
    }

    /**
     * Page de login - accessible à tous
     */
    @GetMapping("/security/login")
    public ModelView loginPage() {
        return new ModelView("/pages/security/login.jsp");
    }

    /**
     * Traitement du login - crée la session avec auth et role
     */
    @PostMapping("/security/login")
    public ModelView doLogin(String username, String role, @Session(create = true) CustomSession session) {
        // Simuler un login réussi
        session.setAttribute("auth", true); // Variable d'authentification
        session.setAttribute("user", username); // Stocker le username
        session.setAttribute("role", role); // Variable de rôle

        ModelView mv = new ModelView("/pages/security/login-success.jsp");
        mv.addAttribute("username", username);
        mv.addAttribute("role", role);
        return mv;
    }

    /**
     * Logout - invalide la session
     */
    @GetMapping("/security/logout")
    public ModelView logout(@Session CustomSession session) {
        if (session != null) {
            session.invalidate();
        }
        ModelView mv = new ModelView("/pages/security/home.jsp");
        mv.addAttribute("message", "Vous êtes déconnecté");
        return mv;
    }

    // ==================== PAGES PROTÉGÉES (@Authorized) ====================

    /**
     * Page protégée - nécessite authentification (n'importe quel utilisateur
     * connecté)
     */
    @Authorized
    @GetMapping("/security/profile")
    public ModelView profile(@Session CustomSession session) {
        ModelView mv = new ModelView("/pages/security/profile.jsp");
        mv.addAttribute("username", session.getAttribute("user"));
        mv.addAttribute("role", session.getAttribute("role"));
        return mv;
    }

    /**
     * Autre page protégée - nécessite authentification
     */
    @Authorized
    @GetMapping("/security/dashboard")
    public ModelView dashboard(@Session CustomSession session) {
        ModelView mv = new ModelView("/pages/security/dashboard.jsp");
        mv.addAttribute("username", session.getAttribute("user"));
        return mv;
    }

    // ==================== PAGES AVEC RÔLE (@Role) ====================

    /**
     * Page admin - nécessite le rôle "admin"
     */
    @Role("admin")
    @GetMapping("/security/admin")
    public ModelView adminPage(@Session CustomSession session) {
        ModelView mv = new ModelView("/pages/security/admin.jsp");
        mv.addAttribute("username", session.getAttribute("user"));
        mv.addAttribute("message", "Bienvenue dans l'espace administrateur!");
        return mv;
    }

    /**
     * Page chef - nécessite le rôle "chef"
     */
    @Role("chef")
    @GetMapping("/security/chef")
    public ModelView chefPage(@Session CustomSession session) {
        ModelView mv = new ModelView("/pages/security/chef.jsp");
        mv.addAttribute("username", session.getAttribute("user"));
        mv.addAttribute("message", "Bienvenue chef!");
        return mv;
    }

    /**
     * Page user - nécessite le rôle "user"
     */
    @Role("user")
    @GetMapping("/security/user-only")
    public ModelView userOnlyPage(@Session CustomSession session) {
        ModelView mv = new ModelView("/pages/security/user-only.jsp");
        mv.addAttribute("username", session.getAttribute("user"));
        return mv;
    }
}
