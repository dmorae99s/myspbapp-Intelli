package com.trainingtcs.myspbapp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.LongStream;

@Service
@AllArgsConstructor
public class MathService {
    public String fibonacci(int n){
        return String.valueOf(LongStream.rangeClosed(1, n).reduce(1,(a,b) -> a + b));

    }
    public String fibonacciSequence(int n){
        return String.valueOf(LongStream.rangeClosed(1, n).reduce(1,(a,b) -> a + b));
    }

    public String factorial(int n){
        return String.valueOf( LongStream.rangeClosed(1, n).reduce(1, (a, b) -> a * b) );
    }


}
