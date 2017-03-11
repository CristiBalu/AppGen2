package fbhack.martaungureanu.appgen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fbhack.martaungureanu.appgen.utils.Model;

import static android.R.id.list;

/**
 * Created by martaungureanu on 11/03/2017.
 */

public class Parser {
    public static Model parse(String input) {

        HashMap<String, String> attributesMap = new HashMap<>();

        String[] userPhrases = input.split("\\.");

        int i = 0;

        while(userPhrases[i].contains("I want the") && !userPhrases[i].contains("user")) {
            String[] attributes = userPhrases[i].split("I want the");
            System.out.println(attributes[0]);
            String attribute = attributes[1];
            String[] values = attribute.split("to be");
            if(!attribute.equals("")) {
                String value = values[1].replaceAll(" ", "");
                attributesMap.put(parseAttributes(values[0]), value);
            }
            i++;
        }

        List<String> elements = new ArrayList<>();

        while(i < userPhrases.length) {
            String[] userActivities = userPhrases[i].split("able to");
            String userActivity = userActivities[1];
            if(userActivity.contains("insert") || userActivity.contains("introduce")) {
                if(userActivity.contains("date")) {
                    elements.add("DatePicker");
                } else if(userActivity.contains("number")) {
                    elements.add("Number");
                } else if(userActivity.contains("password")) {
                    elements.add("Password");
                } else {
                    elements.add("TextInput");
                }
            } else if(userActivity.contains("select") || userActivity.contains("pick")) {
                if(userActivity.contains("date")) {
                    elements.add("DatePicker");
                } else {
                    elements.add("Spinner");
                }
            } else if(userActivity.contains("click") || userActivity.contains("push")
                      || userActivity.contains("press")) {
                elements.add("Button");
            } else if(userActivity.contains("turn") || userActivity.contains("switch")) {
                elements.add("Switch");
            }
            i++;
        }



//        String[] attributes = input.split("I want the");
//        for(String attribute : attributes) {
//            if(!attribute.equals("")) {
//                System.out.println(attribute);
//                String[] values = attribute.split("to be");
//                String value = values[1].replaceAll(" ", "");
//                String finalValue = value;
//                if(value.charAt(value.length() - 1) == '.') {
//                    finalValue = value.substring(0, value.length() - 1);
//                }
//                attributesMap.put(parseAttributes(values[0]), finalValue);
//            }
//        }

        return new Model(attributesMap, elements);
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
