import java.io.IOException;
import java.io.InvalidObjectException;
import java.rmi.NoSuchObjectException;
import java.text.ParseException;
import java.util.Scanner;
public class TaskApp {
    static Scanner input = new Scanner(System.in);

    public TaskApp() throws ParseException, IOException {

        TaskList taskList;
        int mainMenuOptions = 0;

        while (mainMenuOptions != 3) {
            mainMenu();
            try {
                mainMenuOptions = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException ex){
                System.out.println("WARNING: Please enter a number 1-3");
            }
            if (!isMainMenuOptionsValid(mainMenuOptions)){
                throw new IndexOutOfBoundsException("WARNING: option selected is not a valid main menu option. Please try again and enter a number 1-3.");
            }
            switch (mainMenuOptions) {
                case 1:
                    taskList = new TaskList();
                    System.out.println("\nNew task list has been created\n");
                    operationMenu(taskList);
                    break;
                case 2:
                    taskList = new TaskList();
                    System.out.print("Enter the filename to load: ");
                    taskList.load(input.nextLine());
                    System.out.println("task list has been loaded");
                    operationMenu(taskList);
                    break;

            }
        }
    }

    private static boolean isMainMenuOptionsValid(int mainMenuOptions) {
        return (mainMenuOptions >= 1 && mainMenuOptions <= 3);
    }


