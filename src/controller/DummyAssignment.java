package controller;

import model.data.Shirt;
import model.data.SurveyResponse;

import java.util.List;

public class DummyAssignment implements Assignment {
    private GlobalCriterion globalCriterion;

    public DummyAssignment(GlobalCriterion globalCriterion) {
        this.globalCriterion = globalCriterion;
    }

    public double assign(List<Shirt> shirts, List<SurveyResponse> surveyResponses){
        return globalCriterion.loss(shirts,surveyResponses);
    }
}
