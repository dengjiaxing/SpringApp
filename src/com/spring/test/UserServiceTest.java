package com.spring.test;

import java.util.List;
import junit.framework.TestCase;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.bean.User;
import com.spring.service.UserService;
//��������
public class UserServiceTest extends TestCase {
	//��������û��ķ���
	public void testAdd() throws Exception {
		//����Spring����
		ClassPathXmlApplicationContext ctx = 
new ClassPathXmlApplicationContext("ApplicationContext.xml");
		//��ȡuserServiceʵ��
		UserService service = (UserService)ctx.getBean("userService");
		User user = new User();
		//��user�������������ֵ
		user.setUsername("Bob");
		user.setPassword("123456");
		user.setPhoneNum("23552233");
		user.setAddress("���");
		int flag = service.addUser(user);					//����addUser����
		System.out.println(flag);
		ctx.destroy();									//�ر�Spring����
	}
	//���Ը����û��ķ���
	public void testUpdate() throws Exception {
		//����Spring����
		ClassPathXmlApplicationContext ctx = 
new ClassPathXmlApplicationContext("ApplicationContext.xml");
		//��ȡuserServiceʵ��
		UserService service = (UserService)ctx.getBean("userService");
		User user = service.findUserById(2);					//����findUserById����
		user.setUsername("Tom");
		int flag = service.updateUser(user);					//����updateUser����
		System.out.println("���µļ�¼��" + flag);
		User user1 = service.findUserById(1);
		System.out.println(user1.getUsername());
		ctx.destroy();									//�ر�Spring����
	}
	//����ɾ���û��ķ���
	public void testDelete() throws Exception {
		//����Spring����
		ClassPathXmlApplicationContext ctx = 
new ClassPathXmlApplicationContext("ApplicationContext.xml");
		//��ȡuserServiceʵ��
		UserService service = (UserService)ctx.getBean("userService");
		int flag = service.delUserById(2);					//����delUserById����
		System.out.println(flag);
		ctx.destroy();									//�ر�Spring����
	}
	//���Բ����û��ķ���
	public void testFindUsers() throws Exception {
		//����Spring����
		ClassPathXmlApplicationContext ctx = 
new ClassPathXmlApplicationContext("ApplicationContext.xml");
		//��ȡuserServiceʵ��
		UserService service = (UserService)ctx.getBean("userService");
		List<User> list = service.findUsers();					//����findUsers����
		System.out.println("�û���:" + list.size());
		ctx.destroy();									//�ر�Spring����
	}	
}
