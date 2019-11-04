import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        
        /*Read the filepath*/
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give file path: ex: C:\\file.txt");
        String filePath = scanner.next();
        scanner.close();

        /*Read the text file*/
        File file = new File(filePath);
        Scanner scannerFile = new Scanner(file);

        String number;
        ArrayList<Double> numbers = new ArrayList<>();

        /*Put all numbers in a list and replace "," with "." for decimal placement*/
        while(scannerFile.hasNext()){
            number = scannerFile.nextLine();
            String normalizedNumber = number.replace(",", ".");
            numbers.add(Double.parseDouble(normalizedNumber));
        }

        scannerFile.close();

        /*Sort the number in ascending order */
        Collections.sort(numbers);

        /*Find the median*/
        Double median = null;
        if(numbers.size() % 2 == 0){
            median = (numbers.get(numbers.size()/2-1)+numbers.get(numbers.size()/2))/2;
        } else {
            int floor = (int) Math.floor(numbers.size()/2);
            median = numbers.get(floor);

        }

        /*System.out.println(numbers);*/
        System.out.println(median);

    }
}
