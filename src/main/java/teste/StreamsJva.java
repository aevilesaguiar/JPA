package teste;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsJva {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1,30,20,36,369,70);

        List<Integer> resultado = numeros.stream()
                .filter(n->n==100)
                .collect(Collectors.toList());

        resultado.forEach(n-> System.out.println(n));

    }
}
