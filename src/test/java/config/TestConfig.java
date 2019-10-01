package config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by RANGA on 1/24/2017.
 */
@ComponentScan(basePackages = {"com.ranga.domain"})
@Configuration
@EnableAutoConfiguration
public class TestConfig {

}