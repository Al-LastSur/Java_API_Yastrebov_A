// Напишите метод, который вернет содержимое текущей папки в виде массива строк.
// Напишите метод, который запишет массив, возвращенный предыдущим методом в файл.
// Обработайте ошибки с помощью try-catch конструкции.
// В случае возникновения исключения, оно должно записаться в лог-файл.


package practice02;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.util.Arrays;

public class task5 {
    public static void main(String[] args) {
        String folderpath = "M:\\Lessons-HW-Specialization\\Intro2HTML\\yastrebov_a\\HW06";
        // readFileNames(folderpath);
        // readFileNames("M:\\Lessons-HW-Specialization\\Intro2HTML\\yastrebov_a\\HW06");
        // readFileNames("M:/Lessons-HW-Specialization/Intro2HTML/yastrebov_a/HW06");
        
        // File file = new File (folderpath);
        // File[] files = file.listFiles();
        // for (File fileName: files) {
        //     System.out.println (fileName);

        //  to see the files in a terminal line
        System.out.println(Arrays.toString(readFileNamesInDir (folderpath)));
        
        // WriteFileNamesInFile("task1.txt",folderpath);



        }


    public static void readFileNames(String path){
        FileReader  fr = null;
        try {
            File file = new File(path);
            fr = new FileReader(file);            
            if (file.isDirectory()) {

                File[] filesArr = file.listFiles();
                for (File elem : filesArr) {
                    System.out.println(elem.getName());
                }
            } else{
                throw new IOException("File is not a directory");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
// method is working
private static String[] readFileNamesInDir(String path){
    File file  = new File(path);
    if (file.isDirectory()){
        File[] filesArr = file.listFiles();
        String[] fileNames = new String[filesArr.length];
        for (int i = 0; i < filesArr.length; i++) {
            fileNames[i] = filesArr[i].getName();
        }
        return fileNames;
    } else {
        throw new RuntimeException("File is not a directory") {
            
        };
    }
}

private static void WriteFileNamesInFile (String pathIn, String pathOut){
    FileWriter fw = null;
    try{
        fw = new FileWriter(pathIn);
        String[] arr = readFileNamesInDir(pathOut);
        for (int i = 0; i < arr.length; i++) {
            fw.write(arr[i] + "\n");
            // fw.append("\n");
        }
    } catch (IOException e) {
        throw new RuntimeException(e);    
    } finally {
        try{
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException("Closing File Error");
        }
    }
}




    }

// contyionue watching 1 51 27