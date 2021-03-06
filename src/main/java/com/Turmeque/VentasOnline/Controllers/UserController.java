/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Turmeque.VentasOnline.Controllers;


import com.Turmeque.VentasOnline.Entity.User;
import com.Turmeque.VentasOnline.Services.UserService;
import java.util.List;
import java.util.Optional;
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
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author johan
 */
@RestController
@RequestMapping("user")
@CrossOrigin(origins="*")
public class UserController {
    /**
     * Declaracion de parametros
     */
    @Autowired
    private UserService service;
    
    /**
     * Metodo para obtener todos los usuarios
     * @return 
     */
    @GetMapping("/all")
    public List<User> findAllUsers(){
        return service.getUsers();
    }
    
    /**
     * Metododo para verificar la existencia de un email
     * @param email
     * @return 
     */
    
    @GetMapping("/emailexist/{email}")
    public boolean emailExist(@PathVariable ("email") String email){
        return service.emailExist(email);
    }
    
    
    /**
     * Metodo para verificar la existencia de una cuenta
     * @param email
     * @param password
     * @return 
     */
    
    @GetMapping("/{email}/{password}")
    public User userAuthenticate(@PathVariable ("email") String email, @PathVariable ("password") String password){
        return service.userAuthenticate(email, password);
    }
    
    /**
     * Metodo para listar usuarios que cumplen en un mes especifico
     * @param birthday
     * @return 
     */
    @GetMapping("birthday/{birthday}")
    public List<User> findUsersByMonthBirthday(@PathVariable ("birthday") String birthday){
        return service.findByMonthBirthtDay(birthday);
    }
    
    /**
     * Metodo para obtener el usuario por Id
     * @param id
     * @return 
     */
    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable("id") Integer id)
    {
        return service.findById(id);
    }
    
    
    /**
     * Metodo para registrar un nuevo usuario
     * @param user
     * @return 
     */
    
    @PostMapping("/new")
    public ResponseEntity newUser(@RequestBody User user){
        service.newUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    /**
     * Metodo para actualizar usuario
     * @param user
     * @return 
     */
    @PutMapping("/update")
    public ResponseEntity updateUser(@RequestBody User user){
        service.updateUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    /**
     * Metodo para borrar un Usuario
     * @param id
     * @return 
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable ("id") Integer id){
        service.deleteUser(id);
        return ResponseEntity.status(204).build();
    } 

}
