package sk.vaii.sem.semestralna_praca_vaii_backend.configuration;

import com.scheidtbachmann.ps.search.searchextension.config.adapter.SearchExtensionConfigAdapter;
import com.scheidtbachmann.ps.search.searchextension.configuration.ApiPropertiesConfig;
import com.scheidtbachmann.ps.search.searchextension.dto.SearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SearchConfig extends SearchExtensionConfigAdapter<SearchResult> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchConfig.class);

    @Value("${apiconfig.api-version}")
    private String apiVersion;

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }

    @Override
    @ConfigurationProperties(prefix = "apiconfig")
    public ApiPropertiesConfig apiPropertiesConfig() {
        ApiPropertiesConfig apiPropertiesConfig = new ApiPropertiesConfig();
        apiPropertiesConfig.setApiVersion(apiVersion);

        //log information
        LOGGER.info("API version {}.", apiPropertiesConfig.getApiVersion());

        return apiPropertiesConfig;
    }
}

