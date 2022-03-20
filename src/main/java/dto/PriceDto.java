package dto;

import models.Price;
import models.Route;
import repositories.RouteRepository;

public class PriceDto implements Comparable{
    private Long id;
    private String category;
    private double price;

    public PriceDto(Long id, String category, double price){
        this.id = id;
        this.category = category;
        this.price = price;
    }

    public PriceDto() {
    }

    public static PriceDto toPriceDto(Price price){
        PriceDto priceDto=new PriceDto();
        try {
            priceDto.setId(price.getId());
            priceDto.setCategory(price.getCategory());
            priceDto.setPrice(price.getPrice());
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

    @Override
    public int compareTo(Object o) {
        return (int) (this.id-((PriceDto)o).getId());
    }
}
