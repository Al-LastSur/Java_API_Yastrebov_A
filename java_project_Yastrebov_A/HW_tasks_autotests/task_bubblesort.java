package HW_tasks_autotests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.text.SimpleDateFormat;
import java.util.Date;


public class task_bubblesort {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 4, 8, 3, 1};
        System.out.println("Original array: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
    
    private static File log;
    private static FileWriter fileWriter;



    static {
        try {
            log = new File("log.txt");
            fileWriter = new FileWriter(log, true); // true для добавления в файл
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void sort(int[] mas) {
        int n = mas.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (mas[j] > mas[j + 1]) {
                    int temp = mas[j];
                    mas[j] = mas[j + 1];
                    mas[j + 1] = temp;
                    swapped = true;
                }
            }
System.out.println("Iteration " + (i+1) + ": " + Arrays.toString(mas));
logArray(mas);
if (!swapped) break;
}
closeFileWriter();
}

private static void logArray(int[] mas) {
    try {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
        fileWriter.write(timestamp + " " + Arrays.toString(mas) + "\n");
        fileWriter.flush();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

private static void closeFileWriter() {
    try {
        if (fileWriter != null) {
            fileWriter.close();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
  