package com.itu.gest_emp.controller;

import servlet.ModelView;
import servlet.annotations.Controller;
import servlet.annotations.Session;
import servlet.annotations.mapping.GetMapping;
import servlet.annotations.mapping.PostMapping;
import servlet.session.CustomSession;

@Controller
public class AuthController {

    // Login - crée une session automatiquement
    @PostMapping("/login")
    public String login(@Session CustomSession session, String username, String password) {
        // Valider les credentials...

        session.setAttribute("user", username);
        session.setAttribute("loginTime", System.currentTimeMillis());

        return "Login réussi pour " + username;
    }

    // Profile - utilise la session existante
    @GetMapping("/profile")
    public ModelView profile(@Session CustomSession session) {
        String username = session.getAttribute("user", String.class);

        if (username == null) {
            ModelView mv = new ModelView();
            mv.setView("pages/login.jsp");
            return mv;
        }

        ModelView mv = new ModelView();
        mv.addAttribute("username", username);
        mv.addAttribute("sessionId", session.getSessionId());
        mv.setView("pages/profile.jsp");
        return mv;
    }

    // Logout - invalide la session
    @PostMapping("/logout")
    public String logout(@Session CustomSession session) {
        String username = session.getAttribute("user", String.class);
        session.invalidate();

        return "Au revoir " + username;
    }

    // Info session
    @GetMapping("/session-info")
    public String sessionInfo(@Session CustomSession session) {
        StringBuilder info = new StringBuilder();
        info.append("Session ID: ").append(session.getSessionId()).append("\n");
        info.append("Creation Time: ").append(session.getCreationTime()).append("\n");
        info.append("Is New: ").append(session.isNew()).append("\n");
        info.append("Attributes:\n");

        for (String name : session.getAttributeNames()) {
            info.append("  - ").append(name).append(" = ")
                    .append(session.getAttribute(name)).append("\n");
        }

        return info.toString();
    }

    // Ne créer session que si nécessaire
    @GetMapping("/check-auth")
    public String checkAuth(@Session(create = false) CustomSession session) {
        if (session == null) {
            return "Non authentifié";
        }

        String username = session.getAttribute("user", String.class);
        return username != null ? "Authentifié: " + username : "Non authentifié";
    }
}
