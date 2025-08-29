package Tests;

import Core.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BlogSubscriptionRequiredFieldsTest extends BaseTest {
    @Test(description = "Validate that submission can’t be done if a required field is missing")
    public void TestBlogSubscriptionRequiredFields() {
        SoftAssert softAssert = new SoftAssert();
        blogPage.subscribe("",
                "TestEmail@example.com");
        softAssert.assertTrue(blogPage.isSubscribeBtnPresent(),"Subscribe button is not present");
        softAssert.assertFalse(blogPage.isThankYouMsgPresent(),"Thank You message is displayed");
        softAssert.assertTrue(blogPage.isFullNameErrMsgPresent(), "No Error message displayed");
        softAssert.assertEquals(blogPage.getFullNameErrMsg(),"This field is required.");
        blogPage.subscribe("Test Name",
                "");
        softAssert.assertTrue(blogPage.isSubscribeBtnPresent(),"Subscribe button is not present");
        softAssert.assertFalse(blogPage.isThankYouMsgPresent(),"Thank You message is displayed");
        softAssert.assertTrue(blogPage.isEmailErrMsgPresent(), "No Error message displayed");
        softAssert.assertEquals(blogPage.getEmailErrMsg(),"This field is required.");
        blogPage.subscribe("",
                "");
        softAssert.assertTrue(blogPage.isSubscribeBtnPresent(),"Subscribe button is not present");
        softAssert.assertFalse(blogPage.isThankYouMsgPresent(),"Thank You message is displayed");
        softAssert.assertTrue(blogPage.isFullNameErrMsgPresent(), "No Error message displayed");
        softAssert.assertTrue(blogPage.isEmailErrMsgPresent(), "No Error message displayed");
        softAssert.assertEquals(blogPage.getFullNameErrMsg(),"This field is required.");
        softAssert.assertEquals(blogPage.getEmailErrMsg(),"This field is required.");
        softAssert.assertAll();
    }
}
