package com.mycompany.Ex1;
public class main {
    public static void main(String[] args){
        
    StudentManager<Student> manager = new StudentManager<>();

    manager.add(new Student("S001","Nguyễn Kiều Tuấn Anh",5.0));
    manager.add(new Student("S002","Trịnh Chí Quang",5.1));
    manager.add(new Student("S003","Trần Văn Việt",5.2));
    
    System.out.println("--- Danh sách sinh viên ---");
    for(Student s: manager.getAll()){
        System.out.println(s);
    }    
  }
}
