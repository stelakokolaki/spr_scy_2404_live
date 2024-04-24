package gr.codehub.s101.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class MultiplicationController {

    @GetMapping(value="multiply/{a}/by/{b}")
    public String multiply(@PathVariable(value="b") String num1, @PathVariable(value="a") String num2) {
        BigInteger a = new BigInteger(num1);
        BigInteger b = new BigInteger(num2);
        return a.multiply(b).toString();
    }

    @GetMapping("calc")
    public String calculate(@RequestParam(value = "op", defaultValue = "multiply") String operation, @RequestParam int num1, @RequestParam int num2){
        if (!operation.equals("multiply")) {
            return "Cannot perform this operation!";
        }
        return "" + (num1 * num2);
    }

}
