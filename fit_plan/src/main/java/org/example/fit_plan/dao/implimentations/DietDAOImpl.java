package org.example.fit_plan.dao.implimentations;

import org.example.fit_plan.JdbcConnection;
import org.example.fit_plan.dao.DietDAO;
import org.example.fit_plan.model.Diet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
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

        String sql = "INSERT INTO diet (picture, diet_name,diet_description,diet_category,allowed_food,forbidden_food) VALUES (?,?,?,?,?,?)";


        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement createDiet = conn.prepareStatement(sql)) {

            createDiet.setBlob(1, new ByteArrayInputStream(diet.getPicture()));
            createDiet.setString(2, diet.getDietName());
            createDiet.setString(3, diet.getDietDescription());
            createDiet.setString(4, diet.getDietCategory());
            createDiet.setString(5, diet.getAllowedFood());
            createDiet.setString(6, diet.getForbiddenFood());

            createDiet.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Failed to create a diet! ", e);
        }

        return diet;
    }

    @Override
    public Diet update(Diet diet) {

        String sql = "UPDATE diet SET diet_name = ?,diet_description = ?, allowed_food = ?, forbidden_food = ? WHERE diet_id = ?";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement updateDiet = conn.prepareStatement(sql)) {

            updateDiet.setString(1, diet.getDietName());
            updateDiet.setString(2, diet.getDietDescription());
            updateDiet.setString(3, diet.getAllowedFood());
            updateDiet.setString(4, diet.getForbiddenFood());
            updateDiet.setInt(5, diet.getDietId());

            updateDiet.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Failed to update diet with id: " + diet.getDietId() + e);
        }

        return diet;
    }

    @Override
    public boolean deleteById(Integer id) {

        String sql = "DELETE FROM diet WHERE diet_id = ?";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement deleteDiet = conn.prepareStatement(sql)) {

            deleteDiet.setInt(1, id);

            deleteDiet.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Failed to delete the diet with id: " + id + e);
        }

        return true;
    }

    @Override
    public Diet findById(Integer id) {

        Diet diet = new Diet();

        String sql = "SELECT * FROM diet WHERE diet_id = ?";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement findDiet = conn.prepareStatement(sql)) {

            findDiet.setInt(1, id);

            ResultSet resultSet = findDiet.executeQuery();

            while (resultSet.next()) {
                int dietId = resultSet.getInt("diet_id");
                byte[] image = resultSet.getBytes("picture");
                String name = resultSet.getString("diet_name");
                String description = resultSet.getString("diet_description");
                String category = resultSet.getString("diet_category");
                String allowedFood = resultSet.getString("allowed_food");
                String forbiddenFood = resultSet.getString("forbidden_food");

                diet = new Diet(dietId, image, name, description, category, allowedFood, forbiddenFood);
            }
        } catch (SQLException e) {
            LOGGER.error("Failed to find a diet with id: " + id + e);
        }

        return diet;
    }


    @Override
    public Diet findDietByUserId(Integer userId) {

        Diet diet = new Diet();

        String sql = "SELECT d.diet_id, d.picture, d.diet_name, d.diet_description, d.diet_category, d.allowed_food, d.forbidden_food " +
                "FROM diet AS d " +
                "INNER JOIN user_account AS ua ON d.diet_id = ua.diet_id " +
                "WHERE ua.user_id = ?";


        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement findDiet = conn.prepareStatement(sql)) {

            findDiet.setInt(1, userId);

            ResultSet resultSet = findDiet.executeQuery();

            while (resultSet.next()) {
                int dietId = resultSet.getInt("diet_id");
                byte[] image = resultSet.getBytes("picture");
                String name = resultSet.getString("diet_name");
                String description = resultSet.getString("diet_description");
                String category = resultSet.getString("diet_category");
                String allowedFood = resultSet.getString("allowed_food");
                String forbiddenFood = resultSet.getString("forbidden_food");

                diet = new Diet(dietId, image, name, description, category, allowedFood, forbiddenFood);
            }
        } catch (SQLException e) {
            LOGGER.error("Failed to find a diet with user id: " + userId + e);
        }

        return diet;
    }


    @Override
    public List<Diet> findDietsByCategory(String category) {

        List<Diet> diets = new ArrayList<>();

        String sql = "SELECT * FROM diet WHERE diet_category = ?";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement findDiet = conn.prepareStatement(sql)) {

            findDiet.setString(1, category);

            ResultSet resultSet = findDiet.executeQuery();

            while (resultSet.next()) {

                int dietId = resultSet.getInt("diet_id");
                byte[] image = resultSet.getBytes("picture");
                String name = resultSet.getString("diet_name");
                String description = resultSet.getString("diet_description");
                String dietCategory = resultSet.getString("diet_category");
                String allowedFood = resultSet.getString("allowed_food");
                String forbiddenFood = resultSet.getString("forbidden_food");

                diets.add(new Diet(dietId, image, name, description, dietCategory, allowedFood, forbiddenFood));
            }

        } catch (SQLException e) {
            LOGGER.error("Failed to find any diet with category: " + category);
        }

        return diets;
    }

    @Override
    public List<Diet> findRecommendedDiets() {
        List<Diet> diets = new ArrayList<>();

        String sql = "SELECT * FROM diet LIMIT 3";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement findDiet = conn.prepareStatement(sql)) {


            ResultSet resultSet = findDiet.executeQuery();

            while (resultSet.next()) {

                int dietId = resultSet.getInt("diet_id");
                byte[] image = resultSet.getBytes("picture");
                String name = resultSet.getString("diet_name");
                String description = resultSet.getString("diet_description");
                String dietCategory = resultSet.getString("diet_category");
                String allowedFood = resultSet.getString("allowed_food");
                String forbiddenFood = resultSet.getString("forbidden_food");

                diets.add(new Diet(dietId, image, name, description, dietCategory, allowedFood, forbiddenFood));
            }

        } catch (SQLException e) {
            LOGGER.error("Failed to find any diet");
        }

        return diets;
    }

    @Override
    public List<Diet> findAllDiets() {

        List<Diet> diets = new ArrayList<>();

        String sql = "SELECT * FROM diet";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement findDiet = conn.prepareStatement(sql)) {


            ResultSet resultSet = findDiet.executeQuery();

            while (resultSet.next()) {

                int dietId = resultSet.getInt("diet_id");
                byte[] image = resultSet.getBytes("picture");
                String name = resultSet.getString("diet_name");
                String description = resultSet.getString("diet_description");
                String dietCategory = resultSet.getString("diet_category");
                String allowedFood = resultSet.getString("allowed_food");
                String forbiddenFood = resultSet.getString("forbidden_food");

                diets.add(new Diet(dietId, image, name, description, dietCategory, allowedFood, forbiddenFood));
            }

        } catch (SQLException e) {
            LOGGER.error("Failed to find any diet");
        }

        return diets;
    }
}
