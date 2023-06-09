package builder;

import dto.ProductDTO;

public class ProductBuilder {

    private ProductBuilder(){}

    public static ProductDTO inserindoProduto(){
        return ProductDTO.builder()
                .title("Perfume Oil")
                .description("Mega Discount, Impression of A...")
                .price(13)
                .discountPercentage(8.4)
                .rating(4.26)
                .stock(65)
                .brand("Impression of Acqua Di Gio")
                .category("fragrances")
                .thumbnail("https://i.dummyjson.com/data/products/11/thumnail.jpg")
                .build();
    }
}
