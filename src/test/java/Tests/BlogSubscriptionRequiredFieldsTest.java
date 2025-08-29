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
        softAssert.assertTrue(blogPage.isFormContentVisible(),"Subscribe form is not visible");
        softAssert.assertFalse(blogPage.isThankYouMsgVisible(),"Thank You message is visible");
        softAssert.assertTrue(blogPage.isFullNameErrMsgVisible(), "No Error message visible");
        softAssert.assertEquals(blogPage.getFullNameErrMsg(),"This field is required.");
        blogPage.subscribe("Test Name",
                "");
        softAssert.assertTrue(blogPage.isFormContentVisible(),"Subscribe form is not visible");
        softAssert.assertFalse(blogPage.isThankYouMsgVisible(),"Thank You message is visible");
        softAssert.assertTrue(blogPage.isEmailErrMsgVisible(), "No Error message visible");
        softAssert.assertEquals(blogPage.getEmailErrMsg(),"This field is required.");
        blogPage.subscribe("",
                "");
        softAssert.assertTrue(blogPage.isFormContentVisible(),"Subscribe form is not visible");
        softAssert.assertFalse(blogPage.isThankYouMsgVisible(),"Thank You message is visible");
        softAssert.assertTrue(blogPage.isFullNameErrMsgVisible(), "No Error message visible");
        softAssert.assertTrue(blogPage.isEmailErrMsgVisible(), "No Error message visible");
        softAssert.assertEquals(blogPage.getFullNameErrMsg(),"This field is required.");
        softAssert.assertEquals(blogPage.getEmailErrMsg(),"This field is required.");
        softAssert.assertAll();
    }
}
