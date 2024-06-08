package ahmad.api.todolist.services;


import ahmad.api.todolist.models.TacheRepo;
import ahmad.api.todolist.models.tables.Tache;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TacheService {

    @Autowired
    private final TacheRepo tacheRepo;


    public List<Tache> findAll(){
        return tacheRepo.findAll();
    }


    public void addNewTache(Tache tache){
        var t = Tache.builder()
                .text(tache.getText())
                .creationDate(LocalDateTime.now())
                .importance(tache.getImportance())
                .done(false)
                .build();

        tacheRepo.save(t);
    }

    public void deleteTache(Long id){
        Optional<Tache> tache = tacheRepo.findById(id);
        tacheRepo.delete(tache.get());
    }

    public void checkTache(Long id){
        LocalDateTime now = LocalDateTime.now();
        tacheRepo.check(id, now);
    }

    public void unCheckTache(Long id){
        tacheRepo.unCheck(id);
    }


    public void updateTache(Tache t) {
        Optional<Tache> tache = tacheRepo.findById(t.getId());

        if (tache.isPresent()){
            tache.get().setText(t.getText());
            tache.get().setImportance(t.getImportance());
            tacheRepo.save(tache.get());
        }

    }
}
