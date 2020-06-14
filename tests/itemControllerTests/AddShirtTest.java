package itemControllerTests;

import controller.ItemController;
import model.entities.Pants;
import model.entities.Shirt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class AddShirtTest {

    ItemController itemController;
    private final static int MOCK_NEGATIVE = -1;
    private final static int MOCK_ZERO = 0;
    private final static int MOCK_POSITIVE = 1;
    private final static int MOCK_ID_EXIST = 5;
    private final static int MOCK_SIZE_EXIST = 20;


    @BeforeEach
    public void setUp()
    {
        itemController = new ItemController();
    }

    @Test
    public void failIdTest() {
        try {
            Shirt i = new Shirt("blue", "niki", "men", "pants", 200, MOCK_POSITIVE, 200, 500, MOCK_NEGATIVE, "lycra");
            itemController.addShirt(i);
            fail("The addition succeed when should failed");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("id or size must not be negative", e.getMessage());

        }

    }

    @Test
    public void failSizeTest() {
        try {
            Shirt i = new Shirt("blue", "niki", "men", "pants", 200, MOCK_NEGATIVE, 200, 500,MOCK_POSITIVE, "lycra");
            itemController.addShirt(i);
            fail("The addition succeed when should failed");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("id or size must not be negative", e.getMessage());

        }

    }


    @Test
    public void failAddPantsTest() {
        try {
            Pants i = new Pants("blue", "niki", "men", "pants", 200, MOCK_SIZE_EXIST, 200, 500, MOCK_ID_EXIST, "bermuda");
            itemController.addPants(i);
            fail("The addition succeed when should failed");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("id and size exist", e.getMessage());

        }

    }
}



