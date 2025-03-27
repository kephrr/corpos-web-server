package corpos.dakar.web_server.services;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import java.util.List;
import java.util.Optional;

public interface IServiceCore<T,ID> {
    T save(T data);
    Page<T> findAll(Pageable pageable);
    List<T> findAll();
    Optional<T> show(ID dataID);
}
