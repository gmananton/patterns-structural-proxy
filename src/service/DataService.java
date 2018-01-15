package service;

import java.util.List;

/**
 * Created by Anton Mikhaylov on 15.01.2018.
 */
public interface DataService {
    List<String> getAll();
    String getById(int id);
}
