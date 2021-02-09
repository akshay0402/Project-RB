package com.rays.marksheet;

import java.sql.*;
import java.util.ResourceBundle;

public class MarksheetModel {
	public void search(MarksheetBean bean) throws Exception {
ResourceBundle rb = ResourceBundle.getBundle("com.rays.marksheet.app");
		Class.forName(rb.getString("driver"));
		Connection c = DriverManager.getConnection(rb.getString("url"),rb.getString("user"),rb.getString("pwd"));

		PreparedStatement p = c.prepareStatement("select * from school where rollno = ? ");
		p.setString(1, bean.getRollno());
		ResultSet rs = (ResultSet) p.executeQuery();
		while (rs.next()) {

			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4)
					+ "\t" + rs.getInt(5) + "\t" + rs.getInt(6) + "\t" + rs.getInt(7));
		}
		c.close();
		p.close();

	}

	public void meritlist(MarksheetBean bean) throws Exception {
		ResourceBundle rb = ResourceBundle.getBundle("com.rays.marksheet.app");
		Class.forName(rb.getString("driver"));
		Connection c = DriverManager.getConnection(rb.getString("url"),rb.getString("user"),rb.getString("pwd"));

		PreparedStatement p = c.prepareStatement(
				" select *,(phy+che+math) as total, (((phy+che+math)/300)*100) as percentage from school where ((phy+che+math)/300*100) >= 40 order by percentage desc limit 0,10");

		ResultSet rs = (ResultSet) p.executeQuery();
		while (rs.next()) {

			 System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+
			 rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getInt(5)+"\t"+rs.getInt(6)+"\t"+rs.getInt(7)+"\t"+rs.getInt(8)+"\t"+rs.getInt(9));

		}
		c.close();
		p.close();

	}

	public void select(MarksheetBean bean) throws Exception {
		ResourceBundle rb = ResourceBundle.getBundle("com.rays.marksheet.app");
		Class.forName(rb.getString("driver"));
		Connection c = DriverManager.getConnection(rb.getString("url"),rb.getString("user"),rb.getString("pwd"));

		PreparedStatement p = c.prepareStatement("select * from school ");

		ResultSet rs = p.executeQuery();
		while (rs.next())

			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " "+
			 rs.getString(3) + " " + rs.getString(4) + " " + rs.getInt(5) + " " +
			 rs.getInt(6) + " "+ rs.getInt(7));

			c.close();
		p.close();

	}

	public void delete(MarksheetBean bean) throws Exception {
		ResourceBundle rb = ResourceBundle.getBundle("com.rays.marksheet.app");
		Class.forName(rb.getString("driver"));
		Connection c = DriverManager.getConnection(rb.getString("url"),rb.getString("user"),rb.getString("pwd"));

		c.setAutoCommit(false);

		PreparedStatement p = c.prepareStatement("delete from school where id = ?");

		p.setInt(1, bean.getId());

		p.executeUpdate();
		c.commit();
		p.close();
		c.close();
		System.out.println("deleted");

	}

	public void update(MarksheetBean bean) throws Exception {
		ResourceBundle rb = ResourceBundle.getBundle("com.rays.marksheet.app");
		Class.forName(rb.getString("driver"));
		Connection c = DriverManager.getConnection(rb.getString("url"),rb.getString("user"),rb.getString("pwd"));


		c.setAutoCommit(false);

		PreparedStatement p = c.prepareStatement("update school set firstname = ? , lastname = ? where id = ? ");
		p.setString(1, bean.getFirstname());
		p.setString(2, bean.getLastname());
		p.setInt(3, bean.getId());
		p.executeUpdate();
		c.commit();
		p.close();
		c.close();
		System.out.println("updated succesfully");

	}

	public void add(MarksheetBean bean) throws Exception {
		ResourceBundle rb = ResourceBundle.getBundle("com.rays.marksheet.app");
		Class.forName(rb.getString("driver"));
		Connection c = DriverManager.getConnection(rb.getString("url"),rb.getString("user"),rb.getString("pwd"));


		c.setAutoCommit(false);

		PreparedStatement p = c.prepareStatement("insert into school values(?,?,?,?,?,?,?)");

		p.setInt(1, bean.getId());
		p.setString(2, bean.getRollno());
		p.setString(3, bean.getFirstname());

		p.setString(4, bean.getLastname());
		p.setInt(5, bean.getPhy());
		p.setInt(6, bean.getChe());
		p.setInt(7, bean.getMath());

		p.executeUpdate();

		c.commit();
		p.close();
		c.close();
	   System.out.println("inserted");
	}
}
