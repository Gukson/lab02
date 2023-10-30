package controller.arraysystem;

import model.data.SurveyResponse;

import java.util.ArrayList;
import java.util.List;

public class FindMaxPreferenceIndex {
    public Integer findMaxPreferenceIndex(List<SurveyResponse> surveyResponseList){
        int index = 1;
        for(SurveyResponse s: surveyResponseList){
            if(s.getColorPreference().size() > index){
                index = s.getColorPreference().size();
            }
        }
        return index;
    }
}
