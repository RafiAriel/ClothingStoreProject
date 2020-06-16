package itemControllerTests;
import controller.ItemController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class BestSellingProductTest {
    ItemController itemController;

    @BeforeEach
    public void setUp() {itemController = new ItemController();}
//cxvds,vsfvkmsdkc
    @Test
    public void BestSellingProductFoundedTest()
    {
        Item item = itemController.bestSellingProduct();
        Assertions.assertNotNull(item);
    }

    @Test
    public void BestSellingProductNotFoundSucceedTest()
    {
        Item item = itemController.bestSellingProduct();
        Assertions.assertNull(item == null);
    }

}
