package com.bootcamp.training.assignment2.thymecontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bootcamp.training.assignment2.model.Sale;
import com.bootcamp.training.assignment2.repository.ProductRepository;
import com.bootcamp.training.assignment2.repository.SaleRepository;

@Controller
public class SaleNController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SaleRepository saleRepository;
    @GetMapping("/sales")
    public String getSales(Model model) {
        
        return "sale-list";
    }
    @GetMapping("/sales/add")
    public String addSaleForm(Model model) {
        model.addAttribute("sale", new Sale());
        model.addAttribute("products", productRepository.findAll());
        return "sale-form";
    }



    @PostMapping("/sales")
    public String addSale(@Valid Sale sale, BindingResult bindingResult) {//@Valid {
        if (bindingResult.hasErrors()) {
            return "sale-form";
        }
        saleRepository.save(sale);
        return "redirect:/sales";
    }
}

