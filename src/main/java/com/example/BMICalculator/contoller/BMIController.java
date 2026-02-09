package com.example.BMICalculator.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BMIController {

    @GetMapping("/")
    public String showForm() {
        return "bmiForm"; // Show the form page
    }

    @PostMapping("/calculate")
    public String calculateBMI(@RequestParam double weight,
                               @RequestParam double height,
                               Model model) {

        double bmiValue = weight / (height * height); // BMI formula

        String category;
        if (bmiValue < 18.5) {
            category = "Underweight";
        } else if (bmiValue < 24.9) {
            category = "Normal weight";
        } else if (bmiValue < 29.9) {
            category = "Overweight";
        } else {
            category = "Obesity";
        }

        // Add values to the view
        model.addAttribute("weight", weight);
        model.addAttribute("height", height);
        model.addAttribute("bmi", bmiValue);
        model.addAttribute("category", category);

        return "bmiResult"; // Show result page
    }
}
