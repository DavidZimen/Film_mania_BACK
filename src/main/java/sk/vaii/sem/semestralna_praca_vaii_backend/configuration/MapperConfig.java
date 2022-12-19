package sk.vaii.sem.semestralna_praca_vaii_backend.configuration;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sk.vaii.sem.semestralna_praca_vaii_backend.mapper.AppUserMapper;
import sk.vaii.sem.semestralna_praca_vaii_backend.mapper.ArticleMapper;

@Configuration
public class MapperConfig {
    @Bean
    ArticleMapper articleMapper() {
        return Mappers.getMapper(ArticleMapper.class);
    }

    AppUserMapper appUserMapper() {
        return Mappers.getMapper(AppUserMapper.class);
    }
}
