package models;

import dto.PriceDto;

import java.util.List;

public class PriceList {
    private Long id;
    private String name;
    private List<PriceDto> priceList;


    public PriceList(Long id, String name, List<PriceDto> priceList) {
        this.id = id;
        this.name=name;
        this.priceList = priceList;
    }

    public PriceList() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<PriceDto> getPriceList() {
        return priceList;
    }

    public void setPriceList(List<PriceDto> priceList) {
        this.priceList = priceList;
    }
}
