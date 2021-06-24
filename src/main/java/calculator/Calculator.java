package calculator;

import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class Calculator {

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> suma = (a,b) -> a+b;
        BiFunction<Integer, Integer, Integer> resta = (a,b) -> a-b;

        BiFunction<Integer, Integer, Integer> multiplicac = (a,b) -> IntStream.range(0, b+1)
                .reduce((acumulador, numero) -> {
                   return suma.apply(acumulador, a);
                }).getAsInt();

        BiFunction<Integer, Integer, Integer> divis = (a,b) -> IntStream.range(0,a)
                .reduce((acumulador, numero) ->
                        multiplicac.apply(numero,b)<=a?suma.apply(acumulador,1):acumulador).getAsInt();

        System.out.println(suma.apply(5,2));
        System.out.println(resta.apply(5,2));
        System.out.println(multiplicac.apply(5,2));
        System.out.println(divis.apply(5,2));
    }
}