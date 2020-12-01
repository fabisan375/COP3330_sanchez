import java.io.InvalidObjectException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
            throw new InvalidTitleException("WARNING: invalid title. A title shall be 1 or more characters in length; task not created");
        }
        try{
            if (isDateValid(date)) {
                this.date = date;
            }
            else{
                throw new InvalidDateException("WARNING: invalid due date. Date must be current date or future date; task not created");
            }
        } catch (ParseException ex){
            throw new ParseException("WARNING: Invalid due date format. Format must be (YYYY-MM-DD); task not created", 0);
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
        return (description.length() >= 0);
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

    public String edit_Title(String title){
        this.title = title;
        return title;
    }

    public String edit_Description(String description){
        this.description = description;
        return description;
    }

    public String edit_Date(String date){
        this.date = date;
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

    public String edit_TaskItem(String title, String date, String description) throws InvalidObjectException, ParseException {
        if (title.length() == 0 && description.length() == 0 && date.length() == 0){
            throw new InvalidObjectException("WARNING: A contact item shall contain at least one of [title], [description], or [due date]. Please try again.");
        }
        else{
            edit_Title(title);
            if (!isTitleValid(title)){
                throw new InvalidTitleException("WARNING: invalid title. A title shall be 1 or more characters in length; task not created");
            }
            edit_Description(description);
            edit_Date(date);
            try{
                if (isDateValid(date)) {
                    return null;
                }
                else{
                    throw new InvalidDateException("WARNING: invalid due date. Date must be current date or future date; task not created");
                }
            } catch (ParseException ex){
                throw new ParseException("WARNING: Invalid due date format. Format must be (YYYY-MM-DD); task not created", 0);
            }
        }
    }
}
