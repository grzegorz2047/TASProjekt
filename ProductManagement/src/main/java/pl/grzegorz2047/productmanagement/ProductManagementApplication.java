package pl.grzegorz2047.productmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import pl.grzegorz2047.productmanagement.repository.UserRepository;

@SpringBootApplication
@EnableCaching
@ComponentScan(basePackages = "pl.grzegorz2047")
public class ProductManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductManagementApplication.class, args);
    }
}
