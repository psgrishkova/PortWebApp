package repositories;

import db.DBConnection;
import dto.PriceDto;
import models.Price;
import models.PriceList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class PriceRepository {
    public static void add(Price price) {
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(
                    "insert into price(id,category, price) values (?,?," + price.getPrice() + ")"
            );
            ps.setLong(1, price.getId());
            ps.setString(2, price.getCategory());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(Long id) {
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("delete from price where id=?");
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Price> findPriceByPK(Long id, String category) {
        List<Price> all = new LinkedList<>();
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("Select * from price where id=? and category=?");
            ps.setLong(1, id);
            ps.setString(2, category);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                all.add(new Price(rs.getLong(1), rs.getString(2), rs.getDouble(3)));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return all;
        }
    }

    public static List<PriceDto> getAll() {
        List<PriceDto> all = new LinkedList<>();
        try (Connection connection = DBConnection.getConnection()) {
            ResultSet rs = connection.prepareStatement("Select * from price order by id").executeQuery();
            while (rs.next())
                all.add(PriceDto.toPriceDto(new Price(rs.getLong(1), rs.getString(2), rs.getDouble(3))));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return all;
        }
    }

    public static PriceList getPriceList(Long id) {
        PriceList priceList = new PriceList();
        List<PriceDto> all = new LinkedList<>();
        try (Connection connection = DBConnection.getConnection()) {
            ResultSet rs = connection.prepareStatement("Select * from price where id=" + id).executeQuery();
            priceList.setId(id);
            while (rs.next()) {
                all.add(PriceDto.toPriceDto(new Price(rs.getLong(1), rs.getString(2), rs.getDouble(3))));
            }
            priceList.setPriceList(all);
            priceList.setName(RouteRepository.findRouteById(id).get(0).getName());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return priceList;
        }
    }

    public static List<PriceList> getAllPriceLists() {
        List<PriceList> priceLists = new LinkedList<>();
        try (Connection connection = DBConnection.getConnection()) {
            ResultSet rs = connection.prepareStatement("Select DISTINCT  id from price").executeQuery();
            while (rs.next()) {
                priceLists.add(getPriceList(rs.getLong(1)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return priceLists;
        }
    }


}
