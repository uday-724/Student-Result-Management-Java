import java.util.*;
//student_class
class Student{
    int id;
    String name;
    int[]marks=new int[3];
    static String[] SubjectNames={"Maths", "English", "Telugu"};
    Student(int id, String name,int[]marks){
        this.id=id;
        this.name=name;
        this.marks=marks;
    }
    double getAverage(){
        return(marks[0]+marks[1]+marks[2])/3.0;
    }
    String getGrade(){
        double avg = getAverage();
        if(avg >= 90){
        System.out.println("Congrats,YOU ARE PROMOTED");
            return "A";
        }
            else if(avg>=75){
            System.out.println("Congrats,YOR ARE PROMOTED");
            return "B";
            }
            else if(avg>=60){
            System.out.println("Congrats,YOU PASSED THE EXAM");
            return "C";
            }
            else{
                System.out.println("Sorry,BETTER LUCK NEXT TIME!!!");
                return "D";
            }
    }
    void display(){
        System.out.println("\nID: "+id);
        System.out.println("\nName: "+name);
        for(int i=0; i<marks.length;i++){
            System.out.println("Subject"+(i+1)+" - "+SubjectNames[i]+" - "+marks[i]);
        }
System.out.printf("Average:%.2f\n",getAverage());
System.out.printf("Grade:"+getGrade());
    }
}
//main class
public class StudentManagement{
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    //mainmenu and loop
    public static void main(String args[]){
        int choice;
        do{
            System.out.println("\n1. Add Student: \n2. View Students:\n3. Search Student By ID:\n4. Delete Student By ID:\n5. Exit:");
            System.out.println("Enter Your Choice: ");
choice=sc.nextInt();
switch(choice){
    case 1: addStudent();
    break;
    case 2: viewStudents();
    break;
    case 3: searchStudent();
    break;
    case 4: deleteStudent();
    break;
    case 5:System.out.println("Exiting.....");
    break;
    default:System.out.println("Invalid Choice!");
}
        }
while(choice!=5);
    }
    //addstudent
    static void addStudent(){
System.out.print("Enter ID: ");
int id = sc.nextInt();
sc.nextLine();
System.out.print("Enter Name: ");
String name = sc.nextLine();
int[]marks = new int[3];
System.out.println("Enter the marks  of 3 subjects");
for(int i=0;i<3;i++){
    System.out.print(Student.SubjectNames[i]+" : ");
    marks[i]=sc.nextInt();
}
students.add(new Student(id,name,marks));
System.out.println("Student added Successfully!!");
    }
    //viewstudents
    static void viewStudents(){
        if(students.isEmpty()){
        System.out.println("No Students to display");
        return;    
        }
    System.out.println("\n---Students List---");
    for(Student s : students){
        s.display();
    }
}
//search student
static void searchStudent(){
    System.out.println("Enter the Student ID: ");
    int id = sc.nextInt();
    boolean found = false;
    for(Student s : students){
if(s.id==id){
    s.display();
    found=true;
    break;
}
    }
    if(!found){
        System.out.println("Student Not Found");
    }
}
//delete student
static void deleteStudent(){
    System.out.println("Enter Id to delete: ");
    int id = sc.nextInt();
    Iterator<Student> it = students.iterator();
    boolean removed = false;
    while(it.hasNext()){
        if(it.next().id == id){
            it.remove();
            removed=true;
            System.out.println("Student Removed!!!");
            break;
        }
    }
    if(!removed)
    System.out.println("ID Not Found!!");

}
}

