package orderTask;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Order {
    private Product[] products;
    private Customer customer;
    private ShippingDetails shippingDetails;
    private LocalDate dayOfCreate;
    private OrderStatus orderStatus;
    private int id;

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ShippingDetails getShippingDetails() {
        return shippingDetails;
    }

    public void setShippingDetails(ShippingDetails shippingDetails) {
        this.shippingDetails = shippingDetails;
    }

    public LocalDate getDayOfCreate() {
        return dayOfCreate;
    }

    public void setDayOfCreate(LocalDate dayOfCreate) {
        this.dayOfCreate = dayOfCreate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getTotalPrice(){

        BigDecimal sumOfProductPrice = new BigDecimal("0");
        for (Product product : products) {
            BigDecimal productPrice = product.getPrice();
            sumOfProductPrice = sumOfProductPrice.add(productPrice);
        }
        if(getShippingDetails() != null){
            sumOfProductPrice = sumOfProductPrice.add(getShippingDetails().getPrice());
        }
        return  sumOfProductPrice;
    }
}
