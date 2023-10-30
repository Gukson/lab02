package view;

import model.data.Shirt;
import model.data.SurveyResponse;
import model.data.Size;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SurveyResponseParser {
    public SurveyResponse parse(String line){
        String[] splitedLine = line.split(",");
        List<String> colors;

        List<Shirt> result = new ArrayList<>();
        if(splitedLine.length != 2){
            throw new RuntimeException("Cannot parse line with " + splitedLine.length + " components.");
        }
        colors = Arrays.asList(splitedLine[0].split(";"));
        return new SurveyResponse(Size.valueOf(splitedLine[1]), colors);
    }
}
