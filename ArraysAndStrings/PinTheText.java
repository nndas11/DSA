package ArraysAndStrings;

import java.util.*;

//  We are given a list of Bad Phrases and sentence.
//  If the sentence contains any of the bad phrases -> then unsafe.


//  Intuition: Loop through the sentence and check if the word is in pad phrases -> will take O(n)
//  So optimising it to O(1) lookup using HashMap.

public class PinTheText {
    public static void main(String[] args) {
        List<String> badPhrases = Arrays.asList(
                "get free movie downloads",
                "get free hotel upgrades",
                "click here for free ray bans",
                "best spam sites",
                "world war is best avoided",
                "get free candies and free movie downloads sign up"
        );

        System.out.println(pinTextSafety("How to get free movie downloads", badPhrases));
        System.out.println(pinTextSafety("How to get free a upgrades", badPhrases));
        System.out.println(pinTextSafety("Click here for free ray bans", badPhrases));
        System.out.println(pinTextSafety("best spam sites", badPhrases));
        System.out.println(pinTextSafety("world war is best avoided", badPhrases));
        System.out.println(pinTextSafety("How to get free candies and free movie downloads sign up", badPhrases));
    }

    public static boolean pinTextSafety(String sentence, List<String> badPhrases){
        Map<String, List<List<String>>> preprocessd = preProcessor(badPhrases);
        String[] words = sentence.toLowerCase().split(" ");

        for (int i=0;i<words.length;i++){
            if(preprocessd.containsKey(words[i])){
                for (List<String> phrase :preprocessd.get(words[i])){
//                    length check
                    if(phrase.size() + i <= words.length){
                        List<String> subString = Arrays.asList(Arrays.copyOfRange(words, i, i + phrase.size()));
                        if (phrase.equals(subString)){
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static Map<String, List<List<String>>> preProcessor(List<String> badPhrases){
        Map<String, List<List<String>>> map = new HashMap<>();

        for (String phrases: badPhrases){
            String[] splitPhrases =  phrases.split(" ");
            String key = splitPhrases[0];

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(Arrays.asList(splitPhrases));

//            if(map.containsKey(key)){
//                map.get(key).add(Arrays.asList(splitPhrases));
//            }else {
//                map.put(key, new ArrayList<>());
//                map.get(key).add(Arrays.asList(splitPhrases));
//            }
        }

        return map;
    }
}
