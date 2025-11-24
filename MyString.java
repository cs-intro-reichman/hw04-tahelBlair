public class MyString {
    public static void main(String[] args) {
        System.out.println("Testing lowercase:");
        System.out.println("UnHappy : " + lowerCase("UnHappy"));
        System.out.println("This costs 15 Sheksls : " + lowerCase("This costs 15 Sheksls"));
        System.out.println("TLV : " + lowerCase("TLV"));
        System.out.println("lowercase : " + lowerCase("lowercase"));

        System.out.println("Testing contains:");
        System.out.println(contains("unhappy", "happy")); // true
        System.out.println(contains("happy", "unhappy")); // false
        System.out.println(contains("historical", "story")); // false
        System.out.println(contains("psychology", "psycho")); // true
        System.out.println(contains("personality", "son")); // true
        System.out.println(contains("personality", "dad")); // false
        System.out.println(contains("resignation", "sign")); // true
    }

    /** Returns the lowercase version of the given string. */
    public static String lowerCase(String str) {
        String lowStr = "";
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) >= 'A') && (str.charAt(i) <= 'Z')) {
                lowStr = lowStr + (char)(str.charAt(i) + 32);
            } else {
                lowStr = lowStr + str.charAt(i);
            }
        }
        return lowStr;
    }

    /** If str1 contains str2, returns true; otherwise returns false. */
    public static boolean contains(String str1, String str2) {
       if ((str1.length() < str2.length()) || (str1.length() == 0)) {
        return false;
       } else if (str2.length() == 0) return true; 
       else {
            int start = str1.indexOf(str2.charAt(0));
            while (start != -1) {
                boolean contain = true;
                for (int i = 0; i < str2.length(); i++) {
                  if (str1.charAt(start + i) != str2.charAt(i)) { 
                    contain = false;
                    break;
                }
             }
             if (contain) return true;
             start = str1.indexOf(str2.charAt(0), start + 1);
            }  
          }
           return false;
    }
}
