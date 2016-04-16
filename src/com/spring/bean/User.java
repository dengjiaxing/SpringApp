package com.spring.bean;

public class User {
	//定义User类的属性
private int id;  						//user表中的主键id
private String username; 					//用户名
private String password; 					//密码
private String address; 					//地址
private String phoneNum; 				//电话号码
 // id属性的getter和setter方法
public long getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
 // username属性的getter和setter方法
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
 // password属性的getter和setter方法
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
 // address属性的getter和setter方法
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
 // phoneNum属性的getter和setter方法
public String getPhoneNum() {
	return phoneNum;
}
public void setPhoneNum(String phoneNum) {
	this.phoneNum = phoneNum;
}
}
