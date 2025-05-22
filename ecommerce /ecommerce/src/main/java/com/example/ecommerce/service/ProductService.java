package com.example.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductRepo;



@Service
public class ProductService 
{
    
    @Autowired
    private ProductRepo repo;


   public List<Product> getProducts()
   {
     return repo.findAll();
   }

   public Product getProductById(int id)
   {
    return repo.findById(id).orElse(new Product());
   }

   public void addProduct(Product p)
   {
    repo.save(p);
   }
   public void updateProduct(Product p)
   {
    repo.save(p);
   }
   public void deleteProduct(int id)
   {
    repo.deleteById(id);
   }



}
