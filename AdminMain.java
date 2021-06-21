package com.company;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminMain {

    Scanner input = new Scanner(System.in);
    int choice;
    String[][] student; /* to keep student name, student regNo, student Dept */
    int[] students; /* to keep student number of subjects */
    String faculty[][]; // to store faculty name, iD, Dept
    Class[] classes = new Class[2];

    /* create file to save student data */

    File studentData = new File ("C:\\Users\\Dell\\Desktop\\School Management v2.1\\src\\com\\company\\studentData.txt");

    //create a file in the source folder to save all the faculty information

    File facultyData = new File("C:\\Users\\Dell\\Desktop\\School Management v2.1\\src\\com\\company\\facultyData.txt");

    // create file to store all classes in the system

    File classesData = new File("C:\\Users\\Dell\\Desktop\\School Management v2.1\\src\\com\\company\\classesData.txt");



    AdminMain(){

        adminMenu();

    }

    public void adminMenu() {

        do{
            try{

                //menu display

                System.out.println("");
                System.out.println("******* Admin Menu *******");
                System.out.println("(1) Student Management");
                System.out.println("(2) Faculty Management");
                System.out.println(("(3) Classes Management"));
                System.out.println(("(4) Exit Program"));
                System.out.print("\nPick an option: ");

                //get user input

                choice = input.nextInt();

                switch(choice){
                    case 1:
                        System.out.println("[student management code runs...]");
                        adminStudentManagement();
                        break;
                    case 2:
                        System.out.println("[faculty management code runs...]");
                        adminFacultyManagement();
                        break;
                    case 3:
                        System.out.println("[classes management code runs...]");
                        adminClassesManagement();
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid Choice!");

                }

            } catch (InputMismatchException ex){
                System.out.println("Please insert A Valid Input.");
                input.nextLine();
            }
        } while (choice!=5);
    }



    public void adminStudentManagement() {


        do{
            try{

                //menu display
                System.out.println("");
                System.out.println("******* Student Menu *******");
                System.out.println("(1) Add Student");
                System.out.println("(2) View Student");
                System.out.println(("(3) Search Student"));
                System.out.println(("(4) Back"));
                System.out.print("\nPick an option: ");

                //get user input
                choice = input.nextInt();

                switch(choice){
                    case 1:
                        System.out.println("[Add student code runs...]");
                        addStudent();
                        break;
                    case 2:
                        System.out.println("[view student code runs...]");
                        viewStudent();
                        break;
                    case 3:
                        System.out.println("[search student code runs...]");
                        searchStudent(student, students);
                        break;
                    case 4:
                        adminMenu();

                        break;
                    default:
                        System.out.println("Invalid Choice!");

                }

            } catch (InputMismatchException | FileNotFoundException ex){
                System.out.println("Please insert A Valid Input.");
                input.nextLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (choice!=5);
    }




    public void addStudent() throws InputMismatchException {

        System.out.println("");
        System.out.println("***** Add Student *****");

        int f =0;

        // ' if ' block will run after there is student data added once in ' else ' block first */

        if (f != 0) {

            System.out.print("How many students would you like to add? : ");
            int i = input.nextInt();

            /* pass student array containing name regNo and Dept of student to method addStudentData */

            student = addStudentData(student, i);

            /* pass students array containing number of subjects to method addStudentSubjectsData*/

            students = addStudentSubjectsData(students, i);
        }

        else {
            System.out.print("How many students would you like to add? : ");
            int i = input.nextInt();

            student = new String[i][3];
            students = new int[i];

            for (int j = 0; j < students.length; j++) {



                //store name of student in string name

                System.out.print("Enter name of student: ");
                String name = input.next();

                // insert name in appropriate index of student array

                student[j][0] = name;

                //similarly with RegNo and Dept of student

                System.out.print("Enter Reg no of student: ");
                String reg_no = input.next();
                student[j][1] = reg_no;


                System.out.print("Enter Department of student: ");
                String dep = input.next();
                student[j][2] = dep;


                System.out.print("Enter no of subjects: ");
                int subj = input.nextInt();
                if (subj > 7) {
                    System.out.print("Maximum subjects can be seven\nEnter valid no. of subjects: ");
                    subj = input.nextInt();
                    students[j] = subj;
                } else {
                    students[j] = subj;
                }
            }
            f = i;
        }
    }

    public String[][] addStudentData(String[][] student, int i) { /* called in line78 */

        //passed array student is the student array
        //initialize a new array with increased number of rows so that it can store the old data plus have more space for new data to be entered

        String[][] list = new String[ i + student.length][3];

        // go through the new array

        for (int j = 0; j < list.length; j++) {

            //match the indexes of the old array with the new array
            /* copy the data from student array to newly formed list array */

            if (j < student.length) {
                list[j][0] = student[j][0];
                list[j][1] = student[j][1];
                list[j][2] = student[j][2];
            }

            /* once old data copied, else block will get new data and store in the same array initialized */

            else {


                System.out.println("Enter name of student: ");
                String name = input.next();
                list[j][0] = name;

                System.out.println("Enter Reg no of student: ");
                String reg_no = input.next();
                list[j][1] = reg_no;

                System.out.println("Enter Department of student: ");
                String dep = input.next();
                list[j][2] = dep;
            }
        }

        /* return list which now contains old data and new data */

        return list;
    }



    public int[] addStudentSubjectsData(int[] students, int i) { /* called in line82 */

        /*initialize new array with extra size to store old number of subjects as well as new number of subjects */

        int[] list = new int[students.length + i];

        /* copy number of subjects from old students array to newly initialized array */

        for (int j = 0; j < list.length; j++) {
            if (j < students.length) {
                list[j] = students[j];
            }

            /* once old data is copied, else block will get new data and store in the same array */

            else {
                System.out.println("Enter number of subjects: ");
                int a = input.nextInt();
                if (a > 7) {
                    System.out.println("Maximum subjects can be seven\nEnter valid no. of subjects");
                    a = input.nextInt();
                    list[j] = a;
                } else {
                    list[j] = a;
                }
            }
        }

        /* return list which now contains old number of subjects as well as new number of subjects */

        return list;
    }




    public void viewStudent() throws IOException {

        saveFile( student, students) ;

    }


    public void saveFile(String[][] student, int[] students) throws IOException {


        /* creating print writer object to store student data in text file studentData.txt*/

        FileWriter out = new FileWriter("studentData.txt", true);

        try{


            for (int j = 0; j < student.length; j++) {

                /* write to file studentData */
                out.write("++++ ADDED STUDENTS ++++\n");
                out.write("Student " + j + "\nName of student: " + student[j][0] + "\nReg no. of student: " + student[j][1] + "\nDepartment of student: " + student[j][2] + "\nNo. of subjects: " + students[j] + "\n\n");
            }
            /* always close print writer */

            out.close();

            /* calling printFile() method to print contents of file in the console */

            printFile();

        }catch(NullPointerException | IOException ex){
            System.out.println("No Data Found!");
            adminStudentManagement();
        }
    }


    public static void printFile() {

        String fname;
        Scanner scan = new Scanner(System.in);

        /* enter filename with extension to open and read its content */

        System.out.print("Enter File Name to Open with Extension (studentData.txt/facultyData.txt/classesData,txt/attendData.txt) : ");
        fname = scan.nextLine();

        /* this will reference only one line at a time */

        String line = null;

        try
        {
            /* FileReader reads text files in the default encoding */

            FileReader fileReader = new FileReader(fname);

            /* always wrap the FileReader in BufferedReader */

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null)
            {
                System.out.println(line);
            }

            /* always close the file after use */

            bufferedReader.close();
        }
        catch(IOException ex)
        {
            System.out.println("Invalid File Name.");
            System.out.println("Error reading file named '" + fname + "'");
        }
    }



    public void searchStudent(String[][] student, int[] students) {

        System.out.println("\n**** Search Students ****");

        int k = 1;
        while (k == 1) {

            //get regNo of student to be searched

            System.out.print("Enter Reg no of student: ");
            String reg = input.next();

            //go through the data array in which student information is stored

            for (int i = 0; i < student.length; i++) {

                if (reg.equals(student[i][1])) {
                    System.out.println("");
                    System.out.println("Data Found!");
                    System.out.println("Name of student:" + student[i][0] + "\nReg no. of Student: " + student[i][1] + "\nDepartment of student " + student[i][2] + "\nNo. of subjects: " + students[i] + "\n");
                    break;
                } else if (i == (student.length - 1)) {
                    System.out.println("No result");
                }
            }
            System.out.print("Press|1| To Search Record Again\nPress|0| To Exit: ");
            k = input.nextInt();
        }
    }







    public void adminFacultyManagement(){
        do{
            try{

                //menu display

                System.out.println("");
                System.out.println("******* Faculty Menu *******");
                System.out.println("(1) Add Faculty");
                System.out.println("(2) View Faculty");
                System.out.println(("(3) Search Faculty"));
                System.out.println(("(4) Back"));
                System.out.print("\nPick an option: ");

                //get user input

                choice = input.nextInt();

                switch(choice){
                    case 1:
                        System.out.println("[Add faculty code runs...]");
                        addFaculty();
                        break;
                    case 2:
                        System.out.println("[view faculty code runs...]");
                        viewFaculty();
                        break;
                    case 3:
                        System.out.println("[search faculty code runs...]");
                        searchFaculty(faculty);
                        break;
                    case 4:
                        adminMenu();

                        break;
                    default:
                        System.out.println("Invalid Choice!");

                }

            } catch (InputMismatchException | FileNotFoundException ex){
                System.out.println("Please insert A Valid Input.");
                input.nextLine();
            }
        } while (choice!=5);
    }



    public void addFaculty() throws InputMismatchException {

        System.out.println("***** Add Faculty *****");
        int g = 0;

        /* if block will run once some data has been added in the else block */

        if(g!=0){
            System.out.print("How many Staff Members would you like to add: ");
            int a=input.nextInt();

            faculty= newAddFaculty(faculty,a);
        }
        else{
            System.out.print("How many Staff Members would you like to add: ");
            int n=input.nextInt();

            faculty = new String[n][3];

            /* go through all the rows and insert information in appropriate columns */

            for(int j=0;j<faculty.length;j++){

                System.out.print("Enter Name of Staff member: ");

                /* get name of staff member and store in variable 'name' */

                String name=input.next();

                /* store name into 0th index of faculty array */

                faculty[j][0] = name;

                /* similarly for ID and Dept but for index 1 and 2 */

                System.out.print("Enter ID of Staff member: ");
                String ID = input.next();
                faculty[j][1]= ID;

                System.out.print("Enter Dept. of Staff members: ");
                String dep=input.next();
                faculty[j][2] = dep;

            }
            g=n;
        }
    }

    public String [][] newAddFaculty(String [][] facultyDataArray, int n){

        //initialize a new array with increased size so that old data is saved into it and has space for new data
        //n is the number of staff members entered by user

        String [][] list=new String[n+ facultyDataArray.length][3];

        //go through rows of new array

        for(int j=0;j<list.length;j++){

            //match the indexes of the old array with the new array
            /* copy the data from student array to newly formed list array */

            if(j< facultyDataArray.length){

                list[j][0]= facultyDataArray[j][0];
                list[j][1]= facultyDataArray[j][1];
                list[j][2]= facultyDataArray[j][2];
            }

            /* once old data copied, else block will get new data and store in the same array initialized in line118 */

            else{

                System.out.print("Enter name of staff members you would like to add: ");
                String name=input.next();
                list[j][0]=name;

                System.out.print("Enter ID of staff member: ");
                String id=input.next();
                list[j][1]=id;

                System.out.print("Enter Department of staff member: ");
                String dep=input.next();
                list[j][2]=dep;
            }
        }

        /* return list which now contains old data and new data */

        return list;
    }



    public void viewFaculty() throws FileNotFoundException {

        /* calls saveFIle method and passes array containing faculty name, iD and Dept */

        saveFile ( faculty) ;
    }


    /* save the faculty array by printing the data in a text file */

    public void saveFile(String[][] faculty) throws FileNotFoundException {

        /* creating print writer object to store student data in text file facultyData.txt*/

        PrintWriter pr = new PrintWriter("facultyData.txt");

        try{
            for(int j=0;j<faculty.length;j++){
                pr.println("++++ ADDED STAFF MEMBERS ++++");
                pr.println("Staff Member " + j + "\nName of staff member: "+faculty[j][0] + "\nName of staff member: "+faculty[j][0] + "\nID of staff member: "+faculty[j][1] + "\nDepartment of staff member: "+faculty[j][2]);
            }
            /* always close print writer */

            pr.close();

            /* call printFle method to read and print data from file to the console */

            printFile();

        }catch(NullPointerException ex){
            System.out.println("No data found!");
            adminFacultyManagement();
        }
    }



    /* linear search by iD */

    public void searchFaculty(String[][]list1){

        System.out.println("***** Search Faculty *****");

        /* get ID to be searched by user */

        System.out.print("Enter ID of faculty: ");
        String ID =input.next();


        for(int i=0;i<list1.length;i++){

            /* if entered ID matches with ID stored in facultyDataArray then print data */

            if(ID.equals(list1[i][1])){

                System.out.println("Name of staff member:"+list1[i][0]+"\nID of staff member: "+list1[i][1]+"\nDepartment of staff member "+list1[i][2]+ "\n");

                break;
            }

            else if(i==(list1.length-1)){
                System.out.println("No result");
                adminFacultyManagement();
            }
        }
    }






    public void adminClassesManagement() {

        do{
            try{

                //menu display

                System.out.println("******* Class Menu *******");
                System.out.println("(1) Add Class");
                System.out.println("(2) Remove Class");
                System.out.println("(3) View Class");
                System.out.println(("(4) Exit"));
                System.out.print("\nPick an option: ");

                //get user input

                choice = input.nextInt();

                switch(choice){
                    case 1:
                        System.out.println("Add class code runs");
                        addClass();
                        break;
                    case 2:
                        System.out.println("Remove class code runs");
                        removeClass();
                        break;
                    case 3:
                        System.out.println("View class code runs");
                        viewClasses();
                        break;
                    case 4:
                        System.out.println("exited.");
                        adminMenu();

                        break;
                    default:
                        System.out.println("Invalid Choice!");

                }

            } catch (InputMismatchException | FileNotFoundException ex){
                System.out.println("Please insert A Valid Input.");
                input.nextLine();
            }
        } while (choice!=5);
    }



    public void addClass(){

        String className;
        String courseCode;
        int classStrength;

        while (true){

            if (classes.length == Class.classesCount){
                Class[] temp = new Class[classes.length*2];

                for (int i = 0;i<classes.length;i++){
                    temp[i] = classes[i];
                }
                classes = temp;
            }

            System.out.println("<<Add Class>>");

            while (true){

                System.out.print("Enter Class Name >> ");
                className = input.nextLine();

                boolean used = false;

                for (int i = 0;i<Class.classesCount;i++){

                    if (classes[i].className.toLowerCase().equals(className.toLowerCase())){

                        used = true;

                        break;
                    }
                }
                if (className.equals("")){

                    System.out.println("Class Name cannot be empty");
                }

                else if (className.toLowerCase().equals("none")){

                    System.out.println("Class Name cannot be None");

                }
                else if(used){

                    System.out.println("Name already in use . Enter unique name");
                }

                else if(className.length()>10){

                    System.out.println("Class Name cannot be longer than 10 letters");
                }

                else {

                    break;
                }
            }
            System.out.print("Enter Course Code >> ");

            while (true){

                courseCode = input.nextLine();

                if (courseCode.equals("")){

                    System.out.print("Course code cannot be empty . Enter again >> ");
                }

                else if (courseCode.length()>20){

                    System.out.println("Course code cannot be longer than 20 letters");
                }
                else {

                    break;
                }
            }

            while (true){

                try {

                    System.out.print("Enter Class Strength >> ");
                    classStrength = input.nextInt();


                    if (classStrength< 1 ){
                        System.out.println("Class strength cannot be less than 1 ");
                    }

                    else if (classStrength > 80){
                        System.out.println("Class strength too high . Enter smaller strength");
                    }

                    else {
                        break;
                    }
                }
                catch (InputMismatchException e){
                    System.out.println("Enter valid class strength in digits ");
                    input.nextLine();
                }
            }

            classes[Class.classesCount] = new Class(className,courseCode,classStrength);
            System.out.print("Do you want to add another class(N for No) >> ");
            String select = input.next();
            if (select.strip().toLowerCase().equals("n")){
                break;
            }
        }
    }

    //Remove class is called from class management menu if user decides to remove classes
    //It keeps removing classes by name (not case sensitive) in loop
    //Until user decides to stop

    public void removeClass(){

        if (Class.classesCount>0){
            System.out.println("<<Remove Class>>");

            while (true){
                System.out.print("Enter class name >> ");
                boolean removed = false;
                String select = input.next();

                //Loop below checks all classes and removes the class with given name
                //Variable i represents class counter

                for (int i = 0;i<Class.classesCount;i++){

                    if (classes[i].className.toLowerCase().equals(select.toLowerCase())){
                        classes[i] = null;
                        removed = true;

                        //This loop down scales whole array because one class is removed

                        for (int j = i;j<Class.classesCount;j++){
                            classes[j] = classes[j+1];
                        }
                        Class.classesCount = Class.classesCount - 1;
                        break;
                    }
                }

                if (removed){
                    System.out.println("Removed!");
                }
                else {
                    System.out.println("No such class name found ");
                }
                System.out.print("Do you want to remove another class(N for No) >> ");
                select = input.nextLine();

                if (select.strip().toLowerCase().equals("n")){
                    break;
                }
            }
        }
        else {
            System.out.println("No Classes found.");
        }
    }

    //Called by class management menu to show all available classes

    public void viewClasses() throws FileNotFoundException {

        saveFile(classes);
    }

    public void saveFile(Class[] classes) throws FileNotFoundException {

        PrintWriter out = new PrintWriter("classesData.txt");

        if (Class.classesCount > 0){
            out.println("++++ ADDED CLASSES ++++");
            out.println(String.format("%-"+20+"s","Class")+String.format("%-"+20+"s","Course")+String.format("%-"+20+"s","Strength"));
            for (int i = 0;i<Class.classesCount;i++){
                out.println(String.format("%-"+20+"s",classes[i].className)+String.format("%-"+20+"s",classes[i].courseCode)+String.format("%-"+20+"s",classes[i].classStrength));
            }

            /* close print writer always */

            out.close();

            /* call printFile method to read and print contents from created file */

            printFile();
        }
        else {
            System.out.println("No Classes found");
            adminClassesManagement();
        }
    }


}

