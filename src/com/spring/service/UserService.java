package com.spring.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import com.spring.bean.User;
import com.spring.dao.UserDAO;
//����UserService��ʵ��UserDAO�ӿ�
public class UserService implements UserDAO {
	private JdbcTemplate jdbcTemplate;
     //ʵ������û��ķ���
	public int addUser(User user) {
		String sql = "insert into user (username, password, phoneNum, address) values (?, ?, ?, ?)";										//SQL���
	    Object[] params = new Object[] {user.getUsername(), user.getPassword(), user.getPhoneNum(), user.getAddress()};						//���SQL����еĲ���
int flag = jdbcTemplate.update(sql,params);			//����jdbcTemplate��update����
		return flag;
	}
     //ʵ��ɾ���û��ķ���
	public int delUserById(int id) {
		String sql = "delete from user where id = ?";			//SQL���
Object[] params = new Object[] {id};					//���SQL����еĲ���
int flag = jdbcTemplate.update(sql,params);			//����jdbcTemplate��update����
		return flag;
	}
     //ʵ�ָ���id��ѯ�û��ķ���
	public User findUserById(int id) {
		  String sql = "select * from user where id = ?";			//SQL���
	       final User user = new User();
	       final Object[] params = new Object[] {id};			//���SQL����еĲ���
	       // ����jdbcTemplate��query����
	       jdbcTemplate.query(sql,params, new RowCallbackHandler(){
	                         public void processRow(ResultSet rs) throws SQLException {
							 //��user��������Ӹ�������ֵ
	                        	 user.setId(rs.getInt("id"));
	                        	 user.setUsername(rs.getString("username"));
	                        	 user.setPassword(rs.getString("password"));
	                        	 user.setAddress(rs.getString("address"));
	      
	                        	 user.setPhoneNum(rs.getString("phoneNum"));
	                        	
	                         }
	       });
		return user;
	}
	//ʵ�ֻ�ȡ�����û��ķ���
	public List<User> findUsers() {
		String sql = "select * from user";					//SQL���
		List list = jdbcTemplate.queryForList(sql);				//����jdbcTemplate��queryForList����
		return list;
	}
     //ʵ�ָ����û��ķ���
	public int updateUser(User user) {
		String sql = "update user set username = ?, password = ?, phoneNum = ?, address  = ? where id = ?";										//SQL���
//���SQL����еĲ���
	     Object[] params = new Object[] {user.getUsername(), user.getPassword(),  user.getPhoneNum(), user.getAddress(), user.getId()};
int flag = jdbcTemplate.update(sql,params);			//����jdbcTemplate��update����
		return flag;
	}
     //����JdbcTemplate��getter��setter����
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
