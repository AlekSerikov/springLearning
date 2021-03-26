package com.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/employee")
public class MyController {

    @RequestMapping("/")
    public String showFirstView() {
        return "first-view";
    }

    @RequestMapping("askDetails")
    public String askEmployeeDetails() {
        return "ask-emp-details-view";
    }

    @RequestMapping("showDetails")
    public String showEmployeeDetails(@RequestParam("employeeName") String empName, Model model) {

       empName = "Mr." + empName;
       model.addAttribute("nameAttribute", empName);

        return "show-emp-details-view";
    }


}
