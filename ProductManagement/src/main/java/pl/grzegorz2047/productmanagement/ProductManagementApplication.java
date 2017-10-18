package pl.grzegorz2047.productmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import pl.grzegorz2047.productmanagement.model.User;
import pl.grzegorz2047.productmanagement.repository.UserRepository;

import javax.sql.DataSource;

import java.util.List;

import static java.lang.System.exit;

@SpringBootApplication
@ComponentScan(basePackageClasses = ProductManagementApplication.class)
public class ProductManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductManagementApplication.class, args);
    }
}
