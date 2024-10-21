package org.example.fit_plan.dao.implimentations;

import org.example.fit_plan.JdbcConnection;
import org.example.fit_plan.dao.DietDAO;
import org.example.fit_plan.model.Diet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DietDAOImpl implements DietDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(DietDAOImpl.class);

    JdbcConnection jdbcConnection = new JdbcConnection();

    @Override
    public Diet create(Diet diet) {

        String sql = "INSERT INTO diet (diet_name,diet_description,diet_category,allowed_food,forbidden_food) VALUES (?,?,?,?,?)";


        try(Connection conn = jdbcConnection.getConnection();
            PreparedStatement createDiet = conn.prepareCall(sql)){

            createDiet.setString(1, diet.getDietName());
            createDiet.setString(2, diet.getDietDescription());
            createDiet.setString(3, diet.getDietCategory());
            createDiet.setString(4, diet.getAllowedFood());
            createDiet.setString(5, diet.getForbiddenFood());

createDiet.executeUpdate();

        }catch (SQLException e){
            LOGGER.error("Failed to create a diet! ", e);
        }

        return diet;
    }

    @Override
    public Diet update(Diet diet) {

        String sql = "UPDATE diet SET diet_name = ? WHERE diet_id = ?";

        try(Connection conn = jdbcConnection.getConnection();
        PreparedStatement updateDiet = conn.prepareCall(sql)){

            updateDiet.setString(1, diet.getDietName());
            updateDiet.setInt(2, diet.getDietId());

            updateDiet.executeUpdate();

        }catch (SQLException e){
            LOGGER.error("Failed to update diet with id: " + diet.getDietId() + e);
        }

        return diet;
    }

    @Override
    public boolean deleteById(Integer id) {

        String sql = "DELETE FROM diet WHERE diet_id = ?";

        try(Connection conn = jdbcConnection.getConnection();
        PreparedStatement deleteDiet = conn.prepareCall(sql)){

            deleteDiet.setInt(1, id);

            deleteDiet.executeUpdate();

        }catch (SQLException e){
            LOGGER.error("Failed to delete the diet with id: " + id + e);
        }

        return true;
    }

    @Override
    public Diet findById(Integer id) {

        Diet diet = new Diet();

        String sql = "SELECT * FROM diet WHERE diet_id = ?";

        try(Connection conn = jdbcConnection.getConnection();
        PreparedStatement findDiet = conn.prepareCall(sql)){

            findDiet.setInt(1, id);

            ResultSet resultSet = findDiet.executeQuery();

            int dietId = resultSet.getInt("diet_id");
            String name = resultSet.getString("diet_name");
            String description = resultSet.getString("diet_description");
            String category = resultSet.getString("diet_category");
            String allowedFood = resultSet.getString("allowed_food");
            String forbiddenFood = resultSet.getString("forbidden_food");

            diet = new Diet(dietId,name,description,category,allowedFood,forbiddenFood);

        }catch (SQLException e){
            LOGGER.error("Failed to find a diet with id: " + id + e);
        }

        return diet;
    }

    @Override
    public List<Diet> findDietsByCategory(String category) {

        List<Diet> diets = new ArrayList<>();

        String sql = "SELECT * FROM diet WHERE diet_category = ?";

        try(Connection conn = jdbcConnection.getConnection();
        PreparedStatement findDiet = conn.prepareCall(sql)){

            findDiet.setString(1, category);

            ResultSet resultSet = findDiet.executeQuery();

            while(resultSet.next()){

                int dietId = resultSet.getInt("diet_id");
                String name = resultSet.getString("diet_name");
                String description = resultSet.getString("diet_description");
                String dietCategory = resultSet.getString("diet_category");
                String allowedFood = resultSet.getString("allowed_food");
                String forbiddenFood = resultSet.getString("forbidden_food");

                diets.add(new Diet(dietId,name,description,dietCategory,allowedFood,forbiddenFood));
            }

        }catch (SQLException e){
            LOGGER.error("Failed to find any diet with category: " + category);
        }

        return diets;
    }

    @Override
    public List<Diet> findAllDiets() {

        List<Diet> diets = new ArrayList<>();

        String sql = "SELECT * FROM diet";

        try(Connection conn = jdbcConnection.getConnection();
            PreparedStatement findDiet = conn.prepareCall(sql)){


            ResultSet resultSet = findDiet.executeQuery();

            while(resultSet.next()){

                int dietId = resultSet.getInt("diet_id");
                String name = resultSet.getString("diet_name");
                String description = resultSet.getString("diet_description");
                String dietCategory = resultSet.getString("diet_category");
                String allowedFood = resultSet.getString("allowed_food");
                String forbiddenFood = resultSet.getString("forbidden_food");

                diets.add(new Diet(dietId,name,description,dietCategory,allowedFood,forbiddenFood));
            }

        }catch (SQLException e){
            LOGGER.error("Failed to find any diet");
        }

        return diets;
    }
}
