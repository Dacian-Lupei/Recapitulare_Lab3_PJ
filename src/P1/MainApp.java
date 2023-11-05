package P1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        List<Parabola> parabole = new ArrayList<>();
        try{
            Scanner scanner = new Scanner(new File("in.txt"));
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] coeficienti = line.split(" ");
                if(coeficienti.length == 3){
                    int a = Integer.parseInt(coeficienti[0]);
                    int b = Integer.parseInt(coeficienti[1]);
                    int c = Integer.parseInt(coeficienti[2]);
                    Parabola pa = new Parabola(a,b,c);
                    parabole.add(pa);
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        for(Parabola p : parabole){
            System.out.println(p.toString());
        }

        if(parabole.size() >= 2){
            Parabola p1 = parabole.get(0);
            Parabola p2 = parabole.get(1);

            System.out.println(p1.metoda1(p2));
            System.out.println(Parabola.metoda2(p1,p2));
            System.out.println(p1.metoda3(p2));
            System.out.println(Parabola.metoda4(p1,p2));
        }
    }
}
