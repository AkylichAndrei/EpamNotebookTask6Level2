package supportPackage;

import java.io.FileWriter;

public class Note implements Comparable <Note> { //класс заметка
	private String noteSubject;//тема заметки
    private String dateOfCreation;//дата создания заметки
	private String email;//почта
	private String message;//сообщение
	
	public Note(String noteSubject, String dateOfCreation, String email, String message){
		this.noteSubject=noteSubject;
		this.dateOfCreation=dateOfCreation;
		this.email=email;
		this.message=message;
	}
	  @Override
		 //реализуем метод compareTo интерфейса Comparable
		     public int compareTo(Note o) {

		          int   result = this.noteSubject.compareTo(o.noteSubject);
		         return result;
		     }
	 public void delFile() throws Exception {
			FileWriter nFile = new FileWriter("Note.txt", false); //значение False указывает на то,
			//что файл будет перезаписываться
		    nFile.write("");
		    nFile.close();
	}
	 public void add(String noteSubject, String dateOfCreation, String email, String message) throws Exception {
			FileWriter nFile = new FileWriter("Note.txt", true); //значение true указывает на то,
			//что файл будет дозаписываться
		    nFile.write(noteSubject + System.lineSeparator());
		    nFile.write(dateOfCreation + System.lineSeparator());
		    nFile.write(email + System.lineSeparator());
		    nFile.write(message + System.lineSeparator());
		    nFile.close();
		}
	  
	  
	public String getNoteSubject() {
		return noteSubject;
	}

	public void setNoteSubject(String noteSubject) {
		this.noteSubject = noteSubject;
	}

	public String getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(String dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
