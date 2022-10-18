package teste;

import java.util.ArrayList;
import java.util.List;

public class TesteLambda {

    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);
        numeros.add(6);


        numeros.forEach((x)->{ //lambda Expression
            if(x<4){  //() , entrada de valor, ->{} (saida)
                System.out.println(x);
            }
        });

    }

}
