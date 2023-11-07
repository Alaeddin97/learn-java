package strings;

import java.util.Arrays;
import java.util.Formatter;

public class StringMethods {
    public static void main(String[] args) {
        String greetings=" greetings ";
        System.out.println();
        System.out.println("............String methods ........................");
        System.out.println();
        System.out.println("greetings.length(): " + greetings.length());
        System.out.println("greetings.contains(\"s\"): " + greetings.contains("s"));
        System.out.println("greetings.isEmpty(): " + greetings.isEmpty());
        System.out.println("greetings.toUpperCase(): " + greetings.toUpperCase());
        System.out.println("greetings.startWith(\"gree\"): " + greetings.startsWith(" gree"));
        System.out.println("greetings.endWith(\"ings\"): " + greetings.endsWith("ings"));
        System.out.println("greetings.replace(\"g\",\"G\"): " + greetings.replace("gr","Gr")); //replace all recurrences
        System.out.println("greetings.trim(): " + "'" + greetings.trim() + "'"); //remove all leading and trailing spaces
        System.out.println("greetings.strip(): " + "'" + greetings.strip() + "'"); //remove all leading and trailing white spaces
        System.out.println("greetings.substring(1,3): " + greetings.substring(1,3)); // 3rd character excluded
        System.out.println("Arrays.toString(greetings.getBytes()): " + Arrays.toString(greetings.getBytes()));
        System.out.println("Arrays.toString(greetings.toChartArray()): " + Arrays.toString(greetings.toCharArray()));
        System.out.println("greetings.chartAt(1):  " + greetings.charAt(1));
        System.out.println("Arrays.toString(greetings.split(\"t\")): " + Arrays.toString(greetings.split("t")));
        System.out.println("greetings: " + greetings);

        System.out.println();
        System.out.println("......................String comparison .................................");
        System.out.println();

        String greetings1=" greetings ";
        String greetings2=new String(" greetings ");
        String greetings3=" Greetings ";

        System.out.println("greetings == greetings1: " + (greetings == greetings1));
        System.out.println("greetings == greetings2: " + (greetings == greetings2));
        System.out.println("greetings == greetings2.intern(): " + (greetings == greetings2.intern())); // intern() gives the reference within the string pool
        System.out.println("greetings.equals(greetings2): " + greetings.equals(greetings2));
        System.out.println("greetings.equalsIgnoreCase(greetings3): " + greetings1.equalsIgnoreCase(greetings3));

        System.out.println();
        System.out.println("......................Escape sequences in Java...........................");
        System.out.println();


        /*
		 	\t - tab.
			\b - backspace (a step backward in the text or deletion of a single character).
			\n - new line.
			\r - carriage return. ()
			\f - form feed.
			\' single quote.
			\" double quote.
			\\ backslash.
		 */

        System.out.println("\" Hello world !\""); // double quote
        System.out.println("Java source code: C:\\Java\\sources"); //backslash
        System.out.println("Hello\tworld!"); // tab
        System.out.println("Hello world!\b"); // one step backward
        System.out.println("line \nnext line");
        System.out.println("carriage\rreturn\rreturn1");
        System.out.println("form feed 1\f1");


    }
}