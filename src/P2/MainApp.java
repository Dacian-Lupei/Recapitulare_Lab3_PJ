package P2;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class MainApp {
    public static void main(String[] args){
        try {
            List<Produs> produse = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);
            BufferedReader reader = new BufferedReader(new FileReader("produse.csv"));

            String line;
            while ((line = reader.readLine()) != null) {
                //line = reader.readLine(); //daca pun asta citeste din 2 in 2 linii
                String[] elemente = line.split(",");
                if (elemente.length == 4) {
                    String nume = elemente[0];
                    float pret = Float.parseFloat(elemente[1]);
                    int cantitate = Integer.parseInt(elemente[2]);
                    LocalDate data_expirarii = LocalDate.parse(elemente[3]);

                    Produs pr = new Produs(nume, pret, cantitate, data_expirarii);
                    produse.add(pr);
                }
            }
            int opt;
            do {
                System.out.println("------------------------------------------------------");
                System.out.println("1). afisarea tuturor produselor din colectia List");
                System.out.println("2). afisarea produselor expirate");
                System.out.println("3). vanzarea unui produs(daca cantitate 0 atunci se sterge produsul din lista)");
                System.out.println("4). afisarea produselor cu pretul minim");
                System.out.println("5). salvarea produselor care au o cantitate mai mica decat un numar introdus de la tastatura intr-un fisier de iesire");
                System.out.println("------------------------------------------------------");

                System.out.print("Introduceti optiunea dorita: ");
                opt = scanner.nextInt();

                switch (opt) {
                    case 1:
                        for(Produs p: produse){
                            System.out.println(p);
                        }
                        break;
                    case 2:
                        LocalDate currentDate = LocalDate.now();
                        for(Produs p: produse){
                            if(p.getData_expirarii().isBefore(currentDate)){
                                System.out.println(p);
                            }
                        }
                        break;
                    case 3:
                        Scanner scanner2 = new Scanner(System.in);
                        System.out.print("Introduceti denumirea produsului pe care doriti sa il vinteti: ");
                        String denumire = scanner2.nextLine();
                        for(Produs p : produse){
                            if(p.getNume().equals(denumire)){
                                System.out.print("Introduceti cantitatea pe care doriti sa o vindeti: ");
                                int cantitate = scanner2.nextInt();
                                if(cantitate <= p.getCantitate()){
                                    double incasare = cantitate * p.getPret();
                                    p.setCantitate(p.getCantitate() - cantitate);
                                    Produs.incasare += incasare;
                                    System.out.println("Vanzare realizata. Incasare: " + incasare);
                                    if(p.getCantitate() == 0){
                                        produse.remove(p);
                                    }
                                }else {
                                    System.out.println("Cantitate insuficienta pe stoc!!!");
                                }
                            }
                        }
                        break;
                    case 4:
                        float Pret_Minim = Float.MAX_VALUE;
                        for(Produs p: produse){
                            if(p.getPret() < Pret_Minim)
                                Pret_Minim = p.getPret();
                        }
                        for(Produs p: produse){
                            if(p.getPret() == Pret_Minim)
                                System.out.println(p);
                        }
                        break;
                    case 5:
                        try{
                            BufferedWriter writer = new BufferedWriter(new FileWriter("out.txt"));
                            Scanner scanner1 = new Scanner(System.in);
                            System.out.print("Introduceti cantitatea reper: ");
                            int reper_cantitate = scanner1.nextInt();
                            for(Produs p: produse){
                                if(p.getCantitate() < reper_cantitate){
                                    writer.write(p.toString());
                                    writer.newLine();
                                }
                            }
                            System.out.println("Datele s-au salvat cu success in fisier!!!");
                            writer.close();
                        }catch(IOException e){
                            System.err.println("Fisierul e gol!!!" + e.getMessage());
                        }
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + opt);
                }
            } while (true);
        }catch(IOException e){
            System.err.println("Fisier gol " + e.getMessage());
        }
    }
}
