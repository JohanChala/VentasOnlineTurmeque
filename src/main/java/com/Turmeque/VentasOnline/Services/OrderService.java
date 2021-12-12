/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Turmeque.VentasOnline.Services;

import com.Turmeque.VentasOnline.Entity.Order;
import com.Turmeque.VentasOnline.Repository.OrderRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author johan
 */
@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;
    
    @Autowired
    private SequenceGeneratorService autoId;
    
    /**
     * Metodo para registrar una Orden
     * @param order
     * @return 
     */
    public Order newOrder (Order order){
        if(order.getId()==null){
            order.setId(autoId.generateSequence(Order.SEQUENCE_NAME));
            return repository.saveOrder(order);
        }else{
            Optional<Order> res= repository.findById(order.getId());
            if(res.isPresent())
            {
                return order;
            }else{
                return repository.saveOrder(order);             
            }
        }
    }
    
      /**
     * Metodo para obtener todas las ordenes
     * @return 
     */
      public List<Order> getOrders()
    {
        return repository.getOrders();
    }
      
     /**
     * Metodo para borrar una orden
     * @param id     
     */
    public void deleteOrder(Integer id)
    {
      repository.deleteById(id);
    }
    
    
    /**
     * Metodo para obtener una order
     * @param id
     * @return 
     */
    public Optional<Order> getOrder(Integer id){
        return repository.findById(id);
    }
    
    /**
     * Metodo para obtener una listado de order por zona
     * @param zone
     * @return 
     */
    public List<Order> getOrdersByZone(String zone){
        return repository.getOrdersByZone(zone);
    }
    
    
    
}
