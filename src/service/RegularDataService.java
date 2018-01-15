package service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Anton Mikhaylov on 15.01.2018.
 * Обычный сервис доступа к данным. Имитируем задержку при создании объекта и чтении данных
 */
public class RegularDataService implements DataService {

    private final List<String> data = Arrays.asList("Value1", "Value2", "Value3");

    @Override
    public List<String> getAll() {
        safeWait(2000);
        return data;
    }

    @Override
    public String getById(int id) {
        safeWait(2000);
        return data.get(id);
    }

    private void safeWait(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
