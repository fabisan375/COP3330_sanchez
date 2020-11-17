import org.junit.jupiter.api.Test;

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
    public void creatingTaskItemFailsWithInvalidDescription() {
        assertThrows(TaskItem.InvalidDescriptionException.class, () -> new TaskItem(0, "Task 1", "2020-12-12", ""));
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
}


