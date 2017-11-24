//shahad almuhizi
//436201525
import java.util.*;
import java.io.*;
public class Application{
private static int  appcount=0;
private static Student[] studentList=new Student[100];
//*************
//addStudent method
//*************
public static void addStudent(Student s){
studentList[appcount++]=s;}
//*************
//removeStudent method
//*************
public static void removeStudent(int id)throws NotFoundException{
int count=-1;
for (int i=0;i<appcount;i++)
if (studentList[i].getId()==id)
count=i;
if (count!=-1){
for (int s=count;s<appcount-1;s++)
studentList[s]=studentList[s+1];
studentList[--appcount]=null;}
if (count==-1)
throw new NotFoundException ("Student Is Not Found");}
//*************
//MAIN
//*************
public static void main (String[] args){
Scanner input=new Scanner (System.in);
int choice=0;
try {//open big try
//*************
//reading text file
//*************
File text=new File("students(1).txt");
Scanner console=new Scanner(text);
while (console.hasNext()){
try{//open try
String infor=console.nextLine();
int seperator=infor.indexOf('-');
String name=infor.substring(0,seperator);
int sep2=infor.indexOf('-',seperator+1);
String id=infor.substring(seperator+1,sep2);
int id11= Integer.parseInt(id);
String gpa=infor.substring(sep2+1);
double gpa1=Double.parseDouble(gpa);
Student s=new Student (name,id11,gpa1);
addStudent(s);//adding to studentList
}//close try
catch (ArrayIndexOutOfBoundsException e){
System.out.println("The array is full");}//close catch
catch (NumberFormatException e){
System.out.println(e.getMessage());}//close catch
}//close while
//close reading text
console.close();
}//close big try
catch (IOException e){
System.out.println(e.getMessage());}//close catch

//*************
//reading data file
//*************
try {//open big try

File f=new File("students.data");
FileInputStream InF=new FileInputStream(f);
ObjectInputStream DF=new ObjectInputStream(InF);

boolean ok=true;
Student stud;
while (ok){//open while
try{//open try
stud=(Student)DF.readObject();
addStudent(stud);//adding to studentList
}//close try
catch (EOFException e){
ok=false;}//close catch
catch (ArrayIndexOutOfBoundsException e){
System.out.println("The array is full");}//close catch
}//close while
DF.close();
}//close big try
catch (IOException e){
System.out.println(e.getMessage());}//close catch
catch (ClassNotFoundException e){
System.out.println(e.getMessage());}//close catch

//close reading data
for (int i=0;i<appcount;i++)
System.out.println(studentList[i]+"\n");//printing all files
//*************
//menu
//*************
do {

try {
System.out.println("Choose the number you want:\n1.Add a new Student.\n2.Delete a Student.\n3.Display.\n4.Exit");
choice=input.nextInt();}//close try
catch (InputMismatchException e){
System.out.println("Invalid Input, Intgers Only");
input.next();}//close catch


switch (choice){

case 1://ADD A STUDENT
try {
System.out.println("Enter The Student's Information :");
System.out.println("Name:");
String n=input.next();
System.out.println("ID:");
int id1=input.nextInt();
System.out.println("GPA:");
double ggpa=input.nextDouble(); 
Student student=new Student (n,id1,ggpa);
addStudent(student);
System.out.println("The Student is Added");
}//close try
catch (InputMismatchException e){
System.out.println("Invalid Input");
input.next();}//close catch
catch (ArrayIndexOutOfBoundsException e){
System.out.println("Unsuccessful Addition,The Array Is Full");}//close catch
break;

case 2://DELETE A STUDENT
try {
System.out.println("Enter The ID Of The Student You Want To Delete:");
int idd=input.nextInt();
removeStudent(idd);
System.out.println("The Student is Deleted");
}//close try
catch (InputMismatchException e){
System.out.println("Invalid Input");
input.next();}//close catch
catch (NotFoundException e){
System.out.println("The Student Is Not Found");}//close catch

break;

case 3://DISPLAY
for (int i=0;i<appcount;i++)
System.out.println(studentList[i]);
break;

case 4://writing studentList in a new file,then Exit
try {//open try
File g=new File("updatedStudents.data");
FileOutputStream FoS=new FileOutputStream(g);
ObjectOutputStream Os=new ObjectOutputStream(FoS);

for (int i=0;i<appcount;i++)
Os.writeObject(studentList[i]);
Os.close();//close writing
}//close try
catch (IOException e){
System.out.println(e.getMessage());}//close catch
break;

}
if (choice>=5)//If the input is >4
System.out.println("invalid input, Enter from 1-4");
}while (choice!=4);//while codition
//}close try
//catch (IOException e){
//System.out.println(e.getMessage());}//close catch
//catch (ClassNotFoundException e){
//System.out.println(e.getMessage());}//close catch
}//close main
}//close class










