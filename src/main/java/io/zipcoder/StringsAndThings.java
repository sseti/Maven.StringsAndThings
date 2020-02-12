package io.zipcoder;


/**
 * @author tariq
 */
public class StringsAndThings {


    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     * countYZ("day fez"); // Should return 2
     * countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input) {
        int len = input.length();
        int count = 0;
        input = input.toLowerCase();

        for (int i = 0; i < len; i++) {
            if (input.charAt(i) == 'y' || input.charAt(i) == 'z') {
                if (i < len - 1 && !Character.isLetter(input.charAt(i + 1)))
                    count++;
                else if (i == len - 1)
                    count++;
            }
        }

        return count;
    }


    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     * <p>
     * example : removeString("Hello there", "llo") // Should return "He there"
     * removeString("Hello there", "e") //  Should return "Hllo thr"
     * removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove) {

    String result = "";
  for(int i = 0; i < base.length();i++){

        if (i > base.length() - remove.length()) {
            result += base.substring(i, base.length());
            break;
        } else {
            String substring = base.substring(i, i + remove.length());
            if (!(substring.equalsIgnoreCase(remove))) {
                result += base.charAt(i);
            } else {
                i = i + remove.length() - 1;
            }
        }
    }
  return result;
}

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input){
        int balance = 0;
        int p;
        p = input.indexOf("is");
        while(p != -1)
        {
            balance++;
            p = input.indexOf("is", p+2);
        }
        p = input.indexOf("not");
        while(p != -1)
        {
            balance--;
            p = input.indexOf("not", p+3);
        }
        return (balance == 0);
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input){
        if(input.length() == 1 && input.charAt(0) == 'g')
            return false;

        if(input.length() >= 2 &&
                (input.charAt(0) == 'g' && input.charAt(1) != 'g' ||
                        input.charAt(input.length()-1) == 'g' &&
                                input.charAt(input.length()-2) != 'g'))
            return false;

        for(int i = 1; i <= input.length() - 2; i++) {
            if (input.charAt(i) == 'g' && input.charAt(i - 1) != 'g' &&
                    input.charAt(i + 1) != 'g')
                return false;
        }

            return true;

    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){
        int count = 0;
        for (int i = 0; i < input.length() - 2; i++)
            if (input.charAt(i) == input.charAt(i + 1) && input.charAt(i + 1) == input.charAt(i + 2))
                count++;
        return count;
    }
}
