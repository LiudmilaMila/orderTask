package orderTask;

import java.math.BigDecimal;

public class Product {

    public BigDecimal price;
    public String name;
    public int id;

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public BigDecimal getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
