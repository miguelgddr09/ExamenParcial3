package CSVexamen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Lector {

	
	void ejecutar() {
		
		File file=new File("E:\\Programacion Orientada a Objetos\\CSVexamen\\src\\emails.csv");
		String path=file.getPath();
		String line="";
		
		//split ,
		ArrayList<String> csvlist = new ArrayList<String>();
		try {
			BufferedReader reader=new BufferedReader(new FileReader(path));
			while((line=reader.readLine())!=null) {			
					csvlist.add(Arrays.toString(line.split(",|\\\n")));
			}
			reader.close();
			String[] array= csvlist.toArray(new String[0]);
			for (String str : array) {
	            System.out.println(str);
	        }
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		/*try {
			String[] csvfile;
			 
			BufferedReader reader=new BufferedReader(new FileReader(path));
			while((line=reader.readLine())!= null) {
				//csvfile=line.split("\n");
				for(int i=0;i<csvfile.length;i++) {
					String[][]csvfile2[i][]=csvfile[i]
				}
				System.out.println(csvfile[0]);
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}*/
		
		
	}
}
