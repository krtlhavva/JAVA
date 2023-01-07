package com.src;

import com.func.IRechnen;

import java.util.List;

public class Calculator {
    private List<Double> numbers;
    private String operant;
    private IRechnen rechnen;
    public Calculator(List<Double> numbers, String operant){
       this.numbers=numbers;
       this.operant=operant;
    }

    public double cal(){
        switch (operant){
            case "+":
               this.rechnen=new Add(); break;
            case "-":
                this.rechnen= new Subtrahieren(); break;
            case "*":
                this.rechnen=new Multiplizieren(); break;
            case "/":
                this.rechnen=new Dividieren(); break;
        }
         return this.rechnen.calculate(numbers);
    }
}
