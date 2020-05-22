package hw10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestCalculator {
    @Test
    public void TestThat3Plus3Is6(){
       if(Calculator.sum(3, 3) != 6)
            throw new Error();
        Assertions.assertEquals(6, Calculator.sum(3, 3));
    }

    @Test
    public void TestThat40Minus31Is9(){
        if(Calculator.minus(40, 31) != 9)
        Assertions.assertEquals(9, Calculator.minus(40, 31));

    }

    @Test
    public void TestThat2MultiplyBy8Is16(){
       if(Calculator.multiply(2, 8) != 16)
        Assertions.assertEquals(16, Calculator.multiply(2, 8));
    }

    @Test
    public void TestThat400DivideBy2Is200(){
        if(Calculator.divide(400, 2) != 200)
        Assertions.assertEquals(200, Calculator.divide(400, 2));
    }

}
