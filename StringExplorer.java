
/**
 * A program to allow students to try out different 
 * String methods. 
 * @author Laurie White
 * @version April 2012
 */
public class StringExplorer
{

    public static void main(String[] args)
    {
        String sample = "The quick brown fox jumped over the lazy dog.";
        
        //  Demonstrate the indexOf method.
        int position = sample.indexOf("quick");
        System.out.println ("sample.indexOf(\"quick\") = " + position);
        
        //  Demonstrate the toLowerCase method.
        String lowerCase = sample.toLowerCase();
        System.out.println ("sample.toLowerCase() = " + lowerCase);
        System.out.println ("After toLowerCase(), sample = " + sample);
        
        //  Try other methods here:
        int notFoundPsn = sample.indexOf("slow");
        System.out.println("sample.indexOf(\"slow\") = " + notFoundPsn);
        
        int position5 = sample.indexOf("o", 20);
        System.out.println("sample.indexOf(\"o\") = " + position5);
        
        int position2 = sample.indexOf("lazy", 37);
        System.out.println("sample.indexOf(\"lazy\") = " + position2);
        
        int position3 = sample.indexOf("fox");
        System.out.println("sample.indexOf(\"fox\") = " + position3);

        int position4 = sample.indexOf("the", 10);
        System.out.println("sample.indexOf(\"the\") = " + position4);


    }

}
