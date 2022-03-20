package services;

import dto.PriceDto;
import exceptions.DuplicateDataException;
import models.Price;
import models.PriceList;
import repositories.PriceRepository;

import java.util.List;

public class PriceService {
    public static void add(Price price){
        if(findPriceByPK(price.getId(), price.getCategory()).stream().count()!=0) throw new DuplicateDataException("This price list already has a price for the category:"+price.getCategory());
        PriceRepository.add(price);
    }

    public static void delete(Long id) {
        PriceRepository.delete(id);
    }

    public static List<Price> findPriceByPK(Long id, String category) {
        return PriceRepository.findPriceByPK(id,category);
    }

    public static List<PriceDto> getAll() {
        return PriceRepository.getAll();
    }

    public static PriceList getPriceList(Long id){
        return PriceRepository.getPriceList(id);
    }

    public static List<PriceList> getAllPriceLists(){
        return PriceRepository.getAllPriceLists();
    }
}
