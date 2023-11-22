package api.requests;

import api.models.ActualOfferBody;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.Data;


import static api.specs.Specs.request;
import static api.specs.Specs.responseSpecWithStatusCode200;

@Data
public class ActualOfferAggregate {

    public static int reqOfferWithReservation() {

        ActualOfferBody body = new ActualOfferBody();
        body.setIs_reservation_online(true);

        Response actual_offers_with_reservation_online = RestAssured.given(request)
                .body(body)
                .post("/actual_offers/aggregate?type=1999ff3b-ad46-4c6f-a2ce-30faaf1be5e8")
                .then()
                .spec(responseSpecWithStatusCode200)
                .extract().response();

        return Integer.parseInt(actual_offers_with_reservation_online.getBody().asString());

    }

}
