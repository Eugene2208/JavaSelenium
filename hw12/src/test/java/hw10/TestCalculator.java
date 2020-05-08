package hw10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestCalculator {
    @Test
    public void test_that_3_plus_3_is_6(){
       if(Calculator.sum(3, 3) != 6)
            throw new Error();

        Assertions.assertEquals(6, Calculator.sum(3, 3));
    }

    @Test
    public void test_that_40_minus_31_is_9(){
        if(Calculator.minus(40, 31) != 9)
            throw new Error();

        Assertions.assertEquals(9, Calculator.minus(40, 31));

    }

    @Test
    public void test_that_2_multiply_by_8_is_16(){
       if(Calculator.multiply(2, 8) != 16)
            throw new Error();

        Assertions.assertEquals(16, Calculator.multiply(2, 8));
    }

    @Test
    public void test_that_400_divide_by_2_is_200(){
        if(Calculator.divide(400, 2) != 200)
            throw new Error();

        Assertions.assertEquals(200, Calculator.divide(400, 2));
    }

    @Test
    public void test_that_4_minus_4_is_not_2(){
        if(Calculator.minus(4, 4) == 2)
            throw new Error();

        Assertions.assertNotEquals(2, Calculator.minus(4, 4));
    }
}
