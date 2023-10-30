package controller.arraysystem;

import controller.Assignment;
import controller.GlobalCriterion;
import model.data.Shirt;
import model.data.SurveyResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ArrayAssigment implements Assignment {
    private GlobalCriterion globalCriterion;

    public ArrayAssigment(GlobalCriterion globalCriterion) {
        this.globalCriterion = globalCriterion;
    }

    @Override
    public double assign(List<Shirt> shirts, List<SurveyResponse> surveyResponses) {

        List<Shirt> shirtsOutput = new ArrayList<>();
        List<SurveyResponse> surveyResponseOutput = new ArrayList<>();

        List<Shirt> shirtsCopy = new ArrayList<>(shirts);
        List<SurveyResponse> surveyResponseCopy = new ArrayList<>(surveyResponses);

        FindMaxPreferenceIndex fMPI = new FindMaxPreferenceIndex();
        Integer maxIndex = fMPI.findMaxPreferenceIndex(surveyResponses);

        //pierwsze dopasowywanie bluz do zamówień
        matching(maxIndex,shirtsCopy,surveyResponseCopy,shirtsOutput,surveyResponseOutput);

        //dopasowaywanie bluz tylko tak, żeby zgadzał sięrozmiar
        matchingBySize(shirtsCopy,surveyResponseCopy,shirtsOutput,surveyResponseOutput);

        //dobpasowywaie bluz w taki sposób aby ktoś dostał jaka kolwiek bluzę albo nic nie dostał
        blindMatching(shirtsCopy,surveyResponseCopy,shirtsOutput,surveyResponseOutput);

        Double result = globalCriterion.loss(shirtsOutput, surveyResponseOutput);
        return result;
    }

    private void founded(Shirt shirt, SurveyResponse surveyResponse, List<Shirt> shirtList, List<SurveyResponse> surveyResponseList,List<Shirt> shirtListOutput, List<SurveyResponse> surveyResponseListOutput){
        shirtListOutput.add(shirt);
        surveyResponseListOutput.add(surveyResponse);
        shirtList.remove(shirt);
        surveyResponseList.remove(surveyResponse);
    }

    private void matching(Integer maxIndex, List<Shirt> shirts, List<SurveyResponse> surveyResponses, List<Shirt>shirtsOutput, List<SurveyResponse>surveyResponseOutput){
        Integer currentIndex = 0;
        while (currentIndex < maxIndex && shirts.size() > 0 && surveyResponses.size() > 0){
            for(int shirt = 0; shirt < shirts.size(); shirt++){
                Shirt currentShirt = shirts.get(shirt);
                for(int survey = 0; survey < surveyResponses.size(); survey++){
                    SurveyResponse currentSurveyResponse = surveyResponses.get(survey);
                    if(Objects.equals(currentShirt.getSize(), currentSurveyResponse.getSize()) && currentSurveyResponse.getColorPreference().size() > currentIndex && Objects.equals(currentShirt.getColor(), currentSurveyResponse.getColorPreference().get(currentIndex))){
                        founded(currentShirt,currentSurveyResponse,shirts,surveyResponses,shirtsOutput,surveyResponseOutput);
                        shirt = 0;
                        survey = 0;
                    }
                }
            }
            currentIndex ++;
        }
    }

    private void matchingBySize(List<Shirt> shirts, List<SurveyResponse> surveyResponses, List<Shirt>shirtsOutput, List<SurveyResponse>surveyResponseOutput){
        for(int shirt = 0; shirt < shirts.size(); shirt++){
            Shirt currentShirt = shirts.get(shirt);
            for(int survey = 0; survey < surveyResponses.size(); survey++){
                SurveyResponse currentSurveyResponse = surveyResponses.get(survey);
                if(currentShirt.getSize() == currentSurveyResponse.getSize()){
                    founded(currentShirt,currentSurveyResponse,shirts,surveyResponses,shirtsOutput,surveyResponseOutput);
                    shirt = 0;
                    survey = 0;
                }
            }
        }
    }

    private void blindMatching(List<Shirt> shirts, List<SurveyResponse> surveyResponses, List<Shirt>shirtsOutput, List<SurveyResponse>surveyResponsesOutput){
        while (shirts.size() > 0 && surveyResponses.size() > 0){
            founded(shirts.get(0),surveyResponses.get(0),shirts,surveyResponses,shirtsOutput,surveyResponsesOutput);
        }

        while(surveyResponses.size() > 0){
            shirtsOutput.add(null);
            surveyResponsesOutput.add(surveyResponses.get(0));
            surveyResponses.remove(surveyResponses.get(0));
        }
    }
}
