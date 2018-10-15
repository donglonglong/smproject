package com.imooc.smpro.bean;

import java.util.Date;

/**
 * Log 数据传输类
 * @author xlei @qq 251425887 @tel 13352818008
 * @Email dlei0009@163.com
 * @date 2018-10-10 11:32:29
 * @version 1.0
 */
public class Log implements java.io.Serializable{

    private static final long serialVersionUID = 1L;
    private Date oprTime;
    private String type;
    private String operator;
    private String module;
    private String operation;
    private String result;

    public Date getOprTime() {
        return oprTime;
    }

    public void setOprTime(Date oprTime) {
        this.oprTime = oprTime;
    }

    /** setter and getter method */

    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public void setOperator(String operator){
        this.operator = operator;
    }
    public String getOperator(){
        return this.operator;
    }
    public void setModule(String module){
        this.module = module;
    }
    public String getModule(){
        return this.module;
    }
    public void setOperation(String operation){
        this.operation = operation;
    }
    public String getOperation(){
        return this.operation;
    }
    public void setResult(String result){
        this.result = result;
    }
    public String getResult(){
        return this.result;
    }

}