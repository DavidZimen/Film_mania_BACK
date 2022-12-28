package sk.vaii.sem.semestralna_praca_vaii_backend.configuration;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sk.vaii.sem.semestralna_praca_vaii_backend.mapper.AppUserMapper;
import sk.vaii.sem.semestralna_praca_vaii_backend.mapper.ArticleMapper;
import sk.vaii.sem.semestralna_praca_vaii_backend.mapper.PrivilegeMapper;
import sk.vaii.sem.semestralna_praca_vaii_backend.mapper.RoleMapper;

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
}
