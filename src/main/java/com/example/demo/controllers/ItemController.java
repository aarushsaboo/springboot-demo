package com.example.demo.controllers;

import com.example.demo.models.Item;
import com.example.demo.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ItemController {
    
    private final ItemService itemService;
    
    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("items", itemService.getAllItems());
        model.addAttribute("newItem", new Item());
        return "index";
    }
    
    @PostMapping("/add")
    public String addItem(@ModelAttribute Item newItem) {
        itemService.addItem(newItem);
        return "redirect:/";
    }
}