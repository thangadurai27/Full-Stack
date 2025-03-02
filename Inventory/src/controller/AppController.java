package controller;

import dao.UserDAO;
import dao.ProductDAO;
import model.User;
import model.Product;
import java.util.Scanner;

public class AppController {
    private Scanner sc = new Scanner(System.in);
    private UserDAO userDAO;
    private ProductDAO productDAO;

    public AppController(UserDAO userDAO, ProductDAO productDAO) {
        this.userDAO = userDAO;
        this.productDAO = productDAO;
    }

    public void start() {
        while (true) {
            System.out.println("Main Menu");
            System.out.println("1. Admin Login");
            System.out.println("2. Agent Login");
            System.out.println("3. Exit");
            System.out.println("Enter Choice:");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            if (choice == 1) {
                adminLogin();
            } else if (choice == 2) {
                agentLogin();
            } else if (choice == 3) {
                System.out.println("Exiting....");
                System.exit(0);
            } else {
                System.out.println("Invalid choice");
            }
        }
    }

    private void adminLogin() {
        System.out.println("Enter Username:");
        String name = sc.nextLine();
        System.out.println("Enter Password:");
        String password = sc.nextLine();

        User admin = userDAO.findUserByName(name);
        if (admin != null && "Admin".equalsIgnoreCase(admin.getRole())) {
            if (admin.getPassword().equals(password)) {
                System.out.println("Admin logged in successfully");
                adminMenu();
            } else {
                System.out.println("Invalid password");
            }
        } else {
            System.out.println("Admin not found or incorrect role");
        }
    }

    private void agentLogin() {
        System.out.println("Agent login is not yet implemented.");
    }

    private void adminMenu() {
        System.out.println("Admin Menu");
        System.out.println("1. Add Product");
        System.out.println("2. Update Product");
        System.out.println("3. Delete Product");
        System.out.println("4. Log Out");
        System.out.print("Enter Choice: ");
        
        int choice = sc.nextInt();
        sc.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                addProduct();
                break;
            case 2:
                updateProduct();
                break;
            case 3:
                deleteProduct();
                break;
            case 4:
                System.out.println("Logging out...");
                return;
            default:
                System.out.println("Invalid choice. Try again.");
                adminMenu();
        }
    }

    private void addProduct() {
        System.out.println("Enter Product ID:");
        int productId = sc.nextInt();
        sc.nextLine(); // Consume newline

        System.out.println("Enter Product Name:");
        String productName = sc.nextLine();

        System.out.println("Enter Minimum Selling Quantity:");
        int minSellQuantity = sc.nextInt();

        System.out.println("Enter Product Price:");
        double price = sc.nextDouble();

        System.out.println("Enter Quantity Available:");
        int quantityAvailable = sc.nextInt();
        sc.nextLine(); // Consume newline

        Product product = new Product(productId, productName, minSellQuantity, price, quantityAvailable);

        try {
            productDAO.addProduct(product);
            System.out.println("Product added successfully.");
        } catch (Exception e) {
            System.out.println("Error adding product: " + e.getMessage());
        }
    }

    private void updateProduct() {
        System.out.println("Enter Product ID to update:");
        int productId = sc.nextInt();
        sc.nextLine(); // Consume newline

        System.out.println("Enter New Product Name:");
        String productName = sc.nextLine();

        System.out.println("Enter New Minimum Selling Quantity:");
        int minSellQuantity = sc.nextInt();

        System.out.println("Enter New Product Price:");
        double price = sc.nextDouble();

        System.out.println("Enter New Quantity Available:");
        int quantityAvailable = sc.nextInt();
        sc.nextLine(); // Consume newline

        Product product = new Product(productId, productName, minSellQuantity, price, quantityAvailable);

        try {
            productDAO.updateProduct(product);
        } catch (Exception e) {
            System.out.println("Error updating product: " + e.getMessage());
        }
    }

    private void deleteProduct() {
        System.out.println("Enter Product ID to delete:");
        int productId = sc.nextInt();
        sc.nextLine(); // Consume newline

        try {
            productDAO.deleteProduct(productId);
        } catch (Exception e) {
            System.out.println("Error deleting product: " + e.getMessage());
        }
    }
}
