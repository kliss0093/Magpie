
/**
 * Write a description of class StringExplorer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StringExplorer
{
    public static void main(){
        String sample = "The quick brown fox jumped over the lazy dog.";
        
            //  Demonstrate the indexOfMethod
            int position = sample.indexOf("quick");
            System.out.println ("sample.indexOf(\"quick\") = " + position);
            
            //  Demonstrate the toLowerCase method.
            String lowerCase = sample.toLowerCase();
            System.out.println ("Sample.toLowerCase = " + lowerCase);
            System.out.println ("After toLowerCase, sample = " + sample);
            
            //  Try other methods here
            int notFoundPsn = sample.indexOf("slow");
            System.out.println("sample.indexOf(\"slow\") = " + notFoundPsn);
            
            position = sample.indexOf("fox", 30);
            System.out.println ("sample.indexOf(\"fox\") = " + position);
            
            position = sample.indexOf("fox");
            System.out.println ("sample.indexOf(\"fox\") = " + position);
            
            position = sample.indexOf("fox", 30);
            System.out.println ("sample.indexOf(\"fox\") = " + position);
            
            position = sample.indexOf("lazy", 30);
            System.out.println ("sample.indexOf(\"lazy\") = " + position);
            
            position = sample.indexOf("lazy");
            System.out.println ("sample.indexOf(\"lazy\") = " + position);
            
    }
}
