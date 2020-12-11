package services;

import entities.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService {
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "iphone", 100));
        products.put(2, new Product(2, "nokia", 200));
        products.put(3, new Product(3, "samsung", 300));
        products.put(4, new Product(4, "xiaomi",400));
    }


    public List findAll() {
        return new ArrayList<>(products.values());
    }


    public void save(Product product) {

        products.put(product.getId(), product);
    }


    public Product findById(int id) {
        return products.get(id);
    }


    public void update(int id, Product product) {
        products.put(id, product);

    }


    public void remove(int id) {
        products.remove(id);
    }
}
