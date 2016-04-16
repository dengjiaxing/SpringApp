package com.spring.test;

import java.util.List;
import junit.framework.TestCase;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.bean.User;
import com.spring.service.UserService;
//测试用例
public class UserServiceTest extends TestCase {
	//测试添加用户的方法
	public void testAdd() throws Exception {
		//创建Spring容器
		ClassPathXmlApplicationContext ctx = 
new ClassPathXmlApplicationContext("ApplicationContext.xml");
		//获取userService实例
		UserService service = (UserService)ctx.getBean("userService");
		User user = new User();
		//向user对象中添加属性值
		user.setUsername("Bob");
		user.setPassword("123456");
		user.setPhoneNum("23552233");
		user.setAddress("天津");
		int flag = service.addUser(user);					//调用addUser方法
		System.out.println(flag);
		ctx.destroy();									//关闭Spring容器
	}
	//测试更新用户的方法
	public void testUpdate() throws Exception {
		//创建Spring容器
		ClassPathXmlApplicationContext ctx = 
new ClassPathXmlApplicationContext("ApplicationContext.xml");
		//获取userService实例
		UserService service = (UserService)ctx.getBean("userService");
		User user = service.findUserById(2);					//调用findUserById方法
		user.setUsername("Tom");
		int flag = service.updateUser(user);					//调用updateUser方法
		System.out.println("更新的记录数" + flag);
		User user1 = service.findUserById(1);
		System.out.println(user1.getUsername());
		ctx.destroy();									//关闭Spring容器
	}
	//测试删除用户的方法
	public void testDelete() throws Exception {
		//创建Spring容器
		ClassPathXmlApplicationContext ctx = 
new ClassPathXmlApplicationContext("ApplicationContext.xml");
		//获取userService实例
		UserService service = (UserService)ctx.getBean("userService");
		int flag = service.delUserById(2);					//调用delUserById方法
		System.out.println(flag);
		ctx.destroy();									//关闭Spring容器
	}
	//测试查找用户的方法
	public void testFindUsers() throws Exception {
		//创建Spring容器
		ClassPathXmlApplicationContext ctx = 
new ClassPathXmlApplicationContext("ApplicationContext.xml");
		//获取userService实例
		UserService service = (UserService)ctx.getBean("userService");
		List<User> list = service.findUsers();					//调用findUsers方法
		System.out.println("用户数:" + list.size());
		ctx.destroy();									//关闭Spring容器
	}	
}
