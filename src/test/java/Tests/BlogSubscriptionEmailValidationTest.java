package tests;

import core.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BlogSubscriptionEmailValidationTest extends BaseTest {
    @Test(description = "Validate that Invalid email format is not accepted")
    public final void TestBlogSubscriptionEmailValidation() {
        SoftAssert softAssert = new SoftAssert();
        blogPage.subscribe("Test Name" , "TestEmail");
        softAssert.assertTrue(blogPage.isFormContentVisible() , "Subscribe form is not visible");
        softAssert.assertFalse(blogPage.isThankYouMsgVisible() , "Thank You message is visible");
        softAssert.assertTrue(blogPage.isEmailErrMsgVisible() , "No Error message visible");
        softAssert.assertEquals(blogPage.getEmailErrMsg() , "Enter a valid email address." , "The error message is not correct.");
        softAssert.assertAll();
    }
}
