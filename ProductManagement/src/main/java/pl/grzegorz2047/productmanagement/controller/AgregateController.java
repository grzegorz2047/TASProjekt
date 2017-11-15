package pl.grzegorz2047.productmanagement.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.grzegorz2047.productmanagement.repository.OpinionRepository;
import pl.grzegorz2047.productmanagement.repository.ProductRepository;
import pl.grzegorz2047.productmanagement.repository.UserRepository;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(path = "/cumulate")
public class AgregateController {

    @Autowired // This means to get the bean called userRepository
    private OpinionRepository opinionRepositiory;

    @Autowired // This means to get the bean called userRepository
    private UserRepository userRepositiory;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(path = "/all", produces = "application/json; charset=utf-8")
    public @ResponseBody
    Map<String, Iterable> getAll() {
        Map<String, Iterable> objects = new HashMap<>();
        objects.put("opinions", opinionRepositiory.findAll());
        objects.put("users", userRepositiory.findAll());
        objects.put("products", productRepository.findAll());
        return objects;
    }

}
