// Polatkan Eren Polat
// This program creates a list of students and allows the user to 
// lookup information about a student given the ID number.


import java.util.*;

public class Student_Services_Desk {

    private static int nextSID = 22; // must be greater than any of the Students' IDs that we pre-load

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        Map<Integer, Student> studentInfo = new TreeMap<Integer, Student>();
        studentInfo.put(21, new Student(21, "Zog", "TheDestroyer",
                new ArrayList<String>(List.of("BIT 143", "MATH 411", "ENG 120"))));
        studentInfo.put(20,
                new Student(20, "Mary", "Sue", new ArrayList<String>(List.of("BIT 142", "MATH 142", "ENG 100"))));
        studentInfo.put(1,
                new Student(1, "Joe", "Bloggs", new ArrayList<String>(List.of("BIT 115", "MATH 141", "ENG 101"))));

        char choice = 'L'; // anything but 'q' is fine
        while (choice != 'q') {
            System.out.println("\nWhat would you like to do next? ");
            System.out.println("F - Find a specific student");
            System.out.println("L - List all the students (for debugging purposes)");
            System.out.println("A - Add a new student");
            System.out.println("D - Delete an existing student");
            System.out.println("M - Modify an existing student");
            System.out.println("Q - Quit (exit) the program");
            System.out.print("What is your choice?\n(type in the letter & then the enter/return key) ");
            choice = keyboard.nextLine().trim().toLowerCase().charAt(0);
            System.out.println();

            switch (choice) {
                case 'f':
                    System.out.println("Find a student (based on their ID number):\n");
                    System.out.print("What is the ID number of the student to find? ");
                    int findID = Integer.parseInt(keyboard.nextLine().trim());
                    Student foundStudent = studentInfo.get(findID);
                    if (foundStudent != null) {
                        System.out.printf("%s, %s (SID=%d)\nClasses:\n", 
                            foundStudent.getLastName(), 
                            foundStudent.getFirstName(), 
                            foundStudent.getSID());
                        for (String className : foundStudent.getClasses()) {
                            System.out.println("\t" + className);
                        }
                    } else {
                        System.out.println("Didn't find a student with ID # " + findID);
                    }
                    break;

                case 'l':
                    System.out.println("The following students are registered:");
                    for (Student student : studentInfo.values()) {
                        System.out.println(student);
                    }
                    break;

                case 'a':
                    System.out.println("Adding a new student\n");
                    System.out.println("Please provide the following information:");
                    System.out.print("Student's first name? ");
                    String firstName = keyboard.nextLine().trim();
                    System.out.print("Student's last name? ");
                    String lastName = keyboard.nextLine().trim();
                    
                    List<String> classes = new ArrayList<>();
                    System.out.println("Type the name of class, or leave empty to stop.  Press enter/return regardless");
                    while (true) {
                        String className = keyboard.nextLine().trim();
                        if (className.isEmpty()) {
                            break;
                        }
                        classes.add(className);
                    }
                    
                    int newSID = nextSID++;
                    studentInfo.put(newSID, new Student(newSID, firstName, lastName, classes));
                    break;

                case 'd':
                    System.out.println("Deleting an existing student\n");
                    System.out.print("What is the ID number of the student to delete? ");
                    int deleteID = Integer.parseInt(keyboard.nextLine().trim());
                    if (studentInfo.remove(deleteID) != null) {
                        System.out.println("Student account found and removed from the system!");
                    } else {
                        System.out.println("Didn't find a student with ID # " + deleteID);
                    }
                    break;

                case 'm':
                    System.out.println("Modifying an existing student\n");
                    System.out.print("What is the ID number of the student to modify? ");
                    int modifyID = Integer.parseInt(keyboard.nextLine().trim());
                    Student studentToModify = studentInfo.get(modifyID);
                    
                    if (studentToModify != null) {
                        System.out.println("Student account found!");
                        System.out.println("For each of the following type in the new info or leave empty to keep the existing info.  Press enter/return in both cases.");
                        
                        System.out.print("Student's first name: " + studentToModify.getFirstName() + " New first name? ");
                        String newFirstName = keyboard.nextLine().trim();
                        if (!newFirstName.isEmpty()) {
                            studentToModify.setFirstName(newFirstName);
                        }
                        
                        System.out.print("Student's last name: " + studentToModify.getLastName() + " New last name? ");
                        String newLastName = keyboard.nextLine().trim();
                        if (!newLastName.isEmpty()) {
                            studentToModify.setLastName(newLastName);
                        }
                        
                        System.out.println("Updating class list");
                        System.out.println("Here are the current classes: " + studentToModify.getClasses());
                        System.out.println("This program will go through all the current classes.");
                        System.out.println("For each class it will print the name of the class and then ask you if you'd like to delete or keep it.");
                        
                        List<String> currentClasses = new ArrayList<>(studentToModify.getClasses());
                        for (String className : currentClasses) {
                            System.out.println(className);
                            System.out.println("Type d<enter/return> to remove, or just <enter/return> to keep");
                            String response = keyboard.nextLine().trim();
                            if (response.equalsIgnoreCase("d")) {
                                studentToModify.getClasses().remove(className);
                                System.out.println("Removing " + className + "\n");
                            } else {
                                System.out.println("Keeping " + className + "\n");
                            }
                        }
                        
                        System.out.println("Type the name of the class you'd like to add, or leave empty to stop.  Press enter/return regardless");
                        while (true) {
                            String newClass = keyboard.nextLine().trim();
                            if (newClass.isEmpty()) {
                                break;
                            }
                            studentToModify.getClasses().add(newClass);
                        }
                        
                        System.out.println("Here's the student's new, updated info: " + studentToModify);
                    } else {
                        System.out.println("Didn't find a student with ID # " + modifyID);
                    }
                    break;

                case 'q':
                    System.out.println("Thanks for using the program - goodbye!\n");
                    break;
                default:
                    System.out.println("Sorry, but I didn't recognize the option " + choice);
                    break;
            }
        }
    }
}
