package com.src;

import com.func.IRechnen;

import java.util.List;

public class Add implements IRechnen {

    private double sum=0;
    @Override
    public double calculate(List<Double> numbers) {
        for (Double number : numbers) {
            sum = number + sum;
        }
        return sum;
    }
}