    private static void operationMenu (TaskList taskList) throws IOException, ParseException {
        String title;
        String description;
        String date;
        int mark;
        int listOperationsMenuOptions = 0;
        while (listOperationsMenuOptions != 8) {
            displayOperationMenu();
            try{
                listOperationsMenuOptions = Integer.parseInt(input.nextLine());
            }catch (NumberFormatException ex){
                System.out.println("WARNING: Please enter a number 1-8");
            }
            if (!isListOperationsMenuOptionsValid(listOperationsMenuOptions)){
                throw new IndexOutOfBoundsException("WARNING: option selected is not a valid list operation menu option. Please try again and enter a number 1-6.");
            }

            switch (listOperationsMenuOptions) {
                case 1:
                    int size = taskList.size();
                    System.out.println("\nCurrent tasks");
                    System.out.println("---------\n");
                    if (size != 0) {
                        for (int i = 0; i < size; i++) {
                            if (taskList.returnMark(i) == 1) {
                                System.out.println(i + ") ***" + "[" + taskList.returnDate(i) + "]" + taskList.returnTitle(i) + ":" + taskList.returnDescription(i));
                            } else
                                System.out.println(i + ") " + "[" + taskList.returnDate(i) + "]" + taskList.returnTitle(i) + ":" + taskList.returnDescription(i));
                        }
                    } else System.out.println("");
                    break;
                case 2:
                    title = getTitle();
                    description = getDescription();
                    date = getDate();
                    mark = 0;
                    taskList.add(mark, title, date, description);
                    break;
                case 3:
                    size = taskList.size();
                    if (size > 0){
                        System.out.println("\nCurrent tasks");
                        System.out.println("---------\n");
                        for (int i = 0; i < size; i++) {
                            if (taskList.returnMark(i) == 1) {
                                System.out.println(i + ") ***" + "[" + taskList.returnDate(i) + "]" + taskList.returnTitle(i) + ":" + taskList.returnDescription(i));
                            } else
                                System.out.println(i + ") " + "[" + taskList.returnDate(i) + "]" + taskList.returnTitle(i) + ":" + taskList.returnDescription(i));
                        }
                        System.out.print("\nWhich task will you edit?: ");
                        int taskNumber = 0;
                        try{
                            taskNumber = Integer.parseInt(input.nextLine());
                        } catch (NumberFormatException ex){
                            System.out.printf("WARNING: Please enter a number 0-%d\n", size);
                        }

                        System.out.printf("\nEnter a new title for task %d: ", taskNumber);
                        String newTitle = input.nextLine();

                        System.out.printf("\nEnter a new description for task %d: ", taskNumber);
                        String newDescription = input.nextLine();

                        System.out.printf("\nEnter a new due date for task %d (YYYY-MM-DD): ", taskNumber);
                        String newDueDate = input.nextLine();

                        taskList.editTaskList(taskNumber,newTitle, newDueDate, newDescription);
                    }
                    else throw new InvalidObjectException("WARNING: There are currently no tasks to edit. Please try again and create a task first.");
                    break;
                case 4:
                    size = taskList.size();
                    if (size > 0){
                        System.out.println("\nCurrent tasks");
                        System.out.println("---------\n");
                        for (int i = 0; i < size; i++) {
                            if (taskList.returnMark(i) == 1) {
                                System.out.println(i + ") ***" + "[" + taskList.returnDate(i) + "]" + taskList.returnTitle(i) + ":" + taskList.returnDescription(i));
                            } else
                                System.out.println(i + ") " + "[" + taskList.returnDate(i) + "]" + taskList.returnTitle(i) + ":" + taskList.returnDescription(i));
                        }
                        System.out.print("\nWhich task will you remove?: ");
                        int taskNumber = 0;
                        try{
                            taskNumber = Integer.parseInt(input.nextLine());
                        } catch (NumberFormatException ex){
                            System.out.printf("WARNING: Please enter a number 0-%d\n", size);
                        }
                        taskList.delete(taskNumber);
                    }
                    else throw new InvalidObjectException("WARNING: There are currently no tasks to remove. Please try again and create a task first.");
                    break;
                case 5:
                    size = taskList.size();
                    if (size > 0){
                        System.out.println("\nUncompleted tasks");
                        System.out.println("---------\n");
                        for (int i = 0; i < size; i++) {
                            if (taskList.returnMark(i) == 0) {
                                System.out.println(i + ") " + "[" + taskList.returnDate(i) + "]" + taskList.returnTitle(i) + ":" + taskList.returnDescription(i));
                            }
                        }
                        System.out.print("\nWhich task will you mark as completed?: ");
                        int taskNumber = 0;
                        try{
                            taskNumber = Integer.parseInt(input.nextLine());
                        } catch (NumberFormatException ex){
                            System.out.printf("WARNING: Please enter a number 0-%d\n", size);
                        }
                        taskList.markTask(taskNumber);
                    }
                    else throw new InvalidObjectException("WARNING: There are currently no tasks to mark. Please try again and create a task first.");
                    break;
                case 6:
                    size = taskList.size();
                    if (size > 0){
                        System.out.println("\nCompleted tasks");
                        System.out.println("---------\n");
                        for (int i = 0; i < size; i++) {
                            if (taskList.returnMark(i) == 1) {
                                System.out.println(i + ") ***" + "[" + taskList.returnDate(i) + "]" + taskList.returnTitle(i) + ":" + taskList.returnDescription(i));
                            }
                        }
                        System.out.print("\nWhich task will you unmark as completed?: ");
                        int taskNumber = 0;
                        try{
                            taskNumber = Integer.parseInt(input.nextLine());
                        } catch (NumberFormatException ex){
                            System.out.printf("WARNING: Please enter a number 0-%d\n", size);
                        }
                        taskList.unmarkTask(taskNumber);
                    }
                    else throw new InvalidObjectException("WARNING: There are currently no tasks. Please try again and create a task first.");
                    break;
                case 7:
                    if (taskList.size() == 0){
                        throw new NoSuchObjectException("WARNING: A task list shall contain 1 or more task items. Please try again");
                    }
                    else{
                        System.out.print("Enter the filename to save as: ");
                        taskList.save(input.nextLine());
                        System.out.println("task list has been saved");
                    }

                    break;
            }
        }
    }

    private static boolean isListOperationsMenuOptionsValid(int listOperationsMenuOptions) {
        return (listOperationsMenuOptions >= 1 && listOperationsMenuOptions <= 8);
    }

    private static void mainMenu () {
        System.out.println("\nMain Menu");
        System.out.println("---------\n");

        System.out.println("1) Create a new task list");
        System.out.println("2) Load an existing task list");
        System.out.println("3) Quit");
    }
    private static void displayOperationMenu () {
        System.out.println("\nList Operation Menu");
        System.out.println("---------\n");

        System.out.println("1) View the List");
        System.out.println("2) Add an item");
        System.out.println("3) Edit an item");
        System.out.println("4) Remove an item");
        System.out.println("5) Mark an item as completed");
        System.out.println("6) Unmark an item as completed");
        System.out.println("7) Save the current list");
        System.out.println("8) Quit to the main menu");
    }
    private static String getDate () {
        System.out.println("Enter date (YYYY-MM-DD): ");
        return input.nextLine();
    }

    private static String getDescription () {
        System.out.println("Enter description: ");
        return input.nextLine();
    }

    private static String getTitle () {
        System.out.println("Enter title: ");
        return input.nextLine();
    }
}

