package com.bootcamp.training.assignment2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bootcamp.training.assignment2.model.Sale;
import com.bootcamp.training.assignment2.service.SaleService;

@Controller
public class SaleController {

    @Autowired
    private SaleService saleService;
    
//    private List<Product> prodList= Product 

    @GetMapping("/sale")
    public String saleForm(Model model) {
        model.addAttribute("sale", new Sale());
//        model.addAttribute("products", );
        return "sale-form";
    }

    @PostMapping("/sale")
    public String createSale(@ModelAttribute Sale sale) {
        saleService.createSale(sale);
        return "redirect:/sale/list";
        
    }

    @GetMapping("/sale/list")
    public String saleList(Model model) {
        model.addAttribute("sales", saleService.getAllSales());
        return "sale-list";
    }
}

