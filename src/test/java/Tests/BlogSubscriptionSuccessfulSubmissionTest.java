package Tests;

import Core.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BlogSubscriptionSuccessfulSubmissionTest extends BaseTest {
    @Test(description = "Validate and extract Thanks message after submission with valid data")
    public void TestBlogSubscriptionSuccessfulSubmission(){
        SoftAssert softAssert = new SoftAssert();
        blogPage.subscribe("Test Name",
                "TestEmail@example.com");
        softAssert.assertFalse(blogPage.isSubscribeBtnPresent(),"Subscribe button is still present");
        softAssert.assertTrue(blogPage.isThankYouMsgPresent(),"Thank You message is not displayed");
        softAssert.assertEquals(blogPage.getThankYouMsg(),"Thanks for signing up! Check your inbox for your Welcome package!");
        softAssert.assertAll();
    }
}
