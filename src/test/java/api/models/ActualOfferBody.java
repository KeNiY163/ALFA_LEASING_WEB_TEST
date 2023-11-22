package api.models;

import lombok.Data;

@Data
public class ActualOfferBody {
    Boolean is_reservation_online;

    public void setIs_reservation_online(Boolean is_reservation_online) {
        this.is_reservation_online = is_reservation_online;
    }

}
