package controller.criteria;

import controller.GlobalCriterion;
import controller.LocalCriterion;
import model.data.Shirt;
import model.data.SurveyResponse;

import java.util.List;
import java.lang.Math;
public class CumulativeCriterion implements GlobalCriterion {

    private LocalCriterion localCriterion;

    public CumulativeCriterion(LocalCriterion localCriterion) {
        this.localCriterion = localCriterion;
    }

    @Override
    public double loss(List<Shirt> shirts, List<SurveyResponse> surveyResponses) {
        int max = Math.max(shirts.size(), surveyResponses.size());
        double result = 0;
        Shirt currentShirt;
        SurveyResponse currentSurveyResponse;

        for(int i = 0; i<max;i++){
            if (i < shirts.size()) {
                currentShirt = shirts.get(i);
            } else {
                currentShirt = null;
            }
            if (i < surveyResponses.size()) {
                currentSurveyResponse = surveyResponses.get(i);
            } else {
                currentSurveyResponse = null;
            }

            result += this.localCriterion.loss(currentShirt, currentSurveyResponse);
        }
        return result;
    }
}
