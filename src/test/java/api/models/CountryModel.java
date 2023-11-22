package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryModel {
    private String uid;
    private String name;
    private String code;
    private String short_name;
    private String country_code;

}
