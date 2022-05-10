package mainPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import supportPackage.Note;
import supportPackage.Notebook;
import java.io.*;

public class Task6 {

	public static void main(String[] args) throws Exception { //���������� ����� (������������ ������� �����)
		   
		
		List<Notebook> notebook = new ArrayList<>();
		List<Note> note = new ArrayList<>();
		String tempStr1,tempStr2,tempStr3,tempStr4;
		String tempStr,tempGroup;
		int tempInt;
		 //������������ ����� C:\Users\Pc\eclipse-workspace\Task 6
		   FileReader fr = new FileReader( "Note.txt" );
		   Scanner scan2 = new Scanner(fr);
		   
		   //��������� ��� ������� �� �����
		   while (scan2.hasNextLine()) {
	            Note objNote = new Note(scan2.nextLine(), scan2.nextLine(),
	            			 scan2.nextLine(), scan2.nextLine());
	            note.add(objNote);
	       }
		   Collections.sort(note);
		   

	       //�������� ������� � �������� ���� �������
	       Notebook objNotebook = new Notebook("������� 1",note);
	       notebook.add(objNotebook);
	     
	       
	       Scanner scan = new Scanner(System.in);
	       int x = 0;
	       String s ="";
	       
	       while (!"4".equals(s)){
	           System.out.println("1. ��� ��������� ����������� �������� ������� ==> 1");
	           System.out.println("2. ��� ������ �� ��������� ������� ==> 2");
	           System.out.println("3. ��� ���������� ����� ������ ������� ==> 3");
	           System.out.println("4. ��� ������ ������� ==> 4");
	           s = scan.next();
	           try {
	               x = Integer.parseInt(s);
	           } catch (NumberFormatException e){
	               System.out.println("�������� ����");
	           }
	           switch (x){
	               case 1:	
	                   // ����� ������ 1
	               	System.out.println("===== ������ ����� ���� 1 =====");
	                for (Notebook u : notebook) {
	                	
	          	    	System.out.println(u);
	          	    }
	                   break;
	               case 2:
	                   // ����� ������ 2
	               	System.out.println("===== ������ ����� ���� 2 =====");
	                while (!"7".equals(s)){
	     	           System.out.println("1. ��� ������ �� ����  ������� ==> 1");
	     	           System.out.println("2. ��� ������ �� ���� ��������  ������� ==> 2");
	     	           System.out.println("3. ��� ������ �� ����� ������� ==> 3");
	     	           System.out.println("4. ��� ������ �� ������ ��������� ������� ==> 4");
	     	           System.out.println("5. ��� ������ �� ������ ����������(�� ���� � ����) ==> 5");
	     	          System.out.println("6. ��� ������ �� ����� ������ �������� ������� ==> 6");
	     	           System.out.println("7. ��� ������ ������� ==> 7");
	     	           s = scan.next();
	     	           try {
	     	               x = Integer.parseInt(s);
	     	           } catch (NumberFormatException e){
	     	               System.out.println("�������� ����");
	     	           }
	     	           switch (x){
	     	               case 1:	
	     	                   // ����� ������ 1
	     	               	System.out.println("===== ������ ����� ���� 1 =====");
	     	               tempStr = objNotebook.scanerStr();
	     	               tempInt=1; tempGroup="";
	     	               System.out.println(" "+objNotebook.searchNoteSubject(tempStr,tempInt,tempGroup));
	     	                   break;
	     	               case 2:
	     	                   // ����� ������ 2
	     	               	System.out.println("===== ������ ����� ���� 2 =====");
	     	               tempStr = objNotebook.scanerStr();
	     	               tempInt=2; tempGroup="";
	     	               System.out.println(" "+objNotebook.searchNoteSubject(tempStr,tempInt,tempGroup));
	     	               break;
	     	               case 3:
	     	            	   System.out.println("===== ������ ����� ���� 3 =====");
	     	            	  tempStr = objNotebook.scanerStr();
		     	               tempInt=3; tempGroup="";
		     	               System.out.println(" "+objNotebook.searchNoteSubject(tempStr,tempInt,tempGroup));
	     	                  break;
	     	              case 4:
	     	            	   System.out.println("===== ������ ����� ���� 4 =====");
	     	            	  tempStr = objNotebook.scanerStr();
		     	              tempInt=4;
		     	              tempGroup= "";
		     	               System.out.println(" "+objNotebook.searchNoteSubject(tempStr,tempInt,tempGroup));
	     	                  break;
	     	             case 5:
	     	            	   System.out.println("===== ������ ����� ���� 5 =====");
	     	            	  tempStr = objNotebook.scanerStr();
		     	              tempInt = 5;
		     	              tempGroup = objNotebook.scanerStr();
		     	               System.out.println(" "+objNotebook.searchNoteSubject(tempStr,tempInt,tempGroup));
	     	                  break;
	     	            case 6:
	     	            	   System.out.println("===== ������ ����� ���� 6 =====");
	     	            	  tempStr = objNotebook.scanerStr();
		     	               System.out.println(" "+objNotebook.searchAll(tempStr));
	     	                  break;
	     	           }
	     	       }
	               	 
	                   break;
	               case 3:
	            	   System.out.println("===== ������ ����� ���� 3 =====");
	                   // ����� ������ 3
	            	   //����� ������
	            	   System.out.println("������� ����:");tempStr1=objNotebook.scanerStr();
	            	   System.out.println("������� ����:");tempStr2=objNotebook.scanerStrDate();
	            	   System.out.println("������� �����:");tempStr3=objNotebook.scanerStrEmail();
	            	   System.out.println("������� ���������:");tempStr4=objNotebook.scanerStr();
	            	   Note objNote = new Note(tempStr1, tempStr2 , tempStr3 , tempStr4);//�������� ����� �����
		               note.add(objNote);//������� ��� � ���������
		               
		               objNote.delFile();
		               for(Note u : note)
		               objNote.add(u.getNoteSubject(), u.getDateOfCreation(), u.getEmail(), u.getMessage());
		               
		               objNotebook=null; notebook.clear();
		               
		               Notebook objNotebook2 = new Notebook("������� 1",note);
		    	       notebook.add(objNotebook2);
	                   break;
	           }
	       }
	       System.out.println("�� ��������!");
	       scan.close();
	       scan2.close();
	       fr.close();
	       
	}

}
