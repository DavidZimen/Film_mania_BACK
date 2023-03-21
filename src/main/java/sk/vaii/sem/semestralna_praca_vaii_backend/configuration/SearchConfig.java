package sk.vaii.sem.semestralna_praca_vaii_backend.configuration;

import com.scheidtbachmann.ps.search.searchextension.configuration.ApiPropertiesConfig;
import com.scheidtbachmann.ps.search.searchextension.dto.SearchResult;
import com.scheidtbachmann.ps.search.searchextension.service.SearchService;
import com.scheidtbachmann.ps.search.searchextension.service.Searchable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SearchConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchConfig.class);

    @Value("${apiconfig.api-version}")
    private String apiVersion;

    @Value("${apiconfig.url}")
    private String url;

    @Bean
    @ConfigurationProperties(prefix = "apiconfig")
    public ApiPropertiesConfig apiPropertiesConfig() {
        ApiPropertiesConfig apiPropertiesConfig = new ApiPropertiesConfig();
        apiPropertiesConfig.setApiVersion(apiVersion);

        //log information
        LOGGER.info("API version {}.", apiPropertiesConfig.getApiVersion());

        return apiPropertiesConfig;
    }

    @Bean
    public SearchService<SearchResult> searchService(List<Searchable<SearchResult>> searchables) {
        LOGGER.info("Creating Bean of {}", SearchService.class.getName());
        return new SearchService<>(searchables);
    }
}
