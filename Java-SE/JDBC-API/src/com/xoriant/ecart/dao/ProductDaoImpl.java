package com.xoriant.ecart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xoriant.ecart.config.DBConfig;
import com.xoriant.ecart.model.Product;

public class ProductDaoImpl {

	// save Product to DB using Statement interface
	public void save(Product product) {
		try {
			Connection con = DBConfig.getConnection();
			Statement stmt = con.createStatement();
			String q1 = "insert into product values(" + product.getId() + ",'" + product.getName() + "',"
					+ product.getPrice() + ",'" + product.getDescription() + "')";
			System.out.println(q1);
			int res = stmt.executeUpdate(q1);
			if (res != 0) {
				System.out.println(res + " statements executed");
			} else {
				System.out.println("Record not saved..");
			}

		} catch (Exception e) {
			System.out.println("failed due to " + e);
			e.printStackTrace();
		} finally {
			DBConfig.closeConnection();
		}

	}

	// save Product to DB using PreparredStatement
	public void saveV1(Product product) {

		try {
			Connection con = DBConfig.getConnection();
			String q1 = "insert into product values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(q1);
			ps.setInt(1, product.getId());
			ps.setString(2, product.getName());
			ps.setDouble(3, product.getPrice());
			ps.setString(4, product.getDescription());

			int res = ps.executeUpdate();
			if (res != 0) {
				System.out.println(res + " statements executed");
			} else {
				System.out.println("Record not saved..");
			}

		} catch (Exception e) {
			System.out.println("failed due to " + e);
			e.printStackTrace();
		} finally {
			DBConfig.closeConnection();
		}

	}

	// fetch Data from Product table using ResultSet interface
	public List<Product> findAll() {

		List<Product> products = new ArrayList<>();

		try {
			Connection con = DBConfig.getConnection();
			Statement stmt = con.createStatement();
			String q1 = "select * from product";

			ResultSet rs = stmt.executeQuery(q1);

			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				product.setDescription(rs.getString("description"));

				products.add(product);
			}

		} catch (Exception e) {
			System.out.println("failed due to " + e);
			e.printStackTrace();
		} finally {
			DBConfig.closeConnection();
		}

		return products;
	}

	// fetch Data from Product table using ResultSet interface - SCROLL - DEMO
	public List<Product> findAllV1() {

		List<Product> products = new ArrayList<>();

		try {
			Connection con = DBConfig.getConnection();

			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			String q1 = "select * from product";

			ResultSet rs = stmt.executeQuery(q1);
			rs.absolute(2);
			Product product = new Product();
			product.setId(rs.getInt("id"));
			product.setName(rs.getString("name"));
			product.setPrice(rs.getDouble("price"));
			product.setDescription(rs.getString("description"));

			System.out.println(product);

		} catch (Exception e) {
			System.out.println("failed due to " + e);
			e.printStackTrace();
		} finally {
			DBConfig.closeConnection();
		}

		return null;
	}

	// fetch Data from Product table using ResultSet interface - SCROLL - UPDATABLE
	// - DEMO
	public List<Product> findAllV2() {

		List<Product> products = new ArrayList<>();

		try {
			Connection con = DBConfig.getConnection();

			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			String q1 = "select * from product";

			ResultSet rs = stmt.executeQuery(q1);

			rs.absolute(2);
			rs.updateString(2, "EBook");
			rs.updateRow();

			Product product = new Product();

			product.setId(rs.getInt("id"));
			product.setName(rs.getString("name"));
			product.setPrice(rs.getDouble("price"));
			product.setDescription(rs.getString("description"));

			System.out.println(product);

		} catch (Exception e) {
			System.out.println("failed due to " + e);
			e.printStackTrace();
		} finally {
			DBConfig.closeConnection();
		}

		return null;
	}

	// batch Updates
	public void operations() {

		try {
			Connection con = DBConfig.getConnection();

			// disable auto-commit
			con.setAutoCommit(false);

			Product product = new Product(16, "Earphone-1", 18000, "Bot-1");

			String q1 = "insert into product values(" + product.getId() + ",'" + product.getName() + "',"
					+ product.getPrice() + ",'" + product.getDescription() + "')";

			String q2 = "update product set name='new-1' where id=10";
			String q3 = "update product set price=2000 where id=12";

			Statement stmt = con.createStatement();

			stmt.addBatch(q1);
			stmt.addBatch(q2);
			stmt.addBatch(q3);

			int[] res = stmt.executeBatch();
			int counter = 0;

			boolean status = true;

			for (int i = 0; i < res.length; i++) {
				if (res[i] == 1) {
					counter += 1;
				}

				if (res[i] == 0) {
					status = false;
				}
			}

			if (status) {
				con.commit();
			} else {
				con.rollback();
			}

			System.out.println(counter + " statements executed successfully");

		} catch (Exception e) {
			System.out.println("failed due to " + e);
			e.printStackTrace();
		} finally {
			DBConfig.closeConnection();
		}

	}

}
