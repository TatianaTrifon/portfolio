package org.example.fit_plan.dao.implimentations;

import org.example.fit_plan.JdbcConnection;
import org.example.fit_plan.dao.WeightDAO;
import org.example.fit_plan.model.Weight;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WeightDAOImpl implements WeightDAO {

JdbcConnection jdbcConnection = new JdbcConnection();


    @Override
    public Weight create(Weight weight) {

        String sql = "INSERT INTO weight_history (user_id, weight) VALUES (?, ?)";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement createWeight = conn.prepareStatement(sql)) {

            createWeight.setInt(1, weight.getUserId());
            createWeight.setDouble(2, weight.getWeight());
            createWeight.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return weight;
    }

    @Override
    public List<Weight> findById(Integer id) {

        List<Weight> weights = new ArrayList<>();

        String sql = "SELECT weight, entry_date FROM weight_history WHERE user_id = ? ORDER BY entry_date ASC";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement findWeight = conn.prepareStatement(sql)) {

            findWeight.setInt(1, id);

            ResultSet resultSet = findWeight.executeQuery();

            while(resultSet.next()){

                Double weight = resultSet.getDouble("weight");
                Timestamp entryDate = resultSet.getTimestamp("entry_date");

                weights.add(new Weight(weight,entryDate));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return weights;

    }
}
