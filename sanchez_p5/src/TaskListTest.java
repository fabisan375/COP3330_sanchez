import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {
    @Test
    public void addingTaskItemsIncreasesSize() throws ParseException {
        TaskList taskList = new TaskList();
        taskList.add(0, "Task 1", "2020-12-12", "First task");
        int size = taskList.size();
        assertEquals(1, size);
    }

    @Test
    public void completingTaskItemChangesStatus() throws ParseException {
        TaskList itemArray = new TaskList();
        itemArray.add(0, "task 1", "2020-12-12", "first task");
        int mark = itemArray.markTask(0);
        assertEquals(1, mark);
    }

    @Test
    public void uncompletingTaskItemChangesStatus() throws ParseException {
        TaskList itemArray = new TaskList();
        itemArray.add(1, "task 1", "2020-12-12", "first task");
        int mark = itemArray.unmarkTask(0);
        assertEquals(0, mark);
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex() throws ParseException {
        TaskList itemArray = new TaskList();
        itemArray.add(1, "task 1", "2020-12-12", "first task");
        assertThrows(java.lang.IndexOutOfBoundsException.class, () -> itemArray.unmarkTask(5));
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex() throws ParseException {
        TaskList itemArray = new TaskList();
        itemArray.add(1, "task 1", "2020-12-12", "first task");
        assertThrows(java.lang.IndexOutOfBoundsException.class, () -> itemArray.markTask(5));
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex() throws ParseException {
        TaskList itemArray = new TaskList();
        itemArray.add(1, "task 1", "2020-12-12", "first task");
        assertThrows(java.lang.IndexOutOfBoundsException.class, () -> itemArray.editTaskList(5, "task 1", "first task created", "2020-12-12"));
    }

    @Test
    public void editingTaskItemDescriptionSucceedsWithExpectedValue() throws ParseException, InvalidObjectException {
        TaskList itemArray = new TaskList();
        itemArray.add(1, "task 1", "2020-12-12", "first task");
        itemArray.editTaskList(0, "task 1", "2020-12-12", "First created task");
        assertEquals("First created task", itemArray.returnDescription(0));
    }

    @Test
    public void editingTaskItemDueDateSucceedsWithExpectedValue() throws ParseException, InvalidObjectException {
        TaskList itemArray = new TaskList();
        itemArray.add(1, "task 1", "2020-12-12", "first task");
        itemArray.editTaskList(0, "task 1", "2020-12-15", "first task");
        assertEquals("2020-12-15", itemArray.returnDate(0));
    }

    @Test
    public void editingTaskItemTitleFailsWithEmptyString() throws ParseException {
        TaskList itemArray = new TaskList();
        itemArray.add(1, "task 1", "2020-12-12", "first task");
        assertThrows(TaskItem.InvalidTitleException.class, () -> itemArray.editTaskList(0, "", "first task", "2020-12-12"));
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex() throws ParseException {
        TaskList itemArray = new TaskList();
        itemArray.add(1, "task 1", "2020-12-12", "first task");
        assertThrows(java.lang.IndexOutOfBoundsException.class, () -> itemArray.editTaskList(5, "task 01", "first task", "2020-12-12"));
    }

    @Test
    public void editingTaskItemTitleSucceedsWithExpectedValue() throws ParseException, InvalidObjectException {
        TaskList itemArray = new TaskList();
        itemArray.add(1, "task 1", "2020-12-12", "first task");
        itemArray.editTaskList(0, "Task 01", "2020-12-12", "first task");
        assertEquals("Task 01", itemArray.returnTitle(0));
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidDateFormat() throws ParseException {
        TaskList itemArray = new TaskList();
        itemArray.add(1, "task 1", "2020-12-12", "first task");
        assertThrows(java.text.ParseException.class, () -> itemArray.editTaskList(0, "task 1", "first task", "202012-12"));
    }

    @Test
    public void editingTaskItemDateFailsWithInvalidIndex() throws ParseException {
        TaskList itemArray = new TaskList();
        itemArray.add(1, "task 1", "2020-12-12", "first task");
        assertThrows(java.lang.IndexOutOfBoundsException.class, () -> itemArray.editTaskList(5, "task 1", "first task", "2020-12-14"));
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidYYYYMMDD() throws ParseException {
        TaskList itemArray = new TaskList();
        itemArray.add(1, "task 1", "2020-12-12", "first task");
        assertThrows(java.text.ParseException.class, () -> itemArray.editTaskList(0, "task 1", "first task", "2000-01-12"));
    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex() throws ParseException {
        TaskList itemArray = new TaskList();
        itemArray.add(1, "task 1", "2020-12-12", "first task");
        String description = itemArray.returnDescription(0);
        assertEquals("first task", description);
    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex() throws ParseException {
        TaskList itemArray = new TaskList();
        itemArray.add(1, "task 1", "2020-12-12", "first task");
        assertThrows(java.lang.IndexOutOfBoundsException.class, () -> itemArray.returnDescription(2));
    }

    @Test
    public void gettingTaskItemDateSucceedsWithValidIndex() throws ParseException {
        TaskList itemArray = new TaskList();
        itemArray.add(1, "task 1", "2020-12-12", "first task");
        String date = itemArray.returnDate(0);
        assertEquals("2020-12-12", date);
    }

    @Test
    public void gettingTaskItemDateFailsWithInvalidIndex() throws ParseException {
        TaskList itemArray = new TaskList();
        itemArray.add(1, "task 1", "2020-12-12", "first task");
        assertThrows(java.lang.IndexOutOfBoundsException.class, () -> itemArray.returnDate(2));
    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex() throws ParseException {
        TaskList itemArray = new TaskList();
        itemArray.add(1, "task 1", "2020-12-12", "first task");
        String title = itemArray.returnTitle(0);
        assertEquals("task 1", title);
    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex() throws ParseException {
        TaskList itemArray = new TaskList();
        itemArray.add(1, "task 1", "2020-12-12", "first task");
        assertThrows(java.lang.IndexOutOfBoundsException.class, () -> itemArray.returnTitle(2));
    }

    @Test
    public void newListIsEmpty() {
        TaskList taskList = new TaskList();
        assertEquals(0, taskList.size());
    }

    @Test
    public void removingTaskItemsDecreasesSize() throws ParseException {
        TaskList taskList = new TaskList();
        taskList.add(0, "Task 1", "2020-12-12", "First task");
        taskList.add(0, "Task 2", "2020-12-13", "Second task");
        taskList.delete(1);
        int size = taskList.size();
        assertEquals(1, size);
    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex() throws ParseException {
        TaskList taskList = new TaskList();
        taskList.add(0, "Task 1", "2020-12-12", "First task");
        taskList.add(0, "Task 2", "2020-12-13", "Second task");
        assertThrows(java.lang.IndexOutOfBoundsException.class, () -> taskList.delete(2));
    }

    @Test
    public void savedTaskListCanBeLoaded() throws ParseException, IOException {
        TaskList taskList = new TaskList();
        taskList.add(0, "Task 1", "2020-12-12", "First task");
        taskList.add(0, "Task 2", "2020-12-13", "Second task");
        taskList.save("test.txt");
        TaskList taskList2 = new TaskList();
        taskList2.load("test.txt");
        int success = 0;
        if(taskList.returnTitle(0).equals(taskList2.returnTitle(0))){
            success = 1;
        }
        assertEquals(1, success);
    }
}