import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataManager {

	Boolean saveLong(String dateFormatted){
        try {
            File ToFile = new File("ss_mm.txt");
            FileWriter myFileWriter = new FileWriter(ToFile, true);
            BufferedWriter myBufferedWriter = new BufferedWriter(myFileWriter);
            if(!ToFile.exists()){
                ToFile.createNewFile();
            } else {
                myBufferedWriter.append(dateFormatted + "\n");
            }
            myBufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void readFile(){
        try {
            
            BufferedReader br = new BufferedReader(new FileReader("Nuovo.txt"));
           
    		String line;
            float x;
            float prec = 0;
            float current = 0;
            float daSommare = 0;
    		while ((line = br.readLine()) != null) {
                current = (Float.valueOf(line.substring(6))) + daSommare;
       			if (current > prec) {
                    x = (Float.valueOf(line.substring(6))) + daSommare;
                    prec = current;
                } else {
                	daSommare = prec;
                    x = (Float.valueOf(line.substring(6))) + daSommare;
                }
       			saveLong(Float.toString(x));
    		}
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        DataManager datamanager = new DataManager();
        datamanager.readFile();
        
    }

}