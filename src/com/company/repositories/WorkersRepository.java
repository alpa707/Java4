package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Workers;
import com.company.repositories.interfaces.IWorkersRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class WorkersRepository implements IWorkersRepository {
    private final IDB db;

    public WorkersRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createWorkers(Workers workers) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO stones(name,cost,experienced) VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, workers.getName());
            st.setInt(2, workers.getCost());
            st.setBoolean(3, workers.isExperienced());

            boolean executed = st.execute();
            return executed;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Workers getWorkers(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name, cost, experienced FROM stones WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Workers workers = new Workers(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("cost"),
                        rs.getBoolean("experienced"));

                return workers;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Workers> getAllWorkers() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name, cost, experienced FROM stones";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Workers> workers = new ArrayList<>();
            while (rs.next()) {
                Workers worker = new Workers(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("cost"),
                        rs.getBoolean("experienced"));

                workers.add(worker);
            }

            return workers;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
