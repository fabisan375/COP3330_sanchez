
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
public class App {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws ParseException, IOException {

        TaskList taskList = new TaskList();
        int mainMenuOptions = 0;

        while (mainMenuOptions != 3) {
            mainMenu();
            mainMenuOptions = Integer.parseInt(input.nextLine());
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


        private static void operationMenu (TaskList taskList) throws IOException, ParseException {
            String title = "";
            String description = "";
            String date = "";
            int mark = 0;
            int listOperationsMenuOptions = 0;
            while (listOperationsMenuOptions != 8) {
                displayOperationMenu();
                listOperationsMenuOptions = Integer.parseInt(input.nextLine());

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
                        System.out.println("\nCurrent tasks");
                        System.out.println("---------\n");
                        for (int i = 0; i < size; i++) {
                            if (taskList.returnMark(i) == 1) {
                                System.out.println(i + ") ***" + "[" + taskList.returnDate(i) + "]" + taskList.returnTitle(i) + ":" + taskList.returnDescription(i));
                            } else
                                System.out.println(i + ") " + "[" + taskList.returnDate(i) + "]" + taskList.returnTitle(i) + ":" + taskList.returnDescription(i));
                        }
                        System.out.print("\nWhich task will you edit?: ");
                        int taskNumber = Integer.parseInt(input.nextLine());
                        taskList.editTitle(taskNumber);
                        taskList.editDescription(taskNumber);
                        taskList.editDate(taskNumber);
                        break;
                    case 4:
                        size = taskList.size();
                        System.out.println("\nCurrent tasks");
                        System.out.println("---------\n");
                        for (int i = 0; i < size; i++) {
                            if (taskList.returnMark(i) == 1) {
                                System.out.println(i + ") ***" + "[" + taskList.returnDate(i) + "]" + taskList.returnTitle(i) + ":" + taskList.returnDescription(i));
                            } else
                                System.out.println(i + ") " + "[" + taskList.returnDate(i) + "]" + taskList.returnTitle(i) + ":" + taskList.returnDescription(i));
                        }
                        System.out.print("\nWhich task will you remove?: ");
                        taskNumber = Integer.parseInt(input.nextLine());
                        taskList.delete(taskNumber);
                        break;
                    case 5:
                        size = taskList.size();
                        System.out.println("\nUncompleted tasks");
                        System.out.println("---------\n");
                        for (int i = 0; i < size; i++) {
                            if (taskList.returnMark(i) == 0) {
                                System.out.println(i + ") " + "[" + taskList.returnDate(i) + "]" + taskList.returnTitle(i) + ":" + taskList.returnDescription(i));
                            }
                        }
                        System.out.print("\nWhich task will you mark as completed?: ");
                        taskNumber = Integer.parseInt(input.nextLine());
                        taskList.markTask(taskNumber);
                        break;
                    case 6:
                        size = taskList.size();
                        System.out.println("\nCompleted tasks");
                        System.out.println("---------\n");
                        int j = 0;
                        for (int i = 0; i < size; i++) {
                            if (taskList.returnMark(i) == 1) {
                                System.out.println(i + ") ***" + "[" + taskList.returnDate(i) + "]" + taskList.returnTitle(i) + ":" + taskList.returnDescription(i));
                            }
                        }
                        System.out.print("\nWhich task will you unmark as completed?: ");
                        taskNumber = Integer.parseInt(input.nextLine());
                        taskList.unmarkTask(taskNumber);
                        break;
                    case 7:
                        System.out.print("Enter the filename to save as: ");
                        taskList.save(input.nextLine());
                        System.out.println("task list has been saved");
                        break;
                }
            }
        }

        private static void mainMenu () {
            System.out.println("\nMain Menu");
            System.out.println("---------\n");

            System.out.println("1) Create a new list");
            System.out.println("2) Load an existing list");
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

