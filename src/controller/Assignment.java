package controller;

import model.data.Shirt;
import model.data.SurveyResponse;

import java.util.List;

public interface Assignment {

    public double assign(List<Shirt> shirts, List<SurveyResponse> surveyResponses);
}
