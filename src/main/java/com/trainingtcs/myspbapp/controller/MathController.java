package com.trainingtcs.myspbapp.controller;
import com.trainingtcs.myspbapp.service.MathService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@AllArgsConstructor
@RestController
public class MathController {
    private final MathService mathService;

    //get factorial using int in path
    @GetMapping("/factorial/{num}")
    private ResponseEntity<String> getFactorial(@PathVariable("num") int num){
        String fatorized = mathService.factorial(num);
        return ResponseEntity.status(HttpStatus.OK).body(fatorized);
    }

    //get ffibonacci using int in path
    @GetMapping("/fibonacci/{num}")
    private ResponseEntity<String> getFibonacci(@PathVariable("num") int num){
        String fibonized = mathService.fibonacci(num);
        return ResponseEntity.status(HttpStatus.OK).body(fibonized);
    }


    @GetMapping("/letters/{str}")
    private ResponseEntity<String> getCountLetters(@PathVariable("str") String str){
        Map<String,Long> counter = mathService.countLetters(str);
        return ResponseEntity.status(HttpStatus.OK).body(counter.toString());
    }
}
