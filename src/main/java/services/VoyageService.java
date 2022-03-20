package services;

import dto.VoyageDto;
import exceptions.DuplicateDataException;
import models.Voyage;
import repositories.VoyageRepository;

import java.util.List;

public class VoyageService {
    public static void add(Voyage voyage){
        if(VoyageRepository.findCapsIdByVoyageDate(voyage.getDate()).contains(voyage.getCapId())) throw new DuplicateDataException("This captain is already on the voyage at this time");
        if(VoyageRepository.findShipsIdByVoyageDate(voyage.getDate()).contains(voyage.getShipId())) throw new DuplicateDataException("This ship is already on the voyage at this time");
        VoyageRepository.add(voyage);
    }

    public static void delete(Long id){
        VoyageRepository.delete(id);
    }

    public static void update(Voyage voyage){
        if(!VoyageRepository.findVoyageById(voyage.getId()).get(0).getCapId().equals(voyage.getCapId()) && VoyageRepository.findCapsIdByVoyageDate(voyage.getDate()).contains(voyage.getCapId())) throw new DuplicateDataException("This captain is already on the voyage at this time");
        if(!VoyageRepository.findVoyageById(voyage.getId()).get(0).getShipId().equals(voyage.getShipId()) && VoyageRepository.findShipsIdByVoyageDate(voyage.getDate()).contains(voyage.getShipId())) throw new DuplicateDataException("This ship is already on the voyage at this time");
        VoyageRepository.update(voyage);
    }

    public static List<Voyage> findVoyageById(Long id) {
        return VoyageRepository.findVoyageById(id);
    }

    public static List<VoyageDto> getAll() {
        return VoyageRepository.getAll();
    }
}
