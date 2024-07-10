package santoro.note;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.transaction.Transactional;

public interface NoteRepository extends JpaRepository<Note, Long> { //significa: <che_oggetti_manipolo, tipo_della_chiave>
	@Modifying
	@Transactional
	@Query(
		" UPDATE Note SET note_titolo = :note_titolo, note_testo = :note_testo " +
		" WHERE note_id = :note_id "
	)
	void editNote(
		@RequestParam String note_titolo,
		@RequestParam String note_testo,
		@RequestParam Long note_id
	);
}
