package models;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Voyage {
    private Long id;
    private Long acc_id;
    private Long capId;
    private Long routeId;
    private Long shipId;
    private LocalDateTime date;

    public Voyage(Long id, Long acc_id, Long capId, Long routeId, Long shipId, LocalDateTime date) {
        this.id = id;
        this.acc_id = acc_id;
        this.capId = capId;
        this.routeId = routeId;
        this.shipId = shipId;
        this.date=date;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(Long acc_id) {
        this.acc_id = acc_id;
    }

    public Long getCapId() {
        return capId;
    }

    public void setCapId(Long capId) {
        this.capId = capId;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public Long getShipId() {
        return shipId;
    }

    public void setShipId(Long shipId) {
        this.shipId = shipId;
    }
}
