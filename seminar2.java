import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

// Запишите в файл следующие строки:
// Анна=4
// Елена=5
// Марина=6
// Владимир=?
// Константин=?
// Иван=4
// Реализуйте метод, который считывает 
// данные из файла и сохраняет в двумерный массив 
// (либо HashMap, если студенты с ним знакомы). 
// В отдельном методе нужно будет пройти по структуре данных, 
// если сохранено значение ?, заменить его на соответствующее 
// число.Если на каком-то месте встречается символ, 
// отличный от числа или ?, бросить подходящее исключение.
// Записать в тот же файл данные с замененными символами ?.


public class seminar2 {
    public static void main(String[] args) {
        // HashMap<String, Integer> result = new HashMap<>();
        // File file = new File("text.txt");
        // result = readFile(file);
        // writeFile(file, result);
        try (Counter myCounter = new Counter()) {
            myCounter.add();
            System.out.println(myCounter.getIndex());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Counter myCounter = new Counter();
            myCounter.close();
            myCounter.add();
            System.out.println(myCounter.getIndex());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static HashMap<String, Integer> readFile (File file) {
        HashMap<String, Integer> result = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lines = line.split("=");
                int index = 0;
                try {
                    index = Integer.parseInt(lines[1]);
                } catch (NumberFormatException e) {
                    index = lines[0].length();
                } finally {
                    result.put(lines[0], index);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public static void writeFile (File file, HashMap<String, Integer> result) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String key: result.keySet()) {
                writer.write(key + "=" + result.get(key) + '\n');
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


} 