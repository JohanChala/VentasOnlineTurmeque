/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Turmeque.VentasOnline.Services;


import com.Turmeque.VentasOnline.Entity.User;
import com.Turmeque.VentasOnline.Repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author johan
 */
@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    
    /**
     * Metodo para obtener todos los usuarios
     * @return 
     */
      public List<User> getUsers()
    {
        return repository.getUsers();
    }
      
    /**
     * Metodo para registrar un nuevo usuario
     * @param user
     * @return 
     */
    
    public User newUser(User user)
    {
        if(user.getId()== null){
            boolean resultUser= emailExist(user.getEmail());
            if(resultUser){
              return user;  
            }else{
              return repository.saveUser(user);
            }           
        }else{
            Optional<User> res= repository.findById(user.getId());
            if(res.isPresent()){
              return user;  
            }else{                
                boolean resultUser= emailExist(user.getEmail());
                if(resultUser){
                    return user;  
                }else{
                    return repository.saveUser(user);
                }           
            }           
        }
    }
    
    /**
     * Metodo para verificar la existencia de un email
     * @param email
     * @return 
     */
    
    public boolean emailExist(String email){
        User resultUser= repository.findByEmail(email);
        return resultUser != null;     
    }
    
    /**
     * Metodo para autenticar a un usuario
     * @param email
     * @param password
     * @return 
     */
     
    public User userAuthenticate(String email, String password){
        
        User userResult = repository.findUserAuthenticate(email, password);
        if(userResult!=null){
            return userResult;
        }else{
            return new User ();
        }        
    }

}
