package services;

import exceptions.DuplicateDataException;
import models.Ship;
import repositories.ShipRepository;

import java.util.List;

public class ShipService {
    public static void add(Ship s) {
        if(findShipByName(s.getName()).stream().count()!=0) throw new DuplicateDataException("Ship with that name already exists");
        if(findShipByNum(s.getRegNumber()).stream().count()!=0) throw new DuplicateDataException("Ship with that registration number already exists");
        ShipRepository.add(s);
    }

    public static void delete(Long id) {
        ShipRepository.delete(id);
    }

    public static void update(Ship s){
        if(!findShipById(s.getId()).get(0).getName().equals(s.getName()) && findShipByName(s.getName()).stream().count()!=0) throw new DuplicateDataException("Ship with that name already exists");
        if(!findShipById(s.getId()).get(0).getRegNumber().equals(s.getRegNumber()) && findShipByNum(s.getRegNumber()).stream().count()!=0) throw new DuplicateDataException("Ship with that registration number already exists");
        ShipRepository.update(s);
    }

    public static List<Ship> findShipById(Long id) {
        return ShipRepository.findShipById(id);
    }

    public static List<Ship> findShipByNum(String num) {
        return ShipRepository.findShipByNum(num);
    }

    public static List<Ship> findShipByName(String name) {
        return ShipRepository.findShipByName(name);
    }

    public static List<Ship> getAll() {
        return ShipRepository.getAll();
    }
}
