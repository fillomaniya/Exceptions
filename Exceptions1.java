import javax.sound.sampled.SourceDataLine;

// Реализуйте метод, принимающий в качестве аргумента 
// целочисленный массив и некоторое значение.
// Метод идет в массиве заданное значение и 
// возвращает его индекс. При этом, например:
// если длина массива меньше некоторого заданного
//  минимума, метод возвращает -1, в качестве кода ошибки 
// если искомый элемент не найден, метод вернет -2
//  в качестве кода ошибки 
// есля вместо массива пришел пол, метод вернет -3 
//придумайте свои варианты исключительных ситуаций и 
// верните соответствующие коды ошибок
// Напивите метод, в котором реализуйте взаимодействие с пользователем.
// То есть, этот метод запросит искомое число у пользователя, 
// вызовет первый, обработает возвращенное значение и 
// покажет читаный результат пользователю. Например, 
// если вернулся -2, пользователю выведется сообщение:
// «искомый элемент не найден"

public class Exceptions1 {


    public static void main(String[] args) {
        Exceptions1 g = new Exceptions1();
        int[] array = null;
        try {
            int x = g.findIndex(array, 1, 5);
            System.out.println(x);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public int findIndex(int[] arr, int value, int number) {
        int index = -1;

        if (arr == null) {
            throw new RuntimeException("массив пуст");
        } 
        else if (arr.length < number) {
            throw new RuntimeException("Длина массива короче искомого");
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                index = i;
                if (i < number) {
                    throw new RuntimeException("Индекс найденного значения меньше заданного числа");
                } else {
                    throw new RuntimeException("Индекс больше либо равен заданному числу");
                }
            }
        }
            if (index == -1) {
                throw new RuntimeException("Искомый элемент не найден");
            }
            return index;
    } 
}
