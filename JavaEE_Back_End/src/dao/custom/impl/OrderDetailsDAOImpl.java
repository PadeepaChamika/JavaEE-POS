package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.OrderDetailsDAO;
import entity.OrderDetails;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailsDAOImpl implements OrderDetailsDAO {
    @Override
    public JsonArray getAll(Connection connection) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuery(connection, "SELECT * FROM `Order Detail`");
        JsonArrayBuilder orderDetailsArray = Json.createArrayBuilder();
        while (rst.next()) {
            OrderDetails orderDetail = new OrderDetails(rst.getString(1), rst.getString(2), rst.getString(3), rst.getDouble(4), rst.getInt(5), rst.getDouble(6));
            JsonObjectBuilder orderDetailObj = Json.createObjectBuilder();
            orderDetailObj.add("orderId", orderDetail.getOrderId());
            orderDetailObj.add("itemCode", orderDetail.getItemId());
            orderDetailObj.add("itemName", orderDetail.getItemName());
            orderDetailObj.add("unitPrice", orderDetail.getUnitPrice());
            orderDetailObj.add("qty", orderDetail.getBuyQty());
            orderDetailObj.add("total", orderDetail.getTotal());
            orderDetailsArray.add(orderDetailObj.build());
        }
        return orderDetailsArray.build();
    }

    @Override
    public boolean add(Connection connection,OrderDetails orderDetail) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate(connection,"INSERT INTO `Order Detail` VALUES (?,?,?,?,?,?)", orderDetail.getOrderId(), orderDetail.getItemId(), orderDetail.getItemName(), orderDetail.getUnitPrice(), orderDetail.getBuyQty(), orderDetail.getTotal());
    }

    @Override
    public boolean update(Connection connection ,OrderDetails orderDetail) {
        return false;
    }

    @Override
    public boolean delete(Connection connection,String s) {
        return false;
    }

    @Override
    public OrderDetails search(Connection connection,String id) {
        return null;
    }

    @Override
    public JsonArray searchOrderDetails(Connection connection, String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuery(connection, "SELECT * FROM `Order Detail` WHERE orderId=?", id);
        JsonArrayBuilder orderDetailArray = Json.createArrayBuilder();
        while (rst.next()) {
            OrderDetails orderDetail = new OrderDetails(rst.getString(1), rst.getString(2), rst.getString(3), rst.getDouble(4), rst.getInt(5), rst.getDouble(6));
            JsonObjectBuilder obj = Json.createObjectBuilder();
            obj.add("orderId", orderDetail.getOrderId());
            obj.add("itemCode", orderDetail.getOrderId());
            obj.add("itemName", orderDetail.getOrderId());
            obj.add("unitPrice", orderDetail.getOrderId());
            obj.add("qty", orderDetail.getOrderId());
            obj.add("total", orderDetail.getOrderId());
            orderDetailArray.add(obj.build());
        }
        return orderDetailArray.build();
    }
}
