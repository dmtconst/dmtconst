package org.example.demo111.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("calculator")
    public String secondController(Model model,
                                   @RequestParam(value = "x") int x,
                                   @RequestParam(value = "y") int y,
                                   @RequestParam(value = "action") String multiply) {

        int actionResult =
                switch (multiply) {
                    case "multiply" -> Math.multiplyExact(x, y);
                    case "subtract" -> Math.subtractExact(x, y);
                    default -> 0;
                };

        model.addAttribute("actionResult", "твой результат:  " + actionResult);

        return "model/calculator";
    }

}
