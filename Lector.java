package CSVexamen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Lector {
	
	
	 String[][] ReadFileInto2DArray(String filepath, int fields){
		
		List<String> recordList = new ArrayList<String>();
		String delimeter=",";
		String currentLine;
		
		try {
			FileReader fr=new FileReader(filepath);
			BufferedReader reader=new BufferedReader(fr);
			//checks if there is a next item
			while((currentLine=reader.readLine())!=null) {
				recordList.add(currentLine);
			}
			
			int recordCount = recordList.size();
			//creates a final array
			String[][] arrayToReturn=new String[recordCount][fields];
			//create an array to store the values we separate from the split()
			String[] data;
			
			//add the data we have separeted from , to our final array
			for(int i=0; i<recordCount; i++) {
				data=recordList.get(i).split(delimeter);
				for(int j=0; j<data.length; j++) {
					arrayToReturn[i][j]=data[j];
				}
			}
			reader.close();
			return arrayToReturn;
		}catch(IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	 
	 void ejecutar(int idNum) {
		 FileWriter fw=null;
		 PrintWriter printer=null;
		 String filepath="C:\\Users\\migdd\\eclipse-workspace\\CSVexamen\\src\\emails.csv";
		 String[][] data=ReadFileInto2DArray(filepath, 3002);
		 /*for(int i=0; i<data.length; i++) {
			// System.out.println(String.join(",", data[i]));
		 }*/
		 String name=(String.valueOf(idNum))+".txt";
		 try {
			 File sumFile = new File(name);
			 if(sumFile.createNewFile()) {
				 System.out.println("File created...");
			 }else {
				 System.out.println("File already exists...");
			 }
		 }catch(IOException e) {
			 e.printStackTrace();
		 }
		 String value=String.valueOf(idNum).substring(String.valueOf(idNum).length()-3);		 
		 int last3Num=Integer.parseInt(value);
		 int rowIndex=last3Num+50;
		 int sum = 0;
		 //rows
		 try {
			 fw=new FileWriter(name);
			 printer= new PrintWriter(fw);
			 for(int i=1;i<data[i].length;i++) {
				 sum=0;
				 //System.out.print(data[0][i]+": ");
				 //collumns
				 for(int j=last3Num-1; j<rowIndex ; j++) {
					sum+=Integer.parseInt(data[j][i]);
					}
				 String writeVal=String.valueOf(data[0][i])+", "+(String.valueOf(sum));
				 printer.print(writeVal);
				 printer.println();
				 }
		 }catch(IOException e){
			 
		 }finally {
			 try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				printer.close();
	 }
	//ejecutar
		 
	 }
//main
}