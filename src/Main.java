import controller.Assignment;
import controller.arraysystem.ArrayAssigment;
import controller.bruteforce.BruteForce;
import controller.criteria.MainCriteria;
import controller.GlobalCriterion;
import controller.LocalCriterion;
import controller.criteria.CumulativeCriterion;
import view.Engine;

import java.util.Scanner;

public class Main {
    public static Engine engine;
    public static void main(String[] args) {
        LocalCriterion localCriterion = new MainCriteria();
        GlobalCriterion globalCriterion = new CumulativeCriterion(localCriterion);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj ścieżkę do pliku zawierające informacje o zamówionych bluzach");
        String shirtsPath = scanner.nextLine();

        System.out.println("Podaj ścieżkę do pliku zawierające informacje o preferencjach pracowników");
        String survayResponsesPath = scanner.nextLine();

        long start = System.currentTimeMillis();
        System.out.println("Wynik działania algorytmu BruteForce:");
        Assignment bruteForceAssigment = new BruteForce(globalCriterion);
        engine = new Engine(bruteForceAssigment);

        engine.run(shirtsPath, survayResponsesPath);
        //engine.run("./data/bluzy.txt", "./data/orders.txt");
        long elapsedTime = System.currentTimeMillis() - start;

        System.out.println("Zajęło " + elapsedTime/1000F + " sekund\n");


        start = System.currentTimeMillis();
        System.out.println("Wynik działania algorytmu ArrayAssigment:");
        Assignment ArrayAssigment = new ArrayAssigment(globalCriterion);

        engine = new Engine(ArrayAssigment);
        engine.run(shirtsPath, survayResponsesPath);
        //engine.run("./data/bluzy.txt", "./data/orders.txt");

        elapsedTime = System.currentTimeMillis() - start;

        System.out.println("Zajęło " + elapsedTime/1000F + " sekund");
    }
}
//./data/bluzy.txt
//./data/orders.txt