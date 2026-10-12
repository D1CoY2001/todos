import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TasksTest {

    @Test
    public void simpleTaskShouldMatchByTitle() {
        SimpleTask task = new SimpleTask(5, "Позвонить родителям");

        boolean expected = true;
        boolean actual = task.matches("родителям");

        assertEquals(expected, actual);
    }

    @Test
    public void simpleTaskShouldNotMatch() {
        SimpleTask task = new SimpleTask(5, "Позвонить родителям");

        boolean expected = false;
        boolean actual = task.matches("купить");

        assertEquals(expected, actual);
    }

    @Test
    public void epicShouldMatchBySubtask() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("Яйца");

        assertEquals(expected, actual);
    }

    @Test
    public void epicShouldNotMatch() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("Сыр");

        assertEquals(expected, actual);
    }

    @Test
    public void meetingShouldMatchByTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("Выкатка");

        assertEquals(expected, actual);
    }

    @Test
    public void meetingShouldMatchByProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("НетоБанка");

        assertEquals(expected, actual);
    }

    @Test
    public void meetingShouldNotMatch() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = false;
        boolean actual = meeting.matches("Отпуск");

        assertEquals(expected, actual);
    }
}