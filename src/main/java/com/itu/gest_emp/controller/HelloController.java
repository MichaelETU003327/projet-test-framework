package com.itu.gest_emp.controller;

import java.util.Map;

import com.itu.gest_emp.model.Departement;
import com.itu.gest_emp.model.Employe;

import servlet.ModelView;
import servlet.annotations.Controller;
import servlet.annotations.RequestParam;
import servlet.annotations.Upload;
import servlet.annotations.mapping.GetMapping;
import servlet.annotations.mapping.PostMapping;
import servlet.annotations.mapping.RequestMapping;

@Controller
public class HelloController {
    @GetMapping("/upload")
    public ModelView upload() {
        ModelView modelView = new ModelView();
        modelView.setView("pages/upload.jsp");
        return modelView;
    }

    @PostMapping("/upload")
    @Upload
    public String handleUpload() {
        return "Upload réussi !";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Bonjour depuis le framework !";
    }

    @GetMapping("/form")
    public ModelView getForm() {
        ModelView modelView = new ModelView();
        modelView.setView("pages/form.jsp");
        return modelView;
    }

    @GetMapping("/emp-form")
    public ModelView getEmpForm() {
        ModelView modelView = new ModelView();
        modelView.setView("pages/emp-form.jsp");
        return modelView;
    }

    @GetMapping("/test-form")
    public ModelView getTestForm() {
        ModelView modelView = new ModelView();
        modelView.setView("pages/test-form.jsp");
        return modelView;
    }

    @GetMapping("/bye")
    public String bye() {
        return "Au revoir !";
    }

    @GetMapping("/etudiant/{id}")
    public int get(int id) {
        return id;
    }

    @RequestMapping("/personne")
    public String get(String var2, Integer id) {
        return var2;
    }

    @PostMapping("/save")
    public ModelView save(Map<String, Object> parameters) {
        ModelView modelView = new ModelView();
        modelView.setAttributes(parameters);
        modelView.setView("pages/result.jsp");
        return modelView;
    }

    @PostMapping("/save-emp")
    public ModelView save(Employe employe) {
        ModelView modelView = new ModelView();
        modelView.addAttribute("employe", employe);
        modelView.setView("pages/emp-result.jsp");
        return modelView;
    }

    @PostMapping("/submit-test")
    public ModelView save(Employe[] employes, Departement d, int deptId) {
        ModelView modelView = new ModelView();
        modelView.addAttribute("employes", employes);
        modelView.addAttribute("d", d);
        modelView.addAttribute("deptId", deptId);

        modelView.setView("pages/test-result.jsp");
        return modelView;
    }

    @GetMapping("/test/{id}")
    public String getVar2(@RequestParam(name = "var2") String var2, Integer id) {
        return var2;
    }

}
