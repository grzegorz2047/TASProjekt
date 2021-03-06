package pl.grzegorz2047.productmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.grzegorz2047.productmanagement.model.Product;
import pl.grzegorz2047.productmanagement.model.ProductOpinion;
import pl.grzegorz2047.productmanagement.repository.OpinionRepository;
import pl.grzegorz2047.productmanagement.repository.ProductRepository;

import java.util.*;


@Controller    // This means that this class is a Controller
@RequestMapping(path = "/products") // This means URL's start with /users (after Application path)
public class ProductController {
    @Autowired // This means to get the bean called userRepository
    private ProductRepository productRepository;

    @Autowired
    private OpinionRepository opinionRepository;

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
        Map<String, Iterable> objects = new HashMap<>();
        List<Object> products = getProductsSerialized();
        objects.put("products", products);
        return objects;
    }

    private List<Object> getProductsSerialized() {
        List<Object> products = new ArrayList<>();
        Iterable<Product> allProducts = productRepository.findAll();
        //List<Product> topProducts = productRepository.findTop10OrderByAverageScore(new Sort(new Sort.Order(Sort.Direction.DESC, "averageScore")));
        for (Product product : allProducts) {
            //List<ProductOpinion> opins = product.getProductOpinions();
            LinkedHashMap<String, Object> productDTOed = createProductDTOSerialized(product);
            products.add(productDTOed);
        }
        return products;
    }

    private LinkedHashMap<String, Object> createProductDTOSerialized(Product product) {
        LinkedHashMap<String, Object> objectsProduct = new LinkedHashMap<>();
        System.out.println(product.toString());
        Iterable<ProductOpinion> allByProductId = opinionRepository.opinionsForProduct(product.getId());
//             System.out.println("ile opinii dla produktu " + product.getName() + " " + allByProductId);
        objectsProduct.put("id", String.valueOf(product.getId()));
        objectsProduct.put("name", product.getName());
        objectsProduct.put("averageScore", product.getAverageScore());
        objectsProduct.put("opinionNumber", product.getOpinionNumber());
        objectsProduct.put("opinions", allByProductId);
        return objectsProduct;
    }

    @GetMapping(path = "/getone", produces = "application/json; charset=utf-8") // Map ONLY GET Requests
    public @ResponseBody
    Map<String, Product> getProduct(@RequestParam(required = true) long productId) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Map<String, Product> objects = new HashMap<>();
        Product one = productRepository.findOne(productId);
        if (one != null) {
            objects.put("product", one);
            return objects;
        } else {
            return objects;
        }
    }
/*
    @ExceptionHandler({IllegalArgumentException.class})
    public void handleException() {
        System.out.println("ERROR");
    }*/
}