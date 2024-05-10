package be.thomasmore.appetito.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import javax.sql.DataSource;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;


@EnableWebSecurity
@Configuration
public class SecurityConfiguration {

    @Value("${security.h2-console-needed}")
    private boolean h2ConsoleNeeded;

    /**
     * @noinspection SpringJavaInjectionPointsAutowiringInspection
     */
    @Autowired
    private DataSource dataSource;


    @Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager() {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        HandlerMappingIntrospector introspector = new HandlerMappingIntrospector();
        MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);

        http.authorizeHttpRequests(auth -> auth
                .requestMatchers(mvcMatcherBuilder.pattern("/admin/**")).hasAuthority("ADMIN")
                .requestMatchers(mvcMatcherBuilder.pattern("/modify/**")).authenticated()
                .anyRequest().permitAll());
        http.formLogin(form -> form
                .loginPage("/user/login")
                .permitAll()
        );
        http.logout(form -> form.logoutUrl("/user/logout"));

        http.csrf(csfr -> csfr.ignoringRequestMatchers("/modify/addmeal"));
        http.csrf(csfr -> csfr.ignoringRequestMatchers("/modify/editingredients/**"));
        http.csrf(csfr -> csfr.ignoringRequestMatchers("/modify/editnutritions/**"));
        http.csrf(csfr -> csfr.ignoringRequestMatchers("/modify/dishedit/**"));


        //to enable h2-console:
        if (h2ConsoleNeeded) {
            //h2ConsoleNeeded has to be false when deploying on google cloud, otherwise the login does not work
            //h2ConsoleNeeded has to be true when running locally
            http.csrf(csrf -> csrf.ignoringRequestMatchers(toH2Console()));
            http.headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));
        }

        return http.build();
    }
}

