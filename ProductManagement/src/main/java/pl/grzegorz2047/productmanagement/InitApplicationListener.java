package pl.grzegorz2047.productmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        String defaultPassword = "admin1";
        defaultPassword = passwordEncoder.encode(defaultPassword);
        User first = new User("Grzegorz", defaultPassword, new Date(), "ADMIN");
        userRepository.save(first);
        User second = new User("adam123", defaultPassword, new Date(), "USER");
        userRepository.save(second);

        Product product = new Product("Papier do WC");
        Product laptopProduct = new Product("Laptopik");
        productRepository.save(product);
        productRepository.save(laptopProduct);
        opinionRepository.save(new ProductOpinion(first, product, "Nie polecam, trochę swędzi", new Date(), "Spelnia swoje zadanie", "Swędzi", 2));
        opinionRepository.save(new ProductOpinion(first, laptopProduct, "Polecam", new Date(), "Tani", " czasami ktos blokuje plyte glowna!", 3));
        opinionRepository.save(new ProductOpinion(second, laptopProduct, "Polecam, bo sie cykam", new Date(), "Tani jak barszcz", " yyy nie ma", 5));
        opinionRepository.save(new ProductOpinion(first, product, "Bardzo polecam", new Date(), "Zawsze pod reka", "brak", 5));
    }
}
