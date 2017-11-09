package pl.grzegorz2047.productmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import pl.grzegorz2047.productmanagement.model.Opinion;
import pl.grzegorz2047.productmanagement.model.Product;
import pl.grzegorz2047.productmanagement.model.User;
import pl.grzegorz2047.productmanagement.repository.OpinionRepository;
import pl.grzegorz2047.productmanagement.repository.ProductRepository;
import pl.grzegorz2047.productmanagement.repository.UserRepository;

import java.util.ArrayList;
import java.util.Date;

@Component
public class InitApplicationListener implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    OpinionRepository opinionRepository;
    @Autowired
    ReviewElementRepository reviewElementRepository;
    @Autowired
    ProductRepository productRepository;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        User first = new User("Grzegorz", "admin1", new Date());
        userRepository.save(first);
        User second = new User("adam123", "admin1", new Date());
        userRepository.save(second);

        ReviewElement reviewElement = new ReviewElement();
        Product product = new Product("ProductName", reviewElement);
        reviewElementRepository.save(reviewElement);
        productRepository.save(product);
        opinionRepository.save(new Opinion(first, reviewElement, "Nie polecam", new Date(), new ArrayList<String>(), new ArrayList<String>(), 5));
        opinionRepository.save(new Opinion(first, reviewElement,"Polecam", new Date(), new ArrayList<String>(), new ArrayList<String>(), 5));
        opinionRepository.save(new Opinion(first, reviewElement, "Bardzo polecam", new Date(), new ArrayList<String>(), new ArrayList<String>(), 5));
    }
}
