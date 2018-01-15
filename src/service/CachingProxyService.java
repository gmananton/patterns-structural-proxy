package service;


import java.util.List;

/**
 * Created by Anton Mikhaylov on 15.01.2018.
 * Кэширующий прокси с ленивой инициализацией.
 * Делегирует выполнение логики оборачиваемому объекту в случае отсутствия данных в кэше.
 */
public class CachingProxyService implements DataService {

    private final DataService service;
    private List<String> data;

    public CachingProxyService(DataService service) {
        this.service = service;
    }

    @Override
    public List<String> getAll() {
        if (data == null) {
            List<String> dataLoaded = service.getAll();
            data = dataLoaded;
        }

        return data;
    }

    @Override
    public String getById(int id) {
        if (data == null) {
            List<String> dataLoaded = service.getAll();
            data = dataLoaded;
        }
        return data.get(id);
    }


}
