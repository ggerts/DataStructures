// Gregory Gertsen 

import java.util.ArrayList;
import java.util.Random;

public class Genome implements Comparable < Genome > {
    Random randy = new Random();

    String[] dNA = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", " ","-­", "\'" };

    String target = "CHRISTOPHER PAUL MARRIOTT";

    String myString;

    double myMutationRate;


    public Genome(double mutationRate) {

        myString = "A";

        if (mutationRate < 1 && mutationRate > 0) {

            myMutationRate = mutationRate;

        } else {
            System.out.println("Mutation rate out of bounds");
        }

    }

    public Genome(Genome gene) {
        myString = gene.myString;
        myMutationRate = gene.myMutationRate;
    }

    public void mutate() {



        StringBuilder sb = new StringBuilder(myString);

        if (randy.nextDouble() <= myMutationRate) {

            sb.insert(randy.nextInt(myString.length() + 1), dNA[randy.nextInt(dNA.length)]);
            myString = sb.toString();
        }



        if (randy.nextDouble() <= myMutationRate && myString.length() >= 2) {

            sb.deleteCharAt(randy.nextInt(myString.length()));
            myString = sb.toString();

        }


        for (int i = 0; i < sb.length(); i++)

        {
            if (randy.nextDouble() <= myMutationRate) {
                sb.replace(i, i + 1, dNA[randy.nextInt(dNA.length)]);
            }


        }
        myString = sb.toString();




    }


    void crossover(Genome other) {

        StringBuilder sB2 = new StringBuilder();
        int getI;

        if (this.myString.length() >= other.myString.length()) {
            getI = this.myString.length();
        } else {
            getI = other.myString.length();
        }


        for (int i = 0; i < getI; i++) {

            if (randy.nextInt(2) == 0) {
                if (i < this.myString.length()) {
                    sB2.append(this.myString.charAt(i));

                } else {
                    break;
                }

            } else {
                if (i < other.myString.length()) {
                    sB2.append(other.myString.charAt(i));

                } else {
                    break;
                }

            }

        }

        myString = sB2.toString();

    }

    public Integer fitness() {

        int n = myString.length();
        int m = target.length();
        int l = Math.max(n, m);

        Integer f = Math.abs(m - n);


        for (int i = 0; i < l; i++)

        {

            if (i >= this.myString.length() || i >= target.length()) {

                f += 1;
            } else {

                boolean b = this.myString.charAt(i) == target.charAt(i);
                if (!b) {
                    f += 1;
                }
            }
        }

        return f;
    }


    public String toString() {
        return "Genome: " + this.myString + " Fitness: " + this.fitness();
    }


    @Override
    public int compareTo(Genome o) {

        if (this.fitness().equals(o.fitness())) {
            return 0;
        } else if (this.fitness() > o.fitness()) {
            return 1;
        } else {
            return -1;
        }
    }


}