package ahmad.api.todolist.models;

import ahmad.api.todolist.models.tables.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Repository
public interface TacheRepo extends JpaRepository<Tache,Long> {


    @Transactional
    @Modifying
    @Query("Update Tache t SET t.done = true, t.doneDate = :now WHERE t.id = :id")
    void check(Long id, LocalDateTime now);

    @Transactional
    @Modifying
    @Query("Update Tache t SET t.done = false, t.doneDate = null WHERE t.id = :id")
    void unCheck(Long id);
}
