package com.mycompany.Ex1;

import java.util.ArrayList;
import java.util.List;

public class StudentManager<T> {
    private List<T> data = new ArrayList<>();
    
    public void add(T item){
        data.add(item);    
    }
    
    public List<T> getAll(){
        return data;
    }
}

