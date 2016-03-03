package pl.btbw.core.product.components;

import pl.btbw.core.common.output.Component;
import pl.btbw.core.common.output.Mappable;
import pl.btbw.core.product.core.Product;

import java.math.BigDecimal;

public class ProductComponent implements Component {

    public Long id;
    public String name;
    public String slug;
    public String index;
    public String author;
    public String brand;
    public String description;
    public BigDecimal price;

    @Override
    public void map(Mappable mappable) {

        Product product = (Product) mappable;

        this.id = product.getId();
        this.name = product.getName();
        this.slug = product.getSlug();
        this.index = product.getIndex();
        this.author = product.getAuthor();
        this.brand = product.getBrand();
        this.description = product.getDescription();
        this.price = product.getPrice();
    }

    @Override
    public String getNameComponent() {
        return "ProductComponent";
    }
}
