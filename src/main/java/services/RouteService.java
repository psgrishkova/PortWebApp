package services;

import db.DBConnection;
import models.Route;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

public class RouteService {
    public static void add(Route cap) {
        PreparedStatement ps = DBConnection.getPreparedStatement(
                "insert into route(name, start_point, end_point) values (?,?,?)"
        );
        try {
            ps.setString(1, cap.getName());
            ps.setString(2, cap.getFrom());
            ps.setString(3, cap.getTo());
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

    public static void setRoute(Route s) {
        PreparedStatement ps = DBConnection.getPreparedStatement(
                "Update route set name=?, start_point=?, end_point=?" + "where id=?"
        );
        try {
            ps.setString(1, s.getName());
            ps.setString(2, s.getFrom());
            ps.setString(3, s.getTo());
            ps.setLong(4,s.getId());
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
}
