package orderTask;

import java.math.BigDecimal;

public class ShippingDetails {
    private BigDecimal price;
    private String address;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
