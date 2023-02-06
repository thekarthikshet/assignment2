package com.bootcamp.training.assignment2.thymecontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bootcamp.training.assignment2.model.Product;
import com.bootcamp.training.assignment2.model.Promotion;
import com.bootcamp.training.assignment2.model.Sale;
import com.bootcamp.training.assignment2.repository.CustomerRepository;
import com.bootcamp.training.assignment2.repository.ProductRepository;
import com.bootcamp.training.assignment2.repository.PromotionRepository;
import com.bootcamp.training.assignment2.repository.SaleRepository;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Controller
public class SaleNController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private PromotionRepository promotionRepository;
    @Autowired
    private SaleRepository saleRepository;
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @GetMapping("/sales")
    public String getSales(Model model) {
        model.addAttribute("sales", saleRepository.findAll());
        
        return "sale-list";
    }
    @GetMapping("/sales/add")
    public String addSaleForm(Model model) {
        model.addAttribute("sale", new Sale());
           model.addAttribute("sales", saleRepository.findAll());  
        model.addAttribute("products", productRepository.findAll());
        //model.addAttribute("productRep", productRepository);
        model.addAttribute("customers",customerRepository.findAll());
        return "sale-form";
    }
//    @GetMapping("/new")
//    public String test(Model model) {
//        
//        return "NewFile";
//    }
//    @GetMapping("/error")
//    public String errorPage() {
//        return "error";
//    }
    

    @PostMapping("/sales")
    public String addSale(@Valid Sale sale, BindingResult bindingResult) {//@Valid {
        if (bindingResult.hasErrors()) {
            return "sale-form";
        }
        
        productRepository.findById(sale.getProduct_id()).get().setStockInHand(productRepository.findById(sale.getProduct_id()).get().getStockInHand()-sale.getQuantity());
        
        sale.setPrice(productRepository.findById(sale.getProduct_id()).get().getPrice()*sale.getQuantity());
       
        sale.setDiscount(0.0);
        
        productRepository.findById(sale.getProduct_id()).get();

   
    
        
        Promotion promotion = promotionRepository.findByProductId(sale.getProduct_id());
       
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
        Date date = new Date();  
        System.out.println(formatter.format(date));  
        sale.setSaleDate(date);
        
        
        if(date.after(promotion.getStartDate()) && date.before(promotion.getEndDate())) {
        
        sale.setDiscount(promotion.getDiscount()); 
        	
        Double productDiscount = sale.getDiscount();
        Double originalPrice = sale.getPrice();
        Double netPrice = originalPrice - (originalPrice*productDiscount)/100;
        sale.setNetPrice(netPrice);
        
        }
        else {
        sale.setNetPrice(sale.getPrice());
        }
        sale.setProduct_id( sale.getProduct_id() +"-"+productRepository.findById(sale.getProduct_id()).get().getName());
       
        saleRepository.save(sale);
        
        
        
        return "redirect:/sales/add";
    }
}

