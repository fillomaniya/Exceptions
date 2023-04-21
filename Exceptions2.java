// Реализуйте метод checkArray (Integer[] arr), 
// принимающий в качестве аргумента целочисленный одномерный массив.
// Метод должен пройтись по каждому злементу и 
// проверить что он не равен null.
// теперь реализуйте следующую логику:
// Если в Какай-то ячейке встретился null, то 
// необходино "оповестить" об этом пользователя
// Если null'ы встретились в нескольких ячейках, 
// то идеально было бы все их "подсветить”

public class Exceptions2 {
    public static void main(String[] args) {
        Exceptions2 gg = new Exceptions2();
        Integer[] array = {1, 3, null, null};
        System.out.println(gg.checkArray(array));
    }

    public String checkArray(Integer[] arr) {
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                newString.append(i).append(" ");
            }
        }
        if (newString.length() == 2) {
            throw new RuntimeException(" Найден  нулевой элемент в количестве 1");
        }
        if (newString.length() > 1) {
            throw new RuntimeException(newString.toString());
        }
        return "not found";
    }
}
