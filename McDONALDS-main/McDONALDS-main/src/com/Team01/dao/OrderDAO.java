package com.Team01.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.Team01.DTO.*;

public class OrderDAO {
    public static void saveOrder(OrderDTO order) throws Exception {
        DB db = new DB();
        Connection con = db.createConnection();

        String sql = "INSERT INTO orders (order_id, type, food_item, table_no) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, order.getOrderId());
        pstmt.setString(2, order.getType());
        pstmt.setString(3, order.getFoodItem());
        pstmt.setInt(4, order.getTableNo());

        pstmt.executeUpdate();
        con.close();
    }
}