package fbhack.martaungureanu.appgen;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by martaungureanu on 11/03/2017.
 */

public class Parser {
    public static Map<String, String> parse(String input) {

        Map<String, String> attributesMap = new HashMap<>();

        String[] attributes = input.split("I want the");
        for(String attribute : attributes) {
            if(!attribute.equals("")) {
                System.out.println(attribute);
                String[] values = attribute.split("to be");
                String value = values[1].replaceAll(" ", "");
                String finalValue = value;
                if(value.charAt(value.length() - 1) == '.') {
                    finalValue = value.substring(0, value.length() - 1);
                }
                attributesMap.put(parseAttributes(values[0]), finalValue);
            }
        }

        return attributesMap;
    }

    private static String parseAttributes(String userInputAttribute) {
        userInputAttribute.toLowerCase();
        if(userInputAttribute.contains("background")) {
            return "background";
        } else if(userInputAttribute.contains("text")) {
            if(userInputAttribute.contains("size")) {
                return "textSize";
            } else if(userInputAttribute.contains("color")) {
                return "textColor";
            }
        }
        return "";
    }
}
