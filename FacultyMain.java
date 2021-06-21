package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;


public class FacultyMain {

    Scanner input = new Scanner(System.in);
    int choice;
    String[] register = {"Student1", "Student2", "Student3", "Student4"};
    String[] attendArr;

    File attendData = new File("C:\\Users\\Dell\\IdeaProjects\\projectPF\\src\\com\\company\\attendData.txt");

    FacultyMain(){

        facultyMenu();
    }

    public void facultyMenu() {
        do{
            try{

                //menu display

                System.out.println("");
                System.out.println("******* Faculty Menu *******");
                System.out.println("(1) View Students/Faculty");
                System.out.println(("(2) Attendance Management"));
                System.out.println(("(3) Exit Program"));
                System.out.print("\nPick an option: ");

                //get user input

                choice = input.nextInt();

                switch(choice){
                    case 1:
                        System.out.println("[view code runs...]");
                        AdminMain.printFile();
                        break;
                    case 2:
                        System.out.println("[view faculty code runs...]");
                        facultyAttendanceManagement();
                        break;
                    case 3:
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




    public void facultyAttendanceManagement() {

        do{
            try{

                //menu display
                System.out.println("***** Attendance  Management Menu *****");
                System.out.println("(1) Add Attendance");
                System.out.println("(2) View Attendance");
                System.out.println(("(3) Exit"));
                System.out.print("\nPick an option: ");

                //get user input

                choice = input.nextInt();

                switch(choice){

                    case 1:
                        System.out.println("Add attendance code runs");
                        addAttendance(register);
                        break;
                    case 2:
                        System.out.println("view attendance code runs");
                        viewAttendance();
                        break;
                    case 3:
                        System.out.println("Exited back to login");
                        facultyMenu();
                        break;
                    default:
                        System.out.println("Invalid Choice!");

                }

            } catch (InputMismatchException | FileNotFoundException ex){
                System.out.println("Please insert A Valid Input.");
                input.nextLine();
            }
        } while (choice!=3);
    }




    public void addAttendance(String[] register) {

        String[] attendArr = new String[register.length];

        for( int i =0; i< register.length;i++){

            System.out.println("Present (P or p) or Absent(A or a)");
            System.out.println(register[i]);

            System.out.print("Enter attendance: ");
            String attendance = input.next();

            if((attendance.equals("P")) || (attendance.equals("p")) || (attendance.equals("A")) || (attendance.equals("a"))){
                attendArr[i] = attendance;
            }

            else{
                System.out.println("Invalid Input");
                input.nextLine();
            }
        }

        System.out.println("Attendance recorded.");

    }





    public void viewAttendance() throws FileNotFoundException {

        saveFile(register,attendArr);
    }



    public void saveFile(String[] register,String[] attendArr) throws FileNotFoundException {

        /* creating print writer object to store student data in text file attendData.txt*/

        PrintWriter pr = new PrintWriter("attendData.txt");

        try{

            for(int j=0;j<attendArr.length;j++){

                pr.println("++++ ADDED ATTENDANCE ++++");
                pr.println("\n" + "Student Names" + "\t\t" + "Attendances"+"\n"+ register[j] + "\t\t " + attendArr[j]) ;

                System.out.println("Data stored.");
            }
            /* always close print writer */

            pr.close();

            /* call printFle method to read and print data from file to the console */
            if (attendData.exists()){
                AdminMain.printFile();
            }



        }
        catch(NullPointerException ex){
            System.out.println("No data found!\n");
            facultyAttendanceManagement();
        }
    }
}
