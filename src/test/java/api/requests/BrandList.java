package api.requests;

import api.models.DataModelBrand;

import java.util.List;
import java.util.stream.Collectors;

import static api.specs.Specs.request;
import static api.specs.Specs.responseSpecWithStatusCode200;
import static io.restassured.RestAssured.given;

public class BrandList {
    public List<String> ActualBrandList() {

        List<DataModelBrand> brands = given(request).get("/actual_offers/brands?type=1999ff3b-ad46-4c6f-a2ce-30faaf1be5e8")
                .then()
                .spec(responseSpecWithStatusCode200)
                .extract().body().jsonPath().getList(".", DataModelBrand.class);

        return (brands.stream().map(DataModelBrand::getName).collect(Collectors.toList()));

    }

}
