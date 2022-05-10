package supportPackage;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import supportPackage.Note;

public class Notebook {//����� �������
private String name;//�������� ��������
private List<Note> note;

public Notebook(String name, List<Note> note){
	this.name=name;
	this.note=note;
}
@Override
public String toString() {
	String s="";
	  for (int i=0; i < note.size(); i++)
        {
			  s=s + "\r\n  |+++++| ���� �������: "
	            		+ ""+ note.get(i).getNoteSubject() + " "
	            				+ "|+++++| ���� ��������  : "
	            					+ ""+note.get(i).getDateOfCreation()+"  "
	            							+ "  |+++++| �������� ������  : "
	    	            					+ ""+note.get(i).getEmail()+"  "
	    	            							+ "  |+++++| ��������� : "
	    	    	            					+ ""+note.get(i).getMessage()+"  "
	            						+ " ";
         
        }
		 return "{" +
        " �� �������������� ������� :'" + this.name  + " \r\n "+
        ", ������ ������� � �������� : ||'" + s  + '\'' +
        '}';
}
public String searchAll(String tempStr) {
	//"\\s*("+tempStr+")\\s*"
	String s1="",s2="";
	boolean bol=false;
	for (int i=0; i < note.size(); i++) {
	s1 = "\r\n  |+++++| ���� �������  : "
    		+ ""+ note.get(i).getNoteSubject() + " "
    				+ "  |+++++| ���� ��������  : "
    					+ ""+note.get(i).getDateOfCreation()+"  "
    							+ "  |+++++| �������� ������  : "
            					+ ""+note.get(i).getEmail()+"  "
            							+ "  |+++++| ��������� : "
    	            					+ ""+note.get(i).getMessage()+" ";
	Pattern pattern = Pattern.compile("\\s*("+tempStr+")\\s*");
    Matcher matcher = pattern.matcher(s1);
    if (matcher.find()==true)
    	s2=s2+s1;
    	bol=true;
	}
	if(bol == true)
		 return "{" +
     " ���������� ������ : '"+
     "" + s2  + '\'' +
     '}';
	  else return "���������� �� �������!";
}
public String searchNoteSubject(String tempStr, int tempInt ,String tempStrGroup) {//����� �� ����
	String s1 = "";
	boolean bol=false;
	  for (int i=0; i < note.size(); i++)
		  if((( tempInt == 1) && 
				  (Pattern.matches(tempStr,note.get(i).getNoteSubject())==true)) //����� �� ��������
				  ||(( tempInt == 2) && 
						  (Pattern.matches(tempStr,note.get(i).getDateOfCreation())==true))//����� �� ����
				  ||(( tempInt == 3) && 
						  (Pattern.matches(tempStr,note.get(i).getEmail())==true))//����� �� �����
				  ||(( tempInt == 4) && 
						  (Pattern.matches(tempStr,note.get(i).getMessage())==true))//����� �� ���������
				  ||(( tempInt == 5) && 
						  (Pattern.matches(tempStr,note.get(i).getNoteSubject())==true)//�������� �����
						  && 
						  (Pattern.matches(tempStrGroup,note.get(i).getDateOfCreation())==true))
				  ) //����� � ������� ���������
      {
			  bol=true;
			  s1 = s1 + "\r\n  |+++++| ���� �������  : "
	            		+ ""+ note.get(i).getNoteSubject() + " "
	            				+ "  |+++++| ���� ��������  : "
	            					+ ""+note.get(i).getDateOfCreation()+"  "
	            							+ "  |+++++| �������� ������  : "
	    	            					+ ""+note.get(i).getEmail()+"  "
	    	            							+ "  |+++++| ��������� : "
	    	    	            					+ ""+note.get(i).getMessage()+" ";
      }
	  if(bol == true)
		 return "{" +
      " ���������� ������ : '"+
      "" + s1  + '\'' +
      '}';
	  else return "���������� �� �������!";
}
public String searchRegEx(String temp) {
	
	return temp;
}
public String scanerStr() {
	String temp;
    Scanner sc = new Scanner(System.in);//����� ����� ������ � main
    System.out.println("������� ������:");
    temp = sc.nextLine();
   // sc.close();
	return temp;
}

public String scanerStrDate() {//�������� �� ����
	boolean result=false;
	String temp;
    Scanner sc = new Scanner(System.in);//����� ����� ������ � main
    do {
    System.out.println("������� ������:");
    temp = sc.nextLine();
    result = temp.matches("\\d{2}([.])\\d{2}([.])\\d{4}");
	if(result){
	    System.out.println("�������� ��������!");
	}
	else{
	    System.out.println("������ �����! ����� ��� �����: 11.07.1992");    
	}
    }while(result!=true);
   // sc.close();
	return temp;
}

public String scanerStrEmail() {//�������� �� �����
	boolean result=false;
	String temp;
    Scanner sc = new Scanner(System.in);//����� ����� ������ � main
    do {
    System.out.println("������� ������:");
    temp = sc.nextLine();
    result = temp.matches("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}");
	if(result){
	    System.out.println("�������� ��������!");
	}
	else{
	    System.out.println("������ �����! ����� ��� �����: epam@gmail.com");    
	}
    }while(result!=true);
   // sc.close();
	return temp;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public List<Note> getNote() {
	return note;
}
public void setNote(List<Note> note) {
	this.note = note;
}
}
