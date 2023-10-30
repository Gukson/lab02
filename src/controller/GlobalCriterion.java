package controller;

import model.data.Shirt;
import model.data.SurveyResponse;

import java.util.List;

//jak źle są dopasowane koszulki do ludzi
public interface GlobalCriterion {

    public double loss(List<Shirt> shirts, List<SurveyResponse> surveyResponses);
}
