package sk.vaii.sem.semestralna_praca_vaii_backend.searching.rest;

import com.scheidtbachmann.ps.search.searchextension.api.SearchApi;
import com.scheidtbachmann.ps.search.searchextension.dto.SearchResult;
import com.scheidtbachmann.ps.search.searchextension.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Size;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class SearchEndpoint implements SearchApi<SearchResult> {

    @Autowired
    private SearchService<SearchResult> searchService;

    @Value ("${apiconfig.search-path}")
    private String searchPath;

    @Override
    public ResponseEntity<List<SearchResult>> search(@Size(min = 1, max = 255) String tenantName, String query) throws ExecutionException, InterruptedException {
        try {
            return ResponseEntity.ok().body(searchService.search(query));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<String> loadSearchPath() {
        return ResponseEntity.ok()
                .body(this.searchPath);
    }
}
