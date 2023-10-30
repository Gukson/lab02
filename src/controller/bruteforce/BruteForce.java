package controller.bruteforce;

import controller.Assignment;
import controller.GlobalCriterion;
import model.data.Shirt;
import model.data.SurveyResponse;

import java.util.ArrayList;
import java.util.List;

public class BruteForce implements Assignment {
    private GlobalCriterion globalCriterion;

    public BruteForce(GlobalCriterion globalCriterion) {
        this.globalCriterion = globalCriterion;
    }

    public double assign(List<Shirt> shirts, List<SurveyResponse> surveyResponses){
        while (shirts.size() < surveyResponses.size()){
            shirts.add(null);
        }
        List<List<Shirt>> shirtsPermutations = generatePerm(shirts);
        List<Shirt> bestPermutation = null;
        double bestResultScore = Double.MAX_VALUE;

        for (List<Shirt> shirtsPermutation : shirtsPermutations) {
            double score = this.globalCriterion.loss(shirtsPermutation, surveyResponses);
            if (score < bestResultScore) {
                bestPermutation = shirtsPermutation;
                bestResultScore = score;
            }
        }
//        System.out.println(bestPermutation);
        return globalCriterion.loss(bestPermutation,surveyResponses);
    }

    private  <E> List<List<E>> generatePerm(List<E> original) {
        if (original.isEmpty()) {
            List<List<E>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }
        E firstElement = original.remove(0);
        List<List<E>> returnValue = new ArrayList<>();
        List<List<E>> permutations = generatePerm(original);
        for (List<E> smallerPermutated : permutations) {
            for (int index = 0; index <= smallerPermutated.size(); index++) {
                List<E> temp = new ArrayList<>(smallerPermutated);
                temp.add(index, firstElement);
                returnValue.add(temp);
            }
        }
        return returnValue;
    }
}
