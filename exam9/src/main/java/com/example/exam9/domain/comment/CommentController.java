package com.example.exam9.domain.comment;

import com.example.exam9.domain.customer.Customer;
import com.example.exam9.domain.customer.CustomerRepository;
import com.example.exam9.domain.form.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class CommentController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private FormRepository formRepository;

    @PostMapping("/comment")
    public String comment(@RequestParam("name") String name, @RequestParam("comment") String comment,
                          @RequestParam("form") String form){
        Date date = new Date();
        Comment newComment = Comment.builder()
                .comment(comment)
                .date(date)
                .form(formRepository.findByName(form).get())
                .customer(customerRepository.findByName(name).get())
                .build();

        commentRepository.save(newComment);

        return "redirect:/comment";

    }
    @GetMapping("/comment")
    public String commentPage(Model model){
        return "comment";
    }
}
