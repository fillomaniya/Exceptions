import java.io.Closeable;
/**
*   Создайте класс Счетчик, у которого есть метод add(),
*   увеличивающий значение внутренней int переменной на 1.
*   Сделайте ток, чтобы с объектом такого типа можно было
*   работать в блоке try-with-resources. Подумайте, что должно
*   происходить при закрытии этого ресурса? Напишите метод для проверки,
*   закрыт ли ресурс. При попытке вызвать add() у закрытого ресурса,
*   должен выброситься I0Exception
*/


public class Counter implements AutoCloseable {

    private int index;
    private boolean isClosed = false;;

    public Counter() {
        index = 0;
    }

    public void add() {
        if (isClosed) {
            throw new RuntimeException("Вот и исключение");
        }
        index++;
    }

    @Override
    public void close() throws Exception {
        isClosed = true;
        throw new UnsupportedOperationException("Unimplemented method 'close'");
    }

    public int getIndex() {
        return index;
    }

}
