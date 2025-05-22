package com.example.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.ecommerce.service.ProductService;
import com.example.ecommerce.model.Product;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController 
{
    @Autowired
    private ProductService service;
  

    @GetMapping("/products")
    public ResponseEntity<List<Product> > getProducts()
    {
        return new ResponseEntity<>(service.getProducts(),HttpStatus.OK) ;
    }
    
    @GetMapping("/products/{prodid}")
    public ResponseEntity<Product> getProductById( @PathVariable int prodid)
    {
        Product pro= service.getProductById(prodid);
        if(pro!=null)
        return new ResponseEntity<>(pro,HttpStatus.FOUND);
        else 
         return new ResponseEntity<>(pro,HttpStatus.NOT_FOUND);
    }

    @PostMapping("/products")
    public void addProduct( Product p,
                             MultipartFile imgfile)
    {
     service.addProduct(p);
    }
    @PutMapping("/products")
    public void updateProduct(@RequestBody Product p)
    {
     service.updateProduct(p);
    }
    @DeleteMapping("/products/{prodid}")
    public void updateProduct(@PathVariable int prodid)
    {
     service.deleteProduct(prodid);
    }

    
}
