import java.util.ArrayList;

public interface stringMethods {
    public boolean areIsomorphicStrings(String str1, String str2);
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
    int isDivisibleby7(String s);
    String encryptString(String S);
    long countSubEqualPoint(String str);
    boolean areKAnagrams(String str1, String str2, int k);
    boolean checkPangram(String str);

    String revesreWithM(String s, int m);
}
