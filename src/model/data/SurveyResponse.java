package model.data;

import java.util.List;

public class SurveyResponse {
    Size size;
    List<String> colorPreference;

    public SurveyResponse(Size size, List<String> colorPreference){
        this.size = size;
        this.colorPreference = colorPreference;
    }

    public Size getSize() {
        return size;
    }

    public List<String> getColorPreference() {
        return colorPreference;
    }
}

