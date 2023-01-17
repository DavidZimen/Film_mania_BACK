package sk.vaii.sem.semestralna_praca_vaii_backend.configuration;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sk.vaii.sem.semestralna_praca_vaii_backend.mapper.*;

@Configuration
public class MapperConfig {
    @Bean
    ArticleMapper articleMapper() {
        return Mappers.getMapper(ArticleMapper.class);
    }

    @Bean
    AppUserMapper appUserMapper() {
        return Mappers.getMapper(AppUserMapper.class);
    }

    @Bean
    RoleMapper roleMapper() {
        return Mappers.getMapper(RoleMapper.class);
    }

    @Bean
    PrivilegeMapper privilegeMapper() {
        return Mappers.getMapper(PrivilegeMapper.class);
    }

    @Bean
    FilmMapper filmMapper() {
        return Mappers.getMapper(FilmMapper.class);
    }

    @Bean
    RatingMapper ratingMapper() {
        return Mappers.getMapper(RatingMapper.class);
    }

    @Bean
    ActorMapper actorMapper() {
        return Mappers.getMapper(ActorMapper.class);
    }

    @Bean
    DirectorMapper directorMapper() {
        return Mappers.getMapper(DirectorMapper.class);
    }
}
