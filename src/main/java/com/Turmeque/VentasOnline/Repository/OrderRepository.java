/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Turmeque.VentasOnline.Repository;


import com.Turmeque.VentasOnline.Entity.Order;
import com.Turmeque.VentasOnline.RepositoryCrud.IOrderRepositoryCrud;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author johan
 */
@Repository
public class OrderRepository {
   @Autowired
   private IOrderRepositoryCrud orderRepo; 
   
   public Order saveOrder(Order order)
   {
       return orderRepo.save(order);
   }
   
   public Optional<Order> findById(Integer id)
   {
       return orderRepo.findById(id);
   }  
   
     public List<Order> getOrders(){
        return orderRepo.findAll();
    }
     
     public void deleteById(Integer id) {
        orderRepo.deleteById(id);
    }
   
   
}
