package pl.grzegorz2047.productmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import pl.grzegorz2047.productmanagement.model.Product;
import pl.grzegorz2047.productmanagement.model.ProductOpinion;
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
    ProductRepository productRepository;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        User first = new User("Grzegorz", "admin1", new Date());
        userRepository.save(first);
        User second = new User("adam123", "admin1", new Date());
        userRepository.save(second);

        Product product = new Product("Papier do WC");
        productRepository.save(product);
        opinionRepository.save(new ProductOpinion(first, product, "Nie polecam, trochę swędzi", new Date(), "Spelnia swoje zadanie", "Swędzi", 2));
        opinionRepository.save(new ProductOpinion(first, product,"Polecam", new Date(), "Tani", " czasami brakuje", 4));
        opinionRepository.save(new ProductOpinion(first, product, "Bardzo polecam", new Date(), "Zawsze pod reka", "brak", 5));
    }
}
