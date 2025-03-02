package dao;

import model.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductDAOImpl implements ProductDAO {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/InvantryDB";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1234";

    public ProductDAOImpl() {
        // Initialize any resources if needed
    }

    @Override
    public void addProduct(Product product) throws Exception {
        String sql = "INSERT INTO products (id, name, minSellQuantity, price, quantityAvailable) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, product.getId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setInt(3, product.getMinSellQuantity());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setInt(5, product.getQuantityAvailable());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Product added successfully.");
            } else {
                System.out.println("Product addition failed.");
            }
        } catch (Exception e) {
            System.out.println("Error adding product: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void updateProduct(Product product) throws Exception {
        if (!productExists(product.getId())) {
            System.out.println("Product update failed. Product ID may not exist.");
            return;
        }

        String sql = "UPDATE products SET name = ?, minSellQuantity = ?, price = ?, quantityAvailable = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getMinSellQuantity());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getQuantityAvailable());
            preparedStatement.setInt(5, product.getId());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Product updated successfully.");
            } else {
                System.out.println("Product update failed.");
            }
        } catch (Exception e) {
            System.out.println("Error updating product: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void deleteProduct(int productId) throws Exception {
        if (!productExists(productId)) {
            System.out.println("Product deletion failed. Product ID may not exist.");
            return;
        }

        String sql = "DELETE FROM products WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, productId);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Product deleted successfully.");
            } else {
                System.out.println("Product deletion failed.");
            }
        } catch (Exception e) {
            System.out.println("Error deleting product: " + e.getMessage());
            throw e;
        }
    }

    // Check if product exists by ID
    private boolean productExists(int productId) throws Exception {
        String sql = "SELECT id FROM products WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, productId);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();  // Returns true if the product exists
        } catch (Exception e) {
            System.out.println("Error checking product existence: " + e.getMessage());
            throw e;
        }
    }
}
