package com.spring.bean;

public class User {
	//����User�������
private int id;  						//user���е�����id
private String username; 					//�û���
private String password; 					//����
private String address; 					//��ַ
private String phoneNum; 				//�绰����
 // id���Ե�getter��setter����
public long getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
 // username���Ե�getter��setter����
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
 // password���Ե�getter��setter����
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
 // address���Ե�getter��setter����
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
 // phoneNum���Ե�getter��setter����
public String getPhoneNum() {
	return phoneNum;
}
public void setPhoneNum(String phoneNum) {
	this.phoneNum = phoneNum;
}
}
