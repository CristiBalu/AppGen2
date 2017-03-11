package fbhack.martaungureanu.appgen.utils;


import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class Model implements Serializable{
    private HashMap<String, String> aspectMap;
    private List<String> elements;

    public Model(HashMap<String, String> attributeMap, List<String> elements) {
        this.aspectMap = attributeMap;
        this.elements = elements;
    }

    public HashMap<String, String> getAspectMap() {
        return aspectMap;
    }

    public List<String> getElements() {
        return elements;
    }
}
