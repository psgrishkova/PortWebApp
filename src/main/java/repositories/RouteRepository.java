package repositories;

import db.DBConnection;
import models.Route;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class RouteRepository {
    public static void add(Route route) {
        PreparedStatement ps = DBConnection.getPreparedStatement(
                "insert into route(name, start_point, end_point) values (?,?,?)"
        );
        try {
            ps.setString(1, route.getName());
            ps.setString(2, route.getFrom());
            ps.setString(3, route.getTo());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(Long id) {
        PreparedStatement ps = DBConnection.getPreparedStatement(
                "delete from route where id=?"
        );
        try {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Route route) {
        PreparedStatement ps = DBConnection.getPreparedStatement(
                "Update route set name=?, start_point=?, end_point=?" + "where id=?"
        );
        try {
            ps.setString(1, route.getName());
            ps.setString(2, route.getFrom());
            ps.setString(3, route.getTo());
            ps.setLong(4,route.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Route> findRouteById(Long id) {
        List<Route> all = new LinkedList<>();
        try {
            ResultSet rs = DBConnection.getPreparedStatement("Select * from route where id=" + id).executeQuery();
            while (rs.next())
                all.add(new Route(rs.getLong(1), rs.getString(2), rs.getString(3),rs.getString(4)));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return all;
        }
    }

    public static List<Route> getAll() {
        List<Route> all = new LinkedList<>();
        try {
            ResultSet rs = DBConnection.getPreparedStatement("Select * from route").executeQuery();
            while (rs.next())
                all.add(new Route(rs.getLong(1), rs.getString(2), rs.getString(3),rs.getString(4)));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return all;
        }
    }

    public static List<Route> findRouteByName(String name){
        List<Route> all = new LinkedList<>();
        try {
            PreparedStatement ps = DBConnection.getPreparedStatement("Select * from route where name like ?");
            ps.setString(1,name);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                all.add(new Route(rs.getLong(1), rs.getString(2), rs.getString(3),rs.getString(4)));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return all;
        }
    }
}
