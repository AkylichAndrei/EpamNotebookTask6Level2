package supportPackage;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import supportPackage.Note;

public class Notebook {//класс блокнот
private String name;//название блокнота
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
			  s=s + "\r\n  |+++++| Тема заметки: "
	            		+ ""+ note.get(i).getNoteSubject() + " "
	            				+ "|+++++| Дата создания  : "
	            					+ ""+note.get(i).getDateOfCreation()+"  "
	            							+ "  |+++++| Почтовый адресс  : "
	    	            					+ ""+note.get(i).getEmail()+"  "
	    	            							+ "  |+++++| Сообщение : "
	    	    	            					+ ""+note.get(i).getMessage()+"  "
	            						+ " ";
         
        }
		 return "{" +
        " Вы просматриваете Болкнот :'" + this.name  + " \r\n "+
        ", Список заметак в блокноте : ||'" + s  + '\'' +
        '}';
}
public String searchAll(String tempStr) {
	//"\\s*("+tempStr+")\\s*"
	String s1="",s2="";
	boolean bol=false;
	for (int i=0; i < note.size(); i++) {
	s1 = "\r\n  |+++++| Тема заметки  : "
    		+ ""+ note.get(i).getNoteSubject() + " "
    				+ "  |+++++| Дата создания  : "
    					+ ""+note.get(i).getDateOfCreation()+"  "
    							+ "  |+++++| Почтовый адресс  : "
            					+ ""+note.get(i).getEmail()+"  "
            							+ "  |+++++| Сообщение : "
    	            					+ ""+note.get(i).getMessage()+" ";
	Pattern pattern = Pattern.compile("\\s*("+tempStr+")\\s*");
    Matcher matcher = pattern.matcher(s1);
    if (matcher.find()==true)
    	s2=s2+s1;
    	bol=true;
	}
	if(bol == true)
		 return "{" +
     " Результаты поиска : '"+
     "" + s2  + '\'' +
     '}';
	  else return "Совпадений не найдено!";
}
public String searchNoteSubject(String tempStr, int tempInt ,String tempStrGroup) {//поиск по теме
	String s1 = "";
	boolean bol=false;
	  for (int i=0; i < note.size(); i++)
		  if((( tempInt == 1) && 
				  (Pattern.matches(tempStr,note.get(i).getNoteSubject())==true)) //поиск по названию
				  ||(( tempInt == 2) && 
						  (Pattern.matches(tempStr,note.get(i).getDateOfCreation())==true))//поиск по дате
				  ||(( tempInt == 3) && 
						  (Pattern.matches(tempStr,note.get(i).getEmail())==true))//поиск по почте
				  ||(( tempInt == 4) && 
						  (Pattern.matches(tempStr,note.get(i).getMessage())==true))//поиск по сообщению
				  ||(( tempInt == 5) && 
						  (Pattern.matches(tempStr,note.get(i).getNoteSubject())==true)//гркповой поиск
						  && 
						  (Pattern.matches(tempStrGroup,note.get(i).getDateOfCreation())==true))
				  ) //поиск с помощью регулярки
      {
			  bol=true;
			  s1 = s1 + "\r\n  |+++++| Тема заметки  : "
	            		+ ""+ note.get(i).getNoteSubject() + " "
	            				+ "  |+++++| Дата создания  : "
	            					+ ""+note.get(i).getDateOfCreation()+"  "
	            							+ "  |+++++| Почтовый адресс  : "
	    	            					+ ""+note.get(i).getEmail()+"  "
	    	            							+ "  |+++++| Сообщение : "
	    	    	            					+ ""+note.get(i).getMessage()+" ";
      }
	  if(bol == true)
		 return "{" +
      " Результаты поиска : '"+
      "" + s1  + '\'' +
      '}';
	  else return "Совпадений не найдено!";
}
public String searchRegEx(String temp) {
	
	return temp;
}
public String scanerStr() {
	String temp;
    Scanner sc = new Scanner(System.in);//поток будет закрыт в main
    System.out.println("Введите данные:");
    temp = sc.nextLine();
   // sc.close();
	return temp;
}

public String scanerStrDate() {//проверка на дату
	boolean result=false;
	String temp;
    Scanner sc = new Scanner(System.in);//поток будет закрыт в main
    do {
    System.out.println("Введите данные:");
    temp = sc.nextLine();
    result = temp.matches("\\d{2}([.])\\d{2}([.])\\d{4}");
	if(result){
	    System.out.println("проверка пройдена!");
	}
	else{
	    System.out.println("ошибка ввода! прмер для ввода: 11.07.1992");    
	}
    }while(result!=true);
   // sc.close();
	return temp;
}

public String scanerStrEmail() {//проверка на почту
	boolean result=false;
	String temp;
    Scanner sc = new Scanner(System.in);//поток будет закрыт в main
    do {
    System.out.println("Введите данные:");
    temp = sc.nextLine();
    result = temp.matches("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}");
	if(result){
	    System.out.println("проверка пройдена!");
	}
	else{
	    System.out.println("ошибка ввода! прмер для ввода: epam@gmail.com");    
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
