package orderTask;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {

        Product product1 = new Product();
        product1.setName("Ручка");
        product1.setId(4569877);
        product1.setPrice(new BigDecimal("5.26"));

        Product product2 = new Product();
        product2.setName("Карандаш");
        product2.setId(4569837);
        product2.setPrice(new BigDecimal("4.90"));

        Product product3 = new Product();
        product3.setName("Резинка");
        product3.setId(9759877);
        product3.setPrice(new BigDecimal("7.13"));

        Product product4 = new Product();
        product4.setName("Тетрадь");
        product4.setId(1269773);
        product4.setPrice(new BigDecimal("14.12"));

        Product product5 = new Product();
        product5.setName("Дневник");
        product5.setId(7893147);
        product5.setPrice(new BigDecimal("14.12"));

        Product[] products = new Product[]{product1, product2, product3, product4, product5};

        Customer customer1 = new Customer();
        customer1.setId(4656);
        customer1.setName("Иванов И.И.");

        Customer customer2 = new Customer();
        customer2.setId(1219);
        customer2.setName("Донченко А.В.");

        Customer customer3 = new Customer();
        customer3.setId(2441);
        customer3.setName("Арутунян Г.А.");


        ShippingDetails shippingDetails1 = new ShippingDetails();
        shippingDetails1.setAddress("Бочарова 22");
        shippingDetails1.setPrice(new BigDecimal("56.14"));

        ShippingDetails shippingDetails2 = new ShippingDetails();
        shippingDetails2.setAddress("Шевченко 14");
        shippingDetails2.setPrice(new BigDecimal("32.11"));

        ShippingDetails shippingDetails3 = new ShippingDetails();
        shippingDetails3.setAddress("Богдана 9");
        shippingDetails3.setPrice(new BigDecimal("32.11"));

        Order order1 = new Order();
        order1.setId(165156);
        order1.setProducts(new Product[]{products[1], products[1]});
        order1.setCustomer(customer1);
        order1.setShippingDetails(shippingDetails1);
        order1.setDayOfCreate(LocalDate.of(2021, 8, 3));
        order1.setOrderStatus(OrderStatus.INTHEWAY);

        Order order2 = new Order();
        order2.setId(368852);
        order2.setProducts(new Product[]{products[4], products[3]});
        order2.setCustomer(customer1);
        order2.setShippingDetails(null);
        order2.setDayOfCreate(LocalDate.of(2021, 8, 4));
        order2.setOrderStatus(OrderStatus.INPROCESSING);


        Order order3 = new Order();
        order3.setId(97537);
        order3.setProducts(new Product[]{products[2], products[1]});
        order3.setCustomer(customer2);
        order3.setShippingDetails(shippingDetails3);
        order3.setDayOfCreate(LocalDate.of(1992, 12, 5));
        order3.setOrderStatus(OrderStatus.INTHEWAY);

        Order order4 = new Order();
        order4.setId(255903);
        order4.setProducts(new Product[]{products[4], products[3], products[4]});
        order4.setCustomer(customer3);
        order4.setShippingDetails(shippingDetails2);
        order4.setDayOfCreate(LocalDate.of(2019, 4, 22));
        order4.setOrderStatus(OrderStatus.PAID);

        Order order5 = new Order();
        order5.setId(97530);
        order5.setProducts(new Product[]{products[4], products[4]});
        order5.setCustomer(customer3);
        order5.setShippingDetails(null);
        order5.setDayOfCreate(LocalDate.of(2020, 10, 5));
        order5.setOrderStatus(OrderStatus.INPROCESSING);


        Order[] orders = new Order[]{order1, order2, order3, order4, order5};
//         printOrderArray(orders);
//         findOrderByOrderStatus(orders);
//         printCustomersAndSumOfTheyOrders(orders);
//         printTaskSortProductByPriceAndName(orders);
//         printOrdersByDayOfCreatePriceAndProductsQuantity(orders);
//         printSortedTableByDayStatusNameAndPrice(orders);
//         printOrderList(findOrdersByCustomerId(orders,4656));
//         printCustomer(orders);
//         printOrderList(findOrderByProduct(orders, 4569837));printProductList(findProductsFromOrders(orders));
//         printSortedCustomer(orders);
        printSortedOrderByDayOfCreateStatusCustomersNamePrice(orders);
    }

    private void printOrderList(List<Order> orders) {
        for (Order order : orders) {

            Product[] products = order.getProducts();
            System.out.println("\nЗаказ " + order.getId());
            System.out.println("Заказынных продуктов " + order.getProducts().length);
            printProductArray(products);
            System.out.println("Заказчик " + order.getCustomer().getName() + " " + order.getCustomer().getId());
            printShippingDetailIfAbsent(order);
            System.out.println("Дата заказа " + order.getDayOfCreate());
            System.out.println("Статус заказа " + order.getOrderStatus());
            System.out.println("Стоимость заказа " + order.getTotalPrice());

        }
    }

    private void printShippingDetailIfAbsent(Order order) {
        if (order.getShippingDetails() != null) {
            System.out.println("Адрес доставки " + order.getShippingDetails().getAddress());
            System.out.println("Стоимость доставки " + order.getShippingDetails().getPrice());
        } else {
            System.out.println(" Без доставки ");
        }
    }


    private void printOrderArray(Order[] orders) {
        for (int i = 0; i < orders.length; i++) {
            Order order = orders[i];

            Product[] products = order.getProducts();
            System.out.println("\nЗаказ " + order.getId());
            System.out.println("Заказынных продуктов " + order.getProducts().length);
            printProductArray(products);
            System.out.println("Заказчик " + order.getCustomer().getName() + " " + order.getCustomer().getId());
            printShippingDetailIfAbsent(order);
            System.out.println("Дата заказа " + order.getDayOfCreate());
            System.out.println("Статус заказа " + order.getOrderStatus());
            System.out.println("Стоимость заказа " + order.getTotalPrice());

        }
    }


    private void printProductArray(Product[] products) {
        for (Product product : products) {

            printProduct(product);
        }
    }

    private void printProductList(List<Product> products) {
        for (Product product : products) {
            printProduct(product);
        }
    }

    private void printProduct(Product product) {
        System.out.println("Продукт " + product.getId()
                + " " + product.getName()
                + " стоимость " + product.getPrice());
    }

    private void findOrderByOrderStatus(Order[] orders) {
        for (Order order : orders) {
            if (order.getOrderStatus() == OrderStatus.INTHEWAY) {
                System.out.println("\nЗаказ " + order.getId());
                System.out.println("Статус заказа " + order.getOrderStatus());
                if (order.getShippingDetails() != null) {
                    System.out.println("Адрес доставки " + order.getShippingDetails().getAddress());
                }
            }

        }
    }


    private List<Product> getProductsFromOrders(Order[] orders) {

        List<Product> productsInOrders = new ArrayList<>();
        for (Order order : orders) {

            Product[] products = order.getProducts();
            productsInOrders.addAll(Arrays.asList(products));
        }

        return productsInOrders;
    }


    public int compareProductsByPriceAndName(Product p1, Product p2) {
        int result;

        result = p1.getPrice().compareTo(p2.getPrice());
        if (result != 0) {
            return result;
        }

        result = p1.getName().compareTo(p2.getName());
        if (result != 0) {
            return result;
        }

        return 0;
    }

    public int compareOrdersByDayOfCreatePriceAndProductsQuantity(Order o1, Order o2) {
        int result;

        result = o1.getDayOfCreate().compareTo(o2.getDayOfCreate());
        if (result != 0) {
            return -result;
        }

        result = o1.getTotalPrice().compareTo(o2.getTotalPrice());
        if (result != 0) {
            return -result;
        }

        result = Integer.compare(o1.getProducts().length, o2.getProducts().length);
        if (result != 0) {
            return result;
        }

        return 0;

    }

    public int compareByDayStatusNameAndPrice(Order o1, Order o2) {
        int result;

        result = o1.getDayOfCreate().compareTo(o2.getDayOfCreate());
        if (result != 0) {
            return -result;
        }

        result = o1.getOrderStatus().compareTo(o2.getOrderStatus());
        if (result != 0) {
            return result;
        }

        result = o1.getCustomer().getName().compareTo(o2.getCustomer().getName());
        if (result != 0) {
            return result;
        }

        result = o1.getTotalPrice().compareTo(o2.getTotalPrice());
        if (result != 0) {
            return -result;
        }
        return 0;
    }

    private void sortOrdersByDayStatusNameAndPrice(Order[] orders) {
        List<Order> orders1 = Arrays.asList(orders);

        orders1.sort(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return compareByDayStatusNameAndPrice(o1, o2);
            }
        });

    }


    private void sortOrdersByDayOfCreatePriceAndProductsQuantity(Order[] orders) {
        List<Order> orders1 = Arrays.asList(orders);

        orders1.sort(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return compareOrdersByDayOfCreatePriceAndProductsQuantity(o1, o2);
            }
        });
    }

    private void sortProductsByPriceAndName(List<Product> products) {

        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return compareProductsByPriceAndName(o1, o2);
            }
        });
    }

    private void printTaskSortProductByPriceAndName(Order[] orders) {

        List<Product> productsFromOrders = getProductsFromOrders(orders);

        sortProductsByPriceAndName(productsFromOrders);

        printProductList(productsFromOrders);

    }

    private void printOrdersByDayOfCreatePriceAndProductsQuantity(Order[] orders) {
        sortOrdersByDayOfCreatePriceAndProductsQuantity(orders);
        printOrderArray(orders);
    }

    private void printSortedTableByDayStatusNameAndPrice(Order[] orders) {

        System.out.println("Order'sId | "
                + "DayOfCreate | "
                + "OrderStatus | "
                + "Customer'sName | "
                + "Order'sPrice |");

        sortOrdersByDayStatusNameAndPrice(orders);

        for (Order order : orders) {
            System.out.printf("%10s|%13s|%13s|%16s|%14s|%n"
                    , order.getId()
                    , order.getDayOfCreate()
                    , order.getOrderStatus()
                    , order.getCustomer().getName()
                    , order.getTotalPrice());
        }
    }


    private List<Order> findOrdersByCustomerId(Order[] orders, int id) {
        List<Order> result = new ArrayList<>();

        for (Order order : orders) {
            if (order.getCustomer().getId() == id) {
                result.add(order);
            }
        }
        return result;
    }

    private List<Customer> findCustomersFromOrders(Order[] orders) {
        Map<Integer, Customer> customerIntegerMap = new HashMap<>();

        for (Order order : orders) {
            customerIntegerMap.putIfAbsent(order.getCustomer().getId(), order.getCustomer());
        }

        return new ArrayList<>(customerIntegerMap.values());


    }

    private void printCustomer(Order[] orders) {
        List<Customer> customers = findCustomersFromOrders(orders);

        for (Customer customer : customers) {
            System.out.println("Заказчик " + customer.getId()
                    + " имя заказчика " + customer.getName());
        }

    }


    private List<Order> findOrderByProduct(Order[] orders, int productId) {
        List<Order> resultProducts = new ArrayList<>();

        for (Order order : orders) {
            Product[] currentProducts = order.getProducts();
            for (Product currentProduct : currentProducts) {
                if (currentProduct.getId() == productId) {
                    resultProducts.add(order);
                    break;
                }
            }
        }
        return resultProducts;
    }

    private List<Product> findProductsFromOrders(Order[] orders) {

        Map<Integer, Product> productIntegerMap = new HashMap<>();

        for (Order order : orders) {
            Product[] currentProducts = order.getProducts();
            for (Product currentProduct : currentProducts) {
                productIntegerMap.putIfAbsent(currentProduct.getId(), currentProduct);
            }
        }
        return new ArrayList<>(productIntegerMap.values());
    }

    private int compareForCustomerOrdersAndTotalSum(CustomerAndOrdersQuantityContainer c1, CustomerAndOrdersQuantityContainer c2) {

        int result;

        result = Integer.compare(c1.getCountOfOrders(), c2.getCountOfOrders());
        if (result != 0) {
            return -result;
        }

        result = c1.getPrice().compareTo(c2.getPrice());
        if (result != 0) {
            return -result;
        }

        return 0;
    }

    private void sortCustomerShowTack(List<CustomerAndOrdersQuantityContainer> customerForShowerTasks) {
        customerForShowerTasks.sort(new Comparator<CustomerAndOrdersQuantityContainer>() {
            @Override
            public int compare(CustomerAndOrdersQuantityContainer o1, CustomerAndOrdersQuantityContainer o2) {
                return compareForCustomerOrdersAndTotalSum(o1, o2);
            }
        });

    }

    private List<CustomerAndOrdersQuantityContainer> createListCustomerForShowerTask(Order[] orders) {

        Map<Integer, CustomerAndOrdersQuantityContainer> customerIdPerContainer = new HashMap<>();
        for (Order order : orders) {
            int customerId = order.getCustomer().getId();

            if (!customerIdPerContainer.containsKey(customerId)) {
                CustomerAndOrdersQuantityContainer container = new CustomerAndOrdersQuantityContainer();
                container.setCustomer(order.getCustomer());
                container.setCountOfOrders(1);
                container.setPrice(order.getTotalPrice());

                customerIdPerContainer.put(customerId, container);

            } else {
                CustomerAndOrdersQuantityContainer container =
                        customerIdPerContainer.get(customerId);
                container.setCountOfOrders(container.getCountOfOrders() + 1);
                container.setPrice(container.getPrice().add(order.getTotalPrice()));

            }
        }

        return new ArrayList<>(customerIdPerContainer.values());
    }

    private void printSortedCustomer(Order[] orders) {

        List<CustomerAndOrdersQuantityContainer> customers = createListCustomerForShowerTask(orders);

        sortCustomerShowTack(customers);

        for (CustomerAndOrdersQuantityContainer customer : customers) {
            System.out.println(customer.getCustomer().getName() +
                    " кол-во заказов " + customer.getCountOfOrders() +
                    " общая сумма заказов " + customer.getPrice());
        }
    }

    private int compareOrderByDayOfCreateStatusCustomersNamePrice(Order o1, Order o2) {
        int result;

        result = o1.getDayOfCreate().compareTo(o2.getDayOfCreate());
        if (result != 0) {
            return -result;
        }

        result = o1.getOrderStatus().compareTo(o2.getOrderStatus());
        if (result != 0) {
            return -result;
        }

        result = o1.getCustomer().getName().compareTo(o2.getCustomer().getName());
        if (result != 0) {
            return result;
        }

        result = o1.getTotalPrice().compareTo(o2.getTotalPrice());
        if (result != 0) {
            return result;
        }

        return 0;
    }

    private void sortOrderByDayOfCreateStatusCustomersNamePrice(Order[] orders) {
        List<Order> orderList = Arrays.asList(orders);
        orderList.sort(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return compareOrderByDayOfCreateStatusCustomersNamePrice(o1, o2);
            }
        });
    }

    private void printSortedOrderByDayOfCreateStatusCustomersNamePrice(Order[] orders) {

        sortOrderByDayOfCreateStatusCustomersNamePrice(orders);

        System.out.println("Order'sID | "
                + "DayOfCreate | "
                + "Order'sStatus | "
                + "FirsProduct'sName | "
                + "QuantityProducts | "
                + "Customer'sName | "
                + "Order'sPrice | "
                + "DeliveryStatus | ");


        for (Order order : orders) {
            Product[] products = order.getProducts();
            String deliveryStatus = " - ";
            if (order.getShippingDetails() != null) {
                deliveryStatus = " + ";
            }

            System.out.printf("%10s|%13s|%15s|%19s|%18s|%16s|%14s|%16s|%n",
                    order.getId(),
                    order.getDayOfCreate(),
                    order.getOrderStatus(),
                    products[0].name,
                    products.length,
                    order.getCustomer().getName(),
                    order.getTotalPrice(),
                    deliveryStatus

            );
        }
    }
}