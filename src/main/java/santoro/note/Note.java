package santoro.note;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Note {
	private @Id @GeneratedValue Long note_id;
	private String note_titolo;
	private String note_testo;
	
	Note() {}

	public Note(String note_titolo, String note_testo) {
		super();
		this.note_titolo = note_titolo;
		this.note_testo = note_testo;
	}

	public Long getNote_id() {
		return note_id;
	}

	public void setNote_id(Long note_id) {
		this.note_id = note_id;
	}

	public String getNote_titolo() {
		return note_titolo;
	}

	public void setNote_titolo(String note_titolo) {
		this.note_titolo = note_titolo;
	}

	public String getNote_testo() {
		return note_testo;
	}

	public void setNote_testo(String note_testo) {
		this.note_testo = note_testo;
	}
	
}
