package com.example.MidTerm.controllers;

import com.example.MidTerm.models.Oder;
import com.example.MidTerm.models.OderProduct;
import com.example.MidTerm.models.Product;
import com.example.MidTerm.models.User;
import com.example.MidTerm.repositories.OderRepository;
import com.example.MidTerm.repositories.ProductRepository;
import com.example.MidTerm.repositories.UserRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    private List<Product> productsCart = new ArrayList<>();
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OderRepository oderRepository;
    private User user;
    @GetMapping(value = "/home")
    public String showHome(Model model, HttpServletRequest req){
        List<Product> products  = productRepository.findAll();
        Cookie[] cookies = req.getCookies();
        for(Cookie cookie: cookies){
            if ("userCode".equals(cookie.getName())) {
                user = userRepository.findById(Integer.parseInt(cookie.getValue())).get();
                break;
            }
        }
        model.addAttribute("products", products);
        model.addAttribute("loginUser", user);
        model.addAttribute("productCart", productsCart);
        System.out.println(user.getUsername());
        return "index";
    }
    @GetMapping("/cart/{code}")
    public String addCart(@PathVariable("code") int code, Model model) {
        Product product = productRepository.findById(code).get();
        productsCart.add(product);
        model.addAttribute("productCart", productsCart);
        List<Product> products  = productRepository.findAll();
        model.addAttribute("products", products);
        model.addAttribute("loginUser", user);
        return "index";
    }
    @GetMapping("/cart/delete/{code}")
    public String deleteCart(@PathVariable("code") int code, Model model) {
        for(Product p: productsCart){
            if(p.getCode() == code){
                productsCart.remove(p);
                System.out.println(p.getName());
                model.addAttribute("proSize", productsCart.size());
                model.addAttribute("productCart", productsCart);
                List<Product> products  = productRepository.findAll();
                model.addAttribute("products", products);
                model.addAttribute("loginUser", user);
                return "index";
            }
        }
        return "index";
    }
    @GetMapping("/dathang/{code}")
    public String oder(@PathVariable("code") int code, Model model){
        User user = userRepository.findById(code).get();
        model.addAttribute("loginUser", user);

        List<Product> products  = productRepository.findAll();
        model.addAttribute("products", products);
        Oder oder = new Oder(user);
        List<OderProduct> oderProducts = new ArrayList<>();
        for(Product p: productsCart){
            OderProduct oderProduct = new OderProduct(oder, p);
            oderProducts.add(oderProduct);
        }
        oder.setOderProducts(oderProducts);
        System.out.println("oder size; "+oderProducts.size());
        oderRepository.save(oder);
        productsCart.clear();
        model.addAttribute("productCart", productsCart);
        return "index";
    }
    @GetMapping("/detail")
    public String detailOder(Model model){
        List<Oder> oders = oderRepository.findAll();
        List<Oder> oderbyUser = new ArrayList<>();
        System.out.println("sl:"+oders.size());
        for(Oder o: oders){
            if(o.getUser().getCode() == user.getCode()){
                System.out.println("detail size: " + o.getOderProducts().size());
                for(OderProduct p: o.getOderProducts()){
                    System.out.println("product cart name: "+p.getProduct().getName());
                }
                oderbyUser.add(o);
            }
        }
        model.addAttribute("oderList", oderbyUser);
        return "detail";
    }
    @GetMapping("/detailphone/{code}")
    public String detailPhone(@PathVariable("code") int code, Model model){
        Product p = productRepository.findById(code).get();
        model.addAttribute("phone", p);
        return "PhoneDetail";
    }
    @PostMapping("/find")
    public String find(HttpServletRequest request, Model model){
        String name = request.getParameter("namefind");
        List<Product> products  = productRepository.findAll();
        List<Product> productFind = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                productFind.add(product);
            }
        }
        System.out.println("FIND: "+productFind.size());
        model.addAttribute("loginUser", user);
        model.addAttribute("productCart", productsCart);
        model.addAttribute("products", productFind);
        return "index";
    }
}
