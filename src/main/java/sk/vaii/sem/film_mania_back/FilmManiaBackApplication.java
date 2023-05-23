package sk.vaii.sem.film_mania_back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class FilmManiaBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilmManiaBackApplication.class, args);
    }

//    @Bean
//    public CorsFilter corsFilter() {
//        CorsConfiguration corsConfig = new CorsConfiguration();
//
//        corsConfig.setAllowCredentials(true);
//        corsConfig.setAllowedOrigins(Arrays.asList("http://localhost:4201"));
//        corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//        corsConfig.setAllowedHeaders(Arrays.asList("X-Requested-With", "Origin", "Accept",
//                "Content-Type", "Access-Control-Request-Method", "Access-Control-Request-Headers",
//                "Authorization", "X-Requested-With", "Access-Control-Allow-Origin"));
//        corsConfig.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
//                "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
//        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
//        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfig);
//
//        return new CorsFilter(urlBasedCorsConfigurationSource);
//    }
}
