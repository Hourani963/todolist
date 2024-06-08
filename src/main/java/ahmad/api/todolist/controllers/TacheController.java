package ahmad.api.todolist.controllers;


import ahmad.api.todolist.models.tables.Tache;
import ahmad.api.todolist.services.TacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/tache")
@RequiredArgsConstructor
public class TacheController {

    private final TacheService tacheService;


    @GetMapping("getAll")
    public ResponseEntity<List<Tache>> getCarouselImagesList() {
        try {
            return ResponseEntity.ok(tacheService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @PostMapping("addNew")
    public ResponseEntity<String> getCarouselImagesList(@RequestBody Tache tache) {
        try {
            tacheService.addNewTache(tache);
            return ResponseEntity.ok("new tache added");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("");
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteTache(@PathVariable("id") Long id) {
        try {
            tacheService.deleteTache(id);
            return ResponseEntity.ok("tache deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("");
        }
    }

    @PutMapping("check/{id}")
    public ResponseEntity<String> check(@PathVariable("id") Long id) {
        try {
            tacheService.checkTache(id);
            return ResponseEntity.ok("tache checked");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("error");
        }
    }

    @PutMapping("uncheck/{id}")
    public ResponseEntity<String> uncheck(@PathVariable("id") Long id) {
        try {
            tacheService.unCheckTache(id);
            return ResponseEntity.ok("tache unChecked");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("error");
        }
    }

    @PutMapping("update")
    public ResponseEntity<String> check(@RequestBody Tache tache) {
        try {
            tacheService.updateTache(tache);
            return ResponseEntity.ok("tache updated");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("error");
        }
    }

}
