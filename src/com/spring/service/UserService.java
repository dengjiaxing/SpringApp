package com.spring.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import com.spring.bean.User;
import com.spring.dao.UserDAO;
//创建UserService类实现UserDAO接口
public class UserService implements UserDAO {
	private JdbcTemplate jdbcTemplate;
     //实现添加用户的方法
	public int addUser(User user) {
		String sql = "insert into user (username, password, phoneNum, address) values (?, ?, ?, ?)";										//SQL语句
	    Object[] params = new Object[] {user.getUsername(), user.getPassword(), user.getPhoneNum(), user.getAddress()};						//存放SQL语句中的参数
int flag = jdbcTemplate.update(sql,params);			//调用jdbcTemplate的update方法
		return flag;
	}
     //实现删除用户的方法
	public int delUserById(int id) {
		String sql = "delete from user where id = ?";			//SQL语句
Object[] params = new Object[] {id};					//存放SQL语句中的参数
int flag = jdbcTemplate.update(sql,params);			//调用jdbcTemplate的update方法
		return flag;
	}
     //实现根据id查询用户的方法
	public User findUserById(int id) {
		  String sql = "select * from user where id = ?";			//SQL语句
	       final User user = new User();
	       final Object[] params = new Object[] {id};			//存放SQL语句中的参数
	       // 调用jdbcTemplate的query方法
	       jdbcTemplate.query(sql,params, new RowCallbackHandler(){
	                         public void processRow(ResultSet rs) throws SQLException {
							 //向user对象中添加各个属性值
	                        	 user.setId(rs.getInt("id"));
	                        	 user.setUsername(rs.getString("username"));
	                        	 user.setPassword(rs.getString("password"));
	                        	 user.setAddress(rs.getString("address"));
	      
	                        	 user.setPhoneNum(rs.getString("phoneNum"));
	                        	
	                         }
	       });
		return user;
	}
	//实现获取所有用户的方法
	public List<User> findUsers() {
		String sql = "select * from user";					//SQL语句
		List list = jdbcTemplate.queryForList(sql);				//调用jdbcTemplate的queryForList方法
		return list;
	}
     //实现更新用户的方法
	public int updateUser(User user) {
		String sql = "update user set username = ?, password = ?, phoneNum = ?, address  = ? where id = ?";										//SQL语句
//存放SQL语句中的参数
	     Object[] params = new Object[] {user.getUsername(), user.getPassword(),  user.getPhoneNum(), user.getAddress(), user.getId()};
int flag = jdbcTemplate.update(sql,params);			//调用jdbcTemplate的update方法
		return flag;
	}
     //定义JdbcTemplate的getter和setter方法
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
