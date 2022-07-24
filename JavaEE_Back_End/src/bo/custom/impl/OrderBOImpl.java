package bo.custom.impl;

import bo.custom.OrderBO;
import dao.DAOFactory;
import dao.custom.ItemDAO;
import dao.custom.OrderDAO;
import dao.custom.OrderDetailDAO;
import dto.OrderDTO;
import dto.OrderDetailsDTO;
import dto.OrderDetailsDTO;
import entity.Order;
import entity.OrderDetails;
import entity.OrderDetails;

import javax.json.JsonArray;
import javax.json.JsonObject;
import java.sql.Connection;
import java.sql.SQLException;

public class OrderBOImpl implements OrderBO {

    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    OrderDetailsDTO orderDetailDTO = (OrderDetailsDTO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDERDETAIL);
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public JsonObject generateOrderId(Connection connection) throws SQLException, ClassNotFoundException {
        return orderDAO.generateOid(connection);
    }

    @Override
    public JsonArray getAllOrders(Connection connection) throws SQLException, ClassNotFoundException {
        return orderDAO.getAll(connection);
    }

    @Override
    public JsonArray getAllOrderDetails(Connection connection) throws SQLException, ClassNotFoundException {
        return orderDetailDTO.getAll(connection);
    }

    @Override
    public OrderDTO searchOrder(Connection connection, String id) throws SQLException, ClassNotFoundException {
        Order order = orderDAO.search(connection, id);
        System.out.println(order);
        if (order != null) {
            return new OrderDTO(order.getOrderId(), order.getOrderDate(), order.getCustomerId(), order.getTotal());
        }
        return null;
    }

    @Override
    public JsonArray searchOrderDetails(Connection connection, String id) throws SQLException, ClassNotFoundException {
        return orderDetailDTO.searchOrderDetails(connection, id);
    }

    /*@Override
    public boolean placeOrder(Connection connection, OrderDTO orderDTO) {
        try {
            connection.setAutoCommit(false);
            Order order = new Order(orderDTO.getOrderId(), orderDTO.getOrderDate(), orderDTO.getCustomerId(), orderDTO.getTotal());
            boolean add = orderDAO.add(connection, order);
            if (!add) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }
            for (OrderDetailsDTO dto : orderDTO.) {
                OrderDetails orderDetail1 = new OrderDetails(dto.getOrderId(), dto.getItemId(), dto.getItemName(), dto.getUnitPrice(), dto.getBuyQty(), dto.getTotal());
                boolean orderDetailAdded = orderDetailDAO.add(connection, orderDetail1);
                if (!orderDetailAdded) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
            }

            for (OrderDetailsDTO dto : orderDTO.get) {
                boolean updateQty = itemDAO.updateQty(connection, dto.getBuyQty(), dto.getItemId());
                if (!updateQty) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }*/
}
