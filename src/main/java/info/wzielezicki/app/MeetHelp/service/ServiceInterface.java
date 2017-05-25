package info.wzielezicki.app.MeetHelp.service;

import java.util.List;

/**
 * Created by wzielezi on 2017-05-25.
 */
public interface ServiceInterface<T> {

    List<T> getObj();
    T create (T obj);
    T findById(String id);
    T update (T obj);

}
