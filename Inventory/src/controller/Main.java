package controller;

import controller.AppController;
import dao.ProductDAO;
import dao.UserDAO;
import dao.ProductDAOImpl;
import dao.UserDAOImpl;

@SuppressWarnings("unused")
public class Main {
    public static void main(String[] args) {
        // Setup the necessary DAOs
        UserDAO userDAO = new UserDAOImpl();
        ProductDAO productDAO = new ProductDAOImpl();

        // Start the application
        AppController appController = new AppController(userDAO, productDAO);
        appController.start();
    }
}
