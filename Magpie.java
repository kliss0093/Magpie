public class Magpie
{
   public String getGreeting()
   {
     return "Hello, let's talk.";
   }

   public String getResponse(String statement)
   {
     statement.trim();
     String response = "";
    if(statement.indexOf("") == 0){
       return "Say something, please.";
    }
     if (statement.indexOf("no") >= 0
            && (statement.charAt(statement.indexOf("no")) >= 0)){
       response = "Why so negative?";
     } else if (statement.indexOf("mother") >= 0
                 || statement.indexOf("father") >= 0
                 || statement.indexOf("sister") >= 0
                 || statement.indexOf("brother") >= 0) {
       response = "Tell me more about your family.";
     }
     else if (statement.indexOf("pizza") >= 0 || statement.indexOf("nachos") >= 0){//Author: Triston Purpose: covers common food choices.
       response = "Tell me more about food.";
     }
     else if (statement.indexOf("nintendo") >= 0 ||statement.indexOf("xbox") >= 0){
      response = "What video games do you like to play on your console?";//Hunter - makes chatbot interested in video games
    }
    else if (statement.indexOf("Java")  >= 0 || statement.indexOf("C++") >= 0){////Author: Triston Purpose: covers common programming languages
      response = "I also enjoy programming!";
    }
    else if (statement.indexOf("dog") >= 0 ||statement.indexOf("cat") >= 0){//Hunter
      response = "Tell me more about your pets.";
    }
    else if (statement.indexOf("Mr.") >= 0 ||statement.indexOf("Mrs.") >= 0 || statement.indexOf("Ms.") >= 0){//Author: Triston Purpose: Fills requirement
      response = (statement.indexOf("Mr.") >=0 ? "He":"She") + " sounds like a good teacher.";
    } else {
       response = getRandomResponse();
     }
     return response;
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
