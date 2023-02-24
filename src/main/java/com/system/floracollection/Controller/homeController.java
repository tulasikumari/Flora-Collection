package com.system.floracollection.Controller;

import com.system.floracollection.Entity.Product;
import com.system.floracollection.Entity.User;
import com.system.floracollection.Pojo.ContactPojo;
import com.system.floracollection.Service.ProductService;
import com.system.floracollection.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("")
public class homeController {

    private final ProductService productService;
    private final UserService userService;
    @GetMapping("/homepage")
    public String gethome(Model model, Authentication authentication) {

//        model.addAttribute("users", UserService.find(principal.getName()));

        if (authentication!=null){
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority grantedAuthority : authorities) {

                if (grantedAuthority.getAuthority().equals("Admin")) {
                    return "redirect:/admin/dashboard";
                }
            }
            List<Product> products = productService.fetchAll();
            model.addAttribute("product", products);

//            Integer id = userService.findByEmail(principal.getName()).getId();
//            List<Cart> list = cartService.fetchAll(id);
//
//            double total = 0.0;
//            for(Cart totalCalc:list){
//                if (totalCalc.getProduct().getProduct_quantity()>0) total += totalCalc.getQuantity()*totalCalc.getProduct().getProduct_price();
//            }


            List<Product> newProducts = productService.fetchNew();
            model.addAttribute("newProducts", newProducts);

            List<Product> trendingProducts = productService.trending();
            model.addAttribute("trending", trendingProducts);

//            model.addAttribute("total", total);
//            model.addAttribute("cartItems", list);
        }
        return "homepage";
    }


}
