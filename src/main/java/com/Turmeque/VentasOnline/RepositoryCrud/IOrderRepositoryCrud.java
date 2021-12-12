/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Turmeque.VentasOnline.RepositoryCrud;

import com.Turmeque.VentasOnline.Entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author johan
 */
public interface IOrderRepositoryCrud extends MongoRepository<Order,Integer>{
    
}
