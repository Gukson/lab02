package controller.criteria;

import controller.LocalCriterion;
import model.data.Shirt;
import model.data.SurveyResponse;

import java.util.Objects;

public class MainCriteria implements LocalCriterion {
    @Override
    public double loss(Shirt shirt, SurveyResponse surveyResponse) {
        double sum = 0;
        if(shirt == null){
            return 5;
        }
        if(surveyResponse == null){
            return 0;
        }

        if(shirt.getSize() != surveyResponse.getSize()){
            sum +=2;
        }
        if(!(surveyResponse.getColorPreference().contains(shirt.getColor()))){
            sum+=10;
        }
        else {
            for(int x = 0; x<surveyResponse.getColorPreference().size(); x++){
                if(Objects.equals(shirt.getColor(), surveyResponse.getColorPreference().get(x))){
                    break;
                }
                sum += 2;
            }
        }

        return sum;
    }
}
