/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Turmeque.VentasOnline.RepositoryCrud;

import com.Turmeque.VentasOnline.Entity.Order;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author johan
 */
public interface IOrderRepositoryCrud extends MongoRepository<Order,Integer>{
   @Query("{salesMan.zone: ?0}") 
   public List<Order> getOrdersByZone(String zone);
}
