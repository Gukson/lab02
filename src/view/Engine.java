package view;

import controller.Assignment;
import model.data.Shirt;
import model.data.SurveyResponse;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Engine {

    private Assignment assignment;

    public Engine(Assignment assignment) {
        this.assignment = assignment;

    }

    public void run(String pathToPreferences, String pathToStock) {
        List<Shirt> shirts = loadShirts(pathToStock);
        List<SurveyResponse> surveyResponses = loadSurveyResponse(pathToPreferences);
        System.out.println(this.assignment.assign(shirts, surveyResponses) + " punktów");
    }

    public List<SurveyResponse> loadSurveyResponse(String pathToPreference){
        List<SurveyResponse> survayResponse = new ArrayList<>();
        SurveyResponseParser parser = new SurveyResponseParser();

        try {
            File file = new File(pathToPreference);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                survayResponse.add(parser.parse(line));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return survayResponse;
    }

    public List<Shirt> loadShirts(String pathToStock) {
        List<Shirt> shirts = new ArrayList<>();
        ShirtParser parser = new ShirtParser();

        try {
            File file = new File(pathToStock);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                shirts.addAll(parser.parse(line));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return shirts;
    }

}
