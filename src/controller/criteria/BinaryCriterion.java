package controller.criteria;

import controller.LocalCriterion;
import model.data.Shirt;
import model.data.SurveyResponse;


public class BinaryCriterion implements LocalCriterion {
    @Override
    public double loss(Shirt shirt, SurveyResponse surveyResponse) {
        if(shirt == null || surveyResponse == null){
            return 1;
        }
        if(shirt.getSize() == surveyResponse.getSize() && surveyResponse.getColorPreference().get(0).equals(shirt.getColor())) {
            return 0;
        }
        return 1;
    }
}