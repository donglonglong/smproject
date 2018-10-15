package com.imooc.smpro.bean;

/**
 * Staff 数据传输类
 * @author xlei @qq 251425887 @tel 13352818008
 * @Email dlei0009@163.com
 * @date 2018-10-10 11:32:29
 * @version 1.0
 */
public class Staff implements java.io.Serializable{

    private static final long serialVersionUID = 1L;
    private int id;
    private String username;
    private String password;
    private String state;
    private int departmentNo;
    private String employeeName;
    private String sex;
    private String idCard;
    private java.util.Date workTime;
    private java.util.Date leaveTime;
    private java.util.Date bornTime;
    private String remark;
    private Department department;


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    /** setter and getter method */

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return this.username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }
    public void setState(String state){
        this.state = state;
    }
    public String getState(){
        return this.state;
    }
    public void setDepartmentNo(int departmentNo){
        this.departmentNo = departmentNo;
    }
    public int getDepartmentNo(){
        return this.departmentNo;
    }
    public void setEmployeeName(String employeeName){
        this.employeeName = employeeName;
    }
    public String getEmployeeName(){
        return this.employeeName;
    }
    public void setSex(String sex){
        this.sex = sex;
    }
    public String getSex(){
        return this.sex;
    }
    public void setIdCard(String idCard){
        this.idCard = idCard;
    }
    public String getIdCard(){
        return this.idCard;
    }
    public void setWorkTime(java.util.Date workTime){
        this.workTime = workTime;
    }
    public java.util.Date getWorkTime(){
        return this.workTime;
    }
    public void setLeaveTime(java.util.Date leaveTime){
        this.leaveTime = leaveTime;
    }
    public java.util.Date getLeaveTime(){
        return this.leaveTime;
    }
    public void setBornTime(java.util.Date bornTime){
        this.bornTime = bornTime;
    }
    public java.util.Date getBornTime(){
        return this.bornTime;
    }
    public void setRemark(String remark){
        this.remark = remark;
    }
    public String getRemark(){
        return this.remark;
    }

}