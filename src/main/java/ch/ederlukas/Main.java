package ch.ederlukas;

import ch.ederlukas.lambdas.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.TreeSet;

import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args) {
        SpeakLambda speak = (n) -> n;
        System.out.println(sayName(speak, "Lukas"));

        CalculationLambda<Double> squareFunc = (number) -> pow(number, 2);
        Calculation<Double> c = new Calculation<>();
        System.out.println("Square of 5.5 is: " + c.calcSquare(squareFunc, 5.5));

        // Self-built Collection lambda manipulation
        HashSet<String> letters = new HashSet<>(Arrays.asList("Z", "Z", "E", "D", "C", "B", "A"));
        ManipulateCollectionLambda<String, HashSet<String>, TreeSet<String>> manipulation = (l) -> l.stream()
                .sorted().collect(Collectors.toCollection(TreeSet::new));
        Manipulator<String, HashSet<String>, TreeSet<String>> m = new Manipulator<>(letters);
        m.manipulate(manipulation, letters);
        System.out.println(m);
    }

    public static String sayName(SpeakLambda sl, String name) {
        return sl.speak("Hello, " + name);
    }


}