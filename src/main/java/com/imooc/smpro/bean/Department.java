package com.imooc.smpro.bean;

/**
 * Department 数据传输类
 * @author xlei @qq 251425887 @tel 13352818008
 * @Email dlei0009@163.com
 * @date 2018-10-10 11:32:29
 * @version 1.0
 */
public class Department implements java.io.Serializable{

    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String address;

    /** setter and getter method */
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return this.address;
    }

}