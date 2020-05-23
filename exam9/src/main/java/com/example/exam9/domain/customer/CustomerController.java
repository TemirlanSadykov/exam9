package com.example.exam9.domain.customer;

import com.example.exam9.domain.form.FormRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.UUID;

@Controller
@RequestMapping
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerRepository repository;
    private final ResetRepository resetRepository;

    @Autowired
    private FormRepository formRepository;

    @GetMapping("/profile")
    public String pageCustomerProfile(Model model, Principal principal) {
        var user = customerService.getByEmail(principal.getName());
        model.addAttribute("dto", user);
        model.addAttribute("form", formRepository.findAll());
        return "profile";
    }


    @GetMapping("/register")
    public String pageRegisterCustomer(Model model) {
        if (!model.containsAttribute("dto")) {
            model.addAttribute("dto", new CustomerRegisterForm());
        }

        return "register";
    }

    @GetMapping("/forgot")
    public String forgotPassword(Model model) {
        return "forgot";
    }

    @PostMapping("/forgot")
    public String forgot(@RequestParam("email") String email,
                         RedirectAttributes attributes) {
        if (!repository.existsByEmail(email)) {
            attributes.addFlashAttribute("errors", "Email doesn't exist");
            return "redirect:/login";
        }

        PasswordResetToken passwordResetToken = PasswordResetToken.builder()
                .customer(repository.findByEmail(email).get())
                .token(UUID.randomUUID().toString())
                .build();

        resetRepository.deleteAll();
        resetRepository.save(passwordResetToken);

        return "redirect:/reset-password";
    }

    @GetMapping("/reset-password")
    public String resetPasswordPage(Model model) {
        return "forgot-success";
    }

    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam("token") String token, @RequestParam("newPassword") String newPassword,
                                RedirectAttributes attributes) {
        if (!resetRepository.existsByToken(token)) {
            attributes.addFlashAttribute("errors", "Token doesn't exist");
            return "redirect:/forgot-success";
        }

        PasswordResetToken ptoken = resetRepository.findByToken(token).get();
        Customer customer = repository.findById(ptoken.getCustomer().getId()).get();
        customer.setPassword(new BCryptPasswordEncoder().encode(newPassword));

        repository.save(customer);

        return "redirect:/login";
    }

    @PostMapping("/register")
    public String registerPage(@Valid CustomerRegisterForm customerRequestDto,
                               BindingResult validationResult,
                               RedirectAttributes attributes) throws IOException, NullPointerException {

        attributes.addFlashAttribute("dto", customerRequestDto);

        if (validationResult.hasFieldErrors()) {
            attributes.addFlashAttribute("errors", validationResult.getFieldErrors());
            return "redirect:/register";
        }

        customerService.register(customerRequestDto);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage(@RequestParam(required = false, defaultValue = "false") Boolean error, Model model) {
        model.addAttribute("error", error);
        return "login";
    }
}
