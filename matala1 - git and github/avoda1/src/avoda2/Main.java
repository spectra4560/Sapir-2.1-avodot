package avoda2;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {
 public static void main(String[] args) {
	 try {
		 
		 // יצירת הפניה לקובץ
		 File fileCS = new File("src/avoda2/CS.txt");
		 File fileHedva = new File("src/avoda2/hedva.txt");
		 File fileReport = new File("src/avoda2/Report.txt");
		 // פתיחת הקבצים
		 Scanner scannerCS = new Scanner(fileCS);
		 Scanner scannerHedva = new Scanner(fileHedva);
		 PrintWriter writter = new PrintWriter(fileReport);
		 // קריאה שורה ראשונה של כל הקבצים
		 String linesCS = scannerCS.hasNextLine() ? scannerCS.nextLine() : null;
		 String linesHedva = scannerHedva.hasNextLine() ? scannerHedva.nextLine() : null;
		 // לולאה שקוראת את הקובץ 
		 // CS.txt
	
		 while(linesCS != null && linesHedva != null) {

			 // מפרקים את הנתונים של הקובץ הראשון
			 String[] partsCS = linesCS.split(" ");
			 String firstName = partsCS[0];
			 String lastName = partsCS[1];
			 int idCS = Integer.parseInt(partsCS[2]);

			 // מפרקים את הנתונים של הקובץ השני
			 String[] partsHedva = linesHedva.split(" ");
			 int idHedva = Integer.parseInt(partsHedva[0]);
			 int grade1 = Integer.parseInt(partsHedva[1]);
			 int grade2 = Integer.parseInt(partsHedva[2]);

			 if(idCS == idHedva) {
				 int average = (grade1 + grade2) / 2;
				 writter.println(idCS + " " + firstName + " " + lastName + " average: " + average);
				 
				 linesCS = scannerCS.hasNextLine() ? scannerCS.nextLine() : null;
				 linesHedva = scannerHedva.hasNextLine() ? scannerHedva.nextLine() : null;
				 
			 }else if(idCS < idHedva) {
				 linesCS = scannerCS.hasNextLine() ? scannerCS.nextLine() : null;
			 }else {
				 linesHedva = scannerHedva.hasNextLine() ? scannerHedva.nextLine() : null;
			 }
		 }
		 scannerCS.close();
		 scannerHedva.close();
		 writter.close();
			 
	 }catch(FileNotFoundException e) {
         System.out.println("Error: File not found." + e);
 }
 }}
