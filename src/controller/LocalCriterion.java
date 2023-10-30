package controller;

import model.data.Shirt;
import model.data.SurveyResponse;

//Local odpowiada na pytanie jak źle jest dopasowana koszulka do człowieka
public interface LocalCriterion {

    public double loss(Shirt shirt, SurveyResponse surveyResponse);
}
