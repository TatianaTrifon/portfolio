package org.example.task_manager.dao;

import java.util.List;

public interface DAO<T>{

    T create (T t);

    T update (T t);

    boolean deleteById (Integer id);


}
