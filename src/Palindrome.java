import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by nishit jain on 8/1/16.
 */
public class Palindrome {


     public static boolean isWordPalindrome(String inputString){

         List<Character> x = new ArrayList<>(inputString.length());

         for(char tmp: inputString.toLowerCase().toCharArray()){
             x.add(tmp);
         }

         List<Character> y = new ArrayList<>(x);

        Collections.reverse(x);

        return x.equals(y);
    }

    public static boolean isCombinationOfWordFormPalindrome(String inputString) {

        // Test if frequency of every character in string is even.

        //HashMap to store char frequency
        Map<Character, Integer> charFreq = new HashMap<>(inputString.length());

        //Convert input into list
        List<Character> inputStringList = new ArrayList<>(inputString.length());

        for (char c : inputString.toCharArray()) {
            inputStringList.add(c);
        }

        //load charFreq
        inputStringList.stream().forEach((c) -> {
                    if (!charFreq.containsKey(c)) {
                        charFreq.put(c, 1);
                    } else {
                        charFreq.put(c, charFreq.get(c) + 1);
                    }
                }
        );

        //System.out.println("charFreq = " + charFreq);

        //check if all values are even

        int oddNr = 0;
        int evenNr = 0;

        for(int v:charFreq.values()){
            if (v % 2 == 0) evenNr++;
            else oddNr++;
        }

        //System.out.println("evenNr: "+evenNr +" oddNr: "+oddNr);


        if(inputString.length()%2==0){
            //if input string is even in length
            return oddNr == 0;

        }else{
            //if input string is odd in length
            return oddNr==1 ;

        }


    }




    public static void main(String[] args){

        System.out.println("======  PALINDROME ====== ");

        System.out.println("Is this word Palindrome? Aibohphobia : "+isWordPalindrome("Aibohphobia"));
        System.out.println("Is this word Palindrome? kinnikinnik : "+isWordPalindrome("kinnikinnik"));
        System.out.println("Is this word Palindrome? murdrum : "+isWordPalindrome("murdrum"));


        System.out.println("Is combination of character of this word can form  a Palindrome? aaalll :"+ isCombinationOfWordFormPalindrome("aalll"));
        System.out.println("Is combination of character of this word can form  a Palindrome? civic :"+ isCombinationOfWordFormPalindrome("civic"));
        System.out.println("Is combination of character of this word can form  a Palindrome? ciivc :"+ isCombinationOfWordFormPalindrome("ciivc"));


    }
}
