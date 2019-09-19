package com.develogical;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }else if(query.toLowerCase().contains("name")){
            return "superchu";
        }else if (query.toLowerCase().contains("largest")){
            Pattern number = Pattern.compile("\\d+");
            Matcher n = number.matcher(query.toLowerCase());
            List<Integer> nums = new ArrayList<>();
            while (n.find()){
                nums.add(Integer.parseInt(n.group()));
            }

            int max = nums.stream()
                    .mapToInt(v -> v)
                    .max().orElseThrow(NoSuchElementException::new);

            return String.valueOf(max);
        }
        return "";
    }
}
