package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan("/api")
public class WebConfig implements WebMvcConfigurer {

    @Bean("messageConverters")
    public MappingJackson2HttpMessageConverter converter(){
        return new MappingJackson2HttpMessageConverter();
    }
}
