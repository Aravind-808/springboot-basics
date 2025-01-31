/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.corent.springboot_proj;

/**
 *
 * @author shrisaiaravind
 */
public class student {
    private int rollNo, age, standard;
    private String name, section;
    
    public int getRollNo(){
        return rollNo;
    }
    public void setRollNo(int rollNo){
        this.rollNo = rollNo;
    }
    
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    
    public int getStandard(){
        return standard;
    }
    public void setStandard(int standard){
        this.standard = standard;
    }
    
    public String getSection(){
        return section;
    }
    public void setSection(String section){
        this.section = section;
    }
    
    public String getName() {
        return name;
    }
    
    public student(){
        
    }
    
    public student(int rollNo, int age, int standard, String name, String section){
        this.rollNo = rollNo;
        this.age = age;
        this.standard = standard;
        this.section = section;
        this.name = name;
    }
}
