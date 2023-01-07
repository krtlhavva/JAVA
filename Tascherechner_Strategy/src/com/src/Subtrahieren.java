package com.src;

import com.func.IRechnen;

import java.util.List;

public class Subtrahieren implements IRechnen {
    private double sum;
    @Override
    public double calculate(List<Double> numbers) {
        this.sum=numbers.get(0);
        for(int i=1; i<numbers.size(); i++){
            sum = sum - numbers.get(i);
        }
        return sum;

    }
}
