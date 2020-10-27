/**
 * A program to carry on conversations with a human user.
 * This version: 
 * <ul><li>
 *    Uses advanced search for keywords 
 * </li></ul> 
 *    
 * @author Laurie White
 * @version April 2012
 */
public class Magpie
{
    /**
     * Get a default greeting
     * 
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }

    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
   {
    String response = "";
    if(statement.length() == 0 || findKeyword(statement, " ") == 0){
       return "Say something, please.";
    }
     if (findKeyword(statement, "no") >= 0
            && (statement.charAt(findKeyword(statement, "no")) >= 0)){
       response = "Why so negative?";
     } else if (findKeyword(statement, "mother") >= 0
                 || findKeyword(statement, "father") >= 0
                 || findKeyword(statement, "sister") >= 0
                 || findKeyword(statement, "brother") >= 0) {
       response = "Tell me more about your family.";
     }
     else if (findKeyword(statement, "pizza") >= 0 || findKeyword(statement, "nachos") >= 0){//Author: Triston Purpose: covers common food choices.
       response = "Tell me more about food.";
     }
     else if (findKeyword(statement, "nintendo") >= 0 ||findKeyword(statement, "xbox") >= 0){
      response = "What video games do you like to play on your console?";//Hunter - makes chatbot interested in video games
    }
    else if (findKeyword(statement, "java")  >= 0 || findKeyword(statement, "c++") >= 0){////Author: Triston Purpose: covers common programming languages
      response = "I also enjoy programming!";
    }
    else if (findKeyword(statement, "dog") >= 0 ||findKeyword(statement, "cat") >= 0){//Hunter
      response = "Tell me more about your pets.";
    }
    else if (findKeyword(statement, "mr.") >= 0 ||findKeyword(statement, "mrs.") >= 0 || findKeyword(statement, "ms.") >= 0){//Author: Triston Purpose: Fills requirement
      response = (findKeyword(statement, "Mr.") >=0 ? "He":"She") + " sounds like a good teacher.";
    }
    else if (findKeyword(statement, "fizz") >= 0 ||findKeyword(statement, "foo") >= 0 || findKeyword(statement, "ms.") >= 0){//Author: Triston Purpose: additional keyword
      response = (findKeyword(statement, "fizz") >=0 ? "Buzz!":"Bar!");
    }
    else if (findKeyword(statement, "frozen yogurt") >= 0){//Hunter: adds frozen yogurt
      response = "I prefer ice cream.";
    }
    else if (findKeyword(statement, "O'Connell") >= 0){//Hunter: adds frozen yogurt
      response = "Ms.O'Connell my favorite teacher!";
    }
    else {
       response = getRandomResponse();
    }
     return response;
   }

    /**
     * Search for one word in phrase. The search is not case
     * sensitive. This method will check that the given goal
     * is not a substring of a longer string (so, for
     * example, "I know" does not contain "no").
     *
     * @param statement
     *            the string to search
     * @param goal
     *            the string to search for
     * @param startPos
     *            the character of the string to begin the
     *            search at
     * @return the index of the first occurrence of goal in
     *         statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal,
            int startPos)
    {
        String phrase = statement.trim().toLowerCase();
        goal = goal.toLowerCase();

        // The only change to incorporate the startPos is in
        // the line below
        int psn = phrase.indexOf(goal, startPos);

        // Refinement--make sure the goal isn't part of a
        // word
        while (psn >= 0)
        {
            // Find the string of length 1 before and after
            // the word
            String before = " ", after = " ";
            if (psn > 0)
            {
                before = phrase.substring(psn - 1, psn);
            }
            if (psn + goal.length() < phrase.length())
            {
                after = phrase.substring(
                        psn + goal.length(),
                        psn + goal.length() + 1);
            }

            // If before and after aren't letters, we've
            // found the word
            if (((before.compareTo("a") < 0) || (before
                    .compareTo("z") > 0)) // before is not a
                                            // letter
                    && ((after.compareTo("a") < 0) || (after
                            .compareTo("z") > 0)))
            {
                return psn;
            }

            // The last position didn't work, so let's find
            // the next, if there is one.
            psn = phrase.indexOf(goal, psn + 1);

        }

        return -1;
    }

    /**
     * Search for one word in phrase. The search is not case
     * sensitive. This method will check that the given goal
     * is not a substring of a longer string (so, for
     * example, "I know" does not contain "no"). The search
     * begins at the beginning of the string.
     * 
     * @param statement
     *            the string to search
     * @param goal
     *            the string to search for
     * @return the index of the first occurrence of goal in
     *         statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal)
    {
        return findKeyword(statement, goal, 0);
    }
    /**
     * Pick a default response to use if nothing else fits.
     * 
     * @return a non-com    mittal string
     */
    private String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 6;
        double r = Math.random();
        int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
        String response = "";

        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }
        else if (whichResponse == 4){
            response = "Really?";
        }
        else if (whichResponse == 5){
            response = "Wow.";
        }

        return response;
    }
    public static void main(){
        Magpie Maggie = new Magpie();
        System.out.println(Maggie.findKeyword("She's my sister", "sister", 0));
        System.out.println(Maggie.findKeyword("Brother Tom is helpful", "brother", 0));
        System.out.println(Maggie.findKeyword("I can't catch wild cats.", "cat", 0));
        System.out.println(Maggie.findKeyword("I know nothing about snow plows.", "no", 0));
    }
}
