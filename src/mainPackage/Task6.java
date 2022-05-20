package mainPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import supportPackage.Note;
import supportPackage.Notebook;
import java.io.*;

public class Task6 {

	public static void main(String[] args) throws Exception { //волшебнная фраза (безопасность привыше всего)
		List<Notebook> notebook = new ArrayList<>();
		List<Note> note = new ArrayList<>();
		String tempStr1,tempStr2,tempStr3,tempStr4;
		String tempStr,tempGroup;
		int tempInt;
		 //расположение файла C:\Users\Pc\eclipse-workspace\Task 6
		   FileReader fr = new FileReader( "Note.txt" );
		   Scanner scan2 = new Scanner(fr);
		   //прочитаем все заметки из файла
		   while (scan2.hasNextLine()) {
	            Note objNote = new Note(scan2.nextLine(), scan2.nextLine(),
	            			 scan2.nextLine(), scan2.nextLine());
	            note.add(objNote);
	       }
		   Collections.sort(note);
	       //создадим блокнот и поместим туда заметки
	       Notebook objNotebook = new Notebook("Блокнот 1",note);
	       notebook.add(objNotebook);
	     
	       Scanner scan = new Scanner(System.in);
	       int x = 0;
	       String s ="";
	       
	       while (!"4".equals(s)){
	           System.out.println("1. Для просмотра содержимого блокнота введите ==> 1");
	           System.out.println("2. Для поиска по параметру введите ==> 2");
	           System.out.println("3. Для добавления новой записи введите ==> 3");
	           System.out.println("4. Для выхода введите ==> 4");
	           s = scan.next();
	           try {
	               x = Integer.parseInt(s);
	           } catch (NumberFormatException e){
	               System.out.println("Неверный ввод");
	           }
	           switch (x){
	               case 1:	
	                   // вызов метода 1
	               	System.out.println("===== Выбран пункт меню 1 =====");
	                for (Notebook u : notebook) {
	                	
	          	    	System.out.println(u);
	          	    }
	                   break;
	               case 2:
	                   // вызов метода 2
	               	System.out.println("===== Выбран пункт меню 2 =====");
	                while (!"7".equals(s)){
	     	           System.out.println("1. Для поиска по теме  введите ==> 1");
	     	           System.out.println("2. Для поиска по дате создания  введите ==> 2");
	     	           System.out.println("3. Для поиска по почте введите ==> 3");
	     	           System.out.println("4. Для поиска по тексту сообщения введите ==> 4");
	     	           System.out.println("5. Для поиска по группе параметров(По теме и дате) ==> 5");
	     	          System.out.println("6. Для поиска по любой группе символов введите ==> 6");
	     	           System.out.println("7. Для выхода введите ==> 7");
	     	           s = scan.next();
	     	           try {
	     	               x = Integer.parseInt(s);
	     	           } catch (NumberFormatException e){
	     	               System.out.println("Неверный ввод");
	     	           }
	     	           switch (x){
	     	               case 1:	
	     	                   // вызов метода 1
	     	               	System.out.println("===== Выбран пункт меню 1 =====");
	     	               tempStr = objNotebook.scanerStr();
	     	               tempInt=1; tempGroup="";
	     	               System.out.println(" "+objNotebook.searchNoteSubject(tempStr,tempInt,tempGroup));
	     	                   break;
	     	               case 2:
	     	                   // вызов метода 2
	     	               	System.out.println("===== Выбран пункт меню 2 =====");
	     	               tempStr = objNotebook.scanerStr();
	     	               tempInt=2; tempGroup="";
	     	               System.out.println(" "+objNotebook.searchNoteSubject(tempStr,tempInt,tempGroup));
	     	               break;
	     	               case 3:
	     	            	   System.out.println("===== Выбран пункт меню 3 =====");
	     	            	  tempStr = objNotebook.scanerStr();
		     	               tempInt=3; tempGroup="";
		     	               System.out.println(" "+objNotebook.searchNoteSubject(tempStr,tempInt,tempGroup));
	     	                  break;
	     	              case 4:
	     	            	   System.out.println("===== Выбран пункт меню 4 =====");
	     	            	  tempStr = objNotebook.scanerStr();
		     	              tempInt=4;
		     	              tempGroup= "";
		     	               System.out.println(" "+objNotebook.searchNoteSubject(tempStr,tempInt,tempGroup));
	     	                  break;
	     	             case 5:
	     	            	   System.out.println("===== Выбран пункт меню 5 =====");
	     	            	  tempStr = objNotebook.scanerStr();
		     	              tempInt = 5;
		     	              tempGroup = objNotebook.scanerStr();
		     	               System.out.println(" "+objNotebook.searchNoteSubject(tempStr,tempInt,tempGroup));
	     	                  break;
	     	            case 6:
	     	            	   System.out.println("===== Выбран пункт меню 6 =====");
	     	            	  tempStr = objNotebook.scanerStr();
		     	               System.out.println(" "+objNotebook.searchAll(tempStr));
	     	                  break;
	     	           }
	     	       }
	               	 
	                   break;
	               case 3:
	            	   System.out.println("===== Выбран пункт меню 3 =====");
	                   // вызов метода 3
	            	   //введём данные
	            	   System.out.println("ВВедите тему:");tempStr1=objNotebook.scanerStr();
	            	   System.out.println("ВВедите дату:");tempStr2=objNotebook.scanerStrDate();
	            	   System.out.println("ВВедите почту:");tempStr3=objNotebook.scanerStrEmail();
	            	   System.out.println("ВВедите сообщение:");tempStr4=objNotebook.scanerStr();
	            	   Note objNote = new Note(tempStr1, tempStr2 , tempStr3 , tempStr4);//создадим новый объкт
		               note.add(objNote);//закинем его в коллекцию
		               
		               objNote.delFile();
		               for(Note u : note)
		               objNote.add(u.getNoteSubject(), u.getDateOfCreation(), u.getEmail(), u.getMessage());
		               
		               objNotebook=null; notebook.clear();
		               
		               Notebook objNotebook2 = new Notebook("Блокнот 1",note);
		    	       notebook.add(objNotebook2);
	                   break;
	           }
	       }
	       System.out.println("До свидания!");
	       scan.close();
	       scan2.close();
	       fr.close();
	       
	}

}
