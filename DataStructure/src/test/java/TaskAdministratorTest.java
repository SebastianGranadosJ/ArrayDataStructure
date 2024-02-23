import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.edu.upb.quizTareas.Task;
import com.edu.upb.quizTareas.TaskAdministrator;
import com.edu.upb.util.array.Array;

public class TaskAdministratorTest {
    @Test
    void emptyTest(){

        TaskAdministrator admin = new TaskAdministrator();
        admin.addTask("Finish my homework", 1);
        assertEquals(false, admin.exist("Get a beer"));
        assertEquals(true, admin.exist("Finish my homework"));
    }

    @Test
    void addTest(){
        TaskAdministrator admin = new TaskAdministrator();
        assertEquals(true, admin.addTask("Homework", 3));
        assertEquals(true, admin.addTask("Cleaning", 2));
        assertEquals(true, admin.addTask("Washing", 1));
        assertEquals(false, admin.addTask("Homework", 1));
        assertEquals(false, admin.addTask("Shopping", 0));

       System.out.println(admin.print());

    }

    @Test
    void removeTest(){
        TaskAdministrator admin = new TaskAdministrator();
        admin.addTask("Homework", 3);
        admin.addTask("Cleaning", 2);
        admin.addTask("Washing", 1);

        assertEquals(true, admin.removeTask("Homework"));
        assertEquals(false, admin.removeTask("Walking my dog"));
        


       System.out.println(admin.print());

    }
    @Test
    void markComplete(){
        TaskAdministrator admin = new TaskAdministrator();
        admin.addTask("Homework", 3);
        admin.addTask("Cleaning", 2);
        admin.addTask("Washing", 1);

        assertEquals(true, admin.markComplete("Homework"));
        assertEquals(false, admin.markComplete("Walking my dog"));
        


       System.out.println(admin.print());
    }
    @Test
    void displayTasksTest(){
        TaskAdministrator admin = new TaskAdministrator();
        admin.addTask("Homework", 3);
        admin.addTask("Cleaning", 2);
        admin.addTask("Washing", 1);


       System.out.println(admin.displayTasks().toString());
    }

    @Test
    void removeCompletedTasksTest(){
        TaskAdministrator admin = new TaskAdministrator();
        admin.addTask("Homework", 3);
        admin.addTask("Cleaning", 2);
        admin.addTask("Washing", 1);

        admin.markComplete("Homework");
        admin.markComplete("Cleaning");

        assertEquals(true, admin.removeCompletedTasks());
        assertEquals(false, admin.removeCompletedTasks());
        System.out.println(admin.displayTasks().toString());
    }

    @Test
    void sortTaskByNameTest(){
        TaskAdministrator admin = new TaskAdministrator();
        admin.addTask("abbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb", 3);
        admin.addTask("bolon magico psiciquico anscestral mamado epico genial wowo que increible de verdad quiero jugar wow ", 2);
        admin.addTask("accccccccccccccccccccccccccccc", 1);

        Array<Task> array =    admin.sortTasksByName();
    
        System.out.println(array.toString());
    }

}   
