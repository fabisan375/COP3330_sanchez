import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskList {

    private ArrayList<TaskItem> itemArray;

    public TaskList() {
        this.itemArray = new ArrayList<TaskItem>();
    }

    public void add(int mark, String title, String date, String description) throws ParseException {
        this.itemArray.add(new TaskItem(mark, title, date, description));
    }
    public void delete(int index){
        this.itemArray.remove(index);
    }

    public int size(){
        return this.itemArray.size();
    }

    public String returnTitle(int index) {
        return itemArray.get(index).returnTitle();
    }

    public String returnDescription(int index) {
        return itemArray.get(index).returnDescription();
    }

    public String returnDate(int index) {
        return itemArray.get(index).returnDate();
    }
    public int returnMark(int index){
        return itemArray.get(index).returnMark();
    }

    public String editTaskList(int index, String title, String date, String description) throws InvalidObjectException, ParseException {
        return itemArray.get(index).edit_TaskItem(title, date, description);
    }

    public int markTask(int index){
        return itemArray.get(index).markTask();
    }
    public int unmarkTask(int index){
        return itemArray.get(index).unmarkTask();
    }

    public void save(String filename){
        PrintWriter pw;
        try {
            pw = new PrintWriter(filename);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        pw.print(size() + "\n");
        for (int i = 0; i < size(); i++) {
            pw.print(itemArray.get(i).returnTitle() + "\n");
            pw.print(itemArray.get(i).returnDescription() + "\n");
            pw.print(itemArray.get(i).returnDate() + "\n");
            pw.print(itemArray.get(i).returnMark() + "\n");
        }
        pw.close();
    }
    public void load(String filename) throws ParseException, FileNotFoundException {
        Scanner input;
        if (!isFilenameValid(filename)) {
            input = new Scanner(new File(filename));
        }
        else {
            throw new FileNotFoundException("Warning: file named enter could not be found or does not exist, please double check it and try again");
        }

        int mark;
        String title;
        String date;
        String description;

        int size = Integer.parseInt(input.nextLine());
        for (int i = 0; i < size; i++) {
            title = input.nextLine();
            description = input.nextLine();
            date = input.nextLine();
            mark = Integer.parseInt(input.nextLine());
            this.add(mark, title, date, description);
        }
        input.close();
    }

    private static boolean isFilenameValid(String filename) {
        File temp = new File(filename);
        if (temp.exists())
            return false;
        return true;
    }

}

