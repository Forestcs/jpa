package com.example.demo.controller;

import com.example.demo.dao.UserRepository;
import com.example.demo.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    private UserRepository userRepository;


    @RequestMapping("/findAll")
    @ResponseBody
    public String findAllUser(){
        List<User> all = userRepository.findAll();
        return all.toString();
    }

    @PostMapping("/add")
    @ResponseBody
    public String addUser(User user){
        User save = userRepository.save(user);
        return "redirect:/findAll";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String updateUser(User user){
        User save = userRepository.save(user);
        return "redirect:/findAll";
    }

    @DeleteMapping("/delete")
    public String deleteUser(Integer id){
        userRepository.deleteById(id+"");
        return "redirect:/findAll";
    }

}
