package dto;

import models.Price;
import models.Route;
import services.RouteService;

public class PriceDto implements Comparable{
    private Long id;
    private String category;
    private double price;
    private Route route;

    public PriceDto(Long id, String category, double price, Route route){
        this.id = id;
        this.category = category;
        this.price = price;
        this.route = route;
    }

    public PriceDto() {
    }

    public static PriceDto toPriceDto(Price price){
        PriceDto priceDto=new PriceDto();
        try {
            priceDto.setId(price.getId());
            priceDto.setCategory(price.getCategory());
            priceDto.setPrice(price.getPrice());
            priceDto.setRoute(RouteService.findRouteById(price.getRouteId()).get(0));
        }
        catch (Exception e){e.printStackTrace();}
        finally {
            return priceDto;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    @Override
    public int compareTo(Object o) {
        return (int) (this.id-((PriceDto)o).getId());
    }
}
