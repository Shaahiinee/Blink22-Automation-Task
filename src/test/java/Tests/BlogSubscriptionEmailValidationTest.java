package Tests;

import Core.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BlogSubscriptionEmailValidationTest extends BaseTest {
    @Test(description = "Validate that Invalid email format is not accepted")
    public void TestBlogSubscriptionEmailValidation() {
        SoftAssert softAssert = new SoftAssert();
        blogPage.Subscribe("Test Name", "TestEmail");
        softAssert.assertTrue(blogPage.IsSubscribeBtnPresent(),"Subscribe button is not present");
        softAssert.assertFalse(blogPage.IsThankYouMsgPresent(),"Thank You message is displayed");
        softAssert.assertTrue(blogPage.IsEmailErrMsgPresent(), "No Error message displayed");
        softAssert.assertEquals(blogPage.getEmailErrMsg(),"Enter a valid email address.","The error message is not correct.");
        softAssert.assertAll();
    }
}
