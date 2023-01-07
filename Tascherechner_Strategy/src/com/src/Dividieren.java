package com.src;

import com.func.IRechnen;

import java.util.List;

public class Dividieren implements IRechnen {
    private double sum;
    @Override
    public double calculate(List<Double> numbers) {
        this.sum=numbers.get(0);
        for(int i=1; i<numbers.size(); i++){
            if(numbers.get(i)==0){
                System.out.println("Eine Division durch 0 ist nicht möglich");
               return this.sum;     
            }
            sum = sum/numbers.get(i);
        }
        return sum;
    }
}
