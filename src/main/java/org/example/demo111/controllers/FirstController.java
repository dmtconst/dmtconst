package org.example.demo111.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/1")
public class FirstController {

    @GetMapping("/first")
    public String firstController(HttpServletRequest req) {
        String name = req.getParameter("name");
        String lastName = req.getParameter("lastName");

        System.out.println("Salam " + name + " " + lastName);
        return "first";
    }


    @GetMapping("/second")
    public String secondController(@RequestParam(value = "login", required = false) String login,
                                   @RequestParam(value = "password", required = false) String password) {
        System.out.println("Salam " + login + " " + password);
        return "second";
    }

    @GetMapping("/five")
    public String fiveController() {
        return "five/five";
    }
}
