package generalOpControllerTests;

import controller.GeneralOpController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class LoginTest {

    @Test
    public void failLoginEmptyIdTestManager()
    {
        GeneralOpController generalOpController = new GeneralOpController();
        try {
            generalOpController.isManager(-1, "1234");
            fail("Login succeed when should failed");
        }
        catch (IllegalArgumentException e)
        {
            Assertions.assertEquals("id or password must not be null", e.getMessage());

        }
    }

    @Test
    public void failLoginEmptyPasswordTestManager()
    {
        GeneralOpController generalOpController = new GeneralOpController();
        try {
            generalOpController.isManager(12, "");
            fail("Login succeed when should failed");
        }
        catch (IllegalArgumentException e)
        {
            Assertions.assertEquals("id or password must not be null", e.getMessage());

        }
    }


    @Test
    public void failLoginEmptyIdTestWorker()
    {
        GeneralOpController generalOpController = new GeneralOpController();
        try {
            generalOpController.isWorker(-1, "1234");
            fail("Login succeed when should failed");
        }
        catch (IllegalArgumentException e)
        {
            Assertions.assertEquals("id or password must not be null", e.getMessage());

        }
    }


    @Test
    public void failLoginEmptyPasswordTestWorker()
    {
        GeneralOpController generalOpController = new GeneralOpController();
        try {
            generalOpController.isManager(1, "");
            fail("Login succeed when should failed");
        }
        catch (IllegalArgumentException e)
        {
            Assertions.assertEquals("id or password must not be null", e.getMessage());

        }
    }


}
