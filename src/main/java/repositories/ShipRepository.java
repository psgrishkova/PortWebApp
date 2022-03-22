package repositories;

import db.DBConnection;
import models.Ship;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ShipRepository {
    public static void add(Ship s) {

        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(
                    "insert into ship(reg_number, name, capacity) values (?,?,?)"
            );
            ps.setString(1, s.getRegNumber());
            ps.setString(2, s.getName());
            ps.setInt(3, s.getCapacity());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(Long id) {

        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(
                    "delete from ship where id=?"
            );
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Ship s) {

        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(
                    "Update Ship set reg_number=?, name=?, capacity=?" + "where id=?"
            );
            ps.setString(1, s.getRegNumber());
            ps.setString(2, s.getName());
            ps.setInt(3, s.getCapacity());
            ps.setLong(4, s.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Ship> findShipById(Long id) {
        List<Ship> all = new LinkedList<>();
        try (Connection connection = DBConnection.getConnection()) {
            ResultSet rs = connection.prepareStatement("Select * from ship where id=" + id).executeQuery();
            while (rs.next())
                all.add(new Ship(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return all;
        }
    }

    public static List<Ship> findShipByName(String name) {
        List<Ship> ships = new LinkedList<>();
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("Select * from ship where name like ?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                ships.add(new Ship(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return ships;
        }
    }

    public static List<Ship> findShipByNum(String num) {
        List<Ship> ships = new LinkedList<>();
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("Select * from ship where reg_number like ?");
            ps.setString(1, num);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                ships.add(new Ship(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return ships;
        }
    }

    public static List<Ship> getAll() {
        List<Ship> all = new LinkedList<>();
        try (Connection connection = DBConnection.getConnection()) {
            ResultSet rs = connection.prepareStatement("Select * from ship").executeQuery();
            while (rs.next())
                all.add(new Ship(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return all;
        }
    }
}
