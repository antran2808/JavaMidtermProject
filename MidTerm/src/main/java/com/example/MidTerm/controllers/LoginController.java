package com.example.MidTerm.controllers;

import com.example.MidTerm.models.User;
import com.example.MidTerm.repositories.ProductRepository;
import com.example.MidTerm.repositories.UserRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller

public class LoginController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/login")
    public String showLogin(){
//        Product product = new Product("Iphone 14 Pro", 1.100f, "Apple", "Điện thoại màu đen mới 100%", "14-pro-den.jpg");
//        Product product1 = new Product("Iphone 14 Pro Max", 1.700f, "Apple", "Điện thoại màu tím mới 100%", "14-pro-max-tim.jpg");
//        Product product2 = new Product("Iphone 15 Pro", 2.100f, "Apple", "Điện thoại màu đen titanium mới 100%", "iphone15Problacktitanium.jpg");
//        Product product3 = new Product("Iphone 13 Pro Max", 1.000f, "Apple", "Điện thoại màu đen mới 100%", "iphone-13-pro-max-blue.jpg");
//        Product product4 = new Product("Iphone 13", 900f, "Apple", "Điện thoại màu xanh mới 100%", "iphone-13-xanh-512gb.jpg");
//        Product product5 = new Product("Iphone 15 Pro Max", 2.300f, "Apple", "Điện thoại màu xanh titanium mới 100%", "iphone-15-pro-max-blue-titanium.jpg");
//        productRepository.save(product);
//        productRepository.save(product1);
//        productRepository.save(product2);
//        productRepository.save(product3);
//        productRepository.save(product4);
//        productRepository.save(product5);
        return "login";
    }
    @PostMapping("/login")
    public String login(HttpServletRequest req, Model model, HttpServletResponse res){
        String user=req.getParameter("username");
        String pass=req.getParameter("password");
        List<User> users = userRepository.findAll();
        for(User u: users){
            if(user.equals(u.getUsername()) && pass.equals(u.getPassword())) {
                Cookie cookie = new Cookie("userCode", String.valueOf(u.getCode()));
                cookie.setMaxAge(60 * 60 * 24 * 30);
                res.addCookie(cookie);
                return "redirect:/home";
            }
        }
        return "redirect:/login";
    }

}
