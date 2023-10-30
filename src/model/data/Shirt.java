package model.data;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Shirt {
    private String color;
    private Size size;

    public Shirt(String color, Size size){
        this.color = color;
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }
}