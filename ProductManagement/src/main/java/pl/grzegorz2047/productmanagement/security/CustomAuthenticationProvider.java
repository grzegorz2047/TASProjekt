package pl.grzegorz2047.productmanagement.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.grzegorz2047.productmanagement.model.User;
import pl.grzegorz2047.productmanagement.repository.UserRepository;


public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();
        String password = authentication.getCredentials().toString();
        User user = userRepository.getUserByName(login);
        PasswordEncoder eee = new PasswordEncoder() {//http://www.baeldung.com/spring-security-registration-password-encoding-bcrypt
            @Override
            public String encode(CharSequence charSequence) {
                return null;
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return false;
            }
        }
    }

    @Override
    public boolean supports(java.lang.Class<?> aClass) {
        return false;
    }
}
