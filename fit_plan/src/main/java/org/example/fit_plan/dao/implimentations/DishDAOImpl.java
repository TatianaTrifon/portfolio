package org.example.fit_plan.dao.implimentations;

import org.example.fit_plan.JdbcConnection;
import org.example.fit_plan.dao.DishDAO;
import org.example.fit_plan.model.Dish;
import org.example.fit_plan.model.Exercise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DishDAOImpl implements DishDAO {

    JdbcConnection jdbcConnection = new JdbcConnection();

    private static final Logger LOGGER = LoggerFactory.getLogger(DishDAOImpl.class);

    @Override
    public Dish create(Dish dish) {

        String sql = "INSERT INTO dish(picture,dish_name,ingredients,instructions,calories,nutrients) VALUES (?,?,?,?,?,?)";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement createDish = conn.prepareCall(sql)) {

            createDish.setBlob(1, new ByteArrayInputStream(dish.getPicture()));
            createDish.setString(2, dish.getDishName());
            createDish.setString(3, dish.getIngredients());
            createDish.setString(4, dish.getInstructions());
            createDish.setDouble(5, dish.getCalories());
            createDish.setString(6, dish.getNutrients());

            createDish.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Failed to create a dish! " + e);
        }


        return dish;
    }

    @Override
    public Dish update(Dish dish) {

        String sql = "UPDATE dish SET dish_name = ?, ingredients = ?, instructions = ?, calories = ? , nutrients = ? WHERE dish_id = ?";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement updateDish = conn.prepareCall(sql)) {

            updateDish.setString(1, dish.getDishName());
            updateDish.setString(2, dish.getIngredients());
            updateDish.setString(3, dish.getInstructions());
            updateDish.setDouble(4, dish.getCalories());
            updateDish.setString(5, dish.getNutrients());
            updateDish.setInt(6, dish.getDishId());

            updateDish.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Failed to update dish with id: " + dish.getDishId() + e);
        }

        return dish;
    }

    @Override
    public boolean deleteById(Integer id) {

        String sql = "DELETE FROM dish WHERE dish_id = ?";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement deleteDish = conn.prepareCall(sql)) {

            deleteDish.setInt(1, id);

            deleteDish.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Failed to delete the dish with id: " + id + e);
        }

        return true;
    }

    @Override
    public Dish findById(Integer id) {

        Dish dish = new Dish();

        String sql = "SELECT * FROM dish WHERE dish_id = ?";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement findDish = conn.prepareCall(sql)) {

            findDish.setInt(1, id);

            ResultSet resultSet = findDish.executeQuery();

            while (resultSet.next()) {
                int dishId = resultSet.getInt("dish_id");
                byte[] image = resultSet.getBytes("picture");
                String name = resultSet.getString("dish_name");
                String ingredients = resultSet.getString("ingredients");
                String instructions = resultSet.getString("instructions");
                double calories = resultSet.getDouble("calories");
                String nutrients = resultSet.getString("nutrients");

                dish = new Dish(dishId,image, name, ingredients, instructions, calories, nutrients);
            }
        } catch (SQLException e) {
            LOGGER.error("Failed to find a diet with id: " + id + e);
        }


        return dish;
    }

    @Override
    public List<Dish> findByIngredient(String ingredient) {
        List<Dish> dishes = new ArrayList<>();

        String sql = "SELECT * FROM dish WHERE ingredients LIKE ?";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement findDish = conn.prepareStatement(sql)) {

            findDish.setString(1, "%" + ingredient + "%");

            ResultSet resultSet = findDish.executeQuery();

            while (resultSet.next()) {
                int dishId = resultSet.getInt("dish_id");
                byte[] image = resultSet.getBytes("picture");
                String name = resultSet.getString("dish_name");
                String ingredients = resultSet.getString("ingredients");
                String instructions = resultSet.getString("instructions");
                double calories = resultSet.getDouble("calories");
                String nutrients = resultSet.getString("nutrients");

                dishes.add(new Dish(dishId, image, name, ingredients, instructions, calories, nutrients));
            }
        } catch (SQLException e) {
            LOGGER.error("Failed to find a dish with ingredient: " + ingredient, e);
        }

        return dishes;
    }

    @Override
    public List<Dish> findByName(String name) {
        List<Dish> dishes = new ArrayList<>();

        String sql = "SELECT * FROM dish WHERE dish_name = ?";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement findDish = conn.prepareCall(sql)) {

            findDish.setString(1, name);

            ResultSet resultSet = findDish.executeQuery();

            while (resultSet.next()) {
                int dishId = resultSet.getInt("dish_id");
                byte[] image = resultSet.getBytes("picture");
                String dishName = resultSet.getString("dish_name");
                String ingredients = resultSet.getString("ingredients");
                String instructions = resultSet.getString("instructions");
                double calories = resultSet.getDouble("calories");
                String nutrients = resultSet.getString("nutrients");

                dishes.add(new Dish(dishId, image, dishName, ingredients, instructions, calories, nutrients));
            }
        } catch (SQLException e) {
            LOGGER.error("Failed to find a dish with the name: " + name + e);
        }

        return dishes;
    }

    @Override
    public List<Dish> findAll() {

        List<Dish> dishes = new ArrayList<>();

        String sql = "SELECT * FROM dish";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement findDish = conn.prepareCall(sql)) {

            ResultSet resultSet = findDish.executeQuery();

            while (resultSet.next()) {
                int dishId = resultSet.getInt("dish_id");
                byte[] image = resultSet.getBytes("picture");
                String name = resultSet.getString("dish_name");
                String ingredients = resultSet.getString("ingredients");
                String instructions = resultSet.getString("instructions");
                double calories = resultSet.getDouble("calories");
                String nutrients = resultSet.getString("nutrients");

                dishes.add(new Dish(dishId, image, name, ingredients, instructions, calories, nutrients));
            }
        } catch (SQLException e) {
            LOGGER.error("Failed to find any dish! " + e);
        }

        return dishes;

    }

    @Override
    public boolean addToProgress(Integer userId, Integer dishId) {

        String sql = "INSERT INTO user_account_dishes (user_id,dish_id) VALUES (?,?)";


        try(Connection conn = jdbcConnection.getConnection();
            PreparedStatement addDish = conn.prepareStatement(sql)){

            addDish.setInt(1, userId);
            addDish.setInt(2, dishId);
            addDish.executeUpdate();


        }catch (SQLException e){
            LOGGER.error("Failed to add the dish to progress");
        }

        return true;
    }

    @Override
    public List<Dish> findDishByUserAccountId(Integer id) {
        List<Dish> dishes = new ArrayList<>();

        String sql = "SELECT dish.picture, dish.dish_name, dish.ingredients, dish.instructions, dish.calories, dish.nutrients " +
                "FROM dish JOIN user_account_dishes ON dish.dish_id = user_account_dishes.dish_id " +
                "WHERE user_account_dishes.user_id = ?";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement findDish = conn.prepareStatement(sql)) {

            findDish.setInt(1, id);

            ResultSet resultSet = findDish.executeQuery();

            while (resultSet.next()) {
                byte[] picture = resultSet.getBytes("picture");
                String name = resultSet.getString("dish_name");
                String ingredients = resultSet.getString("ingredients");
                String instructions = resultSet.getString("instructions");
                double calories = resultSet.getDouble("calories");
                String nutrients = resultSet.getString("nutrients");

                dishes.add(new Dish(picture, name, ingredients, instructions, calories, nutrients));
            }

        } catch (SQLException e) {
            LOGGER.error("Failed to find any dish! " + e);
        }

        return dishes;
    }

}
