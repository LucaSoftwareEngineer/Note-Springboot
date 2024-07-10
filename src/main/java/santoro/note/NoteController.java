package santoro.note;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NoteController {
	
	@Autowired
	private NoteRepository noteRepository;
	
	//metodo che reucpera le note
	@GetMapping("/get_notes")
	Iterable<Note> getNote() {
		return noteRepository.findAll();
	}
	
	//metodo che cerca la nota per id
	@GetMapping("/search_note_by_id")
	Optional<Note> getNota(@RequestParam Long note_id) {
		return noteRepository.findById(note_id);
	}
	
	
	//metodo per aggiungere una nuova nota
	@PostMapping("/add_note")
	Note addNote(@RequestParam String note_titolo, @RequestParam String note_testo) {
		Note nota = new Note(note_titolo, note_testo);
		return noteRepository.save(nota);
	}
	
	//metodo per modificare una nota
	@PutMapping("/edit_note")
	String editNote(@RequestParam Long note_id, @RequestParam String note_titolo, @RequestParam String note_testo) {
		noteRepository.editNote(note_titolo, note_testo, note_id);
		return "OK";
	}
	
	//metodo per eliminare una nota
	@DeleteMapping("/remove_note")
	String removeNote(@RequestParam Long note_id) {
		noteRepository.deleteById(note_id);
		return "OK";
	}
	
}
