import ch.ederlukas.lambdas.Calculation;
import ch.ederlukas.lambdas.CalculationLambda;
import ch.ederlukas.lambdas.ManipulateCollectionLambda;
import ch.ederlukas.lambdas.Manipulator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static ch.ederlukas.Main.sayName;
import static java.lang.Math.pow;
import static org.junit.jupiter.api.Assertions.*;

public class GeneralTests {

    private static HashSet<String> hashSet;
    private static TreeSet<String> treeSetResult;
    private static ManipulateCollectionLambda<String, HashSet<String>, TreeSet<String>> manipulation;
    private static Manipulator<String, HashSet<String>, TreeSet<String>> m;

    @BeforeAll
    public static void setUp() {
        hashSet = new HashSet<>(Arrays.asList("Z", "Z", "E", "D", "C", "B", "A"));
        treeSetResult = new TreeSet<>(Arrays.asList("A", "B", "C", "D", "E", "Z"));
        manipulation = (l) -> l.stream()
                .sorted().collect(Collectors.toCollection(TreeSet::new));
        m = new Manipulator<>(hashSet);
    }

    @Test
    @DisplayName("hello-lukas-test")
    void helloLukasTest() {
        String testString = "Hello, Lukas";
        assertEquals(sayName((n) -> n, "Lukas"), testString);
    }

    @Test
    @DisplayName("calc-amount-lambda-test")
    void calcAmountLambdaTest() {
        double testResult = 30.25;
        double testBase = 5.5;
        CalculationLambda<Double> squareFunc = (number) -> pow(number, 2);
        Calculation<Double> c = new Calculation<>();
        assertTrue(c.calcSquare(squareFunc, testBase) == testResult);
    }

    @Test
    @DisplayName("treeSet-comparison-test")
    void treeSetComparisonTest() {
        m.manipulate(manipulation, hashSet);
        assertEquals(m.getResult(), treeSetResult);
    }

    @Test
    @DisplayName("TreeSet-NotEqual-HashSet-test")
    void treeSetNotEqualHashSetTest() {
        m.manipulate(manipulation, hashSet);
        assertNotEquals(m.getResult().getClass(), hashSet.getClass());
    }
}
