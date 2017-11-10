package pl.grzegorz2047.productmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.grzegorz2047.productmanagement.model.Product;
import pl.grzegorz2047.productmanagement.repository.ProductRepository;


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
    Iterable<Product> getAllUsers() {
        // This returns a JSON or XML with the users
        return productRepository.findAll();
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public void handleException() {
        System.out.println("ERROR");
    }
}