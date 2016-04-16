package com.spring.dao;

import java.util.List;
import com.spring.bean.User;
//����UserDAO�ӿ�
public interface UserDAO {
	//����id�����û�
	public User findUserById(int id);
	//��ѯ�����û�
	public List<User> findUsers();
	//����idɾ���û�
	public int delUserById(int id);
	//����û�
	public int addUser(User user);
	//�����û�
	public int updateUser(User user);	
}
