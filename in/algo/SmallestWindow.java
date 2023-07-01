package in.algo;


// Given two strings S and P. Find the smallest window in
// the string S consisting of all the characters(including duplicates)
// of the string P.  Return "-1" in case there is no such window present.
// In case there are multiple such windows of same length, return the one
// with the least starting index.
// Note : All characters are in Lowercase alphabets.

public class SmallestWindow {
    public static void main(String[] args) {
        System.out.println(smallestWindow("timetopractice","toc"));
    }

    static String smallestWindow(String m, String k){
        int[] hashPattern = new int[256];
        int[] hashStr = new int[256];

        int length = k.length();
        for (int i = 0; i < length; i++) {
            hashPattern[k.charAt(i)]++;
        }
        int count=0;
        int start=0;
        int lengthStr=m.length();
        int startMin=0;
        for (int i = 0; i < m.length(); i++) {
            hashStr[m.charAt(i)]++;
            if(hashPattern[m.charAt(i)] !=0 && hashStr[m.charAt(i)] <= hashPattern[m.charAt(i)]){
                count++;
            }
            if(count==length){
                while (hashPattern[m.charAt(start)]==0 ||
                        hashStr[m.charAt(start)] > hashPattern[m.charAt(start)]){
                    hashStr[m.charAt(start)]--;
                    start++;
                }
                if(lengthStr > (i-start+1)){
                    lengthStr = i-start+1;
                    startMin = start;
                }
            }
        }
        return (m.substring(startMin,startMin+lengthStr));
    }

}
