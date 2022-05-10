package supportPackage;

import java.io.FileWriter;

public class Note implements Comparable <Note> { //����� �������
	private String noteSubject;//���� �������
    private String dateOfCreation;//���� �������� �������
	private String email;//�����
	private String message;//���������
	
	public Note(String noteSubject, String dateOfCreation, String email, String message){
		this.noteSubject=noteSubject;
		this.dateOfCreation=dateOfCreation;
		this.email=email;
		this.message=message;
	}
	  @Override
		 //��������� ����� compareTo ���������� Comparable
		     public int compareTo(Note o) {

		          int   result = this.noteSubject.compareTo(o.noteSubject);
		         return result;
		     }
	 public void delFile() throws Exception {
			FileWriter nFile = new FileWriter("Note.txt", false); //�������� False ��������� �� ��,
			//��� ���� ����� ����������������
		    nFile.write("");
		    nFile.close();
	}
	 public void add(String noteSubject, String dateOfCreation, String email, String message) throws Exception {
			FileWriter nFile = new FileWriter("Note.txt", true); //�������� true ��������� �� ��,
			//��� ���� ����� ��������������
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
