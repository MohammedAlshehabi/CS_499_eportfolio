import java.util.List;
import java.util.Optional;

public interface ContactRepository {

    void create(Contact contact);

    Optional<Contact> findById(String id);

    List<Contact> findAll();

    void update(Contact contact);

    void deleteById(String id);
}
