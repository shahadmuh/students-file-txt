//Shahad almuhizi
//436201525
import java.io.*;
public class Student implements Serializable{
public static final long serialVersionUID = 3984983569413957335L;
private String name;
private int id;
private double gpa;

public Student(String name,int id,double gpa){
this.name=name;
this.id=id;
this.gpa=gpa;}

public int getId(){
return id;}

public String toString(){
return "Name: "+name+"\tID: "+id+"\tGPA: "+gpa+"\n";}
}