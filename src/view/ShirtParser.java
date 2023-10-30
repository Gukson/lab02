package view;

import model.data.Shirt;
import model.data.Size;

import java.util.ArrayList;
import java.util.List;

public class ShirtParser {

    public Shirt parse(String color, String size) {
        return new Shirt(color.trim(), Size.valueOf(size.trim()));
    }

    public List<Shirt> parse(String line){
        String[] splitedLine = line.split(", ");
        int count;
        List<Shirt> result = new ArrayList<>();
        if(splitedLine.length != 3){
            throw new RuntimeException("Cannot parse line with " + splitedLine.length + " components.");
        }

        try {
            count = Integer.parseInt(splitedLine[2]);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Token " + splitedLine[2] + " is not a number.");
        }

        for(int x = 0; x<count; x++){
            result.add(this.parse(splitedLine[0], splitedLine[1]));
        }
        return result;
    }
}
