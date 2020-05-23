package com.example.exam9.domain.form;

import com.example.exam9.domain.comment.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FormRestController {
    @Autowired
    private FormRepository repository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/theme/{id}")
    public String themes(@PathVariable int id, Model model){
        model.addAttribute("theme", repository.findById(id).get());
        model.addAttribute("comment", commentRepository.findAll());
        return "theme";
    }

}
