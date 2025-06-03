package com.dao;

import java.sql.*;
import java.util.*;

import com.bean.Cart;
import com.bean.Menu;
import com.connection.DBconnection;

public class ProductDao {
	private Connection con;

	private String query;
	private PreparedStatement pst;
	private ResultSet rs;

	public ProductDao() {
		super();
		DBconnection dbcon = new DBconnection();
        con = dbcon.dbConnect();
		this.con = con;
	}

	public List<Menu> getAllProducts() {
		List<Menu> book = new ArrayList<>();
		try {

			query = "select * from Menu";
			pst = this.con.prepareStatement(query);
			rs = pst.executeQuery();

			while (rs.next()) {
				book.add(new Menu(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getBoolean(8)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return book;
	}

	public Menu getSingleProduct(int id) {
		Menu row = null;
		try {
			query = "select * from Menu where menuId=? ";

			pst = this.con.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				row = new Menu(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getBoolean(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		return row;
	}

	public double getTotalCartPrice(ArrayList<Cart> cartList) {
		double sum = 0;
		try {
			if (cartList.size() > 0) {
				for (Cart item : cartList) {
					query = "select price from Menu where menuId=?";
					pst = this.con.prepareStatement(query);
					pst.setInt(1, item.getDishId());
					rs = pst.executeQuery();
					while (rs.next()) {
						sum += rs.getInt(1) * item.getQuantity();
					}

				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return sum;
	}

	public List<Menu> getCartProducts(ArrayList<Cart> cartList) {
		List<Menu> book = new ArrayList<>();
		try {
			if (cartList.size() > 0) {
				for (Cart item : cartList) {
					query = "select * from Menu where menuId=?";
					pst = this.con.prepareStatement(query);
					pst.setInt(1, item.getDishId());
					rs = pst.executeQuery();
					while (rs.next()) {
						Menu row = new Menu(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getString(5),
								rs.getInt(6) * item.getQuantity(), rs.getInt(7), rs.getBoolean(8));

						book.add(row);
					}

				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return book;
	}
}