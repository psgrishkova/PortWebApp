package services;

import exceptions.DuplicateDataException;
import models.Route;
import repositories.RouteRepository;

import java.util.List;

public class RouteService {

    public static void add(Route route) {
        if (!RouteRepository.findRouteByName(route.getName()).isEmpty())
            throw new DuplicateDataException("Route with this name already exists");
        RouteRepository.add(route);
    }

    public static void delete(Long id) {
        RouteRepository.delete(id);
    }

    public static void update(Route route) {
        if (!findRouteById(route.getId()).get(0).getName().equals(route.getName()) && !findRouteByName(route.getName()).isEmpty())
            throw new DuplicateDataException("Route with this name already exists");
        RouteRepository.update(route);
    }

    public static List<Route> findRouteById(Long id) {
        return RouteRepository.findRouteById(id);
    }

    public static List<Route> getAll() {
        return RouteRepository.getAll();
    }

    public static List<Route> findRouteByName(String name) {
        return RouteRepository.findRouteByName(name);
    }
}
