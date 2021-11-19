import java.util.ArrayList;

public interface stringMethods {
    String reverse(String s);
    String RemoveSpecialCharacters(String s);
    String RemoveWhiteSpaceCharacters(String s);
    String RemoveDuplicateCharacters(String s);
    String SortCharactersInAlphabeticalOrder(String s);
    String ReplaceCharactersWithItOccurence(String s);
    char FindFirstNonRepeatingCharacter(String s);
    String ReverseEachWordinGivenString(String s);
    String commonPrefix(String a, String b);
    String longestCommonPrefix(String arr[], int n);
    int romanToDecimal(String s);
    String convertToRoman(int N);
    int shortestDistanceBetweenStrings(ArrayList<String> s, String word1, String word2);
}
