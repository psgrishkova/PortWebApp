package models;

import services.CapService;
import services.RouteService;
import services.ShipService;

import java.time.LocalDateTime;

public class VoyageDto {
    private Long id;
    private Cap cap;
    private Ship ship;
    private Route route;
    private LocalDateTime date;

    public VoyageDto(Long id, Cap cap, Ship ship, Route route, LocalDateTime date) {
        this.id = id;
        this.cap = cap;
        this.ship = ship;
        this.route = route;
        this.date = date;
    }

    public VoyageDto() {
    }

    public static VoyageDto toVoyageDto(Voyage v) {
        VoyageDto r = new VoyageDto();
        try {
            r.setId(v.getId());
            r.setCap(CapService.findCapById(v.getCapId()).get(0));
            r.setRoute(RouteService.findRouteById(v.getRouteId()).get(0));
            r.setShip(ShipService.findShipById(v.getShipId()).get(0));
            r.setDate(v.getDate());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cap getCap() {
        return cap;
    }

    public void setCap(Cap cap) {
        this.cap = cap;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
