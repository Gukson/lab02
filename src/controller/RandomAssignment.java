package controller;

import model.data.Shirt;
import model.data.SurveyResponse;

import java.util.Collections;
import java.util.List;

public class RandomAssignment implements Assignment{

    private GlobalCriterion globalCriterion;
    public RandomAssignment(GlobalCriterion globalCriterion) {
        this.globalCriterion = globalCriterion;
    }


    @Override
    public double assign(List<Shirt> shirts, List<SurveyResponse> surveyResponses) {
        Collections.shuffle(shirts);
        Collections.shuffle(surveyResponses);
        return globalCriterion.loss(shirts,surveyResponses);
    }
}
