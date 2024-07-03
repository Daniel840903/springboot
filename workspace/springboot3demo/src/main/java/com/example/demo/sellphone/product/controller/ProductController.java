package com.example.demo.sellphone.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.sellphone.product.model.Product;
import com.example.demo.sellphone.product.model.ProductRepository;
import com.example.demo.sellphone.product.service.productservice;


@Controller
public class ProductController {
	@Autowired
	public ProductRepository proRepo;
	@Autowired
	public productservice pService;
	
	
	
	@GetMapping("/productlist")
	public String listProducts(Model model) {
		List<Product> products = proRepo.findAll();
		model.addAttribute("listProduct", products);
		return "product/producthomepage";
	} 
	
	@GetMapping("/productfindone")
	public String findOne(@RequestParam("productid") Integer productid,Model m) {
		Optional<Product> productoptional = proRepo.findById(productid);
		Product product = productoptional.get();
		m.addAttribute("product",product);
		
		return "product/productsearch";
	}
	
	@GetMapping("/deleteproduct")
	public String deleteProduct(@RequestParam Integer productid) {
		pService.deletebyId(productid);
		return "redirect:/productlist";
	}
	
	@PostMapping("/updateproduct")
	public String updateProduct(@ModelAttribute Product product) {
		pService.saveProduct(product);
		return "redirect:/productlist";
	}
	//跳轉到新增頁面
	@GetMapping("/insertproduct")
	public String insertProduct() {
		return "product/productinsert";
	}
	
	@PostMapping("/productinsertPost")
	public String postMethodName(@ModelAttribute Product product) {
		pService.saveProduct(product);
		
		return "redirect:/productlist";
	}
	
	
}
