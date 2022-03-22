package services;

import exceptions.DuplicateDataException;
import models.Cap;
import repositories.CapRepository;

import java.util.List;

public class CapService {
    public static void add(Cap cap) {
        if (findCapByName(cap.getName()).stream().count() != 0)
            throw new DuplicateDataException("Сap with that name already exists");
        CapRepository.add(cap);
    }

    public static void delete(Long id) {
        CapRepository.delete(id);
    }

    public static void update(Cap cap) {
        if (!findCapById(cap.getId()).get(0).getName().equals(cap.getName()) && findCapByName(cap.getName()).stream().count() != 0)
            throw new DuplicateDataException("Сap with that name already exists");
        CapRepository.update(cap);
    }

    public static List<Cap> findCapById(Long id) {
        return CapRepository.findCapById(id);
    }

    public static List<Cap> findCapByName(String name) {
        return CapRepository.findCapByName(name);
    }

    public static List<Cap> getAll() {
        return CapRepository.getAll();
    }
}
