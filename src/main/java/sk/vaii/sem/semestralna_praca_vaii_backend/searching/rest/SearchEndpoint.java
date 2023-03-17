package sk.vaii.sem.semestralna_praca_vaii_backend.searching.rest;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sk.vaii.sem.semestralna_praca_vaii_backend.searching.dto.SearchResultDto;
import sk.vaii.sem.semestralna_praca_vaii_backend.searching.service.SearchService;

import java.util.List;

@RestController
public class SearchEndpoint {

    @Autowired
    private SearchService searchService;

    @RequestMapping(value = "/v1/{tenantName}/search", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<SearchResultDto>> search(
            @Parameter(name = "tenantName", description = "Unique name of tenant in multitenant system", required = true, in = ParameterIn.PATH) @PathVariable("tenantName") String tenantName,
            @Parameter(name = "query", required = true, in = ParameterIn.QUERY) String query
    ) {
        try {
            return ResponseEntity.ok().body(searchService.search(query));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
