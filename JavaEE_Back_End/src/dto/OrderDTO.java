package dto;

import javax.json.JsonArray;
import java.util.ArrayList;

public class OrderDTO {
    private String orderId;
    private String orderDate;
    private String customerId;
    private double total;
    private ArrayList<OrderDetailsDTO> orderDetails;

    public OrderDTO(String orderId, String orderDate, String customerId, double orderTotal, JsonArray orderDetails) {
    }

    public OrderDTO(String orderId, String orderDate, String customerId, double total) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.total = total;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderId='" + orderId + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", customerId='" + customerId + '\'' +
                ", total=" + total +
                '}';
    }
}
