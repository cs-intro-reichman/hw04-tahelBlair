public class KeywordsDetector {
    public static void main(String[] args) {
        String[] sentences = {
            "Our product will transform the market",
            "Programming is both painful and engaging",
            "This has nothing to do with machine learning",
            "We need to leverage our core competencies",
            "Let's talk about data and algorithms",
            "Chatbots are great but must be used carefully",
            "This blockchain-based solution will disrupt the industry",
            "The team showed great Synergy in the last project",
            "Use simple words without hype and fluff",
            "Our new technology presents a significant paradigm shift",
            "Effective presentations must be clear, concise, and humble"
        };
        // Some keywords that typically signal bullshit contents in business presentations 
        String[] keywords = {"synergy", "disrupt", "leverage", "Paradigm", "transform"};
        detectAndPrint(sentences, keywords);
    }

    // Iterates through all the sentences.
    // If a sentence contains one or more of the kewords, prints it.
    public static void detectAndPrint(String[] sentences, String[] keywords) {
        String[] lowSen = new String [sentences.length];
        String[] loWord = new String [keywords.length];
        for (int j = 0; j < lowSen.length; j++) {
            lowSen[j] = sentences[j];
            lowSen[j] = lowerCase(lowSen[j]);
        }
        for (int j = 0; j < loWord.length; j++) {
            loWord[j] = keywords[j];
            loWord[j] = lowerCase(loWord[j]);
        }
       for (int i = 0; i < sentences.length; i++) {
            for (int j = 0; j < keywords.length; j++) {
                if (contains (lowSen[i], loWord[j])) {
                    System.out.println(sentences[i]);
                    break;
                }
            }
       }
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
            while ((start != -1) && (start + str2.length() <= str1.length())) {
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
