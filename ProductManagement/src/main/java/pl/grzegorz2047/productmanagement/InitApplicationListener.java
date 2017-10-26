package pl.grzegorz2047.productmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import pl.grzegorz2047.productmanagement.model.Opinion;
import pl.grzegorz2047.productmanagement.model.User;
import pl.grzegorz2047.productmanagement.repository.OpinionRepository;
import pl.grzegorz2047.productmanagement.repository.UserRepository;

import java.util.Date;

@Component
public class InitApplicationListener implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    OpinionRepository opinionRepository;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        User first = new User("Grzegorz", "admin1", new Date());
        userRepository.save(first);
        User second = new User("adam123", "admin1", new Date());
        userRepository.save(second);
        opinionRepository.save(new Opinion(first, "Nie polecam", new Date()));
        opinionRepository.save(new Opinion(second, "Daje rade", new Date()));
        opinionRepository.save(new Opinion(second, "Daje okejke", new Date()));
    }
}
