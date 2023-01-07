package com.src;

import com.func.IRechnen;

import java.util.List;

public class Multiplizieren implements IRechnen {
    private double sum=1;
    @Override
    public double calculate(List<Double> numbers) {

        for(int i=0; i<numbers.size(); i++){
            sum = numbers.get(i) * sum;
        }
        return sum;

    }
}
