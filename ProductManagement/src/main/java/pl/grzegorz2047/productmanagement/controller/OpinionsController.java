package pl.grzegorz2047.productmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.grzegorz2047.productmanagement.model.*;
import pl.grzegorz2047.productmanagement.repository.*;

import java.util.ArrayList;
import java.util.Date;

@Controller    // This means that this class is a Controller
@RequestMapping(path = "/opinions") // This means URL's start with /users (after Application path)
public class OpinionsController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private OpinionRepository opinionRepositiory;
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepositiory;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(path = "/add") // Map ONLY GET Requests
    public @ResponseBody
    String addNewOpinion(@RequestParam long userId, long reviewElementId, @RequestParam String opinionText) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User oneUser = userRepositiory.findOne(userId);
        Product one = productRepository.findOne(reviewElementId);
        if (one != null) {
            ProductOpinion opinion = new ProductOpinion(oneUser, opinionText, new Date(), new ArrayList<String>(), new ArrayList<String>(), 5);
            opinionRepositiory.save(opinion);
            return "Saved";
        } else {
            return "unknown eror";
        }
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<ProductOpinion> getAllOpinions() {
        // This returns a JSON or XML with the users
        return opinionRepositiory.findAll();
    }
}