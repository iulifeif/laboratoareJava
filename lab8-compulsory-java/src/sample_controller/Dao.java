package sample;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    void create(String name, String country);

    void findByName(String name);

}
