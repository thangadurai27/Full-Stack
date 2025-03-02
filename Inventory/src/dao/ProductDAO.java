package dao;

import model.Product;

public interface ProductDAO {
    void addProduct(Product product) throws Exception;
    void updateProduct(Product product) throws Exception;
    void deleteProduct(int productId) throws Exception;
}
