package services;

import db.DBConnection;
import models.Ship;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ShipService {
    public static void add(Ship s) {
        PreparedStatement ps = DBConnection.getPreparedStatement(
                "insert into ship(reg_number, name, capacity) values (?,?,?)"
        );
        try {
            ps.setString(1, s.getRegNumber());
            ps.setString(2, s.getName());
            ps.setInt(3, s.getCapacity());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(Long id) {
        PreparedStatement ps = DBConnection.getPreparedStatement(
                "delete from ship where id=?"
        );
        try {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void setShip(Ship s){
        PreparedStatement ps = DBConnection.getPreparedStatement(
                "Update Ship set reg_number=?, name=?, capacity=?"+"where id=?"
        );
        try {
            ps.setString(1,s.getRegNumber());
            ps.setString(2,s.getName());
            ps.setInt(3,s.getCapacity());
            ps.setLong(4,s.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Ship> findShipById(Long id) {
        List<Ship> all = new LinkedList<>();
        try {
            ResultSet rs = DBConnection.getPreparedStatement("Select * from ship where id="+id).executeQuery();
            while (rs.next())
                all.add(new Ship(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return all;
        }
    }

    public static List<Ship> getAll() {
        List<Ship> all = new LinkedList<>();
        try {
            ResultSet rs = DBConnection.getPreparedStatement("Select * from ship").executeQuery();
            while (rs.next())
                all.add(new Ship(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return all;
        }
    }
}
