package tests;

import core.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BlogSubscriptionSuccessfulSubmissionTest extends BaseTest {
    @Test(description = "Validate and extract Thanks message after submission with valid data")
    public final void TestBlogSubscriptionSuccessfulSubmission() {
        SoftAssert softAssert = new SoftAssert();
        blogPage.subscribe("Test Name" ,
                "TestEmail@example.com");
        softAssert.assertFalse(blogPage.isFormContentVisible() , "Subscribe form is still visible");
        softAssert.assertTrue(blogPage.isThankYouMsgVisible() , "Thank You message is not visible");
        softAssert.assertEquals(blogPage.getThankYouMsg() , "Thanks for signing up! Check your inbox for your Welcome package!");
        softAssert.assertAll();
    }
}
