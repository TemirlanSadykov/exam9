package com.example.exam9.domain.form;

import com.example.exam9.domain.customer.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping
@AllArgsConstructor
public class FormController {

    @Autowired
    private FormRepository formRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/createNewForm")
    public String createNewFormPage(Model model){
        return "createNewForm";
    }
    @PostMapping("/createNewForm")
    public String createNewForm(@RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("customer") String customer){

        Date date = new Date();
        var form = Form.builder()
                .customer(customerRepository.findByName(customer).get())
                .description(description)
                .name(name)
                .date(date)
                .build();
        formRepository.save(form);
        return "redirect:/profile";
    }
}
