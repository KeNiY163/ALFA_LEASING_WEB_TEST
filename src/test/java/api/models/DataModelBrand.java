package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class DataModelBrand {

    public String getName() {
        return name;
    }

    private String uid;
    private String name;
    @JsonProperty("1c_code")
    private String _1c_code;
    private String transliterated_name;
    private CountryModel country;

}

