package complexCalculation;

import java.math.BigInteger;

public class AppComplex {
    public static void main(String[] args) {
        ComplexCalculation c = new ComplexCalculation();
        BigInteger r = c.calculateResult(new BigInteger("10"), new BigInteger("2"), new BigInteger("11"), new BigInteger("3"));
        System.out.println(r.toString());
    }
}
