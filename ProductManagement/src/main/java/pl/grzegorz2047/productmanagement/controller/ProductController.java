package pl.grzegorz2047.productmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.grzegorz2047.productmanagement.model.Product;
import pl.grzegorz2047.productmanagement.repository.ProductRepository;

import java.util.HashMap;
import java.util.Map;


@Controller    // This means that this class is a Controller
@RequestMapping(path = "/products") // This means URL's start with /users (after Application path)
public class ProductController {
    @Autowired // This means to get the bean called userRepository
    private ProductRepository productRepository;

    @GetMapping(path = "/add") // Map ONLY GET Requests
    public @ResponseBody
    String addNewProduct(@RequestParam String name) {
        Product product = new Product(name);
        productRepository.save(product);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Map<String, Iterable> getAllProducts() {
        // This returns a JSON or XML with the users
        Map<String, Iterable> objects = new HashMap<>();
        objects.put("products", productRepository.findAll());
        return objects;
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public void handleException() {
        System.out.println("ERROR");
    }
}