import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
public class Prog01_aOrderedList {
	static aOrderedList aOrderedListObject;

	public static void main(String[] args) throws FileNotFoundException{
        aOrderedListObject = new aOrderedList();
        Scanner s = GetInputFile("Y");
        readInputFile(s);
        PrintWriter w = getOutputFileName("Y");
        printOutPutFile(w);
    }
	
    public static Scanner GetInputFile(String UserPrompt) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        File inputFile;
        String filename;
        String Userresponse;
        if (UserPrompt.equals("Y")) {
            System.out.println("Enter input filename: ");
            filename = scan.next();
            inputFile = new File(filename);
            if (!inputFile.exists()) {
                System.out.println("File specified \"" + filename + "\" does not exist. Would you like to ocntinue ? <Y/N>");
                Userresponse = scan.next();
                GetInputFile(Userresponse);
            } else {
                scan = new Scanner(new File(filename));
                return scan;
            }
        } else throw new FileNotFoundException();
        return null;
    }
    
    public static PrintWriter getOutputFileName(String userPrompt) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        File outputfile;
        String filename;
        String response;
        PrintWriter pw;
        if (userPrompt.equals("Y")) {
            System.out.println("Enter input fileName:");
            filename = scan.next();
            outputfile = new File(filename);
            if (!outputfile.exists()) {
                System.out.println("File specified" + filename + "does not exist. Would you like to ocntinue ? <Y/N>");
                response = scan.next();
                getOutputFileName(response);

            } else {
                pw = new PrintWriter(new File(filename));
                return pw;
            }
        } else
            throw new FileNotFoundException();
        return null;
    }
    public static void readInputFile(Scanner s) throws FileNotFoundException {
      if(!(s == null)) { 
    	s = s.useDelimiter("\\,");
        String operation;
        String make;
        int year;
        int price;
        int index;
        operation = s.next();
        do {
            if (operation.equals('A')) {
                make = s.next();
                year = s.nextInt();
                price = s.nextInt();
                Car newCar = new Car(make, year, price);
                aOrderedListObject.add((Comparable) newCar);
                s.nextLine();
            }
            if (operation.equals("D")) {
                index = s.nextInt();
                aOrderedListObject.remove(index);
            }
        } while (s.hasNextLine());
       } 
      else throw new FileNotFoundException();
      
    }
    
    public static void printOutPutFile(PrintWriter w) {
        w.print("Number of cars : " + aOrderedListObject.size());
        for (int i = 0; i < aOrderedListObject.size(); i++) {
        	Car car = (Car) aOrderedListObject.get(i);
        	w.println();
            w.println("Make : " + car.getMake());
            w.println("Year : " + car.getYear());
            w.println("Price : " + car.getPrice());
        }
    }
}
