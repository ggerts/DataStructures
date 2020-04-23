//Gregory Gertsen 

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {
    public static int count;

    public static void main(String[] args) {

        //testGenome();
        //testPopulation();
        long startTime = System.nanoTime();
        Population p = new Population(100, .05);
        while (p.mostFit.fitness() != 0) {
            p.day();
            count++;
            System.out.println("Static Day: " + count);
            System.out.println("Day: " + p.dayCount);

            System.out.println("Most fit genome: " + p.mostFit.toString());
            System.out.println("");


        }
        long endTime = System.nanoTime();
        long durationInNano = (endTime - startTime);
        long durationInMillis = TimeUnit.NANOSECONDS.toMillis(durationInNano);

        System.out.println("");
        System.out.println("Complete genome: " + p.populationList);
        System.out.println("");
        System.out.println("Running time: " + durationInMillis + " Milliseconds");
    }

    static void testGenome() {
        Genome g = new Genome(.10);
        Genome h = new Genome(.75);

        for (int i = 0; i < 20; i++) {
            g.mutate();
            h.mutate();
        }

        System.out.println("After 20 mutations: " + g.toString());
        System.out.println("After 20 mutations: " + h.toString());

        for (int i = 0; i < 5; i++) {
            g.crossover(h);
            h.crossover(g);
        }


        System.out.println("After 2 crossovers: " + g.toString());
        System.out.println("After 2 crossovers: " + h.toString());



    }

    static void testPopulation() {
        Population p = new Population(20, .75);

        System.out.println("Most fit: " + p.mostFit);
        for (int i = 0; i < 20; i++) {
            p.day();
            System.out.println("Most fit: " + p.mostFit);
        }

        System.out.println(p.populationList);
        System.out.println("Most fit: " + p.mostFit);


    }

}
