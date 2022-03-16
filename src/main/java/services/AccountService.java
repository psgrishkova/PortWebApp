package services;

import db.DBConnection;
import models.Account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.LinkedList;
import java.util.List;

public class AccountService {
    public void add(Account account) {
        PreparedStatement ps = DBConnection.getPreparedStatement("insert into account(login,pass) values (?,?)");
        try {
            ps.setString(1, account.getLogin());
            ps.setString(2, account.getPass());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Long id) {
        PreparedStatement ps = DBConnection.getPreparedStatement("delete from account where id = " + id);
        try {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void set(Account account) {
        PreparedStatement ps = DBConnection.getPreparedStatement("update account set login= ?, pass = ? where id=?");
        try {
            ps.setString(1, account.getLogin());
            ps.setString(2, account.getPass());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Account> getAll() {
        List<Account> all = new LinkedList<>();
        try {
            ResultSet rs = DBConnection.getPreparedStatement("Select * from account").executeQuery();
            while (rs.next())
                all.add(new Account(rs.getLong(1), rs.getString(2), rs.getString(3)));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return all;
        }
    }

    public Account findById(Long id) {
        return getAll().stream()
                .filter(account -> id == account.getId())
                .findFirst()
                .orElse(null);
    }

    public static boolean findByLoginAndPass(String login, String pass) {
        try {
            PreparedStatement ps = DBConnection.getPreparedStatement("Select count(id) from account where login like ? and pass like ?");
            ps.setString(1,login);
            ps.setString(2,pass);
            ResultSet rs = ps.executeQuery();
            rs.next();
            System.out.println(login+"\t"+pass+"\t"+(rs.getInt(1)==1));
            return rs.getInt(1)==1;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
