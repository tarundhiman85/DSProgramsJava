import java.util.ArrayList;
import java.util.Arrays;

public class StringQuestions implements stringMethods{
    public static void main(String[] args) {
        stringMethods methods = new StringQuestions();
//        System.out.println(methods.ReplaceCharactersWithItOccurence("Tarun Dhiman"));
//        System.out.println(methods.convertToRoman(1994));
        ArrayList<String> s = new ArrayList<>();
        s.add("vml");
        s.add("uds");
        s.add("aih");
        s.add("du");
        s.add("vml");
        s.add("uds");
        System.out.println(methods.shortestDistanceBetweenStrings(s,"vml","uds"));
    }

    @Override
    public String reverse(String s) {
        //last visit on 17/11
        //just used two pointer approach
        int end = s.length()-1;
        int start = 0;
        char str[] = s.toCharArray();
        //use two pointer method first convert the string to character array
        //then just apply two pointer tow swap
        while(start<end){
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
        //IMP to convert to string return new String(str)
        return  new String(str);
    }

    @Override
    public String RemoveSpecialCharacters(String s) {
        //just use regular expression with replacement for not including then use ^
        return s.replaceAll("[^a-zA-Z0-9]", "");
    }

    @Override
    public String RemoveWhiteSpaceCharacters(String s) {
        //just use replace method with target and replacement
        return s.replace(" ","");
    }

    @Override
    public String RemoveDuplicateCharacters(String str) {
        int cnt[] = new int[256];
        //use integer array upto 256 and store the count of character
        StringBuffer s = new StringBuffer();
        //to access each character use  .charAt()
        for(int i=0; i<str.length(); i++){
            //just see the count if it is zero or not o
            if(cnt[(int)str.charAt(i)]<1){
                cnt[(int)str.charAt(i)]++;
                //for adding use stringBuffer append method it has also delete method
                s.append(str.charAt(i));
            }
        }
        //we can use s.toString() to convert back to string
        return s.toString();
    }

    @Override
    public String SortCharactersInAlphabeticalOrder(String s) {
        //just convert it into character array and sort it
        char str[] = s.toCharArray();
        Arrays.sort(str);
        return  new String(str);
    }

    @Override
    public String ReplaceCharactersWithItOccurence(String s) {
        int cnt[] = new int[256];
        //just find the count of each character by convert it to charArray
        char str[] = s.toCharArray();
        for(int i=0; i<s.length(); i++){
            if(cnt[(int)str[i]]<1){
                cnt[(int)str[i]]++;
            }
            else{
                //if the character is find previously then we can store its as char occurence back to str[i] with adding 0 asci value
                str[i]=(char)(cnt[(int)str[i]]+'0');
            }
        }
        return new String(str);
    }

    @Override
    public char FindFirstNonRepeatingCharacter(String str) {
        int cnt[] = new int[256];
        //just get the count of each character by first converting it to lowercase
        str=str.toLowerCase();
        for(int i=0; i<str.length(); i++){
            if(cnt[(int)str.charAt(i)]<1){
                cnt[(int)str.charAt(i)]++;
            }
        }
        //then check the first character with the 1 occur and return it
        for(int i=0; i< str.length(); i++){
            if(cnt[(int)str.charAt(i)]==1){
                return str.charAt(i);
            }
        }
        return 'n';
    }

    @Override
    public String ReverseEachWordinGivenString(String s) {
        //last visit 19/11
        String words[]  = s.split(" ");
        String output = "";
        for(String word : words){
            //for each word int the string array
            String revWord="";
            //reverse postion add to revWord
            for (int i = word.length()-1; i>=0; i--){
                revWord = revWord+word.charAt(i);
            }
            //at each time add to the output
            output = output+ revWord + " ";
        }
        return output;
    }

    @Override
    public  String commonPrefix(String a, String b){
        //last visit 19/11
        int i=0, j=0;
        int n1=a.length();
        int n2=b.length();
        String comm="";

        while(i<n1 && j<n2){
            if(a.charAt(i) == b.charAt(j++)){
                comm += a.charAt(i++);
            }
            else{
                return comm;
            }
        }
        return comm;
    }

    @Override
    public String longestCommonPrefix(String arr[], int n){
        // code here
        int i=0;
        boolean tillCond = true;
        String prev = arr[i];
        for(String word : arr){

            if(i++==0){
                continue;
            }
            else{
                //we will compare the strings  and update the prefix
                prev = commonPrefix(word,prev);
            }
        }
        if(prev==""){
            return "-1";
        }
        return prev;
    }

    //according to roman
    int value(char r)
    {
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;
        return -1;
    }

    @Override
    public int romanToDecimal(String s) {
        // code here last visit 19/11
        int total = 0;
        for (int i=0; i<s.length(); i++)
        {
            //we will first find the value at i
            int s1 = value(s.charAt(i));
            if (i+1 <s.length())
            {
                //we will check if it doesnt exceed
                int s2 = value(s.charAt(i+1));
                //now we find the next value
                if (s1 >= s2)
                {
                    //now we check if the previous value is greater
                    //then simply add that value
                    total = total + s1;
                }
                else
                {
                    //else we subtract that value
                    total = total - s1;
                }
            }
            else
            {
                //in the last we add anyways
                total = total + s1;
            }
        }
        return total;
    }

    @Override
    public String convertToRoman(int N) {
        // last visit 19/11
//        Java's StringBuilder can take care of repeated string concatenations
//        without some of the overhead of making string copies
//        I before V  4
//        I before X  9
//
//        X before L  40
//        X before C  90
//
//        C before D  400
//        C before M  900
        int[] val = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] rom = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder ans = new StringBuilder();
        for (int i = 0; N > 0; i++)
            while (N >= val[i]) {
                ans.append(rom[i]);
                //if the value is greater then we need to subtract also as per conditions
                N -= val[i];
            }
        return ans.toString();
    }

    @Override
    public int shortestDistanceBetweenStrings(ArrayList<String> s, String word1, String word2) {

        /*
        last visit on 19/11
        create indexes
        just update the indexes and get min distance
        */

        int mn = Integer.MAX_VALUE;
        int first=-1;
        int second=-1;
        int diff = Integer.MAX_VALUE;

        for(int i=0; i<s.size(); i++)
        {
             if(s.get(i).equals(word1))
            {
                first=i;
            }
             if(s.get(i).equals(word2))
            {
                second=i;
            }
             if(first>=0 && second>=0){
                 diff = Math.abs(first-second);
             }
             mn=Math.min(mn,diff);
        }

        return mn;
    }
}
