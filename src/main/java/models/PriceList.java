package models;

import dto.PriceDto;

import java.util.List;

public class PriceList {
    private Long id;
    private List<PriceDto> priceList;

    public PriceList(Long id, List<PriceDto> priceList) {
        this.id = id;
        this.priceList = priceList;
    }

    public PriceList() {
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
