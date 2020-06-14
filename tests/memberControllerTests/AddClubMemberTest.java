package memberControllerTests;

import controller.GeneralOpController;
import controller.MemberController;
import model.entities.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class AddClubMemberTest {
    MemberController memberController;
    private final static int MOCK_POSITIVE = 1;
    private final static int MOCK_NEGATIVE = -1;
    private final static int MOCK_ZERO = 0;
    private final static String MOCK_NAME = "Daniel";
    private final static String MOCK_DATEOFBIRTH = "31/3/1990";
    private final static int MOCK_POINTSGAINED = 5550;
    private final static String MOCK_EMPTYSTRING = "";
    private final static Member MOCK_MEMBER_WITHOUTNAME = new Member(MOCK_EMPTYSTRING , MOCK_DATEOFBIRTH,MOCK_POSITIVE, MOCK_POINTSGAINED);
    private final static Member MOCK_MEMBER_WITHOUTDATEOFBIRTH = new Member(MOCK_NAME, MOCK_EMPTYSTRING,MOCK_POSITIVE, MOCK_POINTSGAINED);
    private final static Member MOCK_MEMBER_WITHOUTID = new Member(MOCK_NAME, MOCK_DATEOFBIRTH,MOCK_NEGATIVE, MOCK_POINTSGAINED);
    private final static Member MOCK_MEMBER_WITHOUTIDOTHER = new Member(MOCK_NAME, MOCK_DATEOFBIRTH,MOCK_ZERO, MOCK_POINTSGAINED);
    private final static Member MOCK_MEMBER_WITHOUTPOINTSGAINED = new Member(MOCK_NAME, MOCK_DATEOFBIRTH,MOCK_ZERO, MOCK_NEGATIVE);
    private final static Member MOCK_MEMBER_EXIST = new Member("Yuval", "30/2/1999",1, 4534);


    @BeforeEach
    public void setUp()
    {
        memberController = new MemberController();
    }

    @Test
    public void failAddNameTest()
    {
        try {
            memberController.addClubMember(MOCK_MEMBER_WITHOUTNAME);
            fail("The addition succeed when should failed");
        }
        catch (IllegalArgumentException e)
        {
            Assertions.assertEquals("name or id or pointsgaind or dateofbirth must not be null or wrong", e.getMessage());

        }

    }


    @Test
    public void failAddDateOfBirthTest()
    {
        try {
            memberController.addClubMember(MOCK_MEMBER_WITHOUTDATEOFBIRTH);
            fail("The addition succeed when should failed");
        }
        catch (IllegalArgumentException e)
        {
            Assertions.assertEquals("name or id or pointsgaind or dateofbirth must not be null or wrong", e.getMessage());

        }

    }

    @Test
    public void failAddIdTest()
    {
        try {
            memberController.addClubMember(MOCK_MEMBER_WITHOUTID);
            fail("The addition succeed when should failed");
        }
        catch (IllegalArgumentException e)
        {
            Assertions.assertEquals("name or id or pointsgaind or dateofbirth must not be null or wrong", e.getMessage());

        }

    }

    @Test
    public void failAddIdOtherTest()
    {
        try {
            memberController.addClubMember(MOCK_MEMBER_WITHOUTIDOTHER);
            fail("The addition succeed when should failed");
        }
        catch (IllegalArgumentException e)
        {
            Assertions.assertEquals("name or id or pointsgaind or dateofbirth must not be null or wrong", e.getMessage());

        }

    }

    @Test
    public void failAddPointsGainedTest() {
        try {
            memberController.addClubMember(MOCK_MEMBER_WITHOUTPOINTSGAINED);
            fail("The addition succeed when should failed");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("name or id or pointsgaind or dateofbirth must not be null or wrong", e.getMessage());

        }
    }


        @Test
        public void failAddClubMemberTest()
        {
            try {
                memberController.addClubMember(MOCK_MEMBER_EXIST);
                fail("The addition succeed when should failed");
            }
            catch (IllegalArgumentException e)
            {
                Assertions.assertEquals("the member is exist", e.getMessage());

            }


    }













}
