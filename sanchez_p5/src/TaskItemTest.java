import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InvalidObjectException;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {
    @Test
    public void creatingItemFailsWithNoDueDate() {
        assertThrows(java.text.ParseException.class, () -> new TaskItem(0, "Task 1", "", "first test"));
    }

    @Test
    public void creatingItemFailsWithInvalidDueDate() {
        assertThrows(TaskItem.InvalidDateException.class, () -> new TaskItem(0, "Task 1", "2000-01-04", "first test"));
    }

    @Test
    public void creatingItemFailsWithIncompleteDueDate() {
        assertThrows(java.text.ParseException.class, () -> new TaskItem(0, "Task 1", "2000", "first test"));
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle() {
        assertThrows(TaskItem.InvalidTitleException.class, () -> new TaskItem(0, "", "2020-12-12", "first test"));
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle() {
        assertDoesNotThrow(() -> new TaskItem(0, "Task 1", "2020-12-12", "first test"));
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate() {
        assertDoesNotThrow(() -> new TaskItem(0, "Task 1", "2020-12-12", "first test"));
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate() {
        assertThrows(TaskItem.InvalidDateException.class, () -> new TaskItem(0, "Task 1", "2003-11-11", "first test"));
    }

    @Test
    public void settingTaskItemDueDateFailsWithoutDate() {
        assertThrows(java.text.ParseException.class, () -> new TaskItem(0, "Task 1", "", "first test"));
    }

    @Test
    public void settingTaskItemDueDateFailsWithIncompleteDate() {
        assertThrows(java.text.ParseException.class, () -> new TaskItem(0, "Task 1", "1999", "first test"));
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate() {
        assertDoesNotThrow(() -> new TaskItem(0, "Task 1", "2020-12-12", "first test"));
    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle() {
        assertDoesNotThrow(() -> new TaskItem(0, "Task 1", "2020-12-12", "first test"));
    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle() {
        assertThrows(TaskItem.InvalidTitleException.class, () -> new TaskItem(0, "", "2020-12-12", "first test"));
    }

    @Test
    public void settingTaskItemWithMarkSucceeds() throws ParseException {
        TaskItem taskItem = new TaskItem(0, "Task 1", "2020-12-12", "first test");
        int mark = taskItem.markTask();
        assertEquals(1, mark);
    }

    @Test
    public void settingTaskItemWithUnmarkSucceeds() throws ParseException {
        TaskItem taskItem = new TaskItem(1, "Task 1", "2020-12-12", "first test");
        int mark = taskItem.unmarkTask();
        assertEquals(0, mark);
    }

    @Test
    public void creatingTaskItemSucceedsWithValidMark() {
        assertDoesNotThrow(() -> new TaskItem(1, "Task 1", "2020-12-12", "first test"));
    }

    @Test
    public void constructorFailsWithInvalidDueDate() {
        assertThrows(TaskItem.InvalidDateException.class, () -> new TaskItem(0, "Task 1", "2000-01-04", "first test"));
    }

    @Test
    public void constructorFailsWithInvalidTitle() {
        assertThrows(TaskItem.InvalidTitleException.class, () -> new TaskItem(0, "", "2020-12-12", "first test"));
    }

    @Test
    public void constructorSucceedsWithValidDueDate() {
        assertDoesNotThrow(() -> new TaskItem(0, "Task 1", "2020-12-12", "first test"));
    }

    @Test
    public void constructorSucceedsWithValidTitle() {
        assertDoesNotThrow(() -> new TaskItem(0, "Task 1", "2020-12-12", "first test"));
    }

    @Test
    public void editingDescriptionSucceedsWithExpectedValue() throws ParseException, InvalidObjectException {
        TaskItem taskItem = new TaskItem(0, "Task 1", "2020-12-12", "first task");
        taskItem.edit_TaskItem("Task 1", "2020-12-12", "Test");
        assertEquals("Test", taskItem.returnDescription());
    }

    @Test
    public void editingDueDateFailsWithInvalidDateFormat() throws ParseException {
        TaskItem taskItem = new TaskItem(0, "Task 1", "2020-12-12", "first task");
        Assertions.assertThrows(java.text.ParseException.class, () ->{
            taskItem.edit_TaskItem("Task 1", "2020", "Test");
        });
    }

    @Test
    public void editingDueDateFailsWithInvalidYYYMMDD() throws ParseException {
        TaskItem taskItem = new TaskItem(0, "Task 1", "2020-12-12", "first task");
        Assertions.assertThrows(TaskItem.InvalidDateException.class, () ->{
            taskItem.edit_TaskItem("Task 1", "2001-10-10", "Test");
        });
    }

    @Test
    public void editingDateSucceedsWithExpectedValue() throws ParseException, InvalidObjectException {
        TaskItem taskItem = new TaskItem(0, "Task 1", "2020-12-12", "first task");
        taskItem.edit_TaskItem("Task 1", "2021-11-11", "first task");
        assertEquals("2021-11-11", taskItem.returnDate());
    }

    @Test
    public void editingTitleFailsWithEmptyString() throws ParseException {
        TaskItem taskItem = new TaskItem(0, "Task 1", "2020-12-12", "first task");
        Assertions.assertThrows(TaskItem.InvalidTitleException.class, () ->{
            taskItem.edit_TaskItem("", "2020-12-12", "Test");
        });
    }

    @Test
    public void editingTitleSucceedsWithExpectedValue() throws ParseException, InvalidObjectException {
        TaskItem taskItem = new TaskItem(0, "Task 1", "2020-12-12", "first task");
        taskItem.edit_TaskItem("Task 01", "2020-12-12", "first task");
        assertEquals("Task 01", taskItem.returnTitle());
    }
}