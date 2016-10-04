import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class FileWorker {
	
	public static String loadTask(String fileName) {
		File file1 = new File(fileName);			
		char[] buffer = new char[(int) file1.length() - 1];				
		FileReader fileReader;
		try {
			fileReader = new FileReader(file1);
			fileReader.read(buffer);
			fileReader.close();
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return new String(buffer);	
	}
	
	public static Map<String, Float> loadStandard(int n) {		
		FileReader fileReader = null;
		Map<String, Float> map = new LinkedHashMap<String, Float>();
		try {
			switch (n) {
				case 1: 
					fileReader = new FileReader("standard/english_monogram.txt");
					break;
				case 2: 
					fileReader = new FileReader("standard/english_bigram.txt");
					break;
				case 3: 
					fileReader = new FileReader("standard/english_trigrams.txt");
					break;
				case 4: 
					fileReader = new FileReader("standard/english_quadgrams.txt");
					break;
				default: 
					fileReader = null;
					break;
			}			
			
			BufferedReader bufferReader = new BufferedReader(fileReader);
			String str;
			
			long total = 0;
			while ((str = bufferReader.readLine()) != null) {
				map.put(str.split(" ")[0], new Float(str.split(" ")[1]));
				total += Integer.parseInt(str.split(" ")[1]);
			}
			
			for (Map.Entry<String, Float> entry: map.entrySet()) {
				entry.setValue((float) Math.log10(entry.getValue() / total));				
			}
			
			bufferReader.close();
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}
}
