package services;

import db.DBConnection;
import models.Cap;
import models.Ship;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CapService {
    public static void add(Cap cap){
        PreparedStatement ps = DBConnection.getPreparedStatement(
                "insert into captain(name, phone) values (?,?)"
        );
        try {
            ps.setString(1, cap.getName());
            ps.setString(2, cap.getPhone());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(Long id) {
        PreparedStatement ps = DBConnection.getPreparedStatement(
                "delete from captain where id=?"
        );
        try {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void setCap(Cap s){
        PreparedStatement ps = DBConnection.getPreparedStatement(
                "Update captain set name=?, phone=?"+"where id=?"
        );
        try {
            ps.setString(1,s.getName());
            ps.setString(2,s.getPhone());
            ps.setLong(3,s.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Cap> findCapById(Long id) {
        List<Cap> all = new LinkedList<>();
        try {
            ResultSet rs = DBConnection.getPreparedStatement("Select * from captain where id="+id).executeQuery();
            while (rs.next())
                all.add(new Cap(rs.getLong(1), rs.getString(2), rs.getString(3)));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return all;
        }
    }

    public static List<Cap> getAll() {
        List<Cap> all = new LinkedList<>();
        try {
            ResultSet rs = DBConnection.getPreparedStatement("Select * from captain").executeQuery();
            while (rs.next())
                all.add(new Cap(rs.getLong(1), rs.getString(2), rs.getString(3)));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return all;
        }
    }
}
