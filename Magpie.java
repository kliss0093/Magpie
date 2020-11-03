public class Magpie
{
   public String getGreeting()
   {
     return "Hello, let's talk.";
   }

   public String getResponse(String statement)
   {
     String response = "";
     if (statement.indexOf("no") >= 0) {
       response = "Why so negative?";
     } else if (statement.indexOf("yes") >= 0) {
       response = "I like the positivity!";
     } else if ((statement.trim()).length() == 0) {
       response = getRandomNoncommittalResponse();
     } else if (statement.indexOf("Mrs.O'Connell") >= 0) {
       response = "She sounds like a great teacher!";
     } else if (statement.indexOf("new") >= 0) {
       response = "Oh, what did you get?";
     } else if (statement.indexOf("ate") >= 0) {
       response = "That sounds tasty.";
     } else if (statement.indexOf("help") >= 0) {
       response = "What's wrong?";
     } else if (statement.indexOf("outside") >= 0) {
       response = "I love the outdoors.";
     }else if (statement.indexOf("mother") >= 0
                 || statement.indexOf("father") >= 0
                 || statement.indexOf("sister") >= 0
                 || statement.indexOf("brother") >= 0) {
       response = "Tell me more about your family.";
     } else if (statement.indexOf("cat") >= 0
                 || statement.indexOf("dog") >= 0) {
       response = "Tell me more about your pets.";
     }else {
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

   private String getRandomResponse()
   {
     final int NUMBER_OF_RESPONSES = 4;
     double r = Math.random();
     int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
     String response = "";

     if (whichResponse == 0) {
       response = "Interesting, tell me more.";
     } else if (whichResponse == 1) {
       response = "Hmmm.";
     } else if (whichResponse == 2) {
       response = "Do you really think so?";
     } else if (whichResponse == 3) {
       response = "You don't say.";
     }
     return response;
         }
   private String getRandomNoncommittalResponse()
   {
     final int NUMBER_OF_RESPONSES2 = 3;
     double r2 = Math.random();
     int whichResponse2 = (int)(r2 * NUMBER_OF_RESPONSES2);
     String response = "";

     if (whichResponse2 == 0) {
       response = "Say something, please.";
     } else if (whichResponse2 == 1) {
       response = "Talk to me!";
     } else if (whichResponse2 == 2) {
       response = "Oh, so are you going to give me the silent treatment?";
     }
     return response;
         }

   public static void main(String[] args)
   {
     Magpie maggie = new Magpie();

     System.out.println(maggie.getGreeting());
     System.out.println(">My mother and I talked last night.");
     System.out.println(maggie.getResponse("My mother and I talked last night."));
     System.out.println(">I said no.");
     System.out.println(maggie.getResponse("I said no!"));
     System.out.println(">The weather is nice.");
     System.out.println(maggie.getResponse("The weather is nice."));
     System.out.println(">Do you know my brother?");
     System.out.println(maggie.getResponse("Do you know my brother?"));
   }
}
