package Tests;

import Core.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BlogSubscriptionSuccessfulSubmissionTest extends BaseTest {
    @Test(description = "Validate and extract Thanks message after submission with valid data")
    public void TestBlogSubscriptionSuccessfulSubmission(){
        SoftAssert softAssert = new SoftAssert();
        blogPage.Subscribe("Test Name",
                "TestEmail@example.com");
        softAssert.assertFalse(blogPage.IsSubscribeBtnPresent(),"Subscribe button is still present");
        softAssert.assertTrue(blogPage.IsThankYouMsgPresent(),"Thank You message is not displayed");
    }
}
