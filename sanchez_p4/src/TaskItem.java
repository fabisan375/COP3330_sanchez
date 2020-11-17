import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TaskItem {
    private String title;
    private String date;
    private String description;
    private int mark;
    static Scanner input = new Scanner(System.in);
    public TaskItem() {
        this.title = "";
        this.date = "";
        this.description = "";
        this.mark = 0;
    }
    public TaskItem(int mark, String title, String date, String description) throws ParseException {
        if (isTitleValid(title)) {
            this.title = title;
        }
        else {
            throw new InvalidTitleException("WARNING: invalid title; task not created");
        }

        if (isDateValid(date)) {
            this.date = date;
        }
        else{
            throw new InvalidDateException("WARNING: invalid due date; task not created");
        }

        if (isDescriptionValid(description)){
            this.description = description;
        }
        else{
            throw new InvalidDescriptionException("WARNING: invalid description; task not created");
        }

        this.mark = mark;
    }

    private boolean isDescriptionValid(String description) {
        return (description.length() > 0);
    }

    private boolean isDateValid(String date) throws ParseException {

        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        String stringDate = sdformat.format(currentDate);

        Date d1 = sdformat.parse(date);
        Date d2 = sdformat.parse(stringDate);

        return (d1.compareTo(d2) >= 0);
    }

    class InvalidTitleException extends IllegalArgumentException {
        public InvalidTitleException(String msg) {
            super(msg);
        }
    }
    class InvalidDateException extends IllegalArgumentException {
        public InvalidDateException(String msg) {
            super(msg);
        }
    }
    class InvalidDescriptionException extends IllegalArgumentException {
        public InvalidDescriptionException(String msg) {
            super(msg);
        }
    }

    private boolean isTitleValid(String title) {
        return title.length() > 0;
    }

    public String returnTitle(){
        return title;
    }
    public String returnDescription(){
        return description;
    }

    public String returnDate(){

        return date;
    }

    public int returnMark(){
        return mark;
    }

    public String edit_Title(int index){
        System.out.printf("Enter a new title for task %d: \n", index);
        this.title = input.nextLine();
        return title;
    }

    public String edit_Description(int index){
        System.out.printf("Enter a new description for task %d: \n", index);
        this.description = input.nextLine();
        return description;
    }

    public String edit_Date(int index){
        System.out.printf("Enter a new task due date (YYYY-MM-DD) for task %d: \n", index);
        this.date = input.nextLine();
        return date;
    }
    public int markTask(){
        this.mark = 1;
        return mark;
    }
    public int unmarkTask() {
        this.mark = 0;
        return mark;
    }
}
