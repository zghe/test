package com.guo.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserDao implements BaseDao {

	public List<Object> queryAll() {
		return null;
	}

	/**
	 * hzg
	 */
	public UserBean queryById(String id) {
		UserBean bean = new UserBean();
		Connection conn = ConnectionManager.getConnctionManager();
		java.sql.PreparedStatement ps = null;
		java.sql.ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from user where id = "+id);
			rs = ps.executeQuery();
			while(rs.next()){
				bean.setId(rs.getString("id"));
				bean.setUsername("username");
				bean.setPassword("password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}

	public String insert(Object parameterObject) {
		return null;
	}

	public String update(String id) {
		return null;
	}

	public String delete(String id) {
		return null;
	}

	
}
