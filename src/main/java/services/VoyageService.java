package services;

import db.DBConnection;
import models.Voyage;
import dto.VoyageDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

public class VoyageService {
    public static void add(Voyage v) {
        PreparedStatement ps = DBConnection.getPreparedStatement(
                "insert into voyage(route_id, captain_id, ship_id, date) values (?,?,?,?,?)"
        );
        try {
            ps.setLong(1,v.getRouteId());
            ps.setLong(2,v.getCapId());
            ps.setLong(3,v.getShipId());
            ps.setTimestamp(4, Timestamp.valueOf(v.getDate()));

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(Long id) {
        PreparedStatement ps = DBConnection.getPreparedStatement(
                "delete from voyage where id=?"
        );
        try {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void setVoyage(Voyage v){
        PreparedStatement ps = DBConnection.getPreparedStatement(
                "Update voyage set captain_id=?, route_id=?, ship_id=?, date=?"+"where id=?"
        );
        try {
            ps.setLong(1,v.getCapId());
            ps.setLong(2,v.getRouteId());
            ps.setLong(3,v.getShipId());
            ps.setTimestamp(4, Timestamp.valueOf(v.getDate()));
            ps.setLong(5,v.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Voyage> findVoyageById(Long id) {
        List<Voyage> all = new LinkedList<>();
        try {
            ResultSet rs = DBConnection.getPreparedStatement("Select * from voyage where id="+id).executeQuery();
            while (rs.next())
                all.add(new Voyage(rs.getLong(1), rs.getLong(2), rs.getLong(3), rs.getLong(4),  rs.getTimestamp(5).toLocalDateTime()));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return all;
        }
    }

    public static List<VoyageDto> getAll() {
        List<VoyageDto> all = new LinkedList<>();
        try {
            ResultSet rs = DBConnection.getPreparedStatement("Select * from voyage").executeQuery();
            while (rs.next())
                all.add(VoyageDto.toVoyageDto(new Voyage(rs.getLong(1), rs.getLong(2), rs.getLong(3), rs.getLong(4),  rs.getTimestamp(5).toLocalDateTime())));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return all;
        }
    }
}
