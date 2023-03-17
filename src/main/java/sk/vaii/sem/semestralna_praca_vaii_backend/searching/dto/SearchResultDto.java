package sk.vaii.sem.semestralna_praca_vaii_backend.searching.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchResultDto {
    @JsonProperty("name")
    private String name;

    @JsonProperty("resultType")
    private String resultType;

    @JsonProperty("resultLocalId")
    private Integer resultLocalId;
}
