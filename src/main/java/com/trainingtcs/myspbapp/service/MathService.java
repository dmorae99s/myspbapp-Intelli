package com.trainingtcs.myspbapp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class MathService {
    public String fibonacci(int n){

        //fibonacci copied,
        String result = Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .map(String::valueOf).
                reduce("Fibonacci: ",(a,b)-> a+"+"+"b");
result = "TODO: this functionality is not working";
        return result;
    }

    public Map<String,Long> countLetters(String text){
        Map<String, Long> result =
                text.codePoints().mapToObj(Character::toString).collect(Collectors.
                        groupingBy(Function.identity(), Collectors.counting()));

        return result;
    }

    public String factorial(int n){
        if(n > 20) return "Sorry, value tooooooooo hiogh!!!!!!!";

        String result = "Factorial of " + n + " is ";

        LongStream workingStream = LongStream.rangeClosed(1L, n);

        //return the factorial as a text, perhaps is posible doing it with only one stream
        Stream workingStream2 = Stream.iterate(n -1,i-> i>=1,i -> i -1 );
        result = result + String.valueOf(workingStream.reduce((a,b) -> a * b).getAsLong() );
        result = result + " = (" + n + ") ";
        result = result + workingStream2.map(String::valueOf).reduce(" ",(a, b) -> a +"x"+ b);
        return result;
    }


}
