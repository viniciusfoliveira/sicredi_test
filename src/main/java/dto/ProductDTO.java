package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ProductDTO {

    private String title;
    private String description;
    private int price;
    private double discountPercentage;
    private double rating;
    private int stock;
    private String brand;
    private String category;
    private String thumbnail;

    private Map<Object, Object> bodyProduto = new HashMap<>();

    @Builder
    public ProductDTO(String title, String description, int price, double discountPercentage, double rating, int stock, String brand, String category, String thumbnail) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.discountPercentage = discountPercentage;
        this.rating = rating;
        this.stock = stock;
        this.brand = brand;
        this.category = category;
        this.thumbnail = thumbnail;

        bodyProduto.put("title", title);
        bodyProduto.put("description", description);
        bodyProduto.put("price", price);
        bodyProduto.put("discountPercentage", discountPercentage);
        bodyProduto.put("rating", rating);
        bodyProduto.put("stock", stock);
        bodyProduto.put("brand", brand);
        bodyProduto.put("category", category);
        bodyProduto.put("thumbnail", thumbnail);
    }
}
