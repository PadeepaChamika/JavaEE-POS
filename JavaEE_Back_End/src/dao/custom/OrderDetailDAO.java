package dao.custom;

import dao.CrudDAO;
import entity.OrderDetails;
import entity.OrderDetails;

import javax.json.JsonArray;
import java.sql.Connection;
import java.sql.SQLException;

public interface OrderDetailDAO extends CrudDAO<OrderDetails, String> {
    JsonArray searchOrderDetails(Connection connection,String id) throws SQLException, ClassNotFoundException;
}
