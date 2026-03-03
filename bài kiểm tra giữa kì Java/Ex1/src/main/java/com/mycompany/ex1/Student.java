package com.mycompany.Ex1;
public class Student {
   private String id;
   private String name;
   private double gpa;
   
   public Student(String id, String name, double gpa){
   this.id = id;
   this.name = name;
   this.gpa = gpa;
  
   }
   
   public String getId() {return id;}
   public void setId(String id) {this.id = id;}
   
   public String getname() {return name;}
   public void setname(String name) {this.name = name;}
   
   public double getgpa() {return gpa;}
   public void setgpa(double gpa) {this.gpa = gpa;}
   
   @Override
   public String toString(){
       return "Student[ID=" + id +", Name=" + name +", GPA=" + gpa + "]";
       
   }
   
}           

